package com.ruse.world.content.minigames.impl;

import com.ruse.GameSettings;
import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations.Location;
import com.ruse.model.Position;
import com.ruse.model.RegionInstance;
import com.ruse.model.RegionInstance.RegionInstanceType;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class Graveyard {

	public static void start(Player player) {
		player.getPacketSender().sendInterfaceRemoval();
		player.moveTo(new Position(3487, 9260, (player.getIndex() + 1) * 4));
		player.setRegionInstance(new RegionInstance(player, RegionInstanceType.GRAVEYARD));
		DialogueManager.start(player, 97);
		player.getMinigameAttributes().getGraveyardAttributes().setEntered(true).setWave(1).setLevel(0);
		spawn(player, 1, 0);
		player.getPacketSender()
				.sendMessage("<img=5><col=FF0000><shad=0> To leave the purge, simply teleport out.");
	}

	public static void leave(Player player) {
		player.getCombatBuilder().reset(true);
		player.moveTo(GameSettings.DEFAULT_POSITION);
		if (player.getRegionInstance() != null)
			player.getRegionInstance().destruct();
		player.restart();
		player.getMinigameAttributes().getGraveyardAttributes().setEntered(false);
	}

	private final static void spawn(Player player, int wave, int level) {
		if (level == 10) {
			leave(player);
			player.getPacketSender().sendMessage("You successfully stopped the purge!");
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
				return new Position(3485, 9258, z);
			case 1:
				return new Position(3485, 9262, z);
			case 2:
				return new Position(3489, 9258, z);
			case 3:
				return new Position(3489, 9262, z);
			case 4:
				return new Position(3481, 9260, z);
			case 5:
				return new Position(3478, 9259, z);
			case 6:
				return new Position(3494, 9259, z);
			case 7:
				return new Position(3501, 9261, z);
			case 8:
				return new Position(3504, 9256, z);
			case 9:
				return new Position(3506, 9260, z);
			case 10:
				return new Position(3473, 9255, z);
			case 11:
				return new Position(3469, 9258, z);
			case 12:
				return new Position(3473, 9261, z);
			case 13:
				return new Position(3474, 9259, z);
			case 14:
				return new Position(3501, 9253, z);
			case 15:
				return new Position(3488, 9264, z);
		}
		return new Position(3587, 9257, z);
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


	public static Box[] loot = { //
			new Box(4151, 1, 1, 1D),
			new Box(11235, 1, 1, 1D),
			new Box(15486, 1, 1, 1D),
			new Box(18353, 1, 1, 1D),

			new Box(7462, 1, 1, 1D),
			new Box(15031, 1, 1, 1D),
			new Box(6585, 1, 1, 1D),
			new Box(7956, 1, 1, 1D),
			new Box(22077, 1, 1, 1D),
			new Box(6927, 1, 1, 1D),

			new Box(6928, 1, 1, 1D),
			new Box(6929, 1, 1, 1D),
			new Box(19136, 1, 1, 1D),
			new Box(6930, 1, 1, 1D),
			new Box(6931, 1, 1, 1D),
			new Box(6932, 1, 1, 1D),
			new Box(6936, 1, 1, 1D),
			new Box(6933, 1, 1, 1D),
			new Box(6934, 1, 1, 1D),
			new Box(6935, 1, 1, 1D),
			new Box(12634, 1, 1, 1D),
			new Box(23045, 1, 1, 1D),
			new Box(10946, 1, 1, 1D),
	};

}
