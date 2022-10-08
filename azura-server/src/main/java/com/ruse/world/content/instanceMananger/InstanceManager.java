package com.ruse.world.content.instanceMananger;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.model.RegionInstance;
import com.ruse.model.RegionInstance.RegionInstanceType;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class InstanceManager {

	private final Player player;

	public InstanceManager(Player player) {
		this.player = player;
	}
	public int pos = 4;
	private static final InstanceData[] values = InstanceData.values();

	public void create3X3Instance(int npcId, RegionInstanceType type) {
		if (npcId == 9116 && !player.getMagicGuildTier1()) {
			player.getPA().sendMessage("You need to have unlocked Tier 1 of the magician guild to instance this npc");
		}		if (npcId == 9117 && !player.getMagicGuildTier2()) {
			player.getPA().sendMessage("You need to have unlocked Tier 2 of the magician guild to instance this npc");
		}		if (npcId == 9118 && !player.getMagicGuildTier3()) {
			player.getPA().sendMessage("You need to have unlocked Tier 3 of the magician guild to instance this npc");
		}
		if (player.getInventory().contains(4278) && player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID, 750)) {
			player.getInventory().delete(4278, 1);
			player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID, 750);
		} else {
			player.getPA()
					.sendMessage("You need an instance token, these can be obtained from killing any npc in-game!");
			player.getPA().sendMessage("You need 750 Upgrade tokens in your inventory to start a 3x3 instance.");
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
		for (InstanceData data : values) {
			if (npcId == data.getNpcid() || NpcDefinition.forId(npcId).getName() == data.getName()) {
				player.setCurrentInstanceAmount(60);
				player.setCurrentInstanceNpcId(data.getNpcid());
				player.setCurrentInstanceNpcName(data.getName());
			}
		}
		player.getPA().sendMessage("You have instanced yourself " + player.getCurrentInstanceAmount() + " "
				+ player.getCurrentInstanceNpcName());
		player.getPA().sendInterfaceRemoval();
	}


	public void create4X4Instance(int npcId, RegionInstanceType type) {

		if (player.getInventory().contains(4278) && player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID, 1500)) {
			player.getInventory().delete(4278, 1);
			player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID, 1500);
		} else {
			player.getPA()
					.sendMessage("You need an instance token, these can be obtained from killing any npc in-game!");
			player.getPA().sendMessage("You need 1,500 Upgrade tokens in your inventory to start a 4x4 instance.");
			return;
		}

		World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.INSTANCE1, player.getIndex() * pos));
		World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.INSTANCE2, player.getIndex() * pos));

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


		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 3 + (i * 2),
					player.getPosition().getY() - 10 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 3 + (i * 2),
					player.getPosition().getY() - 8 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 3 + (i * 2),
					player.getPosition().getY() - 6 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 4; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 3 + (i * 2),
					player.getPosition().getY() - 4 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (InstanceData data : values) {
			if (npcId == data.getNpcid() || NpcDefinition.forId(npcId).getName() == data.getName()) {
				player.setCurrentInstanceAmount(60);
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

	public void death(Player player, NPC npc, String NpcName) {
		if (npc.getId() != player.getCurrentInstanceNpcId()) {
			return;
		}
		if (player.currentInstanceNpcId == -1 || player.currentInstanceNpcName == "") {
			return;
		}
		player.setCurrentInstanceAmount(player.getCurrentInstanceAmount() - 1);
		String tasks = String.valueOf(player.getCurrentInstanceAmount());
		if (tasks.endsWith(String.valueOf(0)) && player.getCurrentInstanceAmount() > 0) {
			player.getPA().sendMessage("You currently need to kill " + (player.getCurrentInstanceAmount()) + " " + NpcName);

		} else 	if (player.getCurrentInstanceAmount() <= 0) {
			player.getPA().sendMessage("You have used up the total instance count!");
			finish();
			return;
		}
	}

	public void finish() {
		player.getPA().sendMessage("You have used up all your kills inside the instance.");
		player.getPA().sendMessage("to leave the instance simply teleport out.");
		player.getLastRunRecovery().reset();
		if (player != null) {
			onLogout();
		}
	}

	public static int tick = 0;
	public void onLogout() {
		player.getClickDelay().reset();
		if (player.getRegionInstance() != null)
			player.getRegionInstance().destruct();
		player.setData(null);
		player.setCurrentInstanceAmount(-1);
		player.setCurrentInstanceNpcId(-1);
		player.setCurrentInstanceNpcName("");
	}

	public void startTask() {
		TaskManager.submit(new Task(1,false) {
			@Override
			public void execute() {
				player.getClickDelay().equals(5000);
				if(tick == 5) {
					player.getClickDelay().reset();
					stop();
				}
				tick++;
			}
		});
	}

}
