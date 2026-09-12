package com.wildlivebot.registry

import com.wildlivebot.game.repository.GameConfigRepository
import com.wildlivebot.model.Animal
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Biome

object AnimalRepository {
    private val animals = CommonAnimals.list +
            RareAnimals.list +
            EpicAnimals.list +
            LegendaryAnimals.list +
            MythicAnimals.list
    fun getRandomAnimal(guildId: String, targetBiome: Biome? = null): Animal {
        val roll = (1..100).random()
        val config = GameConfigRepository.current(guildId)

        val selectedRarity = when {
            roll <= config.rollCommonMax -> Rarity.COMMON
            roll <= config.rollRareMax -> Rarity.RARE
            roll <= config.rollEpicMax -> Rarity.EPIC
            roll <= config.rollLegendaryMax -> Rarity.LEGENDARY
            else -> Rarity.MYTHIC
        }

        var pool = animals.filter { it.rarity == selectedRarity }
        if (targetBiome != null) {
            val regionPool = pool.filter { it.biome == targetBiome }
            pool = regionPool.ifEmpty { animals.filter { it.biome == targetBiome } }
        }

        return pool.ifEmpty { animals }.random()
    }

    fun getAllAnimals(): List<Animal> = animals
    fun getAnimalById(id: String): Animal? = animals.find { it.id == id }
}