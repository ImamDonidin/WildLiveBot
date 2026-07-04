package com.wildlivebot.model

import kotlinx.serialization.Serializable

@Serializable
enum class QuestType {
    CATCH_REGION,
    CATCH_RARITY,
    CATCH_ANY
}

@Serializable
data class Quest(
    val id: String,
    val type: QuestType,
    val targetValue: String,
    val requiredProgress: Int
)