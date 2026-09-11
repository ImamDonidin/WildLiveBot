package com.wildlivebot.game.repository

import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Quest
import com.wildlivebot.model.QuestType
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Biome
import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import kotlinx.serialization.Serializable
import java.io.File
import java.time.Duration
import java.time.Instant
import java.util.concurrent.ConcurrentHashMap
import org.slf4j.LoggerFactory

@Serializable
private data class QuestData(
    val weeklyQuests: List<Quest> = emptyList(),
    val userProgress: Map<String, List<Int>> = emptyMap(),
    val userClaimedWeekly: Map<String, Boolean> = emptyMap(),
    val nextResetEpoch: Long = 0L,
    val userClaimedWeeksCount: Map<String, Int> = emptyMap()
)

object QuestRepository {
    private val logger = LoggerFactory.getLogger(QuestRepository::class.java)
    private val file = File("data/quests.json")

    private val saved = loadJson(file) { QuestData() }
    private var weeklyQuests = saved.weeklyQuests.toMutableList()
    private val userProgress = ConcurrentHashMap<String, MutableList<Int>>().apply {
        saved.userProgress.forEach { (userId, progress) -> put(userId, progress.toMutableList()) }
    }
    private val userClaimedWeekly = ConcurrentHashMap(saved.userClaimedWeekly)

    private val userClaimedWeeksCount = ConcurrentHashMap(saved.userClaimedWeeksCount)

    fun getClaimedWeeksCount(userId: String): Int = userClaimedWeeksCount.getOrDefault(userId, 0)
    private var nextResetEpoch = saved.nextResetEpoch

    fun checkWeeklyReset() {
        val now = Instant.now().epochSecond
        if (weeklyQuests.isEmpty() || now >= nextResetEpoch) generateNewWeeklyQuests()
    }

    private fun generateNewWeeklyQuests() {
        weeklyQuests = mutableListOf()
        userProgress.clear()
        userClaimedWeekly.clear()
        val config = GameConfigRepository.current()

        val randomBiome = Biome.values().random()
        weeklyQuests.add(Quest("q_region", QuestType.CATCH_REGION, randomBiome.name.lowercase(), config.questRegionTarget))

        if ((0..1).random() == 0) {
            val randomRarity = listOf(Rarity.COMMON, Rarity.RARE, Rarity.EPIC).random()
            weeklyQuests.add(Quest("q_rarity", QuestType.CATCH_RARITY, randomRarity.name.lowercase(), config.questRarityTarget))
        } else {
            val randomType = AnimalType.values().random()
            weeklyQuests.add(Quest("q_type", QuestType.CATCH_TYPE, randomType.name.lowercase(), config.questTypeTarget))
        }
        weeklyQuests.add(Quest("q_any", QuestType.CATCH_ANY, "", config.questAnyTarget))
        nextResetEpoch = Instant.now().plus(Duration.ofDays(7)).epochSecond
        persist()
        logger.info("Generated 3 new weekly quests.")
    }

    fun getWeeklyQuests(): List<Quest> {
        checkWeeklyReset()
        return weeklyQuests
    }

    fun getProgress(userId: String): List<Int> =
        userProgress.computeIfAbsent(userId) { mutableListOf(0, 0, 0) }

    fun hasClaimedWeekly(userId: String): Boolean = userClaimedWeekly.getOrDefault(userId, false)

    fun updateProgress(userId: String, animal: Animal) {
        checkWeeklyReset()
        if (hasClaimedWeekly(userId)) return

        val progress = userProgress.computeIfAbsent(userId) { mutableListOf(0, 0, 0) }
        weeklyQuests.forEachIndexed { index, quest ->
            val current = progress[index]
            if (current < quest.requiredProgress) {
                val matches = when (quest.type) {
                    QuestType.CATCH_REGION -> animal.biome.name.lowercase() == quest.targetValue.lowercase()
                    QuestType.CATCH_RARITY -> animal.rarity.name.lowercase() == quest.targetValue.lowercase()
                    QuestType.CATCH_TYPE -> animal.type.name.lowercase() == quest.targetValue.lowercase()
                    QuestType.CATCH_ANY -> true
                }
                if (matches) progress[index] = current + 1
            }
        }
        persist()
    }

    fun claimWeeklyReward(userId: String): Int? {
        checkWeeklyReset()
        if (hasClaimedWeekly(userId)) return null

        val progress = getProgress(userId)
        val allCompleted = weeklyQuests.indices.all { progress[it] >= weeklyQuests[it].requiredProgress }
        if (!allCompleted) return null

        userClaimedWeekly[userId] = true
        userClaimedWeeksCount[userId] = getClaimedWeeksCount(userId) + 1
        persist()
        return GameConfigRepository.current().weeklyBonusPoints
    }

    private fun persist() = saveJson(
        file,
        QuestData(weeklyQuests.toList(), userProgress.mapValues { it.value.toList() }, userClaimedWeekly.toMap(), nextResetEpoch, userClaimedWeeksCount.toMap())
    )
}