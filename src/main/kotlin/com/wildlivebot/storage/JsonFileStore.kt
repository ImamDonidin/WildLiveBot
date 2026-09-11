package com.wildlivebot.storage

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import org.slf4j.LoggerFactory

@PublishedApi
internal val jsonFileStoreLogger = LoggerFactory.getLogger("JsonFileStore")

@PublishedApi
internal val jsonFileStoreJson = Json { prettyPrint = true; ignoreUnknownKeys = true }

inline fun <reified T> loadJson(file: File, default: () -> T): T {
    if (!file.exists()) return default()
    return try {
        jsonFileStoreJson.decodeFromString<T>(file.readText())
    } catch (e: Exception) {
        jsonFileStoreLogger.error("Failed to load ${file.name}", e)
        default()
    }
}

inline fun <reified T> saveJson(file: File, data: T) {
    try {
        file.parentFile?.mkdirs()
        file.writeText(jsonFileStoreJson.encodeToString(data))
    } catch (e: Exception) {
        jsonFileStoreLogger.error("Failed to save ${file.name}", e)
    }
}