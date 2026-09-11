package com.wildlivebot.command

import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class HelpCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "help") return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

        val embed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "help.title"))
            .setDescription(LangManager.getString(displayLocale, "help.description"))
            .setColor(Color.CYAN)
            .addField(LangManager.getString(displayLocale, "help.section.playing"), LangManager.getString(displayLocale, "help.section.playing_body"), false)
            .addField(LangManager.getString(displayLocale, "help.section.collection"), LangManager.getString(displayLocale, "help.section.collection_body"), false)
            .addField(LangManager.getString(displayLocale, "help.section.shop"), LangManager.getString(displayLocale, "help.section.shop_body"), false)
            .addField(LangManager.getString(displayLocale, "help.section.quests"), LangManager.getString(displayLocale, "help.section.quests_body"), false)
            .addField(LangManager.getString(displayLocale, "help.section.admin"), LangManager.getString(displayLocale, "help.section.admin_body"), false)
            .setFooter(LangManager.getString(displayLocale, "help.footer"))
            .build()

        event.replyEmbeds(embed).setEphemeral(true).queue()
    }
}