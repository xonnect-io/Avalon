package com.ruse.world.content.instanceManangerGold;

import com.ruse.model.Position;
import com.ruse.model.RegionInstance.RegionInstanceType;

/**
 * 
 * @author Adam_#6723
 *
 */

public enum GoldInstanceData {

	EMBER_GIANTS(125071, 9838, "Ember Giant", 35, new int[] { 19624 },
			"Ember Giant",new Position(2758, 4743), RegionInstanceType.KINGS),
	TREE_BASILISK(125072, 1718, "Tree Basilisk", 35, new int[] { 19624 },
			"Tree Basilisk",new Position(2758, 4743), RegionInstanceType.KINGS),
	BAT_OF_LIGHT(125073, 9836, "Bat of light", 35, new int[] { 19624 },
			"Bat of light",new Position(2758, 4743), RegionInstanceType.KINGS),
	GIANT_SPIDER(125074, 117, "Giant Spider", 35, new int[] { 19624 },
			"Giant Spider",new Position(2758, 4743), RegionInstanceType.KINGS),
	CASH_DRAGONS(125075, 500, "Cash Dragon", 35, new int[] { 19624 },
			"Cash Dragon",new Position(2758, 4743), RegionInstanceType.KINGS),
	DEMON_GODDESS(125076, 501, "Demon Goddess", 35, new int[] { 19624 },
			"Demon Goddess",new Position(2758, 4743), RegionInstanceType.KINGS),
	ENERGY_SKELETONS(125077, 503, "Energy Skeleton", 35, new int[] { 19624 },
			"Energy Skeleton",new Position(2758, 4743), RegionInstanceType.KINGS),
	TUROTHS(125078, 1627, "Turoth", 35, new int[] { 19624 },
			"Turoth",new Position(2758, 4743), RegionInstanceType.KINGS),
	LORD(125079, 603, "Lord", 35, new int[] { 19624 },
			"Lord",new Position(2758, 4743), RegionInstanceType.KINGS),
	SHADOW_HUNTERS(125080, 12843, "Shadow Hunter", 35, new int[] { 19624 },
			"Shadow Hunter",new Position(2758, 4743), RegionInstanceType.KINGS),
	GOLEM(125081, 53, "Jynx Golem", 35, new int[] { 19624 },
			"Jynx Golem",new Position(2758, 4743), RegionInstanceType.KINGS),
	SHETANI(125082, 220, "Shetani", 35, new int[] { 19624 },
			"Shetani",new Position(2758, 4743), RegionInstanceType.KINGS),
	TITANIUM_RIPPER(125083, 13635, "Titanium Ripper", 35, new int[] { 19624 },
			"Titanium Ripper",new Position(2758, 4743), RegionInstanceType.KINGS),
	TITAN(125084, 8008, "Avatar Titan", 35, new int[] { 19624 },
			"Avatar Titan",new Position(2758, 4743), RegionInstanceType.KINGS),
	WYVERNS(125085, 3308, "Legendary Wyvern", 3308, new int[] { 19624 },
			"Legendary Wyvern",new Position(2758, 4743), RegionInstanceType.KINGS),
	ONI(125086, 3117, "Oni", 3308, new int[] { 19624 },
			"Oni",new Position(2758, 4743), RegionInstanceType.KINGS),
	SHENRON(125087, 201, "Shenron", 3308, new int[] { 19624 },
			"Shenron",new Position(2758, 4743), RegionInstanceType.KINGS),
	SUBZERO(125088, 202, "SubZero", 3308, new int[] { 19624 },
			"SubZero",new Position(2758, 4743), RegionInstanceType.KINGS),
	ZEUS(125089, 203, "Zeus", 3308, new int[] { 19624 },
			"Zeus",new Position(2758, 4743), RegionInstanceType.KINGS),
	IPOTANE(125090, 8010, "Ipotane", 3308, new int[] { 19624 },
			"Ipotane",new Position(2758, 4743), RegionInstanceType.KINGS),
	VINDICTA(125091, 9807, "Vindicta", 3308, new int[] { 19624 },
			"Vindicta",new Position(2758, 4743), RegionInstanceType.KINGS),
	DONALD_TRUMP(125092, 250, "Donald Trump", 3308, new int[] { 19624 },
			"Donald Trump",new Position(2758, 4743), RegionInstanceType.KINGS),
	RADITZ(125093, 449, "Raditz", 3308, new int[] { 19624 },
			"Raditz",new Position(2758, 4743), RegionInstanceType.KINGS),
	GOKU(125094, 452, "Raditz", 3308, new int[] { 19624 },
			"Raditz",new Position(2758, 4743), RegionInstanceType.KINGS),
	BOTANIC(125095, 2342, "Botanic Guardian", 3308, new int[] { 19624 },
			"Botanic Guardian",new Position(2758, 4743), RegionInstanceType.KINGS),
	ENRAGED_GUARDIAN(125096, 2949, "Enraged Guardian", 3308, new int[] { 19624 },
			"Enraged Guardian",new Position(2758, 4743), RegionInstanceType.KINGS),
	ELEMENTAL_GUARDIAN(125097, 505, "Elemental Guardian", 3308, new int[] { 19624 },
			"Elemental Guardian",new Position(2758, 4743), RegionInstanceType.KINGS),
	INNUYASHA(125098, 185, "Inuyasha", 3308, new int[] { 19624 },
			"Inuyasha",new Position(2758, 4743), RegionInstanceType.KINGS),
	TOLOROKOTH(125099, 6430, "Tolrokoth", 3308, new int[] { 19624 },
			"Tolrokoth",new Position(2758, 4743), RegionInstanceType.KINGS),


	;

	GoldInstanceData(int buttonid, int npcid, String text, int endamount, int rewards[], String name, Position position,
					 RegionInstanceType region) {
		this.buttonid = buttonid;
		this.npcid = npcid;
		this.text = text;
		this.endamount = endamount;
		this.rewards = rewards;
		this.name = name;
		this.position = position;
		this.region = region;
	}

	private Position position;
	private RegionInstanceType region;

	public RegionInstanceType getRegion() {
		return region;
	}

	public void setRegion(RegionInstanceType region) {
		this.region = region;
	}

	public Position getPosition() {
		return position;
	}

	private int npcid, endamount, taskNumber, buttonid;

	public int getButtonid() {
		return buttonid;
	}

	private int amount;
	private int rewards[];

	public int[] getRewards() {
		return rewards;
	}

	private String text, name, weakness;

	public int getAmount() {
		return amount;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public int getTaskNumber() {
		return taskNumber;
	}

	public int getEndamount() {
		return endamount;
	}

	public void setEndamount(int endamount) {
		this.endamount = endamount;
	}

	public String getName() {
		return name;
	}

	public int getNpcid() {
		return npcid;
	}

	public String getText() {
		return text;
	}
}
