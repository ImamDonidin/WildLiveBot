package com.wildlivebot.game.repository

import com.wildlivebot.storage.loadJson
import com.wildlivebot.storage.saveJson
import kotlinx.serialization.Serializable
import java.io.File
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap

@Serializable
private data class InventoryData(
    val baits: Map<String, Map<String, Int>> = emptyMap(),
    val tools: Map<String, List<String>> = emptyMap()
)

object InventoryRepository {
    private val file = File("data/inventory.json")
    private val saved = loadJson(file) { InventoryData() }

    private val baits = ConcurrentHashMap<String, ConcurrentHashMap<String, Int>>().apply {
        saved.baits.forEach { (userId, inv) -> put(userId, ConcurrentHashMap(inv)) }
    }
    private val tools = ConcurrentHashMap<String, MutableList<String>>().apply {
        saved.tools.forEach { (userId, list) -> put(userId, Collections.synchronizedList(list.toMutableList())) }
    }

    fun getBaits(userId: String): Map<String, Int> = baits[userId] ?: emptyMap()

    fun addBait(userId: String, regionId: String) {
        val userInv = baits.computeIfAbsent(userId) { ConcurrentHashMap() }
        userInv[regionId] = userInv.getOrDefault(regionId, 0) + 1
        persist()
    }

    fun consumeBait(userId: String, regionId: String): Boolean {
        val userInv = baits[userId] ?: return false
        val count = userInv.getOrDefault(regionId, 0)
        if (count <= 0) return false
        if (count == 1) userInv.remove(regionId) else userInv[regionId] = count - 1
        persist()
        return true
    }

    fun hasTool(userId: String, toolId: String): Boolean = tools[userId]?.contains(toolId) ?: false

    fun addTool(userId: String, toolId: String): Boolean {
        val userTools = tools.computeIfAbsent(userId) { Collections.synchronizedList(mutableListOf()) }
        if (userTools.contains(toolId)) return false
        userTools.add(toolId)
        persist()
        return true
    }

    private fun persist() = saveJson(
        file,
        InventoryData(baits.mapValues { it.value.toMap() }, tools.mapValues { it.value.toList() })
    )
}