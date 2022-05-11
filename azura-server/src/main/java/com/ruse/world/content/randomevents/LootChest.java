package com.ruse.world.content.randomevents;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.util.Stopwatch;
import com.ruse.world.World;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.content.PlayerPanel;
import com.ruse.world.content.Sounds;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

//import com.ruse.tools.discord.DiscordConstant;
//import com.ruse.tools.discord.DiscordManager;

public final class LootChest {

	/**
	 * @author Crimson 6/10/2017
	 */

	private static int TIME = 1_000_000;// 1_000_000;
	private static int tickDelay = 30, maxLoot = 3;
	private static Stopwatch timer = new Stopwatch().reset();
	public static SpawnedChest LOOT_CHEST = null;
	private static LocationData LAST_LOCATION = null;
	public static int ultraLoots[] = {6769,10946,15288};
	public static int commonLoots[] = { 12855,20488,19116,19115,19114,10942,15290,15289};
	private static boolean firstTime = true;

	public static int getRandomItem(int[] array) {
		return array[Misc.getRandom(array.length - 1)];
	}

	public static void handleAction(Player player, GameObject object) {

			player.setEntityInteraction(object);
				int delay = Misc.getRandom(5);
				player.setCurrentTask(new Task(1, player, false) {
					int cycle = 0, reqCycle = delay >= 2 ? delay : Misc.getRandom(1) + 1;

					@Override
					public void execute() {
						if (!player.getClickDelay().elapsed(60000)) {
						player.sendMessage("You can only search the loot chest 1 time each minute!");
						this.stop();
						return;
					}
						if (player.getInventory().getFreeSlots() == 0) {
							player.performAnimation(new Animation(65535));
							player.getPacketSender().sendMessage("You don't have enough free inventory space.");
							this.stop();
							return;
						}

						if (cycle != reqCycle) {
							cycle++;
							player.performAnimation(new Animation(827));
							LOOT_CHEST.getChestObject().incrementPickAmount();
							player.getClickDelay().reset();
							if (LOOT_CHEST.getChestObject().getPickAmount() < 3)
							World.sendMessage("@blu@[Loot Chest]: @red@A player has found and looted the loot chest. @blu@" +  ( 3 - LOOT_CHEST.getChestObject().getPickAmount()) + "/3@red@ rewards left!");
							int random = Misc.inclusiveRandom(1, 30);
							if (random >= 1 && random <= 19) {
								int commonDrop = getRandomItem(commonLoots);
								player.getInventory().add(commonDrop, 1);
								if ( commonDrop == 12855 );
								player.getInventory().add(12855, Misc.getRandom(25000));
							} else
							if (random == 20) {
								int ultraDrops = getRandomItem(ultraLoots);
								player.getInventory().add(ultraDrops, 1);
								World.sendMessage("@blue@[Loot Chest]: @red@" + player.getUsername() + " @blu@has pulled @red@" +
										ItemDefinition.forId(ultraDrops).getName() + " @blu@from the @red@Loot chest");
							}
						} else if (cycle >= reqCycle) {
							cycle = 0;
							this.stop();
						}
						Sounds.sendSound(player, Sound.PICKUP_ITEM);
					}
				});
				TaskManager.submit(player.getCurrentTask());
		}


	public static class SpawnedChest {

		public SpawnedChest(GameObject chestObject, LocationData chestLocation) {
			this.chestObject = chestObject;
			this.chestLocation = chestLocation;
		}

		private GameObject chestObject;
		private LocationData chestLocation;

		public GameObject getChestObject() {
			return chestObject;
		}

		public LocationData getChestLocation() {
			return chestLocation;
		}
	}

	public static enum LootChestDef {

		LOOT_CHEST("Loot chest", 13291, 20488,maxLoot);

		private String chestName;
		private int id;
		private int reward;
		private int maximumLootingAmount;

		private LootChestDef(String chestName, int id, int reward, int maxCutAmount) {
			this.chestName = chestName;
			this.id = id;
			this.reward = reward;
			this.maximumLootingAmount = maxCutAmount;
		}

		public String getChestName() {
			return chestName;
		}

		public int getId() {
			return id;
		}

		/**
		 * @return the log
		 */
		public int getReward() {
			return reward;
		}

		public int getMaxLootingAmount() {
			return maximumLootingAmount;
		}

		private static final Map<Integer, LootChestDef> chest = new HashMap<Integer, LootChestDef>();

		public static LootChestDef forId(int id) {
			return chest.get(id);
		}

		static {
			for (LootChestDef w : LootChestDef.values())

				chest.put(w.id, w);

		}

	}

	public static enum LocationData {
		MINOTAURS(new Position(2527, 2521), "Minotaurs zone", "@whi@Armoured Minotaurs"),
		LAVA_HOUND(new Position(3433, 4126), "Lava hounds zone", "@whi@Lava hounds"),
		STINKY_BLOB(new Position(2185, 5087), "Stinky Blobs zone", "@whi@Stinky Blobs"),
		BLOODSUCKERS(new Position(2398, 5012), "Bloodsuckers zone", "@whi@Bloodsuckers"),
		ZELDRIS(new Position(2721, 4432), "Zeldris zone", "@whi@Zeldris"),
		CASH_DRAGONS(new Position(2910, 3619), "Cash Dragons zone", "@whi@Cash Dragons"),
		DEMON_GODDESS(new Position(2780, 4458), "Demon Goddess zone", "@whi@Demon Goddess"),
		ENERGY_SKELETON(new Position(2079, 3995), "Energy Skeletons zone", "@whi@Energy Skeletons"),
		TRUMP(new Position(3031, 2854), "Donald Trump zone", "@whi@Donald Trump"),
		GOKU(new Position(3031, 2854), "Goku zone", "@whi@Goku"),
		RADITZ(new Position(2910 + Misc.getRandom(7), 3990 + Misc.getRandom(7)), "Raditz zone", "@whi@Raditz"),
		BOTANIC_QUEEN(new Position(2571, 9435), "Botanic Queen zone", "@whi@Botanic Queen"),
		REBD(new Position(3029, 4000), "Red-eyes Black Dragon zone", "@whi@Red-eyes Black Dragon"),
		BEWD(new Position(2847, 2848), "Blue-eyes White Dragon zone", "@whi@Blue-eyes White Dragon"),
		INUYASHA(new Position(2313 + Misc.getRandom(25), 5389 + Misc.getRandom(30)), "Inuyasha zone", "@whi@Inuyasha"),
		TOKORTH(new Position(1890, 5478), "Tolrokoth zone", "@whi@Tolrokoth"),
		ENRAGED_SUPREME(new Position(2769, 4576), "Enraged Supreme zone", "@whi@Enraged Supreme"),
		MUTATED_HOUND(new Position(2313 + Misc.getRandom(10), 5389 + Misc.getRandom(7)), "Mutated hounds zone", "@whi@Mutated hounds"),
		DEMONS(new Position(2727, 4517), "Plutonic Demons zone", "@whi@Plutonic Demons");
		private LocationData(Position spawnPos, String clue, String playerPanelFrame) {
			this.spawnPos = spawnPos;
			this.clue = clue;
			this.playerPanelFrame = playerPanelFrame;
		}

		private Position spawnPos;
		private String clue;
		public String playerPanelFrame;
	}

	public static LocationData getRandom() {
		LocationData chest = LocationData.values()[Misc.getRandom(LocationData.values().length - 1)];
		return chest;
	}

	public static LootChestDef getRandomChest() {
		LootChestDef chest = LootChestDef.values()[Misc.getRandom(LootChestDef.values().length - 1)];
		return chest;
	}

	public static void sequence() {
		if (LOOT_CHEST == null) {
			if (timer.elapsed(TIME) || firstTime) {
				if (firstTime == true) {
					firstTime = false;
				}
				LocationData locationData = getRandom();
				LootChestDef chest = getRandomChest();
				if (LAST_LOCATION != null) {
					if (locationData == LAST_LOCATION) {
						locationData = getRandom();
					}
				}
				LAST_LOCATION = locationData;
				LOOT_CHEST = new SpawnedChest(new GameObject(chest.getId(), locationData.spawnPos), locationData);
				CustomObjects.spawnGlobalObject(LOOT_CHEST.chestObject);
				World.sendMessage("@blu@[Event]: @red@A Loot chest has spawned at " + locationData.clue + ".");
				World.getPlayers().forEach(p -> PlayerPanel.refreshPanel(p));
				timer.reset();
			}
		} else {
			if (LOOT_CHEST.chestObject.getPickAmount() >= maxLoot) {
				// // System.out.println("HEY WE CUT THE TREE DOWN CXCXCXCXCXXC");
				despawn(true);
				timer.reset();
			}
		}
	}
	public static LocationData getLocation() {
		return LAST_LOCATION;
	}
	public static void despawn(boolean respawn) {
		if (respawn) {
			timer.reset(0);
		} else {
			timer.reset();
		}
		if (LOOT_CHEST != null) {
			for (Player p : World.getPlayers()) {
				if (p == null) {
					continue;
				}
				// p.getPacketSender().sendString(39162, "@or2@Evil Tree: @or2@[ @yel@N/A@or2@
				// ]");
				if (p.getInteractingObject() != null
						&& p.getInteractingObject().getId() == LOOT_CHEST.chestObject.getId()) {
					LAST_LOCATION = null;
					p.performAnimation(new Animation(65535));
					p.getPacketSender().sendClientRightClickRemoval();
					p.getSkillManager().stopSkilling();
				}
			}
			CustomObjects.deleteGlobalObject(LOOT_CHEST.chestObject);
			World.sendMessage("@blu@[Loot Chest]: @red@The Loot chest has been fully looted and will respawn in 1 hour.");
			LOOT_CHEST = null;
			for (Player p : World.getPlayers()) {
				if (p == null) {
					continue;
				}
				PlayerPanel.refreshPanel(p);
			}
		}
	}
}