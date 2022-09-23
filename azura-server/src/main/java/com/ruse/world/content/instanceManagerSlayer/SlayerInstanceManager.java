package com.ruse.world.content.instanceManagerSlayer;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Position;
import com.ruse.model.RegionInstance;
import com.ruse.model.RegionInstance.RegionInstanceType;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class SlayerInstanceManager {

	private final Player player;

	public SlayerInstanceManager(Player player) {
		this.player = player;
	}

	public int pos = 4;

	private static final SlayerInstanceData[] values = SlayerInstanceData.values();

	public void create2X2Instance(int npcId, RegionInstanceType type) {
		if (player.getInventory().contains(23408) && player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID, 2500)) {
			player.getInventory().delete(23408, 1);
			player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID, 2500);
		} else {
			player.getPA()
					.sendMessage("You need an instance token (s), these can be obtained from killing slayer npcs!");
			player.getPA().sendMessage("You need 2,500 Upgrade tokens in your inventory to start a 2x2 Slayer instance.");
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
		for (int i = 0; i < 2; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 1 + (i * 2),
					player.getPosition().getY() - 6 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (int i = 0; i < 2; i++) {
			NPC npc_ = new NPC(npcId, new Position(player.getPosition().getX() - 1 + (i * 2),
					player.getPosition().getY() - 4 , player.getIndex() * pos));
			npc_.setSpawnedFor(player);
			player.getRegionInstance().getNpcsList().add(npc_);
			World.register(npc_);
		}
		for (SlayerInstanceData data : values) {
			if (npcId == data.getNpcid() || NpcDefinition.forId(npcId).getName() == data.getName()) {
				player.setCurrentInstanceAmount(player.getSlayer().getAmountToSlay());
				player.setCurrentInstanceNpcId(data.getNpcid());
				player.setCurrentInstanceNpcName(data.getName());
			}
		}
		player.getPA().sendMessage("You have instanced yourself " + player.getCurrentInstanceAmount() + " "
				+ player.getCurrentInstanceNpcName());
		player.getPA().sendInterfaceRemoval();
	}
	public void finish() {
		player.getPA().sendMessage("to leave the instance simply teleport out.");
		if (player != null) {
			onLogout();
		}
	}

	public void onLogout() {
		if (player.getRegionInstance() != null)
			player.getRegionInstance().destruct();
		player.setDataSlayer(null);
		player.setCurrentInstanceAmount(-1);
		player.setCurrentInstanceNpcId(-1);
		player.setCurrentInstanceNpcName("");
		startTask();
	}

	public static int tick = 0;
	public void startTask() {
		TaskManager.submit(new Task(1,false) {
			@Override
			public void execute() {
				player.getClickDelay().equals(5000);
				if(tick == 4) {
					player.getClickDelay().reset();
					stop();
				}
				tick++;
			}
		});
	}
}
