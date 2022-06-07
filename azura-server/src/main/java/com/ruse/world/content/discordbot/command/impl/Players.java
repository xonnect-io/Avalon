package com.ruse.world.content.discordbot.command.impl;

import com.ruse.GameSettings;
import com.ruse.motivote3.doMotivote;
import com.ruse.world.World;
import com.ruse.world.content.*;
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
public class Players  extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        int players = GameSettings.players + World.getPlayers().size ();
        eb.setTitle("Server Information");
        eb.setDescription("There are currently " + players + " players online!");
        eb.addField("Server perk: ", ServerPerks.getInstance().getActivePerk() != null ? ServerPerks.getInstance().getActivePerk().getName() : " Not Active", true);
        eb.addField("Donation boss status:",DonationBossSystem.currentSpawn == null? "Donation boss: " + DonationBossSystem.getAmntDonated() + "/500 donated"
                : "Donation boss: Alive ::donoboss", true);
        eb.addField("Vote boss status:", VoteBossDrop.currentSpawn == null  ? "Vote Boss: " + doMotivote.getVoteCount() + "/50 please vote!" : "Vote Boss:@whi@ Alive ::Vboss", true);
        eb.addField("X2 Drop rate:", GameSettings.DOUBLEDR ? "On " :"Off", true);
        eb.setThumbnail(e.getJDA().getSelfUser().getAvatarUrl());
        eb.setColor(new Color(0x296d98));
        e.getChannel().sendMessage(eb.build()).queue();
    }

    
}
