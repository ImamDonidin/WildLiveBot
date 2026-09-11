package com.wildlivebot.game

import com.wildlivebot.game.repository.InventoryRepository
import com.wildlivebot.game.repository.LeaderboardRepository
import com.wildlivebot.model.Biome
import org.slf4j.LoggerFactory

object ShopService {
    private val logger = LoggerFactory.getLogger(ShopService::class.java)

    fun buyBait(userId: String, regionId: String, price: Int): Boolean {
        if (LeaderboardRepository.getPoints(userId) < price) return false
        LeaderboardRepository.addPoints(userId, -price)
        InventoryRepository.addBait(userId, regionId.lowercase().trim())
        return true
    }

    fun buyTool(userId: String, toolId: String, price: Int): Boolean {
        if (LeaderboardRepository.getPoints(userId) < price) return false
        if (!InventoryRepository.addTool(userId, toolId.lowercase().trim())) return false
        LeaderboardRepository.addPoints(userId, -price)
        return true
    }

    fun useBait(userId: String, channelId: String, regionId: String): Boolean {
        val cleanId = regionId.lowercase().trim()
        if (!InventoryRepository.consumeBait(userId, cleanId)) return false
        return try {
            RuntimeGameState.setActiveBait(channelId, Biome.valueOf(cleanId.uppercase()))
            true
        } catch (e: Exception) {
            logger.error("Unknown region ID for biome conversion: $regionId", e)
            false
        }
    }
}