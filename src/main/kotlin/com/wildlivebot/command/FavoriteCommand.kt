package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.regestry.AnimalRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class FavoriteCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "favorite") return

        val input = event.getOption("animal")?.asString?.trim() ?: return
        val userId = event.user.id

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        val animal = AnimalRepository.getAnimalById(input)
            ?: AnimalRepository.getAllAnimals().find {
                it.nameEn.equals(input, ignoreCase = true) ||
                        it.nameRu.equals(input, ignoreCase = true) ||
                        it.nameUk.equals(input, ignoreCase = true) ||
                        it.aliasesEn.contains(input) ||
                        it.aliasesRu.contains(input) ||
                        it.aliasesUk.contains(input)
            }

        if (animal == null) {
            event.reply(LangManager.getString(displayLocale, "command.favorite.not_found", input))
                .setEphemeral(true).queue()
            return
        }

        val animalName = when (displayLocale) {
            DiscordLocale.UKRAINIAN -> animal.nameUk
            DiscordLocale.RUSSIAN -> animal.nameRu
            else -> animal.nameEn
        }

        val success = GameManager.setFavoriteAnimal(userId, animal.id)

        if (success) {
            event.reply(LangManager.getString(displayLocale, "command.favorite.success", animalName))
                .queue()
        } else {
            event.reply(LangManager.getString(displayLocale, "command.favorite.not_caught", animalName))
                .setEphemeral(true).queue()
        }
    }
}