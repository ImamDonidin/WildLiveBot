package com.wildlivebot.game.repository

import com.wildlivebot.model.Achievement
import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import java.io.File
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap

object AchievementRepository {
    private val file = File("data/achievements.json")

    private val unlocked = ConcurrentHashMap<String, MutableSet<String>>().apply {
        loadJson(file) { emptyMap<String, List<String>>() }.forEach { (userId, ids) ->
            put(userId, Collections.synchronizedSet(ids.toMutableSet()))
        }
    }

    fun getUnlocked(userId: String): Set<Achievement> =
        (unlocked[userId] ?: emptySet()).mapNotNull { id ->
            try { Achievement.valueOf(id) } catch (e: Exception) { null }
        }.toSet()

    fun unlock(userId: String, achievement: Achievement): Boolean {
        val userSet = unlocked.computeIfAbsent(userId) { Collections.synchronizedSet(mutableSetOf()) }
        if (!userSet.add(achievement.name)) return false
        persist()
        return true
    }

    private fun persist() = saveJson(file, unlocked.mapValues { it.value.toList() })
}