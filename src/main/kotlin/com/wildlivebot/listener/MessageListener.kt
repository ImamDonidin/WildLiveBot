package com.wildlivebot.listener

import com.wildlivebot.game.GameManager
import com.wildlivebot.regestry.AnimalRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button
import java.awt.Color
import org.slf4j.LoggerFactory

class MessageListener : ListenerAdapter() {
    private val logger = LoggerFactory.getLogger(MessageListener::class.java)

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.author.isBot || !event.isFromGuild) return

        val channelId = event.channel.id
        val guildId = event.guild.id

        val allowedChannelId = GameManager.getGuildChannel(guildId)
        if (allowedChannelId == null || channelId != allowedChannelId) return

        val activeAnimal = GameManager.getActiveAnimal(channelId) ?: return

        val rawAnswer = event.message.contentRaw.lowercase().trim()
        val userId = event.author.id

        val localeRaw = event.guild.locale.languageName.lowercase()
        val serverLocale = LangManager.getGuildLocale(localeRaw)

        val (forcedLocale, userAnswer) = LangManager.parseUserAnswer(rawAnswer)

        val fitsUk = activeAnimal.aliasesUk.contains(userAnswer)
        val fitsRu = activeAnimal.aliasesRu.contains(userAnswer)
        val fitsEn = activeAnimal.aliasesEn.contains(userAnswer)

        val hasCyrillic = userAnswer.any { it in 'а'..'я' || it == 'і' || it == 'ї' || it == 'є' || it == 'ґ' }
        val defaultLocale = when {
            forcedLocale != null -> forcedLocale
            localeRaw.startsWith("ukr") -> DiscordLocale.UKRAINIAN
            localeRaw.startsWith("rus") -> DiscordLocale.RUSSIAN
            hasCyrillic -> {
                if (userAnswer.any { it in listOf('і', 'ї', 'є', 'ґ') }) DiscordLocale.UKRAINIAN
                else DiscordLocale.RUSSIAN
            }
            else -> DiscordLocale.ENGLISH_US
        }

        val matchedLocale = if (forcedLocale != null) {
            when (forcedLocale) {
                DiscordLocale.UKRAINIAN -> if (fitsUk) DiscordLocale.UKRAINIAN else null
                DiscordLocale.RUSSIAN -> if (fitsRu) DiscordLocale.RUSSIAN else null
                else -> if (fitsEn) DiscordLocale.ENGLISH_US else null
            }
        } else {
            when {
                !fitsUk && !fitsRu && !fitsEn -> null

                fitsUk && !fitsRu && !fitsEn -> DiscordLocale.UKRAINIAN
                fitsRu && !fitsUk && !fitsEn -> DiscordLocale.RUSSIAN
                fitsEn && !fitsUk && !fitsRu -> DiscordLocale.ENGLISH_US

                fitsUk && localeRaw.startsWith("ukr") -> DiscordLocale.UKRAINIAN
                fitsRu && localeRaw.startsWith("rus") -> DiscordLocale.RUSSIAN
                fitsEn && localeRaw.startsWith("eng") -> DiscordLocale.ENGLISH_US

                fitsUk && userAnswer.any { it in listOf('і', 'ї', 'є', 'ґ') } -> DiscordLocale.UKRAINIAN
                fitsRu -> DiscordLocale.RUSSIAN
                else -> DiscordLocale.ENGLISH_US
            }
        }

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
                if (!GameManager.hasTool(userId, "sky_camera")) {
                    val localizedAnimalName = when (matchedLocale) {
                        DiscordLocale.UKRAINIAN -> activeAnimal.nameUk
                        DiscordLocale.RUSSIAN -> activeAnimal.nameRu
                        else -> activeAnimal.nameEn
                    }

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

            GameManager.removeActiveAnimal(channelId)
            GameManager.removeActiveBaitForChannel(channelId)

            val pointsToAward = activeAnimal.rarity.rewardPoints
            val totalPoints = GameManager.addPoints(userId, pointsToAward)

            GameManager.catchAnimalForCollection(userId, activeAnimal.id)
            GameManager.updateQuestProgress(userId, activeAnimal)

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
                .setActionRow(revealButton)
                .queue()
        }
        else {
            val customHintKey = activeAnimal.hints[userAnswer]

            if (customHintKey != null) {
                val hintResponse = LangManager.getString(defaultLocale, customHintKey)
                event.message.reply(hintResponse).queue()
                return
            }

            val earnedPoints = GameManager.addPointsForWrongGuess(channelId, userId)
            val totalPoints = GameManager.getPoints(userId)

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
                .setActionRow(response.second)
                .queue()
            return
        }

        if (!event.componentId.startsWith("reveal:")) return

        val parts = event.componentId.split(":")
        val animalId = parts[1]
        val catcherId = parts[2]
        val clickerId = event.user.id

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        if (clickerId != catcherId) {
            val failMessage = LangManager.getString(displayLocale, "game.reveal.locked_error")
            event.reply(failMessage).setEphemeral(true).queue()
            return
        }

        val animal = com.wildlivebot.regestry.AnimalRepository.getAnimalById(animalId)
        if (animal == null) {
            event.reply("Critical error: Animal not found.").setEphemeral(true).queue()
            return
        }

        val animalName = when (displayLocale) {
            DiscordLocale.UKRAINIAN -> animal.nameUk
            DiscordLocale.RUSSIAN -> animal.nameRu
            else -> animal.nameEn
        }

        val randomFactObject = animal.facts.random()
        val translatedFact = when (displayLocale) {
            DiscordLocale.UKRAINIAN -> randomFactObject.uk
            DiscordLocale.RUSSIAN -> randomFactObject.ru
            else -> randomFactObject.en
        }

        val revealEmbed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "game.reveal.title"))
            .addField(LangManager.getString(displayLocale, "game.reveal.name"), "**$animalName**", false)
            .addField(LangManager.getString(displayLocale, "game.fun_fact"), translatedFact, false)
            .setColor(Color.decode(animal.rarity.colorHex))
            .build()

        event.replyEmbeds(revealEmbed).setEphemeral(true).queue()
    }
}