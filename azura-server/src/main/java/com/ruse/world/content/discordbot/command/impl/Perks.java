package com.ruse.world.content.discordbot.command.impl;

import com.ruse.GameSettings;
import com.ruse.world.World;
import com.ruse.world.content.serverperks.ServerPerks;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/*
 * @project Vanity-Server
 * @author Patrity - https://github.com/Patrity
 * Created on - 4/13/2020
 */
public class Perks extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        int players = GameSettings.players + World.getPlayers().size ();
        eb.setTitle("Server Perk");
        eb.addField("Active perk: ", ServerPerks.getInstance().getActivePerk() != null ? ServerPerks.getInstance().getActivePerk().getName() : " N/A", true);

        eb.setThumbnail(e.getJDA().getSelfUser().getAvatarUrl());
        eb.setColor(new Color(0x296d98));
        e.getChannel().sendMessage(eb.build()).queue();
    }

    
}
