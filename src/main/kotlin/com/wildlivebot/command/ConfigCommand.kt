package com.wildlivebot.command

import com.wildlivebot.game.repository.GameConfigRepository
import com.wildlivebot.utils.LangManager
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.DiscordLocale

class ConfigCommand : ListenerAdapter() {

    private val intFields = setOf(
        "weekly_bonus_points", "wrong_guess_points", "bait_price", "sky_camera_price",
        "quest_region_target", "quest_rarity_target", "quest_type_target", "quest_any_target",
        "roll_common_max", "roll_rare_max", "roll_epic_max", "roll_legendary_max"
    )
    private val longFields = setOf("catch_cooldown_minutes")

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name != "config") return

        val displayLocale = LangManager.getSupportedLocale(event.userLocale)

        val member = event.member ?: return
        if (!member.hasPermission(Permission.MANAGE_SERVER)) {
            event.reply(LangManager.getString(displayLocale, "command.config.no_permission"))
                .setEphemeral(true).queue()
            return
        }

        when (event.subcommandName) {
            "view" -> handleView(event, displayLocale)
            "set" -> handleSet(event, displayLocale)
        }
    }

    private fun handleView(event: SlashCommandInteractionEvent, displayLocale: DiscordLocale) {
        val c = GameConfigRepository.current()
        val lines = listOf(
            "catch_cooldown_minutes" to c.catchCooldownMinutes.toString(),
            "weekly_bonus_points" to c.weeklyBonusPoints.toString(),
            "wrong_guess_points" to c.wrongGuessPoints.toString(),
            "bait_price" to c.baitPrice.toString(),
            "sky_camera_price" to c.skyCameraPrice.toString(),
            "quest_region_target" to c.questRegionTarget.toString(),
            "quest_rarity_target" to c.questRarityTarget.toString(),
            "quest_type_target" to c.questTypeTarget.toString(),
            "quest_any_target" to c.questAnyTarget.toString(),
            "roll_common_max" to c.rollCommonMax.toString(),
            "roll_rare_max" to c.rollRareMax.toString(),
            "roll_epic_max" to c.rollEpicMax.toString(),
            "roll_legendary_max" to c.rollLegendaryMax.toString()
        ).joinToString("\n") { (key, value) ->
            LangManager.getString(displayLocale, "command.config.view_entry", key, value)
        }

        event.reply("${LangManager.getString(displayLocale, "command.config.title")}\n$lines")
            .setEphemeral(true).queue()
    }

    private fun handleSet(event: SlashCommandInteractionEvent, displayLocale: DiscordLocale) {
        val field = event.getOption("field")?.asString ?: return
        val rawValue = event.getOption("value")?.asString ?: return

        if (field !in intFields && field !in longFields) {
            event.reply(LangManager.getString(displayLocale, "command.config.unknown_field"))
                .setEphemeral(true).queue()
            return
        }

        if (field in longFields) {
            val value = rawValue.toLongOrNull()
            if (value == null) {
                event.reply(LangManager.getString(displayLocale, "command.config.invalid_value", field))
                    .setEphemeral(true).queue()
                return
            }
            GameConfigRepository.update { it.copy(catchCooldownMinutes = value) }
        } else {
            val value = rawValue.toIntOrNull()
            if (value == null) {
                event.reply(LangManager.getString(displayLocale, "command.config.invalid_value", field))
                    .setEphemeral(true).queue()
                return
            }
            GameConfigRepository.update { current ->
                when (field) {
                    "weekly_bonus_points" -> current.copy(weeklyBonusPoints = value)
                    "wrong_guess_points" -> current.copy(wrongGuessPoints = value)
                    "bait_price" -> current.copy(baitPrice = value)
                    "sky_camera_price" -> current.copy(skyCameraPrice = value)
                    "quest_region_target" -> current.copy(questRegionTarget = value)
                    "quest_rarity_target" -> current.copy(questRarityTarget = value)
                    "quest_type_target" -> current.copy(questTypeTarget = value)
                    "quest_any_target" -> current.copy(questAnyTarget = value)
                    "roll_common_max" -> current.copy(rollCommonMax = value)
                    "roll_rare_max" -> current.copy(rollRareMax = value)
                    "roll_epic_max" -> current.copy(rollEpicMax = value)
                    "roll_legendary_max" -> current.copy(rollLegendaryMax = value)
                    else -> current
                }
            }
        }

        event.reply(LangManager.getString(displayLocale, "command.config.set_success", field, rawValue)).queue()
    }
}