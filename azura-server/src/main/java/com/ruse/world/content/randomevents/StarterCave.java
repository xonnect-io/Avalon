package com.ruse.world.content.randomevents;

import com.ruse.world.entity.impl.player.Player;

public final class StarterCave {
	public static void handleAction(Player player) {
		if (!player.isFishCollected()) {
			player.getInventory().add(17817, 500);
			player.getPacketSender().sendMessage("You find x500 Fury sharks!");
			player.setFishCollected(true);
		} else	if (player.isFishCollected()) {
			player.getPacketSender().sendMessage("You already gathered some fishies!");
		}
	}
}