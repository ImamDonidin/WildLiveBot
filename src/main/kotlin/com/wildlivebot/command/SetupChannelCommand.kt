package com.wildlivebot.command

import com.wildlivebot.game.repository.GuildConfigRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SetupChannelCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "setup-channel") return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

        val member = event.member ?: return
        if (!member.hasPermission(Permission.MANAGE_SERVER)) {
            event.reply(LangManager.getString(displayLocale, "command.setup.no_permission"))
                .setEphemeral(true).queue()
            return
        }

        val targetChannel = event.getOption("channel")?.asChannel ?: return
        val guildId = event.guild?.id ?: return

        GuildConfigRepository.setChannel(guildId, targetChannel.id)

        event.reply(LangManager.getString(displayLocale, "command.setup.success", targetChannel.asMention))
            .queue()
    }
}