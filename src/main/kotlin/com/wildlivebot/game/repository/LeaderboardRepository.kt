package com.wildlivebot.game.repository

import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import java.io.File
import java.util.concurrent.ConcurrentHashMap

object LeaderboardRepository {
    private val file = File("data/leaderboard.json")
    private val points = ConcurrentHashMap(loadJson(file) { emptyMap<String, Int>() })

    fun getPoints(userId: String): Int = points.getOrDefault(userId, 0)

    fun addPoints(userId: String, delta: Int): Int {
        val newValue = getPoints(userId) + delta
        points[userId] = newValue
        persist()
        return newValue
    }

    fun getUserRank(userId: String): Int {
        val sorted = points.entries.sortedByDescending { it.value }.map { it.key }
        val index = sorted.indexOf(userId)
        return if (index != -1) index + 1 else sorted.size + 1
    }

    fun getTopPlayers(limit: Int = 10): List<Pair<String, Int>> =
        points.entries.sortedByDescending { it.value }.take(limit).map { it.key to it.value }

    private fun persist() = saveJson(file, points.toMap())
}