package com.ruse.world.content.discordbot;

import com.ruse.GameSettings;
import com.ruse.world.World;
import com.ruse.world.content.discordbot.command.Commands;
import com.ruse.world.content.discordbot.events.MessageReceived;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Map;
import java.util.Objects;

/*
 * @project Vanity-Server
 * @author Patrity - https://github.com/Patrity
 * Created on - 4/13/2020
 */
public class Bot extends ListenerAdapter {

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

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        if (GameSettings.LOCALHOST)
            return;

        if (e.getAuthor().isBot()) {
            return;
        }


            System.out.println("Hitting out why no connect");
            if (e.getMessage().getContentDisplay().equalsIgnoreCase("!connect")) {
                User user = e.getAuthor();

                if (DiscordIntegration.connectedAccounts.containsValue(user.getIdLong())) {
                    DiscordIntegration.sendPrivateMessage(user, e.getChannel(), "This discord account is already connected to another in-game account!");
                }

                if (DiscordIntegration.idForCode.containsValue(user.getIdLong())) {
                    String code = null;
                    for (Map.Entry<String, Long> entry : DiscordIntegration.idForCode.entrySet()) {
                        if (entry.getValue() == user.getIdLong()) {
                            code = entry.getKey();
                        }
                    }
                    if (code == null) {
                        code = DiscordIntegration.generateCode(4);
                    }

                    DiscordIntegration.sendPrivateMessage(user, e.getChannel(), "Hello! You have already generated a code! Enter the following in the discord integration prompt:\n"
                            + code);
                    return;

                }
                String code = DiscordIntegration.generateCode(4);

                while (DiscordIntegration.idForCode.containsKey(code)) {
                    code = DiscordIntegration.generateCode(4);
                }

                DiscordIntegration.idForCode.put(code, e.getAuthor().getIdLong());

                DiscordIntegration.sendPrivateMessage(user, e.getChannel(),
                        "Hello! To connect your discord account to your in-game account, enter the following in the discord integration prompt:\n"
                                + code);
            }


        Commands command = Commands.isCommand(e);

        if (Objects.isNull(command)) {
            return;
        }

        command.getAdapter().onGuildMessageReceived(e);
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
