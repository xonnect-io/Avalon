package com.ruse.world.content.minigames;

import com.ruse.world.entity.impl.player.Player;

public class MagicGuild {
    private final Player player;

    public MagicGuild(Player player) {this.player = player;}

    public void openMain() {
        player.getPacketSender().sendInterface(77130);
        player.getPacketSender().sendString(77140,  player.getPointsHandler().getAvalonBeastBKC() >= 50000
                ? "@gre@- 50,000 Skeleton Brute KC"
                : "@red@- 50,000 Skeleton Brute KC");

    }

    public void openT1() {
        player.getPacketSender().sendInterface(77330);
        player.getPacketSender().sendString(77337,  player.getPointsHandler().getFacelessMagicianKC() >= 50000
                ? "@gre@- 50,000 Faceless Magician KC"
                : "@red@- 50,000 Faceless Magician KC");

    }

    public void openT2() {
        player.getPacketSender().sendInterface(77430);
        player.getPacketSender().sendString(77437,  player.getPointsHandler().getLotusMagicianKC() >= 50000
                ? "@gre@- 100,000 Lotus Magician KC"
                : "@red@- 100,000 Lotus Magician KC");

    }

    public void openT3() {
        player.getPacketSender().sendInterface(77530);
        player.getPacketSender().sendString(77537,  player.getPointsHandler().getShadowMagicianKC() >= 150000
                ? "@gre@- 150,000 Shadow Magician KC"
                : "@red@- 150,000 Shadow Magician KC");

    }
}
