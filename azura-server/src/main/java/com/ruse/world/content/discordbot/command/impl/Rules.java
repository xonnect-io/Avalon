package com.ruse.world.content.discordbot.command.impl;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Rules extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Rules");
        eb.setDescription("[Click Here](https://Avalon317.com/rules) to find the rules for Avalon!");
        eb.setColor(Color.RED);
        e.getChannel().sendMessage(eb.build()).queue();
    }
}
