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
                goodsList.append("• **$regionName** `(${region.name.lowercase()})`\n")
            }

            embed.addField(
                LangManager.getString(displayLocale, "command.shop.goods_title"),
                goodsList.toString(),
                false
            )

            val inventoryContent = if (userBaits.isEmpty()) {
                LangManager.getString(displayLocale, "game.inventory.empty")
            } else {
                userBaits.entries.mapNotNull { (regionId, count) ->
                    val region = try { Region.valueOf(regionId.uppercase()) } catch (e: Exception) { null }

                    if (region != null) {
                        val name = when (displayLocale) {
                            DiscordLocale.UKRAINIAN -> region.nameUk
                            DiscordLocale.RUSSIAN -> region.nameRu
                            else -> region.nameEn
                        }
                        LangManager.getString(displayLocale, "game.inventory.count", name, count)
                    } else null
                }.joinToString("\n").ifEmpty { LangManager.getString(displayLocale, "game.inventory.empty") }
            }

            embed.addField(
                LangManager.getString(displayLocale, "game.inventory.title"),
                inventoryContent,
                false
            )

            event.replyEmbeds(embed.build()).queue()
            return
        }

        if (event.name == "buy") {
            val baitId = event.getOption("id")?.asString?.lowercase()?.trim() ?: ""

            val validRegion = try {
                Region.valueOf(baitId.uppercase())
            } catch (e: Exception) {
                null
            }

            if (validRegion == null) {
                event.reply(LangManager.getString(displayLocale, "command.buy.wrong_id", baitId))
                    .setEphemeral(true).queue()
                return
            }

            event.deferReply().setEphemeral(true).queue({ hook ->
                try {
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