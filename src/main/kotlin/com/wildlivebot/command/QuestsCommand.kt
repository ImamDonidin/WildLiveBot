package com.wildlivebot.command

import com.wildlivebot.game.repository.QuestRepository
import com.wildlivebot.game.repository.LeaderboardRepository
import com.wildlivebot.model.Biome
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.QuestType
import com.wildlivebot.model.Rarity
import com.wildlivebot.utils.LangManager
import com.wildlivebot.utils.localizedName
import com.wildlivebot.game.AchievementService
import com.wildlivebot.utils.sendAchievementUnlocks
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import com.wildlivebot.game.repository.GameConfigRepository
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class QuestsCommand : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "quests") return
        val guildId = event.guild?.id ?: return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

        val userId = event.user.id
        val subcommand = event.subcommandName

        if (subcommand == "claim") {
            val bonus = QuestRepository.claimWeeklyReward(guildId, userId)
            if (bonus != null) {
                LeaderboardRepository.addPoints(userId, bonus)
                event.reply(LangManager.getString(displayLocale, "command.quests.reward_success", bonus)).queue()
                sendAchievementUnlocks(event.channel, displayLocale, AchievementService.checkAndUnlock(guildId, userId))
            } else {
                if (QuestRepository.hasClaimedWeekly(guildId, userId))  {
                    event.reply(LangManager.getString(displayLocale, "command.quests.claimed")).setEphemeral(true).queue()
                } else {
                    event.reply(LangManager.getString(displayLocale, "command.quests.not_ready")).setEphemeral(true).queue()
                }

            }
            return
        }

        if (subcommand == "view" || subcommand == null) {
            val quests = QuestRepository.getWeeklyQuests(guildId)
            val progress = QuestRepository.getProgress(guildId, userId)
            val hasClaimed = QuestRepository.hasClaimedWeekly(guildId, userId)

            val bonus = GameConfigRepository.current(guildId).weeklyBonusPoints
            val embed = EmbedBuilder()

                .setTitle(LangManager.getString(displayLocale, "command.quests.title"))
                .setDescription(LangManager.getString(displayLocale, "command.quests.description"))
                .setColor(Color.CYAN)

            var allDone = true
            quests.forEachIndexed { index, quest ->
                val currentProgress = progress[index]
                val isDone = currentProgress >= quest.requiredProgress
                if (!isDone) allDone = false

                val statusIcon = if (isDone) "✅" else "⏳"

                val targetName = when (quest.type) {
                    QuestType.CATCH_REGION -> {
                        val biome = try { Biome.valueOf(quest.targetValue.uppercase().trim()) } catch (e: Exception) { null }
                        biome?.localizedName(displayLocale) ?: quest.targetValue
                    }
                    QuestType.CATCH_RARITY -> {
                        val rar = try { Rarity.valueOf(quest.targetValue.uppercase().trim()) } catch (e: Exception) { null }
                        rar?.localizedName(displayLocale) ?: quest.targetValue
                    }
                    QuestType.CATCH_TYPE -> {
                        val animType = try { AnimalType.valueOf(quest.targetValue.uppercase().trim()) } catch (e: Exception) { null }
                        animType?.localizedName(displayLocale) ?: quest.targetValue
                    }
                    QuestType.CATCH_ANY -> ""
                }

                val key = when (quest.type) {
                    QuestType.CATCH_REGION -> "quest.type.catch_region"
                    QuestType.CATCH_RARITY -> "quest.type.catch_rarity"
                    QuestType.CATCH_TYPE -> "quest.type.catch_type"
                    QuestType.CATCH_ANY -> "quest.type.catch_any"
                }

                val taskTitle = LangManager.getString(displayLocale, "command.quests.task_title", statusIcon, index + 1)

                embed.addField(
                    taskTitle,
                    LangManager.getString(displayLocale, key, targetName, currentProgress, quest.requiredProgress),
                    false
                )
            }

            val footerKey = when {
                hasClaimed -> "command.quests.claimed"
                allDone -> "command.quests.claim_ready"
                else -> "command.quests.not_ready"
            }
            embed.setFooter(LangManager.getString(displayLocale, footerKey, bonus))

            event.replyEmbeds(embed.build()).queue()
            return
        }
    }
}