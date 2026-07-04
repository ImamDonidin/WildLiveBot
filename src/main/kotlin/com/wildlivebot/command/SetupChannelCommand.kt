package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SetupChannelCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "setup-channel") return

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        val member = event.member ?: return
        if (!member.hasPermission(Permission.MANAGE_SERVER)) {
            event.reply(LangManager.getString(displayLocale, "command.setup.no_permission"))
                .setEphemeral(true).queue()
            return
        }

        val targetChannel = event.getOption("channel")?.asChannel ?: return
        val guildId = event.guild?.id ?: return

        GameManager.setGuildChannel(guildId, targetChannel.id)

        event.reply(LangManager.getString(displayLocale, "command.setup.success", targetChannel.asMention))
            .queue()
    }
}