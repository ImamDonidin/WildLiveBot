package com.wildlivebot.utils

import com.wildlivebot.model.Achievement
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.InteractionHook
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel

fun buildAchievementMessage(locale: DiscordLocale, unlocked: List<Achievement>): String {
    val lines = unlocked.joinToString("\n") { ach ->
        LangManager.getString(locale, "achievement.unlocked.line", ach.icon, ach.localizedName(locale), ach.localizedDescription(locale))
    }
    return "${LangManager.getString(locale, "achievement.unlocked.title")}\n$lines"
}

fun sendAchievementUnlocks(hook: InteractionHook, locale: DiscordLocale, unlocked: List<Achievement>) {
    if (unlocked.isEmpty()) return
    hook.sendMessage(buildAchievementMessage(locale, unlocked)).queue()
}

fun sendAchievementUnlocks(channel: MessageChannel, locale: DiscordLocale, unlocked: List<Achievement>) {
    if (unlocked.isEmpty()) return
    channel.sendMessage(buildAchievementMessage(locale, unlocked)).queue()
}