package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.regestry.AnimalRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class CollectionCommand : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "collection" && event.name != "collection_list") return

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        val userId = event.user.id

        val caughtIds = GameManager.getUserCollection(userId)

        val embed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "command.collection.title", event.user.name))
            .setColor(Color.MAGENTA)

        if (caughtIds.isEmpty()) {
            embed.setDescription(LangManager.getString(displayLocale, "command.collection.empty"))
            event.replyEmbeds(embed.build()).queue()
            return
        }

        val caughtCounts = caughtIds.groupingBy { it.lowercase().trim() }.eachCount()

        val allAnimals = AnimalRepository.getAllAnimals()

        val animalsByRarity = allAnimals.groupBy { it.rarity }

        var totalUniqueCaught = 0

        animalsByRarity.keys.sortedBy { it.ordinal }.forEach { rarity ->
            val animalsInRarity = animalsByRarity[rarity] ?: return@forEach

            val raritySectionContent = StringBuilder()

            animalsInRarity.forEach { animal ->
                val count = caughtCounts[animal.id.lowercase().trim()] ?: 0

                if (count > 0) {
                    totalUniqueCaught++

                    val animalName = when (displayLocale) {
                        DiscordLocale.UKRAINIAN -> animal.nameUk
                        DiscordLocale.RUSSIAN -> animal.nameRu
                        else -> animal.nameEn
                    }

                    val countSuffix = if (count > 1) " — **$count ${LangManager.getString(displayLocale, "game.pcs")}**" else ""
                    raritySectionContent.append("• $animalName$countSuffix\n")
                }
            }

            if (raritySectionContent.isNotEmpty()) {
                embed.addField(
                    "${rarity.displayName}",
                    raritySectionContent.toString(),
                    false
                )
            }
        }

        embed.setDescription(
            LangManager.getString(
                displayLocale,
                "command.collection.description",
                totalUniqueCaught,
                allAnimals.size,
                caughtIds.size
            )
        )

        event.replyEmbeds(embed.build()).queue()
    }
}