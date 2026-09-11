package com.wildlivebot.game.repository

import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import kotlinx.serialization.Serializable
import java.io.File
import java.util.concurrent.ConcurrentHashMap

@Serializable
private data class GuildConfigData(val guildChannels: Map<String, String> = emptyMap())

object GuildConfigRepository {
    private val file = File("data/guild_config.json")
    private val channels = ConcurrentHashMap(loadJson(file) { GuildConfigData() }.guildChannels)

    fun setChannel(guildId: String, channelId: String) {
        channels[guildId] = channelId
        persist()
    }

    fun getChannel(guildId: String): String? = channels[guildId]

    private fun persist() = saveJson(file, GuildConfigData(channels.toMap()))
}