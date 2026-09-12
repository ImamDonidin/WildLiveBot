package com.wildlivebot.game.repository

import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import kotlinx.serialization.Serializable
import java.io.File
import java.util.concurrent.ConcurrentHashMap

@Serializable
data class GameConfigData(
    val catchCooldownMinutes: Long = 30L,
    val weeklyBonusPoints: Int = 500,
    val wrongGuessPoints: Int = 10,
    val baitPrice: Int = 150,
    val skyCameraPrice: Int = 500,
    val questRegionTarget: Int = 3,
    val questRarityTarget: Int = 2,
    val questTypeTarget: Int = 3,
    val questAnyTarget: Int = 7,
    val rollCommonMax: Int = 45,
    val rollRareMax: Int = 70,
    val rollEpicMax: Int = 85,
    val rollLegendaryMax: Int = 97
)

object GameConfigRepository {
    private val file = File("data/game_config.json")
    private val configs = ConcurrentHashMap(loadJson(file) { emptyMap<String, GameConfigData>() })

    fun current(guildId: String): GameConfigData = configs[guildId] ?: GameConfigData()

    fun update(guildId: String, mutator: (GameConfigData) -> GameConfigData) {
        configs[guildId] = mutator(current(guildId))
        persist()
    }

    private fun persist() = saveJson(file, configs.toMap())
}