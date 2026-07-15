package com.wildlivebot.model

enum class Rarity(val displayName: String, val colorHex: String, val rewardPoints: Int) {
    COMMON("Common", "#7F8C8D", 100),
    RARE("Rare", "#3498DB", 150),
    EPIC("Epic", "#9B59B6", 250),
    LEGENDARY("Legendary", "#F1C40F", 500),
    MYTHIC("Mythic", "#CC0605", 1000)
}

data class Animal(
    val id: String,
    val nameEn: String,
    val nameRu: String,
    val nameUk: String,
    val aliasesEn: List<String>,
    val aliasesRu: List<String>,
    val aliasesUk: List<String>,
    val rarity: Rarity,
    val imagePath: String,
    val hints: Map<String, String> = emptyMap(),
    val facts: List<Fact>,
    val region: Region,
    val type: AnimalType
)