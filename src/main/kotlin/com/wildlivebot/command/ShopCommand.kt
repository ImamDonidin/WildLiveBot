package com.wildlivebot.command

import com.wildlivebot.game.repository.LeaderboardRepository
import com.wildlivebot.game.repository.InventoryRepository
import com.wildlivebot.game.ShopService
import com.wildlivebot.game.repository.GameConfigRepository
import com.wildlivebot.model.Biome
import com.wildlivebot.utils.LangManager
import com.wildlivebot.utils.localizedName
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color
import org.slf4j.LoggerFactory

class ShopCommand : ListenerAdapter() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "shop" && event.name != "buy") return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)
        val userId = event.user.id
        val prices = GameConfigRepository.current()

        if (event.name == "shop") {
            val userPoints = LeaderboardRepository.getPoints(userId)
            val userBaits = InventoryRepository.getBaits(userId)
            val hasCamera = InventoryRepository.hasTool(userId, "sky_camera")

            val embed = EmbedBuilder()
                .setTitle(LangManager.getString(displayLocale, "command.shop.title"))
                .setDescription(LangManager.getString(displayLocale, "command.shop.description", userPoints))
                .setColor(Color.ORANGE)

            val goodsList = StringBuilder()

            Biome.values().forEach { biome ->
                val biomeName = biome.localizedName(displayLocale)
                goodsList.append("• **$biomeName Bait** `(${biome.name.lowercase()})` — **${prices.baitPrice} 🪙**\n")
            }

            val cameraName = LangManager.getString(displayLocale, "item.sky_camera.name")
            goodsList.append("\n📷 **$cameraName** `(sky_camera)` — **${prices.skyCameraPrice} 🪙**\n")
            goodsList.append(LangManager.getString(displayLocale, "item.sky_camera.desc"))

            embed.addField(
                LangManager.getString(displayLocale, "command.shop.goods_title", prices.baitPrice),
                goodsList.toString(),
                false
            )

            val inventoryContent = StringBuilder()

            if (userBaits.isNotEmpty()) {
                val baitsStr = userBaits.entries.mapNotNull { (biomeId, count) ->
                    val biome = try { Biome.valueOf(biomeId.uppercase()) } catch (e: Exception) { null }
                    biome?.let { LangManager.getString(displayLocale, "game.inventory.count", it.localizedName(displayLocale), count) }
                }.joinToString("\n")
                inventoryContent.append(baitsStr)
            }

            if (hasCamera) {
                if (inventoryContent.isNotEmpty()) inventoryContent.append("\n")
                inventoryContent.append("📷 **${LangManager.getString(displayLocale, "item.sky_camera.name")}** (⚙️ Permanent)")
            }

            val finalInventory = inventoryContent.toString().ifEmpty {
                LangManager.getString(displayLocale, "game.inventory.empty")
            }

            embed.addField(
                LangManager.getString(displayLocale, "game.inventory.title"),
                finalInventory,
                false
            )

            event.replyEmbeds(embed.build()).queue()
            return
        }

        if (event.name == "buy") {
            val rawItemId = event.getOption("id")?.asString?.lowercase()?.trim() ?: ""

            event.deferReply().setEphemeral(true).queue({ hook ->
                try {
                    if (rawItemId == "sky_camera") {
                        if (InventoryRepository.hasTool(userId, "sky_camera")) {
                            hook.sendMessage(LangManager.getString(displayLocale, "command.buy.already_owned")).queue()
                            return@queue
                        }

                        val success = ShopService.buyTool(userId, "sky_camera", prices.skyCameraPrice)
                        if (success) {
                            val cameraName = LangManager.getString(displayLocale, "item.sky_camera.name")
                            hook.sendMessage(LangManager.getString(displayLocale, "command.buy.success", cameraName)).queue()

                            val unlocked = com.wildlivebot.game.AchievementService.checkAndUnlock(userId)
                            if (unlocked.isNotEmpty()) sendAchievementUnlocks(hook, displayLocale, unlocked)
                        } else {
                            hook.sendMessage(LangManager.getString(displayLocale, "command.buy.no_points", prices.skyCameraPrice)).queue()
                        }
                        return@queue
                    }

                    val validBiome = try { Biome.valueOf(rawItemId.uppercase()) } catch (e: Exception) { null }

                    if (validBiome == null) {
                        hook.sendMessage(LangManager.getString(displayLocale, "command.buy.wrong_id", rawItemId)).queue()
                        return@queue
                    }

                    val success = ShopService.buyBait(userId, validBiome.name.lowercase(), prices.baitPrice)

                    if (success) {
                        hook.sendMessage(LangManager.getString(displayLocale, "command.buy.success", validBiome.localizedName(displayLocale))).queue()
                    } else {
                        hook.sendMessage(LangManager.getString(displayLocale, "command.buy.no_points", prices.baitPrice)).queue()
                    }
                } catch (e: Exception) {
                    logger.error("Error inside deferred buy command block", e)
                    val err = LangManager.getString(displayLocale, "game.error.critical")
                    hook.sendMessage(LangManager.getString(displayLocale, "game.error.prefix", err)).queue()
                }
            }, { error ->
                logger.warn("Discord API rejected /buy interaction: ${error.message}")
            })
            return
        }
    }
}