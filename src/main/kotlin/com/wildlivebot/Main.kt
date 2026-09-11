package com.wildlivebot

import com.wildlivebot.command.CatchCommand
import com.wildlivebot.command.LeaderboardCommand
import com.wildlivebot.command.SetupChannelCommand
import com.wildlivebot.command.ProfileCommand
import com.wildlivebot.command.FavoriteCommand
import com.wildlivebot.command.ShopCommand
import com.wildlivebot.command.UseCommand
import com.wildlivebot.command.QuestsCommand
import com.wildlivebot.command.CollectionCommand
import com.wildlivebot.command.ConfigCommand
import com.wildlivebot.game.repository.QuestRepository
import com.wildlivebot.listener.MessageListener
import com.wildlivebot.model.Biome
import com.wildlivebot.command.AchievementsCommand
import com.wildlivebot.command.HelpCommand
import com.wildlivebot.listener.WelcomeListener
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData
import org.slf4j.LoggerFactory
import java.util.concurrent.CountDownLatch

private val logger = LoggerFactory.getLogger("WildLiveBotMain")

fun main() {
    val token = System.getenv("BOT_TOKEN")

    logger.info("Initializing WildLiveBot...")

    try {
        QuestRepository.checkWeeklyReset()
    } catch (e: Exception) {
        logger.error("Failed to initialize game quests storage on start", e)
    }

    try {
        val latch = CountDownLatch(1)

        val jda = JDABuilder.createDefault(token)
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
            .addEventListeners(
                CatchCommand(),
                MessageListener(),
                LeaderboardCommand(),
                SetupChannelCommand(),
                ProfileCommand(),
                FavoriteCommand(),
                ShopCommand(),
                UseCommand(),
                QuestsCommand(),
                CollectionCommand(),
                ConfigCommand(),
                AchievementsCommand(),
                HelpCommand(),
                WelcomeListener()
            )
            .build()

        jda.awaitReady()
        logger.info("Logged in successfully as: ${jda.selfUser.name}")

        Runtime.getRuntime().addShutdownHook(Thread {
            logger.info("IntelliJ IDEA stop triggered! Safely closing JDA and freezing threads...")
            try {
                jda.shutdown()
                if (!jda.awaitShutdown(java.time.Duration.ofSeconds(5))) {
                    jda.shutdownNow()
                }
                logger.info("JDA background threads destroyed. Process killed successfully!")
            } catch (e: Exception) {
                logger.error("Error during execution of JDA shutdown hook", e)
            } finally {
                latch.countDown()
            }
        })

        val buyChoices = Biome.values().map { region ->
            net.dv8tion.jda.api.interactions.commands.Command.Choice(region.nameEn, region.name.lowercase())
        }.toMutableList()

        buyChoices.add(
            net.dv8tion.jda.api.interactions.commands.Command.Choice("Sky Camera (sky_camera)", "sky_camera")
        )

        val useChoices = Biome.values().map { region ->
            net.dv8tion.jda.api.interactions.commands.Command.Choice(region.nameEn, region.name.lowercase())
        }

        val buyItemOption = OptionData(OptionType.STRING, "id", "The ID of the item or bait you want to buy", true)
            .addChoices(buyChoices)

        val useBaitOption = OptionData(OptionType.STRING, "id", "The ID of the biome bait you want to activate", true)
            .addChoices(useChoices)

        val configFieldKeys = listOf(
            "catch_cooldown_minutes", "weekly_bonus_points", "wrong_guess_points",
            "bait_price", "sky_camera_price",
            "quest_region_target", "quest_rarity_target", "quest_type_target", "quest_any_target",
            "roll_common_max", "roll_rare_max", "roll_epic_max", "roll_legendary_max"
        )
        val configFieldChoices = configFieldKeys.map { key ->
            net.dv8tion.jda.api.interactions.commands.Command.Choice(key, key)
        }
        val configSetFieldOption = OptionData(OptionType.STRING, "field", "The configuration field to change", true)
            .addChoices(configFieldChoices)
        val configSetValueOption = OptionData(OptionType.STRING, "value", "The new numeric value", true)

        jda.updateCommands().addCommands(
            Commands.slash("catch", "Catch a wild animal!"),
            Commands.slash("leaderboard", "View the top players on this server!"),
            Commands.slash("setup-channel", "Set the only channel where animals can be caught")
                .addOption(OptionType.CHANNEL, "channel", "The channel for hunting game", true),

            Commands.slash("profile", "View your or another player's profile")
                .addOption(OptionType.USER, "user", "The user whose profile you want to view", false),

            Commands.slash("favorite", "Set your favorite animal from your collection")
                .addOption(OptionType.STRING, "animal", "The ID of the animal", true),

            Commands.slash("collection", "View your collection of caught wild animals!"),

            Commands.slash("shop", "Open the hunting bait shop"),

            Commands.slash("buy", "Buy a specific item or biome bait").addOptions(buyItemOption),
            Commands.slash("use", "Activate a biome bait in the current channel").addOptions(useBaitOption),

            Commands.slash("config", "View or change game balance settings (admin only)")
                .addSubcommands(
                    SubcommandData("view", "View all current configuration values"),
                    SubcommandData("set", "Change a configuration value")
                        .addOptions(configSetFieldOption, configSetValueOption)
                ),

            Commands.slash("achievements", "View all achievements and your progress"),

            Commands.slash("help", "Show a guide to all WildLiveBot commands"),

            Commands.slash("quests", "Manage your weekly hunting quests")
                .addSubcommands(
                    SubcommandData("view", "View your weekly hunting quests progress"),
                    SubcommandData("claim", "Claim your weekly bonus reward if all quests are complete")
                )
        ).queue {
            logger.info("Global slash commands registered successfully!")
        }

        latch.await()

    } catch (e: Exception) {
        logger.error("Critical error during bot startup!", e)
    }
}