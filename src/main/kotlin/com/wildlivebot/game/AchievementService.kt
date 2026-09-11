package com.wildlivebot.game

import com.wildlivebot.game.repository.AchievementRepository
import com.wildlivebot.game.repository.CollectionRepository
import com.wildlivebot.game.repository.InventoryRepository
import com.wildlivebot.game.repository.LeaderboardRepository
import com.wildlivebot.game.repository.QuestRepository
import com.wildlivebot.model.Achievement
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Rarity
import com.wildlivebot.registry.AnimalRepository

object AchievementService {

    fun checkAndUnlock(userId: String): List<Achievement> {
        val newlyUnlocked = mutableListOf<Achievement>()

        fun tryUnlock(achievement: Achievement, condition: Boolean) {
            if (condition && AchievementRepository.unlock(userId, achievement)) {
                newlyUnlocked.add(achievement)
            }
        }

        val collection = CollectionRepository.getCollection(userId)
        val uniqueCaught = collection.distinct()
        val totalAnimals = AnimalRepository.getAllAnimals().size

        tryUnlock(Achievement.FIRST_CATCH, collection.isNotEmpty())
        tryUnlock(Achievement.COLLECTOR_10, uniqueCaught.size >= 10)
        tryUnlock(Achievement.COLLECTOR_50, uniqueCaught.size >= 50)
        tryUnlock(Achievement.FULL_COLLECTION, totalAnimals > 0 && uniqueCaught.size >= totalAnimals)

        val hasMythic = uniqueCaught.any { AnimalRepository.getAnimalById(it)?.rarity == Rarity.MYTHIC }
        tryUnlock(Achievement.FIRST_MYTHIC, hasMythic)

        val hasCaughtBird = uniqueCaught.any { AnimalRepository.getAnimalById(it)?.type == AnimalType.BIRD }
        tryUnlock(Achievement.SKY_HUNTER, hasCaughtBird && InventoryRepository.hasTool(userId, "sky_camera"))

        tryUnlock(Achievement.RICH_HUNTER, LeaderboardRepository.getPoints(userId) >= 5000)
        tryUnlock(Achievement.QUEST_MASTER, QuestRepository.getClaimedWeeksCount(userId) >= 5)

        return newlyUnlocked
    }
}