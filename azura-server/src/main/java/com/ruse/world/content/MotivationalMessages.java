package com.ruse.world.content;

import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

public class MotivationalMessages {

    private final Player player;

    public MotivationalMessages(Player player) {this.player = player;}
    public void startTask() {
        if (player.motivationalToggle) {
            player.getPacketSender().sendInterface(60640);
            if (Misc.getRandom(5) == 5) {
                player.getPacketSender().sendString(60642, ("Focus on your goal. Dont look in any direction but ahead"));
                System.out.println("Random: 5");
            } else if (Misc.getRandom(5) == 4) {
                player.getPacketSender().sendString(60642, ("When you feel like quitting, think about why you started."));
                System.out.println("Random: 4");
            } else if (Misc.getRandom(5) == 3) {
                player.getPacketSender().sendString(60642, ("A dream does not become reality through magic; it takes sweat."));
                System.out.println("Random: 3");
            } else if (Misc.getRandom(5) == 2) {
                player.getPacketSender().sendString(60642, ("When you feel like quitting, think about why you started."));
                System.out.println("Random: 2");
            } else
                player.getPacketSender().sendString(60642, ("Suffer the pain of discipline. Or, suffer the pain of regret."));
            System.out.println("Random: 0");
        } else
            return;
    }
    public void endTask() {
        player.getPacketSender().sendInterfaceRemoval();
    }
}
