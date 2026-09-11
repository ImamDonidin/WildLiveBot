package com.wildlivebot.model

enum class Achievement(
    val nameEn: String, val nameRu: String, val nameUk: String,
    val descEn: String, val descRu: String, val descUk: String,
    val icon: String
) {
    FIRST_CATCH(
        "First Steps", "Первые шаги", "Перші кроки",
        "Catch your first animal.", "Поймайте своё первое животное.", "Спіймайте свою першу тварину.",
        "🐾"
    ),
    COLLECTOR_10(
        "Budding Naturalist", "Начинающий натуралист", "Початківець-натураліст",
        "Catch 10 unique animals.", "Поймайте 10 уникальных видов животных.", "Спіймайте 10 унікальних видів тварин.",
        "📖"
    ),
    COLLECTOR_50(
        "Seasoned Explorer", "Опытный исследователь", "Досвідчений дослідник",
        "Catch 50 unique animals.", "Поймайте 50 уникальных видов животных.", "Спіймайте 50 унікальних видів тварин.",
        "🧭"
    ),
    FULL_COLLECTION(
        "Master Naturalist", "Мастер-натуралист", "Майстер-натураліст",
        "Catch every animal in the game.", "Поймайте всех животных в игре.", "Спіймайте всіх тварин у грі.",
        "🏅"
    ),
    FIRST_MYTHIC(
        "Against All Odds", "Вопреки всему", "Всупереч усьому",
        "Catch a Mythic-rarity animal.", "Поймайте животное мифической редкости.", "Спіймайте тварину міфічної рідкості.",
        "🌟"
    ),
    SKY_HUNTER(
        "Sky Hunter", "Охотник за небом", "Мисливець за небом",
        "Buy a Sky Camera and catch a bird.", "Купите Небесный Фотоаппарат и поймайте птицу.", "Купіть Небесний Фотоапарат і спіймайте птаха.",
        "📷"
    ),
    RICH_HUNTER(
        "Wealthy Naturalist", "Состоятельный натуралист", "Заможний натураліст",
        "Reach 5000 total points.", "Наберите 5000 очков.", "Наберіть 5000 очок.",
        "💰"
    ),
    QUEST_MASTER(
        "Quest Master", "Мастер заданий", "Майстер завдань",
        "Claim 5 weekly quest rewards.", "Заберите награду за 5 недель квестов.", "Заберіть нагороду за 5 тижнів квестів.",
        "📜"
    )
}