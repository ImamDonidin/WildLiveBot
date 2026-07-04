package com.wildlivebot.game

import com.wildlivebot.model.Animal
import com.wildlivebot.model.Region
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Quest
import com.wildlivebot.model.QuestType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import java.util.concurrent.ConcurrentHashMap
import java.time.Instant
import java.time.Duration
import java.util.Collections
import org.slf4j.LoggerFactory

@Serializable
data class BotData(
    val leaderboards: Map<String, Int> = emptyMap(),
    val guildChannels: Map<String, String> = emptyMap(),
    val collections: Map<String, List<String>> = emptyMap(),
    val favorites: Map<String, String> = emptyMap(),
    val inventories: Map<String, Map<String, Int>> = emptyMap(),
    val weeklyQuests: List<Quest> = emptyList(),
    val userQuestProgress: Map<String, List<Int>> = emptyMap(),
    val userClaimedWeekly: Map<String, Boolean> = emptyMap(),
    val nextQuestResetEpoch: Long = 0L
)

object GameManager {
    private val logger = LoggerFactory.getLogger(this::class.java)
    private val jsonFile = File("bot_data.json")
    private val jsonConfig = Json { prettyPrint = true }

    private val botData = loadData()
    private val leaderboards = ConcurrentHashMap<String, Int>(botData.leaderboards)
    private val guildChannels = ConcurrentHashMap<String, String>(botData.guildChannels)

    private val collections = ConcurrentHashMap<String, MutableList<String>>().apply {
        botData.collections.forEach { (k, v) -> put(k, v.toMutableList()) }
    }
    private val favorites = ConcurrentHashMap<String, String>(botData.favorites)

    private val inventories = ConcurrentHashMap<String, ConcurrentHashMap<String, Int>>().apply {
        botData.inventories.forEach { (userId, invMap) ->
            put(userId, ConcurrentHashMap(invMap))
        }
    }

    private var weeklyQuests = botData.weeklyQuests.toMutableList()
    private val userQuestProgress = ConcurrentHashMap<String, MutableList<Int>>().apply {
        botData.userQuestProgress.forEach { (k, v) -> put(k, v.toMutableList()) }
    }
    private val userClaimedWeekly = ConcurrentHashMap<String, Boolean>(botData.userClaimedWeekly)
    private var nextQuestResetEpoch = botData.nextQuestResetEpoch

    private val cooldowns = ConcurrentHashMap<String, Instant>()
    private val activeSpawns = ConcurrentHashMap<String, Animal>()
    private val roundWrongGuesses = ConcurrentHashMap<String, MutableSet<String>>()
    private val activeBaits = ConcurrentHashMap<String, Region>()

    private const val COOLDOWN_MINUTES = 30L
    private const val WEEKLY_BONUS_POINTS = 500

    private fun loadData(): BotData {
        if (!jsonFile.exists()) return BotData()
        return try {
            jsonConfig.decodeFromString<BotData>(jsonFile.readText())
        } catch (e: Exception) {
            logger.error("Failed to load bot_data.json", e)
            BotData()
        }
    }

    private fun saveData() {
        try {
            val data = BotData(
                leaderboards.toMap(),
                guildChannels.toMap(),
                collections.mapValues { it.value.toList() },
                favorites.toMap(),
                inventories.mapValues { it.value.toMap() },
                weeklyQuests.toList(),
                userQuestProgress.mapValues { it.value.toList() },
                userClaimedWeekly.toMap(),
                nextQuestResetEpoch
            )
            jsonFile.writeText(jsonConfig.encodeToString(data))
        } catch (e: Exception) {
            logger.error("Failed to save bot data!", e)
        }
    }

    fun getUserBaits(userId: String): Map<String, Int> = inventories[userId] ?: emptyMap()

    fun buyBait(userId: String, regionId: String, price: Int): Boolean {
        val currentPoints = getPoints(userId)
        if (currentPoints < price) return false

        addPoints(userId, -price)

        val cleanRegionId = regionId.lowercase().trim()
        val userInv = inventories.computeIfAbsent(userId) { ConcurrentHashMap() }
        userInv[cleanRegionId] = userInv.getOrDefault(cleanRegionId, 0) + 1
        saveData()
        return true
    }

    fun useBait(userId: String, channelId: String, regionId: String): Boolean {
        val cleanRegionId = regionId.lowercase().trim()
        val userInv = inventories[userId] ?: return false
        val count = userInv.getOrDefault(cleanRegionId, 0)
        if (count <= 0) return false

        try {
            val region = Region.valueOf(cleanRegionId.uppercase())

            if (count == 1) {
                userInv.remove(cleanRegionId)
            } else {
                userInv[cleanRegionId] = count - 1
            }

            activeBaits[channelId] = region
            saveData()
            return true
        } catch (e: Exception) {
            logger.error("Unknown region ID for biome conversion: $regionId", e)
            return false
        }
    }

    fun getActiveBaitForChannel(channelId: String): Region? = activeBaits[channelId]
    fun removeActiveBaitForChannel(channelId: String) { activeBaits.remove(channelId) }

    fun checkWeeklyReset() {
        val now = Instant.now().epochSecond
        if (weeklyQuests.isEmpty() || now >= nextQuestResetEpoch) {
            generateNewWeeklyQuests()
        }
    }

    private fun generateNewWeeklyQuests() {
        weeklyQuests.clear()
        userQuestProgress.clear()
        userClaimedWeekly.clear()

        val randomRegion = Region.values().random()
        weeklyQuests.add(Quest("q_region", QuestType.CATCH_REGION, randomRegion.name.lowercase(), 3))

        val randomRarity = listOf(Rarity.COMMON, Rarity.RARE, Rarity.EPIC).random()
        weeklyQuests.add(Quest("q_rarity", QuestType.CATCH_RARITY, randomRarity.name.lowercase(), 2))

        weeklyQuests.add(Quest("q_any", QuestType.CATCH_ANY, "", 7))

        nextQuestResetEpoch = Instant.now().plus(Duration.ofDays(7)).epochSecond
        saveData()
        logger.info("Generated 3 new weekly quests based on the new biome system.")
    }

    fun getWeeklyQuests(): List<Quest> {
        checkWeeklyReset()
        return weeklyQuests
    }

    fun getUserProgress(userId: String): List<Int> {
        return userQuestProgress.computeIfAbsent(userId) { mutableListOf(0, 0, 0) }
    }

    fun hasClaimedWeekly(userId: String): Boolean = userClaimedWeekly.getOrDefault(userId, false)

    fun updateQuestProgress(userId: String, animal: Animal) {
        checkWeeklyReset()
        if (userClaimedWeekly.getOrDefault(userId, false)) return

        val progress = userQuestProgress.computeIfAbsent(userId) { mutableListOf(0, 0, 0) }

        weeklyQuests.forEachIndexed { index, quest ->
            val current = progress[index]
            if (current < quest.requiredProgress) {
                val matches = when (quest.type) {
                    QuestType.CATCH_REGION -> animal.region.name.lowercase() == quest.targetValue.lowercase()
                    QuestType.CATCH_RARITY -> animal.rarity.name.lowercase() == quest.targetValue.lowercase()
                    QuestType.CATCH_ANY -> true
                }
                if (matches) {
                    progress[index] = current + 1
                }
            }
        }
        saveData()
    }

    fun claimWeeklyReward(userId: String): Boolean {
        checkWeeklyReset()
        if (userClaimedWeekly.getOrDefault(userId, false)) return false

        val progress = getUserProgress(userId)
        val allCompleted = weeklyQuests.mapIndexed { index, quest ->
            progress[index] >= quest.requiredProgress
        }.all { it }

        if (allCompleted) {
            userClaimedWeekly[userId] = true
            addPoints(userId, WEEKLY_BONUS_POINTS)
            saveData()
            return true
        }
        return false
    }

    fun catchAnimalForCollection(userId: String, animalId: String) {
        val userBox = collections.computeIfAbsent(userId) { Collections.synchronizedList(mutableListOf<String>()) }
        userBox.add(animalId)
        saveData()
    }

    fun getUserCollection(userId: String): List<String> = collections[userId] ?: emptyList()

    fun setFavoriteAnimal(userId: String, animalId: String): Boolean {
        val caughtAnimals = getUserCollection(userId)
        if (animalId in caughtAnimals) {
            favorites[userId] = animalId
            saveData()
            return true
        }
        return false
    }

    fun getFavoriteAnimalId(userId: String): String? = favorites[userId]

    fun getUserRank(userId: String): Int {
        val sortedPlayers = leaderboards.entries.sortedByDescending { it.value }.map { it.key }
        val index = sortedPlayers.indexOf(userId)
        return if (index != -1) index + 1 else sortedPlayers.size + 1
    }

    fun setGuildChannel(guildId: String, channelId: String) { guildChannels[guildId] = channelId; saveData() }
    fun getGuildChannel(guildId: String): String? = guildChannels[guildId]

    fun getRemainingCooldown(userId: String): Long? {
        val lastUsed = cooldowns[userId] ?: return null
        val nextAvailable = lastUsed.plus(Duration.ofMinutes(COOLDOWN_MINUTES))
        val now = Instant.now()
        return if (now.isBefore(nextAvailable)) Duration.between(now, nextAvailable).seconds else null
    }

    fun setCooldown(userId: String) = cooldowns.put(userId, Instant.now())
    fun spawnAnimal(channelId: String, animal: Animal) {
        activeSpawns[channelId] = animal
        roundWrongGuesses[channelId] = Collections.newSetFromMap(ConcurrentHashMap<String, Boolean>())
    }
    fun getActiveAnimal(channelId: String): Animal? = activeSpawns[channelId]
    fun removeActiveAnimal(channelId: String) { activeSpawns.remove(channelId); roundWrongGuesses.remove(channelId) }
    fun addPointsForWrongGuess(channelId: String, userId: String): Boolean {
        val wrongUsers = roundWrongGuesses[channelId] ?: return false
        if (wrongUsers.add(userId)) { addPoints(userId, 10); return true }
        return false
    }
    fun addPoints(userId: String, points: Int): Int {
        val currentPoints = leaderboards.getOrDefault(userId, 0)
        val newPoints = currentPoints + points
        leaderboards[userId] = newPoints
        saveData()
        return newPoints
    }
    fun getTopPlayers(limit: Int = 10): List<Pair<String, Int>> = leaderboards.entries.sortedByDescending { it.value }.take(limit).map { it.key to it.value }
    fun getPoints(userId: String): Int = leaderboards.getOrDefault(userId, 0)
}