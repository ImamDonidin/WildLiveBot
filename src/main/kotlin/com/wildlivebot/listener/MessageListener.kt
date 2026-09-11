package com.wildlivebot.listener

import com.wildlivebot.game.RuntimeGameState
import com.wildlivebot.game.repository.GuildConfigRepository
import com.wildlivebot.game.repository.CollectionRepository
import com.wildlivebot.game.repository.GameConfigRepository
import com.wildlivebot.game.repository.LeaderboardRepository
import com.wildlivebot.game.repository.QuestRepository
import com.wildlivebot.game.repository.InventoryRepository
import com.wildlivebot.utils.LangManager
import com.wildlivebot.registry.AnimalRepository
import com.wildlivebot.utils.localizedName
import com.wildlivebot.utils.localizedText
import com.wildlivebot.game.AchievementService
import com.wildlivebot.utils.sendAchievementUnlocks
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.components.buttons.Button
import net.dv8tion.jda.api.components.actionrow.ActionRow
import java.awt.Color
import org.slf4j.LoggerFactory

class MessageListener : ListenerAdapter() {
    private val logger = LoggerFactory.getLogger(MessageListener::class.java)

    companion object {
        private val UKRAINIAN_ONLY_LETTERS = charArrayOf('і', 'ї', 'є', 'ґ')
    }

    private fun guessAnswerLocale(forcedLocale: DiscordLocale?, guildLocaleRaw: String, userAnswer: String): DiscordLocale {
        if (forcedLocale != null) return forcedLocale
        if (guildLocaleRaw.startsWith("ukr")) return DiscordLocale.UKRAINIAN
        if (guildLocaleRaw.startsWith("rus")) return DiscordLocale.RUSSIAN

        val hasCyrillic = userAnswer.any { it in 'а'..'я' || it in UKRAINIAN_ONLY_LETTERS }
        if (!hasCyrillic) return DiscordLocale.ENGLISH_US
        return if (userAnswer.any { it in UKRAINIAN_ONLY_LETTERS }) DiscordLocale.UKRAINIAN else DiscordLocale.RUSSIAN
    }

    private fun resolveMatchedLocale(
        fitsUk: Boolean, fitsRu: Boolean, fitsEn: Boolean,
        forcedLocale: DiscordLocale?, guildLocaleRaw: String, userAnswer: String
    ): DiscordLocale? {
        if (forcedLocale != null) {
            return when (forcedLocale) {
                DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN.takeIf { fitsUk }
                DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN.takeIf { fitsRu }
                else -> DiscordLocale.ENGLISH_US.takeIf { fitsEn }
            }
        }

        val matchCount = listOf(fitsUk, fitsRu, fitsEn).count { it }
        if (matchCount == 0) return null
        if (matchCount == 1) {
            return when {
                fitsUk -> DiscordLocale.UKRAINIAN
                fitsRu -> DiscordLocale.RUSSIAN
                else -> DiscordLocale.ENGLISH_US
            }
        }

        return when {
            fitsUk && guildLocaleRaw.startsWith("ukr") -> DiscordLocale.UKRAINIAN
            fitsRu && guildLocaleRaw.startsWith("rus") -> DiscordLocale.RUSSIAN
            fitsEn && guildLocaleRaw.startsWith("eng") -> DiscordLocale.ENGLISH_US
            fitsUk && userAnswer.any { it in UKRAINIAN_ONLY_LETTERS } -> DiscordLocale.UKRAINIAN
            fitsRu -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.author.isBot || !event.isFromGuild) return

        val channelId = event.channel.id
        val guildId = event.guild.id

        val allowedChannelId = GuildConfigRepository.getChannel(guildId)
        if (allowedChannelId == null || channelId != allowedChannelId) return

        val activeAnimal = RuntimeGameState.getActiveAnimal(channelId) ?: return

        val rawAnswer = event.message.contentRaw.lowercase().trim()
        val userId = event.author.id

        val localeRaw = event.guild.locale.languageName.lowercase()

        val (forcedLocale, userAnswer) = LangManager.parseUserAnswer(rawAnswer)

        val fitsUk = activeAnimal.aliasesUk.contains(userAnswer)
        val fitsRu = activeAnimal.aliasesRu.contains(userAnswer)
        val fitsEn = activeAnimal.aliasesEn.contains(userAnswer)

        val defaultLocale = guessAnswerLocale(forcedLocale, localeRaw, userAnswer)
        val matchedLocale = resolveMatchedLocale(fitsUk, fitsRu, fitsEn, forcedLocale, localeRaw, userAnswer)

        if (matchedLocale != null) {

            val selfMember = event.guild.selfMember
            val channel = event.channel.asGuildMessageChannel()

            if (selfMember.hasPermission(channel, net.dv8tion.jda.api.Permission.MESSAGE_MANAGE)) {
                event.message.delete().queue(
                    null,
                    { error -> logger.warn("Failed to delete user's guess message: ${error.message}") }
                )
            } else {
                logger.warn("Skipped message deletion: Missing MESSAGE_MANAGE permission in channel ${channel.name}")
            }

            if (activeAnimal.type == com.wildlivebot.model.AnimalType.BIRD) {
                if (!InventoryRepository.hasTool(userId, "sky_camera")) {
                    val localizedAnimalName = activeAnimal.localizedName(matchedLocale)

                    val noCameraMessage = LangManager.getString(
                        matchedLocale,
                        "game.error.no_camera",
                        event.author.asMention,
                        localizedAnimalName
                    )
                    event.channel.sendMessage(noCameraMessage).queue()
                    return
                }
            }

            RuntimeGameState.removeActiveAnimal(channelId)
            RuntimeGameState.removeActiveBait(channelId)

            val pointsToAward = activeAnimal.rarity.rewardPoints
            val totalPoints = LeaderboardRepository.addPoints(userId, pointsToAward)

            CollectionRepository.catchAnimal(userId, activeAnimal.id)
            QuestRepository.updateProgress(userId, activeAnimal)

            val unlocked = AchievementService.checkAndUnlock(userId)

            val successEmbed = EmbedBuilder()
                .setTitle(LangManager.getString(matchedLocale, "game.correct_catch"))
                .setDescription(LangManager.getString(matchedLocale, "game.congratulations", event.author.asMention, "???"))
                .addField(LangManager.getString(matchedLocale, "game.points_earned"), "+$pointsToAward 🏆 (${activeAnimal.rarity.displayName})", true)
                .addField(LangManager.getString(matchedLocale, "game.total_score"), "$totalPoints 🪙", true)
                .setColor(Color.GREEN)
                .build()

            val revealButton = Button.secondary(
                "reveal:${activeAnimal.id}:$userId",
                LangManager.getString(matchedLocale, "game.reveal_button")
            )

            event.channel.sendMessageEmbeds(successEmbed)
                .setComponents(ActionRow.of(revealButton))
                .queue()

            event.channel.sendMessageEmbeds(successEmbed)
                .setComponents(ActionRow.of(revealButton))
                .queue()

            sendAchievementUnlocks(event.channel, matchedLocale, unlocked)
        }
        else {
            val customHintKey = activeAnimal.hints[userAnswer]

            if (customHintKey != null) {
                val hintResponse = LangManager.getString(defaultLocale, customHintKey)
                event.message.reply(hintResponse).queue()
                return
            }

            val earnedPoints = RuntimeGameState.addPointsForWrongGuess(channelId, userId)
            if (earnedPoints) {
                LeaderboardRepository.addPoints(userId, GameConfigRepository.current().wrongGuessPoints)
            }
            val totalPoints = LeaderboardRepository.getPoints(userId)

            if (earnedPoints) {
                val response = LangManager.getString(defaultLocale, "game.wrong_name", totalPoints)
                event.message.reply(response).queue()
            } else {
                val response = LangManager.getString(defaultLocale, "game.still_wrong", totalPoints)
                event.message.reply(response).queue()
            }
        }
    }

    override fun onButtonInteraction(event: ButtonInteractionEvent) {
        if (event.componentId.startsWith("col:prev:") || event.componentId.startsWith("col:next:")) {
            val parts = event.componentId.split(":")
            val action = parts[1]
            val ownerId = parts[2]
            val currentIndex = parts[3].toInt()
            val clickerId = event.user.id

            val userLocale = event.userLocale
            val displayLocale = LangManager.getSupportedLocale(userLocale)

            if (clickerId != ownerId) {
                val failMessage = LangManager.getString(displayLocale, "game.reveal.locked_error")
                event.reply(failMessage).setEphemeral(true).queue()
                return
            }

            val newIndex = if (action == "next") currentIndex + 1 else currentIndex - 1

            val response = com.wildlivebot.command.CollectionCommand.buildCollectionPage(
                ownerId,
                newIndex,
                event.user.name,
                displayLocale
            )

            event.editMessageEmbeds(response.first)
                .setComponents(ActionRow.of(response.second))
                .queue()
            return
        }

        if (!event.componentId.startsWith("reveal:")) return

        val parts = event.componentId.split(":")
        val animalId = parts[1]
        val catcherId = parts[2]
        val clickerId = event.user.id

        val userLocale = event.userLocale
        val displayLocale = LangManager.getSupportedLocale(userLocale)

        if (clickerId != catcherId) {
            val failMessage = LangManager.getString(displayLocale, "game.reveal.locked_error")
            event.reply(failMessage).setEphemeral(true).queue()
            return
        }

        val animal = AnimalRepository.getAnimalById(animalId)
        if (animal == null) {
            event.reply("Critical error: Animal not found.").setEphemeral(true).queue()
            return
        }

        val animalName = animal.localizedName(displayLocale)

        val randomFactObject = animal.facts.random()
        val translatedFact: String = randomFactObject.localizedText(displayLocale)

        val revealEmbed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "game.reveal.title"))
            .addField(LangManager.getString(displayLocale, "game.reveal.name"), "**$animalName**", false)
            .addField(LangManager.getString(displayLocale, "game.fun_fact"), translatedFact, false)
            .setColor(Color.decode(animal.rarity.colorHex))
            .build()

        event.replyEmbeds(revealEmbed).setEphemeral(true).queue()
    }
}