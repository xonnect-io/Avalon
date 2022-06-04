package com.ruse.world.content.instanceManangerGold;

import com.ruse.model.Position;
import com.ruse.model.RegionInstance;
import com.ruse.model.RegionInstance.RegionInstanceType;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class GoldInstanceManager {

	private final Player player;

	public GoldInstanceManager(Player player) {
		this.player = player;
	}

	public int pos = 4;

	boolean smallgrid = true;
	private static final GoldInstanceData[] values = GoldInstanceData.values();

	public void create3X3Instance(int npcId, RegionInstanceType type) {
		if (player.getInventory().contains(23264) && player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID, 750)) {
			player.getInventory().delete(23264, 1);
			player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID, 750);
		} else {
			player.getPA()
					.sendMessage("You need an instance token, these can be obtained from killing any npc ingame!");
			player.getPA().sendMessage("You need to have 750+ Avalon tokens in your inventory");
			return;
		}
		if (player.getRegionInstance() != null) {
			for (NPC n : player.getRegionInstance().getNpcsList()) {
				if (n != null) {
					World.deregister(n);
				}
			}
			player.getRegionInstance().getNpcsList().clear();
		} else {
			for (NPC n : World.getNpcs()) {
				if (n != null) {
					if (n.getPosition().getRegionId() == 11082 && n.getPosition().getZ() == (player.getIndex() * pos)) {
						World.deregister(n);
					}
				}
			}
		}
		player.setRegionInstance(new RegionInstance(player, type));
		player.lastInstanceNpc = npcId;
		player.moveTo(new Position(2785, 4771 ,
				player.getIndex() * 4));

		for (int i = 0; i < 3; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 2 + (i * 2),
					player.getPosition().getY() - 8 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 3; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 2 + (i * 2),
					player.getPosition().getY() - 6 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 3; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 2 + (i * 2),
					player.getPosition().getY() - 4 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (GoldInstanceData data : values) {
			if (npcId == data.getNpcid() || NpcDefinition.forId(npcId).getName() == data.getName()) {
				player.setCurrentInstanceAmount(120);
				player.setCurrentInstanceNpcId(data.getNpcid());
				player.setCurrentInstanceNpcName(data.getName());
				if (data.getNpcid() == 6260) {
					player.getPA().sendMessage(
							"We have instanced the home area for you, to leave the instance simply teleport out.");
				}
			}
		}
		player.getPA().sendMessage("You have instanced yourself " + player.getCurrentInstanceAmount() + " "
				+ player.getCurrentInstanceNpcName());
		player.getPA().sendInterfaceRemoval();
	}

	public void create4X4InstanceGold(int npcId, RegionInstanceType type) {
		if (player.getInventory().contains(23264) && player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID, 1500)) {
			player.getInventory().delete(23264, 1);
			player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID, 1500);
		} else {
			player.getPA()
					.sendMessage("You need an instance token, these can be obtained from killing any npc ingame!");
			player.getPA().sendMessage("You need to have 750+ Avalon tokens in your inventory");
			return;
		}
		if (player.getRegionInstance() != null) {
			for (NPC n : player.getRegionInstance().getNpcsList()) {
				if (n != null) {
					World.deregister(n);
				}
			}
			player.getRegionInstance().getNpcsList().clear();
		} else {
			for (NPC n : World.getNpcs()) {
				if (n != null) {
					if (n.getPosition().getRegionId() == 11082 && n.getPosition().getZ() == (player.getIndex() * pos)) {
						World.deregister(n);
					}
				}
			}
		}
		player.setRegionInstance(new RegionInstance(player, type));
		player.lastInstanceNpc = npcId;
		player.moveTo(new Position(2786, 4775 ,
				player.getIndex() * 4));
		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 2 + (i * 2),
					player.getPosition().getY() - 8 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 2 + (i * 2),
					player.getPosition().getY() - 6 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 2 + (i * 2),
					player.getPosition().getY() - 4 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 2 + (i * 2),
					player.getPosition().getY() - 2 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (GoldInstanceData data : values) {
			if (npcId == data.getNpcid() || NpcDefinition.forId(npcId).getName() == data.getName()) {
				player.setCurrentInstanceAmount(data.getEndamount() + Misc.exclusiveRandom(25, 60));
				player.setCurrentInstanceNpcId(data.getNpcid());
				player.setCurrentInstanceNpcName(data.getName());
				if (data.getNpcid() == 6260) {
					player.getPA().sendMessage(
							"We have instanced the home area for you, to leave the instance simply teleport out.");
				}
			}
		}
		player.getPA().sendMessage("You have instanced yourself " + player.getCurrentInstanceAmount() + " "
				+ player.getCurrentInstanceNpcName());
		player.getPA().sendInterfaceRemoval();
	}


	public void handleKill(Player player, NPC npc, String NpcName) {
		if (npc.getId() != player.getCurrentInstanceNpcId()) {
			return;
		}
		if (player.currentInstanceNpcId == -1 || player.currentInstanceNpcName == "") {
			return;
		}
		player.setCurrentInstanceAmount(player.getCurrentInstanceAmount() - 1);

		if (player.getCurrentInstanceAmount() == 110 || player.getCurrentInstanceAmount() == 100 || player.getCurrentInstanceAmount() == 90 ||
				player.getCurrentInstanceAmount() == 80 || player.getCurrentInstanceAmount() == 70 ||  player.getCurrentInstanceAmount() == 60 ||
				player.getCurrentInstanceAmount() == 50 || player.getCurrentInstanceAmount() == 40 || player.getCurrentInstanceAmount() == 30 ||
				player.getCurrentInstanceAmount() == 20 || player.getCurrentInstanceAmount() == 10) {
			player.getPA().sendMessage("You currently need to kill " + player.getCurrentInstanceAmount() + " " + NpcName);
		}

		if (player.getCurrentInstanceAmount() <= 0) {
			player.getPA().sendMessage("You have used up the total instance count!");
			finish();
			return;
		}
	}

	public void finish() {
		player.getPA().sendMessage("You have used up all your kills inside the instance.");
		player.getPA().sendMessage("to leave the instance simply teleport out.");
		if (player != null) {
			onLogout();
		}
	}

	public void onLogout() {
		if (player.getRegionInstance() != null)
			player.getRegionInstance().destruct();
		player.setDataGold(null);
		player.setCurrentInstanceAmount(-1);
		player.setCurrentInstanceNpcId(-1);
		player.setCurrentInstanceNpcName("");
	}
}
