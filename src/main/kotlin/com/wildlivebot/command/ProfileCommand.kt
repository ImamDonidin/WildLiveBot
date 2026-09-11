package com.wildlivebot.command

import com.wildlivebot.game.GameConfig
import com.wildlivebot.game.repository.LeaderboardRepository
import com.wildlivebot.game.repository.CollectionRepository
import com.wildlivebot.registry.AnimalRepository
import com.wildlivebot.utils.LangManager
import com.wildlivebot.utils.localizedName
import net.dv8tion.jda.api.EmbedBuilder
import com.wildlivebot.game.repository.AchievementRepository
import com.wildlivebot.model.Achievement
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class ProfileCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "profile") return

        val targetUser = event.getOption("user")?.asUser ?: event.user
        val userId = targetUser.id

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

        val points = LeaderboardRepository.getPoints(userId)
        val rank = LeaderboardRepository.getUserRank(userId)

        val collection = CollectionRepository.getCollection(userId)
        val uniqueCaughtCount = collection.distinct().size
        val totalAnimalsCount = AnimalRepository.getAllAnimals().size
        val totalCaughtCount = collection.size

        val progressPercent = if (totalAnimalsCount > 0) (uniqueCaughtCount * 100) / totalAnimalsCount else 0
        val filledBlocks = progressPercent / GameConfig.PROGRESS_BAR_SEGMENTS
        val progressBar = "🟩".repeat(filledBlocks) + "⬜".repeat(GameConfig.PROGRESS_BAR_SEGMENTS - filledBlocks)

        val favAnimalId = CollectionRepository.getFavorite(userId)
        val favAnimal = favAnimalId?.let { AnimalRepository.getAnimalById(it) }

        val collectionValue = LangManager.getString(displayLocale, "command.profile.collection_value", uniqueCaughtCount, totalAnimalsCount)
        val totalCaughtLine = LangManager.getString(displayLocale, "command.profile.total_caught", totalCaughtCount)

        val embed = EmbedBuilder()
            .setAuthor(LangManager.getString(displayLocale, "command.profile.author", targetUser.name), null, targetUser.effectiveAvatarUrl)
            .addField(LangManager.getString(displayLocale, "command.profile.score"), LangManager.getString(displayLocale, "command.profile.score_value", points), true)
            .addField(LangManager.getString(displayLocale, "command.profile.rank"), "#$rank", true)

            .addField(
                LangManager.getString(displayLocale, "command.profile.collection"),
                "🎒 $collectionValue\n$totalCaughtLine\n$progressBar",
                false
            )

        val unlockedAchievements = AchievementRepository.getUnlocked(userId)
        val achievementsValue = if (unlockedAchievements.isEmpty()) {
            LangManager.getString(displayLocale, "command.profile.achievements_none")
        } else {
            unlockedAchievements.joinToString(" ") { it.icon }
        }
        embed.addField(
            LangManager.getString(displayLocale, "command.profile.achievements", unlockedAchievements.size, Achievement.values().size),
            achievementsValue,
            false
        )

        if (favAnimal != null) {
            val animalName = favAnimal.localizedName(displayLocale)
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