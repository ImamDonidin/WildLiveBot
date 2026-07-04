package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.model.Region
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.QuestType
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class QuestsCommand : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "quests") return

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        val userId = event.user.id
        val subcommand = event.subcommandName

        if (subcommand == "claim") {
            val success = GameManager.claimWeeklyReward(userId)
            if (success) {
                event.reply(LangManager.getString(displayLocale, "command.quests.reward_success")).queue()
            } else {
                if (GameManager.hasClaimedWeekly(userId)) {
                    event.reply(LangManager.getString(displayLocale, "command.quests.claimed")).setEphemeral(true).queue()
                } else {
                    event.reply(LangManager.getString(displayLocale, "command.quests.not_ready")).setEphemeral(true).queue()
                }
            }
            return
        }

        if (subcommand == "view" || subcommand == null) {
            val quests = GameManager.getWeeklyQuests()
            val progress = GameManager.getUserProgress(userId)
            val hasClaimed = GameManager.hasClaimedWeekly(userId)

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
                        val biome = try {
                            Region.valueOf(quest.targetValue.uppercase().trim())
                        } catch (e: Exception) {
                            null
                        }

                        if (biome != null) {
                            when (displayLocale) {
                                DiscordLocale.RUSSIAN -> biome.nameRu
                                DiscordLocale.UKRAINIAN -> biome.nameUk
                                else -> biome.nameEn
                            }
                        } else {
                            quest.targetValue
                        }
                    }
                    QuestType.CATCH_RARITY -> {
                        val rar = try { Rarity.valueOf(quest.targetValue.uppercase().trim()) } catch(e: Exception) { null }
                        if (rar != null) {
                            when (displayLocale) {
                                DiscordLocale.RUSSIAN -> when (rar) {
                                    Rarity.COMMON -> "Обычное"
                                    Rarity.RARE -> "Редкое"
                                    Rarity.EPIC -> "Эпическое"
                                    Rarity.LEGENDARY -> "Легендарное"
                                }
                                DiscordLocale.UKRAINIAN -> when (rar) {
                                    Rarity.COMMON -> "Звичайне"
                                    Rarity.RARE -> "Рідкісне"
                                    Rarity.EPIC -> "Епічне"
                                    Rarity.LEGENDARY -> "Легендарне"
                                }
                                else -> rar.displayName
                            }
                        } else {
                            quest.targetValue
                        }
                    }
                    QuestType.CATCH_ANY -> ""
                }

                val key = when (quest.type) {
                    QuestType.CATCH_REGION -> "quest.type.catch_region"
                    QuestType.CATCH_RARITY -> "quest.type.catch_rarity"
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
            embed.setFooter(LangManager.getString(displayLocale, footerKey))

            event.replyEmbeds(embed.build()).queue()
            return
        }
    }
}