package com.ruse.world.content.instanceManangerGold;
import com.ruse.world.entity.impl.player.Player;

public class GoldInstanceInterfaceHandler {

	private Player player;

	private static final GoldInstanceData[] dataGold = GoldInstanceData.values();

	public GoldInstanceInterfaceHandler(Player player) {
		this.player = player;
	}

	public void open() {
		player.getPA().sendInterface(75000);
		sendBossNames();
		player.getPacketSender().sendItemOnInterface(36665, 23264, 0, 1);
		player.getPacketSender().sendString(75009,"Spawns: @whi@120");
		player.getPacketSender().sendString(75011,"@yel@Upgrade token (u)");
	}

	public void sendBossNames() {
		int startID = 125071;
		for (GoldInstanceData dataGold : dataGold) {
			player.getPA().sendString(startID++, dataGold.getName());
		}
	}

	public void sendItems() {
		resetItems();
		for (GoldInstanceData dataGold : dataGold) {
			for (int i = 0; i < dataGold.getRewards().length; i++) {
			}
		}
	}

	public void handleButtons(int id) {
		for (GoldInstanceData dataGold : dataGold) {
			
			if ( id == dataGold.getButtonid()) {
				player.setDataGold(dataGold);
				player.getPA().sendNpcIdToDisplayPacket(dataGold.getNpcid(), 36660);
			}
		}
	}

	public void resetItems() {
		int interfaceId = 75007;
		for (int index = 0; index < 10; index++) {
			player.getPA().sendItemOnInterface(interfaceId, -1, -1);
		}
	}
}
