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

    private static String TOKEN = "OTg4MzU2NTgzOTI5MDQ5MDk5.GPekPf.h129ZhaNbX3oPRccnix9mG_JRe3UTQUTTMoBvg";
    public static String PREFIX = "::";
    public static String GOD_ROLE = "928084516235534336";
    public static String OWNER_ROLE = "928081454926274571";
    public static String VERIFIED_ROLE = "928085230059917382";
    public static String PLAYER_ROLE = "931379844401483796";

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
        if (GameSettings.LOCALHOST)
            return;

        if (countDown == TIMER) {
        	int players = (int) World.getPlayers().size() + GameSettings.players;
            discord.getPresence().setActivity(Activity.watching((players) + " Players!"));
            countDown = 0;
        } else {
            countDown++;
        }
    }
}
