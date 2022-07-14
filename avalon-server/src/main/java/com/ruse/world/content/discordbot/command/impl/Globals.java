package com.ruse.world.content.discordbot.command.impl;

import com.ruse.GameSettings;
import com.ruse.motivote3.doMotivote;
import com.ruse.world.World;
import com.ruse.world.content.VoteBossDrop;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.globalBosses.*;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/*
 * @project Vanity-Server
 * @author Patrity - https://github.com/Patrity
 * Created on - 4/13/2020
 */
public class Globals extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        int players = GameSettings.players + World.getPlayers().size ();
        eb.setTitle("Globals");
        eb.addField("**Vote boss:** ", VoteBossDrop.currentSpawn == null  ? "" + doMotivote.getVoteCount() + "/60" : "Alive", true);
        eb.addField("**AFK Boss:** ", ""+ AfkSystem.getLeft() + " steals left", true);
        eb.addField("**Hellraiser:** ", ""+ HellraiserSystem.getLeft() + "  kills left", true);
        eb.addField("**Dragon King:** ", DragonKingBoss.currentBoss == null  ? "" + DragonKingBoss.timeLeft() + "" : "Alive", true);
        eb.addField("**Nightmare:** ", NightmareBoss.currentBoss == null  ? "" + NightmareBoss.timeLeft() + "" : "Alive", true);
        eb.addField("**Naraku:** ", NarakuBoss.currentBoss == null  ? "" + NarakuBoss.timeLeft() + "" : "Alive", true);
        eb.addField("**Guardian:** ", + GuardianSpawnSystem.getLeft() + "  tickets left", true);
        eb.addField("**Nephilim:** ", + NephilimSpawnSystem.getLeft() + " tokens left", true);
        eb.addField("**Iron:** ", IronmanBoss.currentBoss == null  ? "" + IronmanBoss.timeLeft() + "" : "Alive", true);
        eb.addField("**Onyx:** ", OnyxPantherBoss.currentBoss == null  ? "" + OnyxPantherBoss.timeLeft() + "" : "Alive", true);
        eb.addField("**Zenyte:** ", ZenyteGolemBoss.currentBoss == null  ? " " + ZenyteGolemBoss.timeLeft() + "" : "Alive", true);
        eb.addField("**Tanzanite:** ", ZenyteGolemBoss.currentBoss == null  ? "" + ZenyteGolemBoss.timeLeft() + "" : "Alive", true);

        eb.setThumbnail(e.getJDA().getSelfUser().getAvatarUrl());
        eb.setColor(new Color(0x296d98));
        e.getChannel().sendMessage(eb.build()).queue();
    }

    
}
