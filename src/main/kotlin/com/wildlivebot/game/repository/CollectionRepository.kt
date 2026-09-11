package com.wildlivebot.game.repository

import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import kotlinx.serialization.Serializable
import java.io.File
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap

@Serializable
private data class CollectionData(
    val collections: Map<String, List<String>> = emptyMap(),
    val favorites: Map<String, String> = emptyMap()
)

object CollectionRepository {
    private val file = File("data/collections.json")
    private val saved = loadJson(file) { CollectionData() }

    private val collections = ConcurrentHashMap<String, MutableList<String>>().apply {
        saved.collections.forEach { (userId, animals) ->
            put(userId, Collections.synchronizedList(animals.toMutableList()))
        }
    }
    private val favorites = ConcurrentHashMap(saved.favorites)

    fun catchAnimal(userId: String, animalId: String) {
        collections.computeIfAbsent(userId) { Collections.synchronizedList(mutableListOf()) }.add(animalId)
        persist()
    }

    fun getCollection(userId: String): List<String> = collections[userId] ?: emptyList()

    fun hasCaught(userId: String, animalId: String): Boolean = collections[userId]?.contains(animalId) ?: false

    fun setFavorite(userId: String, animalId: String): Boolean {
        if (!hasCaught(userId, animalId)) return false
        favorites[userId] = animalId
        persist()
        return true
    }

    fun getFavorite(userId: String): String? = favorites[userId]

    private fun persist() =
        saveJson(file, CollectionData(collections.mapValues { it.value.toList() }, favorites.toMap()))
}