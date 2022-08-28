package com.ruse.world.content.instanceManagerSlayer;

import com.ruse.world.entity.impl.player.Player;

public class SlayerInstanceInterfaceHandler {

	private Player player;

	private static final SlayerInstanceData[] dataSlayer = SlayerInstanceData.values();


	public SlayerInstanceInterfaceHandler(Player player) {
		this.player = player;
	}

	public void open() {
		sendBossNames();
		player.getPA().sendInterface(71000);
		player.getPacketSender().sendConfig(1085, 0);
		player.getPacketSender().sendItemOnInterface(35006, 23408, 0, 1);
		player.getPacketSender().sendString(131012, "Slayer Task: @whi@" + "@red@" + (player.getSlayer().getSlayerTask() == null ? "Task required" : "@whi@" +player.getSlayer().getSlayerTask().getName()));
		player.getPacketSender().sendString(131009, "Spawns: @whi@" + "@whi@" + (player.getSlayer().getAmountToSlay() == 0 ? "No Task" : "@whi@" +player.getSlayer().getAmountToSlay()));
		player.getPacketSender().sendString(131011, "@mag@Upgrade token (s)");
		player.getPacketSender().sendString(131010, "Cost: @whi@2,500 Upgrade tokens");
	}

	public void sendBossNames() {
		int startID = 48071;
		for (SlayerInstanceData dataSlayer : dataSlayer) {
			player.getPA().sendString(startID++, dataSlayer.getName());
		}
	}

	public void sendItems() {
		resetItems();
		for (SlayerInstanceData dataSlayer : dataSlayer) {
			for (int i = 0; i < dataSlayer.getRewards().length; i++) {
			}
		}
	}

	public void handleButtons(int id) {
		for (SlayerInstanceData dataSlayer : dataSlayer) {

			if ( id == dataSlayer.getButtonid()) {
				player.setDataSlayer(dataSlayer);
				player.getPA().sendNpcIdToDisplayPacket(dataSlayer.getNpcid(), 35004);
			}
		}
	}

	public void resetItems() {
		int interfaceId = 131007;
		for (int index = 0; index < 10; index++) {
			player.getPA().sendItemOnInterface(interfaceId, -1, -1);
		}
	}
}

