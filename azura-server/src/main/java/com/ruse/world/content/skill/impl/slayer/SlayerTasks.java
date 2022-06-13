package com.ruse.world.content.skill.impl.slayer;

import com.ruse.model.Position;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.util.Misc;

import java.util.*;

/**
 * @author Gabriel Hannason
 */

public enum SlayerTasks {

	NO_TASK(null, -1, null, -1, null),

	// Easy bosses
	DONALD_TRUMP(SlayerMaster.BOSS_SLAYER, 250, "Donald Trump can be found by using the Teleport interface.", 350_000,
			new Position(3040, 2846, 0)),
	RADITZ(SlayerMaster.BOSS_SLAYER, 449, "Raditz can be found by using the Teleport interface.", 350_000,
			new Position(2911, 3911, 0)),
	GOKU(SlayerMaster.BOSS_SLAYER, 452, "Goku can be found by using the Teleport interface.", 350_000,
			new Position(3357, 9311, 0)),
	//Med bosses
	BOTANIC_GUARDIAN(SlayerMaster.BOSS_SLAYER, 2342, "Botanic Guardian can be found by using the Teleport interface.", 400_000,
			new Position(2586, 9449, 0)),
	ENRAGED_GUARDIAN(SlayerMaster.BOSS_SLAYER, 2949, "Enraged Guardian can be found by using the Teleport interface.", 666_666,
			new Position(2847, 2847, 0)),
	ELEMENTAL_GUARDIAN(SlayerMaster.BOSS_SLAYER, 505, "Elemental Guardian can be found by using the Teleport interface.", 550_000,
			new Position(2847, 2850, 0)),

	// Hard bosses
	INUYASHA(SlayerMaster.BOSS_SLAYER, 185, "Inuyashas can be found by using the Teleport interface.", 600_000,
			new Position(2328, 5409, 0)),
	TOLROKOTH(SlayerMaster.BOSS_SLAYER, 6430, "Tolrokoths can be found by using the Teleport interface.", 650_000,
			new Position(1887, 5468, 0)),
	DEMONS_OF_DEITY(SlayerMaster.BOSS_SLAYER, 440, "Demons of Deity can be found by using the Teleport interface.", 650_000,
			new Position(2781, 4576, 0)),
	MUTATED_HOUND(SlayerMaster.BOSS_SLAYER, 9839, "Mutated hounds can be found by using the Teleport interface.", 750_000,
			new Position(3421, 4777, 0)),
	PLUTONIC_DEMON(SlayerMaster.BOSS_SLAYER, 12810, "Plutonic demons can be found by using the Teleport interface.", 750_000,
			new Position(2728, 4505, 0)),


	// Easy slayer tasks 12.5k-50k * 2 = 25-100k / task
	SYMBIOTE(SlayerMaster.EASY_SLAYER, 1727, "Easy Slayer Dungeon", 17500, new Position(1883, 5222)),
	ELEMENTAL_MOSS(SlayerMaster.EASY_SLAYER, 1740,"Easy Slayer Dungeon", 17500, new Position(1868, 5231)),
	LEOPARD(SlayerMaster.HARD_SLAYER, 1733,  "Easy Slayer Dungeon 2", 17500, new Position(1902, 5239)),
	DINO(SlayerMaster.EASY_SLAYER, 6870, "Easy Slayer Dungeon", 17500, new Position(1895, 5198)),
	SPIRIT_CRITTER(SlayerMaster.EASY_SLAYER, 6871, "Easy Slayer Dungeon", 17500, new Position(1879, 5201)),

	// Med slayer tasks 50k-125k * 2 = 100-250k / task
	ELEMENTAL_FIRE(SlayerMaster.MEDIUM_SLAYER, 1741, "Medium Slayer Dungeon", 55000, new Position(2334, 5223)),
	WILD_GRAAHK(SlayerMaster.MEDIUM_SLAYER, 1734, "Medium Slayer Dungeon", 55000, new Position(2343, 5201)),
	RUSTED_GARGOYLE(SlayerMaster.MEDIUM_SLAYER, 1712, "Medium Slayer Dungeon", 55000, new Position(2324, 5200)),
	DARK_BLOODVELD(SlayerMaster.MEDIUM_SLAYER, 1710, "Medium Slayer Dungeon", 55000, new Position(2320, 5230)),
	ZAMORAK_BIRD(SlayerMaster.MEDIUM_SLAYER, 1725, "Medium Slayer Dungeon", 55000, new Position(2345, 5242)),

	// Hard slayer tasks 125-250k * 2 = 250-500k / task
	GIANT_SPIDERS(SlayerMaster.HARD_SLAYER, 117, "Monster teleports", 150_000, new Position(2721, 4446)),
	DEMON_GODDESS(SlayerMaster.HARD_SLAYER, 501, "Monster teleports", 180_000, new Position(2784, 4445)),
	ENERGY_SKELETON(SlayerMaster.HARD_SLAYER, 503, "Monster teleports", 200_000, new Position(2088, 3995)),
	TUROTHS(SlayerMaster.HARD_SLAYER, 1627, "Monster teleports", 225_000, new Position(3154, 5556)),

	;


	/*
	 * @param taskMaster
	 * 
	 * @param npcId
	 * 
	 * @param npcLocation
	 * 
	 * @param XP
	 * 
	 * @param taskPosition
	 */

	// 1 last thing left the dILY REWARD huh
	SlayerTasks(SlayerMaster taskMaster, int npcId, String npcLocation, int XP, Position taskPosition) {
		this.taskMaster = taskMaster;
		this.npcId = npcId;
		this.npcLocation = npcLocation;
		this.XP = XP;
		this.taskPosition = taskPosition;
	}

	public static Map<SlayerMaster, ArrayList<SlayerTasks>> tasks = new HashMap<>();
	static {


		for (SlayerMaster master : SlayerMaster.values()) {
			ArrayList<SlayerTasks> slayerMasterSet = new ArrayList<>();
			for(SlayerTasks t : SlayerTasks.values()) {
				if(t.taskMaster == master) {
					slayerMasterSet.add(t);
				}
			}
			tasks.put(master, slayerMasterSet);
		}
	}
	private SlayerMaster taskMaster;
	private int npcId;
	private String npcLocation;
	private int XP;
	private Position taskPosition;

	public SlayerMaster getTaskMaster() {
		return this.taskMaster;
	}

	public int getNpcId() {
		return this.npcId;
	}

	public String getNpcLocation() {
		return this.npcLocation;
	}

	public int getXP() {
		return this.XP;
	}

	public Position getTaskPosition() {
		return this.taskPosition;
	}


	public static SlayerTaskData getNewTaskData(SlayerMaster master) {
		int slayerTaskAmount = 20;
		ArrayList<SlayerTasks> possibleTasks = tasks.get(master);
		SlayerTasks task = possibleTasks.get(Misc.getRandom(possibleTasks.size() - 1));

		/*
		 * Getting a task
		 */
		if (master == SlayerMaster.BOSS_SLAYER) {
			slayerTaskAmount = 25 + Misc.getRandom(25);

		} else if (master == SlayerMaster.EASY_SLAYER) {
			slayerTaskAmount = 25 + Misc.random(25);
		} else if (master == SlayerMaster.MEDIUM_SLAYER) {
			slayerTaskAmount = 50 + Misc.random(25);
		} else if (master == SlayerMaster.HARD_SLAYER) {
			slayerTaskAmount = 60 + Misc.random(40);
		}
		return new SlayerTaskData(task, slayerTaskAmount);
	}//

	public String getName() {
		NpcDefinition def = NpcDefinition.forId(npcId);
		return def == null ? Misc.formatText(this.toString().toLowerCase().replaceAll("_", " ")) : def.getName();
	}
}
