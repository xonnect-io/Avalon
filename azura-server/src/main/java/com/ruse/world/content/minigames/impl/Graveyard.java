package com.ruse.world.content.minigames.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations.Location;
import com.ruse.model.Position;
import com.ruse.model.RegionInstance;
import com.ruse.model.RegionInstance.RegionInstanceType;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class Graveyard {

	public static void start(Player player) {
		player.getPacketSender().sendInterfaceRemoval();
		player.moveTo(new Position(2580, 4509, (player.getIndex() + 1) * 4));
		player.setRegionInstance(new RegionInstance(player, RegionInstanceType.GRAVEYARD));
		DialogueManager.start(player, 97);
		player.getMinigameAttributes().getGraveyardAttributes().setEntered(true).setWave(1).setLevel(0);
		spawn(player, 1, 0);
		player.getPacketSender()
				.sendMessage("<img=5><col=FF0000><shad=0> To leave the graveyard, simply teleport out.");
	}

	public static void leave(Player player) {
		player.getCombatBuilder().reset(true);
		player.moveTo(new Position(3503, 3564)); // -4 y
		if (player.getRegionInstance() != null)
			player.getRegionInstance().destruct();
		player.restart();
		player.getMinigameAttributes().getGraveyardAttributes().setEntered(false);
	}

	private final static void spawn(Player player, int wave, int level) {
		if (level == 10) {
			leave(player);
			player.getPacketSender().sendMessage("You successfully completed the purge minigame!");
			return;
		}
		TaskManager.submit(new Task(4, player, false) {
			@Override
			public void execute() {
				if (player.getRegionInstance() == null || !player.isRegistered()
						|| player.getLocation() != Location.GRAVEYARD) {
					stop();
					return;
				}
				final int zombieAmount = (wave * 2);
				player.getMinigameAttributes().getGraveyardAttributes().setRequiredKills(zombieAmount);
				for (int i = 0; i <= zombieAmount; i++) {
					NPC n = new NPC(getSpawn(level), getSpawnPos(player.getPosition().getZ())).setSpawnedFor(player);
					World.register(n);
					player.getRegionInstance().getNpcsList().add(n);
					n.getCombatBuilder().attack(player);
				}
				stop();
			}
		});
	}

	public static boolean handleDeath(Player player, NPC npc) {
		int amount = 0;
		switch (npc.getId()) {
		case 76:
			amount = 1;
			break;
		case 5664:
			amount = 3;
			break;
		case 5400:
			amount = 6;
			break;
		case 8162:
			amount = 9;
			break;
		case 5407:
			amount = 13;
			break;
		}
		if (amount > 0) {
			// GroundItemManager.spawnGroundItem(player, new GroundItem(new Item(14667),
			// npc.getPosition(), player.getUsername(), false, 150, false, -1));
			player.getInventory().add(14667, 1);
			if (player.getMinigameAttributes().getGraveyardAttributes().decrementAndGetRequiredKills() <= 0) {
				if (player.getMinigameAttributes().getGraveyardAttributes().incrementAndGetWave() >= 5) {
					player.getMinigameAttributes().getGraveyardAttributes().setWave(1).incrementLevel();
				}
				spawn(player, player.getMinigameAttributes().getGraveyardAttributes().getWave(),
						player.getMinigameAttributes().getGraveyardAttributes().getLevel());
			}

			return true;
		}
		return false;
	}

	private final static Position getSpawnPos(int z) {
		switch (Misc.getRandom(15)) {
		case 0:
			return new Position(2585, 4511, z); // + 5 x + 2 y
		case 1:
			return new Position(2584, 4513, z); // + 4 x + 4 y
		case 2:
			return new Position(2585, 4515, z); //+ 5 x + 6 y
		case 3:
			return new Position(2581, 4517, z);// + 1 x + 8 y
		case 4:
			return new Position(2582, 4514, z); // + 2 x + 5 y
		case 5:
			return new Position(2576, 4516, z); // - 4 x + 7 y
		case 6:
			return new Position(2576, 4519, z); // - 4 x + 10 y
		case 7:
			return new Position(2571, 4514, z); //-9 x + 4 y
		case 8:
			return new Position(2571, 4515, z); // -9 x + 6 y
		case 9:
			return new Position(2575, 4510, z);// -5 x + 1 y
		case 10:
			return new Position(2579, 4510, z); // -1 x + 1 y
		case 11:
			return new Position(2580, 4512, z); // 0x + 3 y
		case 12:
			return new Position(2578, 4515, z); // -2x + 6 y
		case 13:
			return new Position(2579, 4518, z); // - 1x + 9 y
		case 14:
			return new Position(2581, 4518, z);// +1x + 9y
		case 15:
			return new Position(2582, 4516, z); //+2x +7y
		}
		return new Position(2584, 4521, z); // + 4x + 12y
	}

	private static final int getSpawn(int level) {
		final int random = Misc.getRandom(14);
		switch (level) {
		case 1:
			if (random <= 2)
				return 76;
			return 5664;
		case 2:
			if (random <= 3)
				return 76;
			else if (random == 4 || random == 5)
				return 5664;
			return 5400;
		case 3:
			if (random <= 3)
				return 76;
			else if (random == 4 || random == 5)
				return 5664;
			else if (random == 6 || random == 7)
				return 5400;
			return 8162;
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			if (random <= 3)
				return 76;
			else if (random == 4 || random == 5)
				return 5664;
			else if (random == 8)
				return 8162;
			return 5407;
		}
		return 76;
	}
}
