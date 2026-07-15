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
import com.wildlivebot.game.GameManager
import com.wildlivebot.listener.MessageListener
import com.wildlivebot.model.Region
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
        GameManager.checkWeeklyReset()
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
                CollectionCommand()
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

        val buyChoices = Region.values().map { region ->
            net.dv8tion.jda.api.interactions.commands.Command.Choice(region.nameEn, region.name.lowercase())
        }.toMutableList()

        buyChoices.add(
            net.dv8tion.jda.api.interactions.commands.Command.Choice("Sky Camera (sky_camera)", "sky_camera")
        )

        val useChoices = Region.values().map { region ->
            net.dv8tion.jda.api.interactions.commands.Command.Choice(region.nameEn, region.name.lowercase())
        }

        val buyItemOption = OptionData(OptionType.STRING, "id", "The ID of the item or bait you want to buy", true)
            .addChoices(buyChoices)

        val useBaitOption = OptionData(OptionType.STRING, "id", "The ID of the biome bait you want to activate", true)
            .addChoices(useChoices)

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