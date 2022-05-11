package com.ruse.world.content.discordbot;

import com.ruse.GameSettings;
import com.ruse.world.World;
import com.ruse.world.content.discordbot.events.MessageReceived;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

/*
 * @project Vanity-Server
 * @author Patrity - https://github.com/Patrity
 * Created on - 4/13/2020
 */
public class Bot {

    private static String TOKEN = "OTI4MzYzMzUyNDc0OTE5MDEz.YdXrvw.M-jhfcDKV80IlZ734KjLV9lQM2s";
    public static String PREFIX = "::";
    public static String OWNER_ROLE = "928081454926274571";
    public static String DEVELOPER_ROLE = "928081544617291797";
    public static String ADMIN_ROLE = "928104093313011752";
    public static String GLOBAL_MOD_ROLE = "928104093313011752";

    private static int TIMER = 60;

    public static JDA discord;

    public static void init() {
        try {
            discord = JDABuilder.createDefault(TOKEN)
            .setToken(TOKEN)
            .setActivity(Activity.watching("Avalon317.com"))
            .build()
            .awaitReady(); // Blocking guarantees that JDA will be completely loaded.
            discord.addEventListener(new MessageReceived());
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int countDown = 0;

    public static void updatePlayers() {
        if (countDown == TIMER) {
        	int players = (int) World.getPlayers().size() + GameSettings.players;
            discord.getPresence().setActivity(Activity.watching((players) + " Players!"));
            countDown = 0;
        } else {
            countDown++;
        }
    }
}
