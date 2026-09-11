package com.wildlivebot.listener

import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.guild.GuildJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color
import org.slf4j.LoggerFactory

class WelcomeListener : ListenerAdapter() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onGuildJoin(event: GuildJoinEvent) {
        val guild = event.guild
        val displayLocale = LangManager.getSupportedLocale(guild.locale)

        val targetChannel = guild.systemChannel?.takeIf { it.canTalk() }
            ?: guild.textChannels.firstOrNull { it.canTalk() }

        if (targetChannel == null) {
            logger.warn("Could not find a channel to send the welcome message in guild ${guild.id}")
            return
        }

        val embed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "welcome.title"))
            .setDescription(LangManager.getString(displayLocale, "welcome.description"))
            .addField(
                LangManager.getString(displayLocale, "welcome.setup_title"),
                LangManager.getString(displayLocale, "welcome.setup_body"),
                false
            )
            .addField(
                LangManager.getString(displayLocale, "welcome.help_title"),
                LangManager.getString(displayLocale, "welcome.help_body"),
                false
            )
            .setColor(Color.GREEN)
            .setFooter(LangManager.getString(displayLocale, "welcome.footer"))
            .build()

        targetChannel.sendMessageEmbeds(embed).queue(
            null,
            { error -> logger.warn("Failed to send welcome message in guild ${guild.id}: ${error.message}") }
        )
    }
}