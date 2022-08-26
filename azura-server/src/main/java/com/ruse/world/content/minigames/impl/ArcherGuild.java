package com.ruse.world.content.minigames.impl;

import com.ruse.world.entity.impl.player.Player;

public class ArcherGuild {
    private final Player player;

    public ArcherGuild(Player player) {this.player = player;}

    public void openMain() {
        player.getPacketSender().sendInterface(88130);
        player.getPacketSender().sendString(88140,  player.getWarriorMaster() == true
                ? "@gre@- Warrior Master"
                : "@red@- Warrior Master");

    }

    public void openT1() {
        player.getPacketSender().sendInterface(88330);
        player.getPacketSender().sendString(88337,  player.getPointsHandler().getFacelessMagicianKC() >= 100_000
                ? "@gre@- 25,000 Forest Archer KC"
                : "@red@- 25,000 Forest Archer KC");

    }

    public void openT2() {
        player.getPacketSender().sendInterface(88430);
        player.getPacketSender().sendString(88437,  player.getPointsHandler().getLotusMagicianKC() >= 50000
                ? "@gre@- 50,000 Forest Archer KC"
                : "@red@- 50,000 Forest Archer KC");

    }

    public void openT3() {
        player.getPacketSender().sendInterface(88530);
        player.getPacketSender().sendString(88537,  player.getPointsHandler().getShadowMagicianKC() >= 150000
                ? "@gre@- 75,000 Forest Archer KC"
                : "@red@- 75,000 Forest Archer KC");

    }
}
