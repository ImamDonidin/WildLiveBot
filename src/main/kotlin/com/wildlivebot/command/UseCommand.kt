package com.wildlivebot.command

import com.wildlivebot.game.ShopService
import com.wildlivebot.model.Biome
import com.wildlivebot.utils.LangManager
import com.wildlivebot.utils.localizedName
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class UseCommand : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "use") return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

        val userId = event.user.id
        val channelId = event.channel.id
        val baitId = event.getOption("id")?.asString?.lowercase()?.trim() ?: ""

        val validBiome = try {
            Biome.valueOf(baitId.uppercase())
        } catch (e: Exception) {
            null
        }

        if (validBiome == null) {
            event.reply(LangManager.getString(displayLocale, "command.use.wrong_id", baitId))
                .setEphemeral(true).queue()
            return
        }

        val cleanBaitId = validBiome.name.lowercase()
        val activated = ShopService.useBait(userId, channelId, cleanBaitId)

        if (activated) {
            val regionName = validBiome.localizedName(displayLocale)
            event.reply(LangManager.getString(displayLocale, "command.use.success", regionName)).queue()
        } else {
            event.reply(LangManager.getString(displayLocale, "command.use.no_bait", baitId))
                .setEphemeral(true).queue()
        }
    }
}