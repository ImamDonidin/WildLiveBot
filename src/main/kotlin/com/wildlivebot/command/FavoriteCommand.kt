package com.wildlivebot.command

import com.wildlivebot.game.repository.CollectionRepository
import com.wildlivebot.registry.AnimalRepository
import com.wildlivebot.utils.LangManager
import com.wildlivebot.utils.localizedName
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class FavoriteCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "favorite") return

        val input = event.getOption("animal")?.asString?.trim() ?: return
        val userId = event.user.id

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

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

        val animalName = animal.localizedName(displayLocale)

        val success = CollectionRepository.setFavorite(userId, animal.id)

        if (success) {
            event.reply(LangManager.getString(displayLocale, "command.favorite.success", animalName))
                .queue()
        } else {
            event.reply(LangManager.getString(displayLocale, "command.favorite.not_caught", animalName))
                .setEphemeral(true).queue()
        }
    }
}