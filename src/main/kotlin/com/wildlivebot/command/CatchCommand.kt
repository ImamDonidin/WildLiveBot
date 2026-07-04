package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.regestry.AnimalRepository
import com.wildlivebot.utils.LangManager
import com.wildlivebot.util.ImageUtils
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.utils.FileUpload
import java.awt.Color
import org.slf4j.LoggerFactory

class CatchCommand : ListenerAdapter() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "catch") return

        event.deferReply().queue({ hook ->
            val userLocale = event.userLocale
            val displayLocale = when (userLocale) {
                DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
                DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
                else -> DiscordLocale.ENGLISH_US
            }

            try {
                val userId = event.user.id
                val channelId = event.channel.id
                val guildId = event.guild?.id ?: return@queue

                val allowedChannelId = GameManager.getGuildChannel(guildId)
                if (allowedChannelId == null) {
                    hook.sendMessage(LangManager.getString(displayLocale, "command.catch.setup_required")).queue()
                    return@queue
                }

                if (channelId != allowedChannelId) {
                    hook.sendMessage(LangManager.getString(displayLocale, "command.catch.wrong_channel", allowedChannelId)).queue()
                    return@queue
                }

                val remainingSeconds = GameManager.getRemainingCooldown(userId)
                if (remainingSeconds != null) {
                    val minutes = remainingSeconds / 60
                    val seconds = remainingSeconds % 60
                    hook.sendMessage(LangManager.getString(displayLocale, "command.catch.cooldown", minutes, seconds)).queue()
                    return@queue
                }

                if (GameManager.getActiveAnimal(channelId) != null) {
                    hook.sendMessage(LangManager.getString(displayLocale, "command.catch.already_spawned")).queue()
                    return@queue
                }

                val activeBait = GameManager.getActiveBaitForChannel(channelId)
                val animal = AnimalRepository.getRandomAnimal(activeBait)
                logger.info("Spawning ${animal.nameEn} in channel $channelId for user ${event.user.name}.")

                val imageStream = this::class.java.getResourceAsStream(animal.imagePath)
                if (imageStream == null) {
                    logger.error("Could not find image file at path: ${animal.imagePath}")
                    val err = LangManager.getString(displayLocale, "game.error.image_stream")
                    hook.sendMessage(LangManager.getString(displayLocale, "game.error.prefix", err)).queue()
                    return@queue
                }

                val imageBytes = imageStream.use { stream ->
                    ImageUtils.compressImage(stream, animal.imagePath, maxDimension = 1200, quality = 0.8f)
                }

                if (imageBytes.isEmpty()) {
                    logger.error("Failed to process image bytes for path: ${animal.imagePath}")
                    val err = LangManager.getString(displayLocale, "game.error.image_empty")
                    hook.sendMessage(LangManager.getString(displayLocale, "game.error.prefix", err)).queue()
                    return@queue
                }

                GameManager.setCooldown(userId)
                GameManager.spawnAnimal(channelId, animal)

                if (activeBait != null) {
                    GameManager.removeActiveBaitForChannel(channelId)
                }

                val fileName = animal.imagePath.substringAfterLast("/")
                val file = FileUpload.fromData(imageBytes, fileName)

                val localizedBiome = when (displayLocale) {
                    DiscordLocale.UKRAINIAN -> animal.region.nameUk
                    DiscordLocale.RUSSIAN -> animal.region.nameRu
                    else -> animal.region.nameEn
                }

                val rarityString = LangManager.getString(displayLocale, "game.rarity", animal.rarity.displayName)
                val biomeString = LangManager.getString(displayLocale, "game.biome", localizedBiome)

                val embed = EmbedBuilder()
                    .setTitle(LangManager.getString(displayLocale, "command.catch.title"))
                    .setDescription(LangManager.getString(displayLocale, "command.catch.description"))
                    .setImage("attachment://$fileName")
                    .setColor(Color.decode(animal.rarity.colorHex))
                    .setFooter("$rarityString | $biomeString")
                    .build()

                hook.editOriginalAttachments(file).setEmbeds(embed).queue()

            } catch (e: Exception) {
                logger.error("Error inside deferred catch command block", e)
                val err = LangManager.getString(displayLocale, "game.error.critical")
                hook.sendMessage(LangManager.getString(displayLocale, "game.error.prefix", err)).queue()
            }
        }, { error ->
            logger.warn("Discord API rejected interaction early: ${error.message}")
        })
    }
}