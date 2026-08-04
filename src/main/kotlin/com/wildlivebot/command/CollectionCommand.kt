package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.regestry.AnimalRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button
import java.awt.Color

class CollectionCommand : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "collection" && event.name != "collection_list") return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)
        val userId = event.user.id
        val caughtIds = GameManager.getUserCollection(userId)

        val embed = EmbedBuilder()
            .setTitle(LangManager.getString(displayLocale, "command.collection.title", event.user.name))
            .setColor(Color.MAGENTA)

        if (caughtIds.isEmpty()) {
            embed.setDescription(LangManager.getString(displayLocale, "command.collection.empty"))
            event.replyEmbeds(embed.build()).setEphemeral(true).queue()
            return
        }

        val response = buildCollectionPage(userId, 0, event.user.name, displayLocale)

        event.replyEmbeds(response.first)
            .setActionRow(response.second)
            .queue()
    }

    companion object {
        fun buildCollectionPage(
            userId: String,
            targetRarityIndex: Int,
            userName: String,
            displayLocale: net.dv8tion.jda.api.interactions.DiscordLocale
        ): Pair<net.dv8tion.jda.api.entities.MessageEmbed, List<Button>> {

            val caughtIds = GameManager.getUserCollection(userId)
            val caughtCounts = caughtIds.groupingBy { it.lowercase().trim() }.eachCount()
            val allAnimals = AnimalRepository.getAllAnimals()

            val userAnimalsByRarity = allAnimals
                .filter { caughtCounts.containsKey(it.id.lowercase().trim()) }
                .groupBy { it.rarity }
                .entries
                .sortedBy { it.key.ordinal }

            val totalUniqueCaught = allAnimals.count { caughtCounts.containsKey(it.id.lowercase().trim()) }

            val embed = EmbedBuilder()
                .setTitle(LangManager.getString(displayLocale, "command.collection.title", userName))
                .setColor(Color.MAGENTA)
                .setDescription(
                    LangManager.getString(
                        displayLocale,
                        "command.collection.description",
                        totalUniqueCaught,
                        allAnimals.size,
                        caughtIds.size
                    )
                )

            val safeIndex = targetRarityIndex.coerceIn(0, userAnimalsByRarity.lastIndex)
            val currentEntry = userAnimalsByRarity[safeIndex]
            val rarity = currentEntry.key
            val animals = currentEntry.value

            val raritySectionContent = StringBuilder()
            animals.forEach { animal ->
                val count = caughtCounts[animal.id.lowercase().trim()] ?: 0
                val animalName = when (displayLocale) {
                    net.dv8tion.jda.api.interactions.DiscordLocale.UKRAINIAN -> animal.nameUk
                    net.dv8tion.jda.api.interactions.DiscordLocale.RUSSIAN -> animal.nameRu
                    else -> animal.nameEn
                }
                val countSuffix = if (count > 1) " — **$count ${LangManager.getString(displayLocale, "game.pcs")}**" else ""
                raritySectionContent.append("• $animalName$countSuffix\n")
            }

            embed.addField(
                "📖 ${rarity.displayName} (Tom ${safeIndex + 1}/${userAnimalsByRarity.size})",
                raritySectionContent.toString(),
                false
            )

            val buttons = mutableListOf<Button>()

            buttons.add(
                Button.primary("col:prev:$userId:$safeIndex", "◀")
                    .withDisabled(safeIndex == 0)
            )

            buttons.add(
                Button.primary("col:next:$userId:$safeIndex", "▶")
                    .withDisabled(safeIndex == userAnimalsByRarity.lastIndex)
            )

            return Pair(embed.build(), buttons)
        }
    }
}