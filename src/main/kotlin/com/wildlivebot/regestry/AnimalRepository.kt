package com.wildlivebot.regestry

import com.wildlivebot.model.Animal
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Region

object AnimalRepository {
    private val animals = CommonAnimals.list +
            RareAnimals.list +
            EpicAnimals.list +
            LegendaryAnimals.list +
            MythicAnimals.list

    fun getRandomAnimal(targetRegion: Region? = null): Animal {
        val roll = (1..100).random()

        val selectedRarity = when {
            roll <= 45 -> Rarity.COMMON
            roll <= 70 -> Rarity.RARE
            roll <= 85 -> Rarity.EPIC
            roll <= 97 -> Rarity.LEGENDARY
            else -> Rarity.MYTHIC
        }

        var pool = animals.filter { it.rarity == selectedRarity }
        if (targetRegion != null) {
            val regionPool = pool.filter { it.region == targetRegion }
            pool = regionPool.ifEmpty { animals.filter { it.region == targetRegion } }
        }

        return pool.ifEmpty { animals }.random()
    }

    fun getAllAnimals(): List<Animal> = animals
    fun getAnimalById(id: String): Animal? = animals.find { it.id == id }
}