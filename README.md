# WildLiveBot

A feature-rich, multi-language Discord bot built with **Kotlin** and **JDA (Java Discord API)** that transforms text channels into an interactive wildlife hunting game. Players catch unique species across diverse biomes, build their personal collection, unlock achievements, complete weekly quests, and compete on a global leaderboard.

## Features

* **Hunting System (`/catch`):** The bot spawns a random wild animal in the designated channel. Any server member can try to guess its name in the chat to catch it.
* **Smart Hints:** Educational anti-confusion system — if a player confuses closely related or similar species (e.g., Bison vs. Wisent, Badger vs. Wolverine), the bot provides a helpful tip pointing out anatomical or geographical differences.
* **Biome Baits (`/shop`, `/buy`, `/use`):** By earning points from successful catches, players can visit the shop to purchase specialized baits that guarantee spawning fauna from a specific biome (Taiga, Savanna, Desert, and more), or a **Sky Camera** — required to catch birds.
* **Showcase & Collection (`/collection`):** A detailed showroom for players. It groups discovered species by rarity (from Common to Mythic) and keeps a strict count of duplicate catches, browsable page by page with buttons.
* **Naturalist Profile (`/profile`):** A player's digital business card, showing their point balance, global server rank, a visual progress bar of collection completion, their earned achievements, and their designated `/favorite` animal.
* **Achievements (`/achievements`):** Persistent milestones — from catching your first animal to completing the full collection or landing a Mythic-rarity catch — tracked and displayed with locked/unlocked status.
* **Weekly Quests (`/quests`):** Dynamic, rotating weekly tasks challenging players to catch a specific number of animals, a certain rarity, or a designated biome to claim a bonus reward.
* **Admin Configuration (`/config`):** Server administrators can tune game balance on the fly — catch cooldown, point rewards, shop prices, quest targets, and rarity drop rates — no redeploy required.
* **Guided Onboarding:** An automatic welcome message on server join, plus a full in-Discord `/help` command listing every available feature.
* **Full Localization:** Automatic interface adaptation based on the user's Discord locale — fully supporting **English**, **Ukrainian**, and **Russian**, for system messages, animal names, and hints alike.

## Commands

| Category | Command | Description |
|---|---|---|
| Playing | `/catch` | Spawn an animal in the hunting channel (subject to a cooldown) |
| Progress | `/profile [user]` | View a player's score, rank, collection progress, and achievements |
| Progress | `/collection` | Browse every animal you've caught, grouped by rarity |
| Progress | `/favorite <animal>` | Set your favorite caught animal |
| Progress | `/leaderboard` | View the top players on the server |
| Progress | `/achievements` | View all achievements and your unlock progress |
| Shop | `/shop` | Browse baits, tools, and your current inventory |
| Shop | `/buy <id>` | Purchase a biome bait or the Sky Camera |
| Shop | `/use <id>` | Activate a bait in the current channel |
| Quests | `/quests view` | Check your weekly quest progress |
| Quests | `/quests claim` | Claim your reward once all weekly quests are complete |
| Admin | `/setup-channel <channel>` | Choose the channel where animals will spawn |
| Admin | `/config view` | View all current game balance settings |
| Admin | `/config set <field> <value>` | Change a game balance setting |
| General | `/help` | Show the full command guide |

## Tech Stack & Architecture

* **Language:** Kotlin (2.3.10), JVM toolchain 21
* **Framework:** [JDA](https://github.com/discord-jda/JDA) (Java Discord API) v6, using the Components V2 API for buttons and layouts
* **Data Storage:** Lightweight, dependency-free persistence via Kotlinx Serialization — each domain (leaderboard, collections, inventory, quests, guild config, achievements, balance settings) is stored in its own JSON file under `data/`, isolated behind a dedicated repository object
* **Concurrency:** In-memory state backed by `ConcurrentHashMap`, safe for JDA's multi-threaded event dispatch
* **Graphics Processing:** Java AWT / ImageIO — bicubic image resizing and compression applied to animal images before upload

### Project structure

```text
src/main/kotlin/com/wildlivebot/
├── command/                    # One class per slash command
├── listener/                   # Message & button interaction listeners
│                              # (guessing, reveals, onboarding)
├── game/
│   ├── repository/             # Persisted state, one repository per domain
│   ├── RuntimeGameState.kt     # Non-persisted, in-round state
│   │                            # (spawns, cooldowns, etc.)
│   ├── ShopService.kt          # Cross-repository operations
│   │                            # (spend points, grant items)
│   └── AchievementService.kt
├── model/                      # Data classes & enums
│                              # (Animal, Biome, Rarity, Achievement, Quest, ...)
├── registry/                   # Static animal data, grouped by rarity
├── storage/                    # Generic JSON load/save helpers
└── utils/                      # Localization & locale-aware display helpers
```

## Setup & Running

### 1. Prerequisites

No local Gradle installation is required — the project ships with the Gradle Wrapper. You only need a JDK 21 (or newer) available on your `PATH`.

### 2. Environment variable

Before running the application, set your Discord bot token as an environment variable:

* **Variable name:** `BOT_TOKEN`
* **Variable value:** `your_discord_bot_token_here`

### 3. Build and run

```bash
# On Windows:
gradlew.bat run

# On Linux / macOS:
chmod +x gradlew
./gradlew run
```

On first launch, the bot will create a `data/` directory next to the working directory to store its persistent state — leaderboard, collections, quests, and configuration. This directory is not part of the repository and is safe to back up or `.gitignore` independently.

### 4. First-time server setup

After inviting the bot to a server, an administrator needs to run `/setup-channel` to choose where animals will spawn — the bot will also post a short onboarding message automatically when it joins. Run `/help` at any time for the full command reference.

## Localization

All player-facing text lives in `src/main/resources/messages_{en,ru,uk}.properties`. Locale is resolved per-user (from Discord's interaction locale) for slash commands, and per-server for passive features like the welcome message. Contributions adding new languages are welcome — see the existing `.properties` files for the expected key structure.

## License

Distributed under the MIT License. See [LICENSE](./LICENSE) for details.