package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.model.Region
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color
import org.slf4j.LoggerFactory

class ShopCommand : ListenerAdapter() {

    private val logger = LoggerFactory.getLogger(this::class.java)
    private val baitPrice = 150
    private val cameraPrice = 500

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "shop" && event.name != "buy") return

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        val userId = event.user.id

        if (event.name == "shop") {
            val userPoints = GameManager.getPoints(userId)
            val userBaits = GameManager.getUserBaits(userId)
            val hasCamera = GameManager.hasTool(userId, "sky_camera")

            val embed = EmbedBuilder()
                .setTitle(LangManager.getString(displayLocale, "command.shop.title"))
                .setDescription(LangManager.getString(displayLocale, "command.shop.description", userPoints))
                .setColor(Color.ORANGE)

            val goodsList = StringBuilder()

            Region.values().forEach { region ->
                val regionName = when (displayLocale) {
                    DiscordLocale.UKRAINIAN -> region.nameUk
                    DiscordLocale.RUSSIAN -> region.nameRu
                    else -> region.nameEn
                }
                goodsList.append("• **$regionName Bait** `(${region.name.lowercase()})` — **$baitPrice 🪙**\n")
            }

            val cameraName = LangManager.getString(displayLocale, "item.sky_camera.name")
            goodsList.append("\n📷 **$cameraName** `(sky_camera)` — **$cameraPrice 🪙**\n")
            goodsList.append(LangManager.getString(displayLocale, "item.sky_camera.desc"))

            embed.addField(
                LangManager.getString(displayLocale, "command.shop.goods_title"),
                goodsList.toString(),
                false
            )

            val inventoryContent = StringBuilder()

            if (userBaits.isNotEmpty()) {
                val baitsStr = userBaits.entries.mapNotNull { (regionId, count) ->
                    val region = try { Region.valueOf(regionId.uppercase()) } catch (e: Exception) { null }
                    if (region != null) {
                        val name = when (displayLocale) {
                            DiscordLocale.UKRAINIAN -> region.nameUk
                            DiscordLocale.RUSSIAN -> region.nameRu
                            else -> region.nameEn
                        }
                        LangManager.getString(displayLocale, "game.inventory.count", name, count)
                    } else null
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
                        if (GameManager.hasTool(userId, "sky_camera")) {
                            hook.sendMessage(LangManager.getString(displayLocale, "command.buy.already_owned")).queue()
                            return@queue
                        }

                        val success = GameManager.buyTool(userId, "sky_camera", cameraPrice)
                        if (success) {
                            val cameraName = LangManager.getString(displayLocale, "item.sky_camera.name")
                            hook.sendMessage(LangManager.getString(displayLocale, "command.buy.success", cameraName)).queue()
                        } else {
                            hook.sendMessage(LangManager.getString(displayLocale, "command.buy.no_points")).queue()
                        }
                        return@queue
                    }

                    val validRegion = try { Region.valueOf(rawItemId.uppercase()) } catch (e: Exception) { null }

                    if (validRegion == null) {
                        hook.sendMessage(LangManager.getString(displayLocale, "command.buy.wrong_id", rawItemId)).queue()
                        return@queue
                    }

                    val success = GameManager.buyBait(userId, validRegion.name.lowercase(), baitPrice)

                    if (success) {
                        val regionName = when (displayLocale) {
                            DiscordLocale.UKRAINIAN -> validRegion.nameUk
                            DiscordLocale.RUSSIAN -> validRegion.nameRu
                            else -> validRegion.nameEn
                        }
                        hook.sendMessage(LangManager.getString(displayLocale, "command.buy.success", regionName)).queue()
                    } else {
                        hook.sendMessage(LangManager.getString(displayLocale, "command.buy.no_points")).queue()
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