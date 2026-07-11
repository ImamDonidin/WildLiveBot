package com.wildlivebot.model

enum class Region(
    val nameEn: String,
    val nameRu: String,
    val nameUk: String
) {
    TEMPERATE_FORESTS(
        "Temperate Forests",
        "Умеренные леса",
        "Помірні ліси"
    ),

    BOREAL_FORESTS(
        "Boreal Forests",
        "Тайга",
        "Тайга"
    ),

    TROPICAL_RAINFORESTS(
        "Tropical Rainforests",
        "Тропические леса",
        "Тропічні ліси"
    ),

    SAVANNAS(
        "Savannas",
        "Саванны",
        "Савани"
    ),

    GRASSLANDS(
        "Grasslands",
        "Луга и степи",
        "Луки та степи"
    ),

    DESERTS_SEMIDESERTS (
        "Deserts & Semi-deserts",
        "Пустыни и Полупустыни",
        "Пустелі та Напівпустелі"
    ),

    MOUNTAINS(
        "Mountains",
        "Горы",
        "Гори"
    ),

    WETLANDS(
        "Wetlands",
        "Болота",
        "Болота"
    ),

    RIVERS_LAKES(
        "Rivers & Lakes",
        "Реки и озёра",
        "Річки та озера"
    ),

    OCEANS(
        "Oceans",
        "Океаны",
        "Океани"
    ),

    ARCTIC(
        "Arctic",
        "Арктика",
        "Арктика"
    ),

    ANTARCTICA(
        "Antarctica",
        "Антарктида",
        "Антарктида"
    ),
    CLIFFS(
        "Cliffs",
        "Скалы",
        "Скелі"
    ),
    COASTS(
        "Coasts",
        "Побережья",
        "Узбережжя"
    ),
}