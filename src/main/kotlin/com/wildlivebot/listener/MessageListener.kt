package com.wildlivebot.listener

import com.wildlivebot.game.GameManager
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class MessageListener : ListenerAdapter() {

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
            GameManager.removeActiveAnimal(channelId)

            val pointsToAward = activeAnimal.rarity.rewardPoints
            val totalPoints = GameManager.addPoints(userId, pointsToAward)

            GameManager.catchAnimalForCollection(userId, activeAnimal.id)

            GameManager.updateQuestProgress(userId, activeAnimal)

            val animalName = when (matchedLocale) {
                DiscordLocale.UKRAINIAN -> activeAnimal.nameUk
                DiscordLocale.RUSSIAN -> activeAnimal.nameRu
                else -> activeAnimal.nameEn
            }

            val randomFactObject = activeAnimal.facts.random()
            val translatedFact = when (matchedLocale) {
                DiscordLocale.UKRAINIAN -> randomFactObject.uk
                DiscordLocale.RUSSIAN -> randomFactObject.ru
                else -> randomFactObject.en
            }

            val successEmbed = EmbedBuilder()
                .setTitle(LangManager.getString(matchedLocale, "game.correct_catch"))
                .setDescription(LangManager.getString(matchedLocale, "game.congratulations", event.author.asMention, animalName))
                .addField(LangManager.getString(matchedLocale, "game.points_earned"), "+$pointsToAward 🏆 (${activeAnimal.rarity.displayName})", true)
                .addField(LangManager.getString(matchedLocale, "game.total_score"), "$totalPoints 🪙", true)
                .addField(LangManager.getString(matchedLocale, "game.fun_fact"), translatedFact, false)
                .setColor(Color.GREEN)
                .build()

            event.channel.sendMessageEmbeds(successEmbed).queue()
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
}