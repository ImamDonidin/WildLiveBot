package com.wildlivebot.command

import com.wildlivebot.game.GameManager
import com.wildlivebot.model.Region
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class UseCommand : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "use") return

        val userLocale = event.userLocale
        val displayLocale = when (userLocale) {
            DiscordLocale.UKRAINIAN -> DiscordLocale.UKRAINIAN
            DiscordLocale.RUSSIAN -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }

        val userId = event.user.id
        val channelId = event.channel.id
        val baitId = event.getOption("id")?.asString?.lowercase()?.trim() ?: ""

        val validRegion = try {
            Region.valueOf(baitId.uppercase())
        } catch (e: Exception) {
            null
        }

        if (validRegion == null) {
            event.reply(LangManager.getString(displayLocale, "command.use.wrong_id", baitId))
                .setEphemeral(true).queue()
            return
        }

        val cleanBaitId = validRegion.name.lowercase()
        val activated = GameManager.useBait(userId, channelId, cleanBaitId)

        if (activated) {
            val regionName = when (displayLocale) {
                DiscordLocale.UKRAINIAN -> validRegion.nameUk
                DiscordLocale.RUSSIAN -> validRegion.nameRu
                else -> validRegion.nameEn
            }
            event.reply(LangManager.getString(displayLocale, "command.use.success", regionName)).queue()
        } else {
            event.reply(LangManager.getString(displayLocale, "command.use.no_bait", baitId))
                .setEphemeral(true).queue()
        }
    }
}