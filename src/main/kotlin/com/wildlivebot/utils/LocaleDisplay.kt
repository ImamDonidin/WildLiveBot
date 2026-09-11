package com.wildlivebot.utils

import com.wildlivebot.model.Achievement
import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Fact
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Biome
import net.dv8tion.jda.api.interactions.DiscordLocale

fun Biome.localizedName(locale: DiscordLocale): String = when (locale) {
    DiscordLocale.UKRAINIAN -> nameUk
    DiscordLocale.RUSSIAN -> nameRu
    else -> nameEn
}

fun Rarity.localizedName(locale: DiscordLocale): String = when (locale) {
    DiscordLocale.UKRAINIAN -> displayNameUk
    DiscordLocale.RUSSIAN -> displayNameRu
    else -> displayName
}

fun AnimalType.localizedName(locale: DiscordLocale): String = when (locale) {
    DiscordLocale.UKRAINIAN -> displayNameUk
    DiscordLocale.RUSSIAN -> displayNameRu
    else -> displayNameEn
}

fun Animal.localizedName(locale: DiscordLocale): String = when (locale) {
    DiscordLocale.UKRAINIAN -> nameUk
    DiscordLocale.RUSSIAN -> nameRu
    else -> nameEn
}

fun Fact.localizedText(locale: DiscordLocale): String = when (locale) {
    DiscordLocale.UKRAINIAN -> uk
    DiscordLocale.RUSSIAN -> ru
    else -> en
}

fun Achievement.localizedName(locale: DiscordLocale): String = when (locale) {
    DiscordLocale.UKRAINIAN -> nameUk
    DiscordLocale.RUSSIAN -> nameRu
    else -> nameEn
}

fun Achievement.localizedDescription(locale: DiscordLocale): String = when (locale) {
    DiscordLocale.UKRAINIAN -> descUk
    DiscordLocale.RUSSIAN -> descRu
    else -> descEn
}