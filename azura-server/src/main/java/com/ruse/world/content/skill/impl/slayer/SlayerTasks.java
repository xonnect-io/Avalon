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

	// Easy bosses xp =  half the npcs health
	HANTO(SlayerMaster.BOSS_SLAYER, 250, "Hanto warrior can be found by using the Teleport interface.", 50_000 / 2,
			new Position(2849, 4576, 0)),
	RADITZ(SlayerMaster.BOSS_SLAYER, 449, "Raditz can be found by using the Teleport interface.", 100_000 / 2,
			new Position(2911, 3991, 0)),
	GOKU(SlayerMaster.BOSS_SLAYER, 452, "Goku can be found by using the Teleport interface.", 500_000 / 2,
			new Position(3358, 9307, 0)),
	//Med bosses xp =  half the npcs health
	BOTANIC_GUARDIAN(SlayerMaster.BOSS_SLAYER, 2342, "Botanic Guardian can be found by using the Teleport interface.", 6000000 / 2,
			new Position(2586, 9449, 0)),
	ENRAGED_GUARDIAN(SlayerMaster.BOSS_SLAYER, 2949, "Enraged Guardian can be found by using the Teleport interface.", 6000000 / 2,
			new Position(3039, 3995, 0)),
	ELEMENTAL_GUARDIAN(SlayerMaster.BOSS_SLAYER, 505, "Elemental Guardian can be found by using the Teleport interface.", 6000000 / 2,
			new Position(2781, 4576, 0)),

	// Hard bosses xp =  half the npcs health
	INUYASHA(SlayerMaster.BOSS_SLAYER, 185, "Inuyashas can be found by using the Teleport interface.", 5000000 / 2,
			new Position(2328, 5409, 0)),
	TOLROKOTH(SlayerMaster.BOSS_SLAYER, 6430, "Tolrokoths can be found by using the Teleport interface.", 5000000 / 2,
			new Position(1887, 5468, 0)),
	DEMONS_OF_DEITY(SlayerMaster.BOSS_SLAYER, 440, "Demons of Deity can be found by using the Teleport interface.", 4500000 / 2,
			new Position(2842, 9387, 0)),
	MUTATED_HOUND(SlayerMaster.BOSS_SLAYER, 9839, "Mutated hounds can be found by using the Teleport interface.", 25000000 / 2,
			new Position(3421, 4777, 0)),
	PLUTONIC_DEMON(SlayerMaster.BOSS_SLAYER, 12810, "Plutonic demons can be found by using the Teleport interface.", 250000000 / 2,
			new Position(2728, 4505, 0)),

	RAMMERNAUT(SlayerMaster.BOSS_SLAYER, 9767, "Rammernaut can be found by using the Teleport interface.", 75000000 / 2,
			new Position(2326, 9831, 4)),

	// Easy slayer tasks- xp =  half the npcs health
	SYMBIOTE(SlayerMaster.EASY_SLAYER, 1727, "Easy Slayer Dungeon", 20_000 / 2, new Position(1883, 5222)),
	ELEMENTAL_MOSS(SlayerMaster.EASY_SLAYER, 1740,"Easy Slayer Dungeon", 20_000 / 2, new Position(1868, 5231)),
	LEOPARD(SlayerMaster.HARD_SLAYER, 1733,  "Easy Slayer Dungeon 2", 25_000 / 2, new Position(1902, 5239)),
	DINO(SlayerMaster.EASY_SLAYER, 6870, "Easy Slayer Dungeon", 25_000 / 2, new Position(1895, 5198)),
	SPIRIT_CRITTER(SlayerMaster.EASY_SLAYER, 6871, "Easy Slayer Dungeon", 30_000 / 2, new Position(1879, 5201)),

	// Med slayer tasks 50k- xp =  half the npcs health
	ELEMENTAL_FIRE(SlayerMaster.MEDIUM_SLAYER, 1741, "Medium Slayer Dungeon", 40_000 / 2, new Position(2334, 5223)),
	WILD_GRAAHK(SlayerMaster.MEDIUM_SLAYER, 1734, "Medium Slayer Dungeon", 40_000 / 2, new Position(2343, 5201)),
	RUSTED_GARGOYLE(SlayerMaster.MEDIUM_SLAYER, 1712, "Medium Slayer Dungeon", 45_000 / 2, new Position(2324, 5200)),
	TRAPPER(SlayerMaster.MEDIUM_SLAYER, 1710, "Medium Slayer Dungeon", 45_000 / 2, new Position(2320, 5230)),
	ZAMORAK_BAT(SlayerMaster.MEDIUM_SLAYER, 1725, "Medium Slayer Dungeon", 50_000 / 2, new Position(2345, 5242)),

	// Hard slayer tasks xp =  half the npcs health
	GIANT_SPIDERS(SlayerMaster.HARD_SLAYER, 117, "Monster teleports", 120_000 / 2, new Position(2721, 4446)),
	DEMON_GODDESS(SlayerMaster.HARD_SLAYER, 501, "Monster teleports", 160_000 / 2, new Position(2784, 4445)),
	ENERGY_SKELETON(SlayerMaster.HARD_SLAYER, 503, "Monster teleports", 200_000 / 2, new Position(2088, 3995)),
	TUROTHS(SlayerMaster.HARD_SLAYER, 1627, "Monster teleports", 180_000 / 2, new Position(3154, 5556)),
	CAVE_DRONE(SlayerMaster.HARD_SLAYER, 6799, "Dungeon teleports", 1_000_000 / 2, new Position(2080, 5533)),
	CAVE_SNAIL(SlayerMaster.HARD_SLAYER, 6792, "Dungeon teleports", 1_000_000 / 2, new Position(2080, 5533)),
	CAVE_MUTANT(SlayerMaster.HARD_SLAYER, 6798, "Dungeon teleports", 1_000_000 / 2, new Position(2080, 5533)),

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
