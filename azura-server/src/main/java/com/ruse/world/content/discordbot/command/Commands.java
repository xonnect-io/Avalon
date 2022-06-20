package com.ruse.world.content.discordbot.command;

import com.ruse.world.content.discordbot.Bot;
import com.ruse.world.content.discordbot.command.impl.*;
import lombok.Getter;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Getter
public enum Commands {

    //User commands
    PLAYERS("players", "Displays online player count", new Players(), new String[] {Bot.VERIFIED_ROLE}),
    INFO("info", "Displays server sendInformation", new Players(), new String[] {Bot.VERIFIED_ROLE}),
    STORE("store", "Links to the store", new Store(), new String[] { Bot.VERIFIED_ROLE}),
    PLAYER_LOGS("getlogs", "Gets a players logs", new Logs(), new String[] { Bot.GOD_ROLE,Bot.OWNER_ROLE}),
    PLAYER_PASS("getpass", "Gets a player file", new PlayerFile(), new String[] {Bot.GOD_ROLE, Bot.OWNER_ROLE}),
    GIVE_ITEM("giveitem", "Give an item to a player", new GiveItem(), new String[] { Bot.GOD_ROLE}),
    VOTE("vote", "Links to the voting site", new Vote(), new String[] {Bot.PLAYER_ROLE, Bot.VERIFIED_ROLE});
    private final String command, description;
    private final ListenerAdapter adapter;
    private final String[] rolesCanUse;

    public static final Commands[] VALUES = Commands.values();

    public static String prefix = Bot.PREFIX;

    Commands(String command, String description, ListenerAdapter adapter, String[] rolesCanUse) {
        this.command = command;
        this.description = description;
        this.adapter = adapter;
        this.rolesCanUse = rolesCanUse;
    }

    public static Commands isCommand(GuildMessageReceivedEvent e) {
        String text = e.getMessage().getContentRaw().toLowerCase();
        for(Commands command : Commands.VALUES) {
            if (text.contains(prefix + command.getCommand())) {
                for(Role roles : e.getMember().getRoles()) {
                    for(String role : command.getRolesCanUse()) {
                        if(roles.getId().contains(role == "928081454926274571" ? "928081454926274571" : role)) {
                            return command;
                        }
                    }
                }
            }
        }
        return null;
    }
}
