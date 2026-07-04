package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.regestry.AnimalRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class ProfileCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "profile") return

        val targetUser = event.getOption("user")?.asUser ?: event.user
        val userId = targetUser.id

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        val points = GameManager.getPoints(userId)
        val rank = GameManager.getUserRank(userId)

        val collection = GameManager.getUserCollection(userId)
        val uniqueCaughtCount = collection.distinct().size
        val totalAnimalsCount = AnimalRepository.getAllAnimals().size
        val totalCaughtCount = collection.size

        val progressPercent = if (totalAnimalsCount > 0) (uniqueCaughtCount * 100) / totalAnimalsCount else 0
        val filledBlocks = progressPercent / 10
        val progressBar = "🟩".repeat(filledBlocks) + "⬜".repeat(10 - filledBlocks)

        val favAnimalId = GameManager.getFavoriteAnimalId(userId)
        val favAnimal = favAnimalId?.let { AnimalRepository.getAnimalById(it) }

        val embed = EmbedBuilder()
            .setAuthor(LangManager.getString(displayLocale, "command.profile.author", targetUser.name), null, targetUser.effectiveAvatarUrl)
            .addField(LangManager.getString(displayLocale, "command.profile.score"), LangManager.getString(displayLocale, "command.profile.score_value", points), true)
            .addField(LangManager.getString(displayLocale, "command.profile.rank"), "#$rank", true)

            .addField(
                LangManager.getString(displayLocale, "command.profile.collection"),
                "🎒 $uniqueCaughtCount / $totalAnimalsCount\n✨ Total caught: **$totalCaughtCount**\n$progressBar",
                false
            )

        if (favAnimal != null) {
            val animalName = when (displayLocale) {
                DiscordLocale.UKRAINIAN -> favAnimal.nameUk
                DiscordLocale.RUSSIAN -> favAnimal.nameRu
                else -> favAnimal.nameEn
            }
            embed.addField(LangManager.getString(displayLocale, "command.profile.favorite"), "**$animalName** (${favAnimal.rarity.displayName})", false)
            embed.setColor(Color.decode(favAnimal.rarity.colorHex))
        } else {
            embed.addField(LangManager.getString(displayLocale, "command.profile.favorite"), LangManager.getString(displayLocale, "command.profile.favorite_none"), false)
            embed.setColor(Color.ORANGE)
        }

        embed.setFooter(LangManager.getString(displayLocale, "command.profile.footer_hint"))

        event.replyEmbeds(embed.build()).queue()
    }
}