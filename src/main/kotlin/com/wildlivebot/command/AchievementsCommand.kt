package com.wildlivebot.command

import com.wildlivebot.game.repository.AchievementRepository
import com.wildlivebot.model.Achievement
import com.wildlivebot.utils.LangManager
import com.wildlivebot.utils.localizedName
import com.wildlivebot.utils.localizedDescription
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class AchievementsCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "achievements") return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)
        val userId = event.user.id
        val unlocked = AchievementRepository.getUnlocked(userId)

        val embed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "command.achievements.title", event.user.name))
            .setColor(Color.YELLOW)

        Achievement.values().forEach { achievement ->
            val statusIcon = if (achievement in unlocked) "✅" else "🔒"
            embed.addField(
                "$statusIcon ${achievement.icon} ${achievement.localizedName(displayLocale)}",
                achievement.localizedDescription(displayLocale),
                false
            )
        }

        event.replyEmbeds(embed.build()).setEphemeral(true).queue()
    }
}