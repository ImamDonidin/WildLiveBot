package com.wildlivebot.command

import com.wildlivebot.game.repository.LeaderboardRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color
import org.slf4j.LoggerFactory

class LeaderboardCommand : ListenerAdapter() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "leaderboard") return

        logger.info("User ${event.user.name} requested the leaderboard.")

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

        val topPlayers = LeaderboardRepository.getTopPlayers(10)

        val embed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "command.leaderboard.title"))
            .setColor(Color.ORANGE)
            .setFooter(LangManager.getString(displayLocale, "command.leaderboard.footer"))

        if (topPlayers.isEmpty()) {
            embed.setDescription(LangManager.getString(displayLocale, "command.leaderboard.empty"))
        } else {
            val sb = StringBuilder()

            topPlayers.forEachIndexed { index, pair ->
                val userId = pair.first
                val points = pair.second

                val medal = when (index) {
                    0 -> "🥇"
                    1 -> "🥈"
                    2 -> "🥉"
                    else -> "🔹 `#${index + 1}`"
                }

                val formatPattern = if (index < 3) "command.leaderboard.entry_top" else "command.leaderboard.entry"

                sb.append(LangManager.getString(displayLocale, formatPattern, medal, userId, points))
            }

            embed.setDescription(sb.toString())
        }

        event.replyEmbeds(embed.build()).queue()
    }
}