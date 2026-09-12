package com.wildlivebot.game.repository

import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Biome
import com.wildlivebot.model.Quest
import com.wildlivebot.model.QuestType
import com.wildlivebot.model.Rarity
import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import kotlinx.serialization.Serializable
import java.io.File
import java.time.Duration
import java.time.Instant
import java.util.concurrent.ConcurrentHashMap
import org.slf4j.LoggerFactory

@Serializable
private data class GuildQuestState(
    val weeklyQuests: List<Quest> = emptyList(),
    val userProgress: Map<String, List<Int>> = emptyMap(),
    val userClaimedWeekly: Map<String, Boolean> = emptyMap(),
    val nextResetEpoch: Long = 0L,
    val userClaimedWeeksCount: Map<String, Int> = emptyMap()
)

@Serializable
private data class QuestData(val guilds: Map<String, GuildQuestState> = emptyMap())

private class GuildQuestData(
    var weeklyQuests: MutableList<Quest> = mutableListOf(),
    val userProgress: ConcurrentHashMap<String, MutableList<Int>> = ConcurrentHashMap(),
    val userClaimedWeekly: ConcurrentHashMap<String, Boolean> = ConcurrentHashMap(),
    var nextResetEpoch: Long = 0L,
    val userClaimedWeeksCount: ConcurrentHashMap<String, Int> = ConcurrentHashMap()
)

object QuestRepository {
    private val logger = LoggerFactory.getLogger(QuestRepository::class.java)
    private val file = File("data/quests.json")

    private val guildStates = ConcurrentHashMap<String, GuildQuestData>().apply {
        loadJson(file) { QuestData() }.guilds.forEach { (guildId, saved) ->
            put(guildId, GuildQuestData(
                weeklyQuests = saved.weeklyQuests.toMutableList(),
                userProgress = ConcurrentHashMap<String, MutableList<Int>>().apply {
                    saved.userProgress.forEach { (userId, progress) -> put(userId, progress.toMutableList()) }
                },
                userClaimedWeekly = ConcurrentHashMap(saved.userClaimedWeekly),
                nextResetEpoch = saved.nextResetEpoch,
                userClaimedWeeksCount = ConcurrentHashMap(saved.userClaimedWeeksCount)
            ))
        }
    }

    private fun stateFor(guildId: String) = guildStates.computeIfAbsent(guildId) { GuildQuestData() }

    fun checkWeeklyReset(guildId: String) {
        val state = stateFor(guildId)
        val now = Instant.now().epochSecond
        if (state.weeklyQuests.isEmpty() || now >= state.nextResetEpoch) generateNewWeeklyQuests(guildId, state)
    }

    private fun generateNewWeeklyQuests(guildId: String, state: GuildQuestData) {
        val config = GameConfigRepository.current(guildId)

        state.weeklyQuests = mutableListOf()
        state.userProgress.clear()
        state.userClaimedWeekly.clear()

        val randomBiome = Biome.values().random()
        state.weeklyQuests.add(Quest("q_region", QuestType.CATCH_REGION, randomBiome.name.lowercase(), config.questRegionTarget))

        if ((0..1).random() == 0) {
            val randomRarity = listOf(Rarity.COMMON, Rarity.RARE, Rarity.EPIC).random()
            state.weeklyQuests.add(Quest("q_rarity", QuestType.CATCH_RARITY, randomRarity.name.lowercase(), config.questRarityTarget))
        } else {
            val randomType = AnimalType.values().random()
            state.weeklyQuests.add(Quest("q_type", QuestType.CATCH_TYPE, randomType.name.lowercase(), config.questTypeTarget))
        }

        state.weeklyQuests.add(Quest("q_any", QuestType.CATCH_ANY, "", config.questAnyTarget))
        state.nextResetEpoch = Instant.now().plus(Duration.ofDays(7)).epochSecond
        persist()
        logger.info("Generated 3 new weekly quests for guild $guildId.")
    }

    fun getWeeklyQuests(guildId: String): List<Quest> {
        checkWeeklyReset(guildId)
        return stateFor(guildId).weeklyQuests
    }

    fun getProgress(guildId: String, userId: String): List<Int> =
        stateFor(guildId).userProgress.computeIfAbsent(userId) { mutableListOf(0, 0, 0) }

    fun hasClaimedWeekly(guildId: String, userId: String): Boolean =
        stateFor(guildId).userClaimedWeekly.getOrDefault(userId, false)

    fun getClaimedWeeksCount(guildId: String, userId: String): Int =
        stateFor(guildId).userClaimedWeeksCount.getOrDefault(userId, 0)

    fun updateProgress(guildId: String, userId: String, animal: Animal) {
        checkWeeklyReset(guildId)
        val state = stateFor(guildId)
        if (state.userClaimedWeekly.getOrDefault(userId, false)) return

        val progress = state.userProgress.computeIfAbsent(userId) { mutableListOf(0, 0, 0) }
        state.weeklyQuests.forEachIndexed { index, quest ->
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

    fun claimWeeklyReward(guildId: String, userId: String): Int? {
        checkWeeklyReset(guildId)
        val state = stateFor(guildId)
        if (state.userClaimedWeekly.getOrDefault(userId, false)) return null

        val progress = getProgress(guildId, userId)
        val allCompleted = state.weeklyQuests.indices.all { progress[it] >= state.weeklyQuests[it].requiredProgress }
        if (!allCompleted) return null

        state.userClaimedWeekly[userId] = true
        state.userClaimedWeeksCount[userId] = getClaimedWeeksCount(guildId, userId) + 1
        persist()
        return GameConfigRepository.current(guildId).weeklyBonusPoints
    }

    private fun persist() {
        val snapshot = guildStates.mapValues { (_, state) ->
            GuildQuestState(
                state.weeklyQuests.toList(),
                state.userProgress.mapValues { it.value.toList() },
                state.userClaimedWeekly.toMap(),
                state.nextResetEpoch,
                state.userClaimedWeeksCount.toMap()
            )
        }
        saveJson(file, QuestData(snapshot))
    }
}