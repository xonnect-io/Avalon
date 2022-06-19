package com.ruse.world.content.cardPacks;

import com.ruse.world.entity.impl.player.Player;

public class cardPackInterfaceHandler {

    public static void openInterface(Player player) {
        player.getPacketSender().sendInterface(73050);
        //player.getPacketSender().sendItemOnInterface(73057, 23276, 1);

    }
}
