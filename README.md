# WildLiveBot

A feature-rich, multi-language Discord bot built with **Kotlin** and **JDA (Java Discord API)** that transforms text channels into an interactive wildlife hunting game. Players can catch unique species across diverse biomes, build their personal collection, complete weekly quests, and compete on a global leaderboard.

## Features

* **Hunting System (`/catch`):** The bot spawns a random wild animal in the designated channel. Any server member can try to guess its name in the chat to catch it.
* **Smart Hints:** Educational anti-confusion system — if a player confuses closely related or similar animals (e.g., Bison vs. Wisent, Badger vs. Wolverine), the bot provides a helpful tip pointing out anatomical or geographical differences.
* **Biome Baits (`/shop`, `/buy`, `/use`):** By earning points from successful catches, players can visit the shop to purchase specialized baits that guarantee spawning fauna from specific ecological biomes (Taiga, Savanna, Desert, etc.).
* **Showcase & Collection (`/collection`):** A detailed showroom for players. It groups discovered species by their rarity (from Common to Legendary) and keeps a strict count of duplicate catches.
* **Naturalist Profile (`/profile`):** A player's digital business card displaying their point balance, global server rank, a custom visual progress bar of their collection completion, and their designated `/favorite` animal.
* **Weekly Quests (`/quests`):** Dynamic, rotating weekly tasks challenging players to catch a specific number of animals, a certain rarity, or from a designated biome to claim a large bonus reward.
* **Full Localization:** Automatic interface adaptation based on the user's native Discord locale — fully supporting English, Ukrainian, and Russian for both system commands and animal names.

## Tech Stack & Architecture

* **Language:** Kotlin
* **Framework:** JDA (Java Discord API) v5
* **Data Storage:** Lightweight local database powered by Kotlinx Serialization (JSON storage via `bot_data.json`).
* **Graphics Processing:** Java AWT / ImageIO (high-performance bicubic image compression before sending to Discord).

## How to Run

### 1. Environment Variables
The bot follows security best practices and does not hardcode private tokens. Before running the application, you must pass your Discord Bot Token via your system's environment variables:
* **Variable Name:** `BOT_TOKEN`
* **Variable Value:** `your_discord_bot_token_here`

### 2. Building and Running with Gradle
The project is fully configured and ready to build. Open your terminal in the root directory and run:

```bash
# On Windows:
gradlew.bat run

# On Linux / macOS:
chmod +x gradlew
./gradlew run