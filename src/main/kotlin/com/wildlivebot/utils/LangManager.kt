package com.wildlivebot.utils

import net.dv8tion.jda.api.interactions.DiscordLocale
import java.text.MessageFormat
import java.util.ResourceBundle
import java.util.Locale

object LangManager {
    private val bundles = mapOf(
        DiscordLocale.RUSSIAN to ResourceBundle.getBundle("messages", Locale("ru")),
        DiscordLocale.UKRAINIAN to ResourceBundle.getBundle("messages", Locale("uk")),
        DiscordLocale.ENGLISH_US to ResourceBundle.getBundle("messages", Locale("en"))
    )

    private val defaultBundle = ResourceBundle.getBundle("messages", Locale("en"))

    private val prefixToLocale = mapOf(
        "укр" to DiscordLocale.UKRAINIAN,
        "ukr" to DiscordLocale.UKRAINIAN,
        "ua" to DiscordLocale.UKRAINIAN,
        "рус" to DiscordLocale.RUSSIAN,
        "ру" to DiscordLocale.RUSSIAN,
        "rus" to DiscordLocale.RUSSIAN,
        "ru" to DiscordLocale.RUSSIAN,
        "eng" to DiscordLocale.ENGLISH_US,
        "en" to DiscordLocale.ENGLISH_US
    )

    fun getGuildLocale(languageName: String): DiscordLocale {
        val name = languageName.lowercase()
        return when {
            name.startsWith("ukr") -> DiscordLocale.UKRAINIAN
            name.startsWith("rus") -> DiscordLocale.RUSSIAN
            else -> DiscordLocale.ENGLISH_US
        }
    }

    fun parseUserAnswer(rawAnswer: String): Pair<DiscordLocale?, String> {
        val parts = rawAnswer.split("\\s+".toRegex(), 2)
        if (parts.size < 2) return Pair(null, rawAnswer)

        val firstWord = parts[0].lowercase()
        val targetLocale = prefixToLocale[firstWord]

        return if (targetLocale != null) {
            Pair(targetLocale, parts[1].trim())
        } else {
            Pair(null, rawAnswer)
        }
    }

    fun getString(locale: DiscordLocale, key: String, vararg args: Any): String {
        val bundle = bundles[locale] ?: defaultBundle
        val template = if (bundle.containsKey(key)) bundle.getString(key) else defaultBundle.getString(key)
        return MessageFormat.format(template, *args)
    }
}