package com.ruse.world.content.minigames.impl;

import com.ruse.model.Item;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.net.packet.PacketSender;
import com.ruse.world.entity.impl.player.Player;

class UnknownZoneInterface {
	private static final int INTERFACE_ID = 16210;
	private static final int title = 16212;
	private static final int ROOM1 = 16213;
	private static final int ROOM2 = 16214;
	private static final int ROOM3 = 16215;
	private final Player player;

	public void open() {

		System.err.println("Called hitting it");
		player.getPacketSender().sendWalkableInterface(INTERFACE_ID, true);

		player.getPacketSender().sendString(title, "The Unknown");

		player.getPacketSender().sendString(ROOM1, "Unknown Archer: @whi@" + player.getPointsHandler().getMG1Count() + "/25");

		player.getPacketSender().sendString(ROOM2, "Unknown Creature: @whi@" + player.getPointsHandler().getMG2Count() + "/25");

		player.getPacketSender().sendString(ROOM3, "Unknown Ghost: @whi@" + player.getPointsHandler().getMG3Count() + "/25");
		refresh();
	}

	UnknownZoneInterface(Player player) {
		this.player = player;
	}

	public void refresh() {

		player.getPacketSender().sendWalkableInterface(INTERFACE_ID, true);

		player.getPacketSender().sendString(title, "The Unknown");

		player.getPacketSender().sendString(ROOM1, "Unknown Archer: @whi@" + player.getPointsHandler().getMG1Count() + "/25");

		player.getPacketSender().sendString(ROOM2, "Unknown Creature: @whi@" + player.getPointsHandler().getMG2Count() + "/25");

		player.getPacketSender().sendString(ROOM3, "Unknown Ghost: @whi@" + player.getPointsHandler().getMG3Count() + "/25");
		}


	public void close() {
		player.getPacketSender().sendWalkableInterface(INTERFACE_ID, false);
	}
}
