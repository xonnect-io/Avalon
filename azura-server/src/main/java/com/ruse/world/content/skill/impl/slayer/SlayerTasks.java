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


	//boss slayer tasks ///////////
	// Old bosses
	/*FRIEZA(SlayerMaster.BOSS_SLAYER, 252, "Frieza can be found by using the Teleport interface", 500,
			new Position(2516, 3042, 0)),
	PERFECT_CELL(SlayerMaster.BOSS_SLAYER, 449, "Raditz can be found by using the Teleport interface.", 500,
			new Position(3000, 2511, 0)),
	SUPER_BUU(SlayerMaster.BOSS_SLAYER, 452, "Goku can be found by using the Teleport interface.", 500,
			new Position(3342, 3022, 0)),
	HERBAL_ROGUE(SlayerMaster.BOSS_SLAYER, 2342, "Herbal Rogue can be found by using the Teleport interface.", 500,
			new Position(3044, 2969, 0)),
	AZURE_BEAST(SlayerMaster.BOSS_SLAYER, 3831, "Azure Beast can be found by using the Teleport interface.", 500,
			new Position(2924, 2842, 0)),
	Inuyasha(SlayerMaster.BOSS_SLAYER, 185, "Inuyasha can be found by using the Teleport interface.", 500,
			new Position(1807, 3211, 0)),

	SUPREME_BOSS(SlayerMaster.BOSS_SLAYER, 440, "Supreme Boss can be found by using the Teleport interface.", 600,
			new Position(2403, 5082, 1000)),
	VASA_NISTIRIO(SlayerMaster.BOSS_SLAYER, 1120, "Vasa Nistirio can be found by using the Teleport interface.", 600,
			new Position(2910, 2593, 0)),*/

	// Boss slayer tasks 375-750k * 2 = 750-1500k / task
	// Easy bosses
	DONALD_TRUMP(SlayerMaster.BOSS_SLAYER, 250, "Donald Trump can be found by using the Teleport interface.", 350_000,
			new Position(3040, 2846, 0)),
	RADITZ(SlayerMaster.BOSS_SLAYER, 449, "Raditz can be found by using the Teleport interface.", 350_000,
			new Position(2911, 3911, 0)),
	GOKU(SlayerMaster.BOSS_SLAYER, 452, "Goku can be found by using the Teleport interface.", 350_000,
			new Position(3357, 9311, 0)),
	//Med bosses
	BOTANIC_QUEEN(SlayerMaster.BOSS_SLAYER, 2342, "Botanic Queen can be found by using the Teleport interface.", 400_000,
			new Position(2586, 9449, 0)),
	RED_EYES_BLACK_DRAGON(SlayerMaster.BOSS_SLAYER, 2949, "Red-Eyes Black dragon can be found by using the Teleport interface.", 666_666,
			new Position(2847, 2847, 0)),
	BLUE_EYES_BLACK_DRAGON(SlayerMaster.BOSS_SLAYER, 505, "Blue-Eyes Black dragon can be found by using the Teleport interface.", 550_000,
			new Position(2847, 2850, 0)),

	// Hard bosses
	INUYASHA(SlayerMaster.BOSS_SLAYER, 185, "Inuyashas can be found by using the Teleport interface.", 600_000,
			new Position(2328, 5409, 0)),
	TOLROKOTH(SlayerMaster.BOSS_SLAYER, 6430, "Tolrokoths can be found by using the Teleport interface.", 650_000,
			new Position(1887, 5468, 0)),
	ENRAGED_SUPREME(SlayerMaster.BOSS_SLAYER, 440, "Enraged supremes can be found by using the Teleport interface.", 650_000,
			new Position(2781, 4576, 0)),
	MUTATED_HOUND(SlayerMaster.BOSS_SLAYER, 9839, "Mutated hounds can be found by using the Teleport interface.", 750_000,
			new Position(3421, 4777, 0)),
	PLUTONIC_DEMON(SlayerMaster.BOSS_SLAYER, 12810, "Plutonic demons can be found by using the Teleport interface.", 750_000,
			new Position(2728, 4505, 0)),


	// Easy slayer tasks 12.5k-50k * 2 = 25-100k / task
	SYMBIOTE(SlayerMaster.EASY_SLAYER, 1727, "Easy Slayer Dungeon", 17500, new Position(1883, 5222)),
	ELEMENTAL_MOSS(SlayerMaster.EASY_SLAYER, 1740,"Easy Slayer Dungeon", 17500, new Position(1868, 5231)),
	LEOPARD(SlayerMaster.HARD_SLAYER, 1733,  "Easy Slayer Dungeon 2", 17500, new Position(1902, 5239)),
	WOLPERTINGER(SlayerMaster.EASY_SLAYER, 6870, "Easy Slayer Dungeon", 17500, new Position(1895, 5198)),
	SPIRIT_WOLF(SlayerMaster.EASY_SLAYER, 6871, "Easy Slayer Dungeon", 17500, new Position(1879, 5201)),

	// Med slayer tasks 50k-125k * 2 = 100-250k / task
	ELEMENTAL_FIRE(SlayerMaster.MEDIUM_SLAYER, 1741, "Medium Slayer Dungeon", 55000, new Position(2334, 5223)),
	WILD_GRAAHK(SlayerMaster.MEDIUM_SLAYER, 1734, "Medium Slayer Dungeon", 55000, new Position(2343, 5201)),
	RUSTED_GARGOYLE(SlayerMaster.MEDIUM_SLAYER, 1712, "Medium Slayer Dungeon", 55000, new Position(2324, 5200)),
	DARK_BLOODVELD(SlayerMaster.MEDIUM_SLAYER, 1710, "Medium Slayer Dungeon", 55000, new Position(2320, 5230)),
	ZAMORAK_BIRD(SlayerMaster.MEDIUM_SLAYER, 1725, "Medium Slayer Dungeon", 55000, new Position(2345, 5242)),

	// Hard slayer tasks 125-250k * 2 = 250-500k / task
	NATIVE_DEMON(SlayerMaster.HARD_SLAYER, 1715, "Hard Slayer Dungeon", 150_000, new Position(1632, 4844)),
	SEA_CREATURE(SlayerMaster.HARD_SLAYER, 1735, "Hard Slayer Dungeon", 180_000, new Position(1704, 4839)),
	KREE_DEVIL(SlayerMaster.HARD_SLAYER, 1736, "Hard Slayer Dungeon", 200_000, new Position(1708, 4816)),
	HYNDRA(SlayerMaster.HARD_SLAYER, 1743, "Hard Slayer Dungeon", 225_000, new Position(1670, 4815)),
	CHINESE_DRAGON(SlayerMaster.HARD_SLAYER, 1716, "Hard Slayer Dungeon", 250_000, new Position(1641, 4820)),
	EVIL_CHINCHOMPA(SlayerMaster.HARD_SLAYER, 1723, "Hard Slayer Dungeon", 200_000, new Position(1617, 4823)),
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
