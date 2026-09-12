package com.wildlivebot.game

import com.wildlivebot.game.repository.GameConfigRepository
import com.wildlivebot.model.Animal
import com.wildlivebot.model.Biome
import java.time.Duration
import java.time.Instant
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap

object RuntimeGameState {

    private val cooldowns = ConcurrentHashMap<String, Instant>()
    private val activeSpawns = ConcurrentHashMap<String, Animal>()
    private val roundWrongGuesses = ConcurrentHashMap<String, MutableSet<String>>()
    private val activeBaits = ConcurrentHashMap<String, Biome>()

    fun getRemainingCooldown(guildId: String, userId: String): Long? {
        val nextAvailable = cooldowns[userId]?.plus(
            Duration.ofMinutes(GameConfigRepository.current(guildId).catchCooldownMinutes)
        ) ?: return null
        val now = Instant.now()
        return if (now.isBefore(nextAvailable)) Duration.between(now, nextAvailable).seconds else null
    }

    fun setCooldown(userId: String) { cooldowns[userId] = Instant.now() }

    fun spawnAnimal(channelId: String, animal: Animal) {
        activeSpawns[channelId] = animal
        roundWrongGuesses[channelId] = Collections.newSetFromMap(ConcurrentHashMap())
    }

    fun getActiveAnimal(channelId: String): Animal? = activeSpawns[channelId]

    fun removeActiveAnimal(channelId: String) {
        activeSpawns.remove(channelId)
        roundWrongGuesses.remove(channelId)
    }

    fun addPointsForWrongGuess(channelId: String, userId: String): Boolean =
        roundWrongGuesses[channelId]?.add(userId) ?: false

    fun setActiveBait(channelId: String, biome: Biome) { activeBaits[channelId] = biome }
    fun getActiveBait(channelId: String): Biome? = activeBaits[channelId]
    fun removeActiveBait(channelId: String) { activeBaits.remove(channelId) }
}