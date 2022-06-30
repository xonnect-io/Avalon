package com.ruse.world.content.instanceMananger;

import com.ruse.model.Position;
import com.ruse.model.RegionInstance.RegionInstanceType;

/**
 * 
 * @author Adam_#6723
 *
 */

public enum InstanceData {

	EMBER_GIANTS(-30465, 9838, "Ember Giant", 35, new int[] { 19624 },
			"Ember Giant",new Position(2758, 4743), RegionInstanceType.KINGS),
	TREE_BASILISK(-30464, 1718, "Tree Gorgon", 35, new int[] { 19624 },
			"Tree Basilisk",new Position(2758, 4743), RegionInstanceType.KINGS),
	BAT_OF_LIGHT(-30463, 9836, "Bat of light", 35, new int[] { 19624 },
			"Bat of light",new Position(2758, 4743), RegionInstanceType.KINGS),
	GIANT_SPIDER(-30462, 117, "Giant Spider", 35, new int[] { 19624 },
			"Giant Spider",new Position(2758, 4743), RegionInstanceType.KINGS),
	CASH_DRAGONS(-30461, 500, "Cash Dragon", 35, new int[] { 19624 },
			"Cash Dragon",new Position(2758, 4743), RegionInstanceType.KINGS),
	DEMON_GODDESS(-30460, 501, "Demon Goddess", 35, new int[] { 19624 },
			"Demon Goddess",new Position(2758, 4743), RegionInstanceType.KINGS),
	ENERGY_SKELETONS(-30459, 503, "Energy Skeleton", 35, new int[] { 19624 },
			"Energy Skeleton",new Position(2758, 4743), RegionInstanceType.KINGS),
	TUROTHS(-30458, 1627, "Turoth", 35, new int[] { 19624 },
			"Turoth",new Position(2758, 4743), RegionInstanceType.KINGS),
	LORD(-30457, 603, "Lord", 35, new int[] { 19624 },
			"Lord",new Position(2758, 4743), RegionInstanceType.KINGS),
	SHADOW_HUNTERS(-30456, 12843, "Shadow Hunter", 35, new int[] { 19624 },
			"Shadow Hunter",new Position(2758, 4743), RegionInstanceType.KINGS),
	GOLEM(-30455, 53, "Jynx Golem", 35, new int[] { 19624 },
			"Jynx Golem",new Position(2758, 4743), RegionInstanceType.KINGS),
	SHETANI(-30454, 220, "Shetani", 35, new int[] { 19624 },
			"Shetani",new Position(2758, 4743), RegionInstanceType.KINGS),
	TITANIUM_RIPPER(-30453, 13635, "Titanium Ripper", 35, new int[] { 19624 },
			"Titanium Ripper",new Position(2758, 4743), RegionInstanceType.KINGS),
	TITAN(-30452, 8008, "Avatar Titan", 35, new int[] { 19624 },
			"Avatar Titan",new Position(2758, 4743), RegionInstanceType.KINGS),
	WYVERNS(-30451, 3308, "Legendary Wyvern", 3308, new int[] { 19624 },
			"Legendary Wyvern",new Position(2758, 4743), RegionInstanceType.KINGS),
	ONI(-30450, 3117, "Oni", 3308, new int[] { 19624 },
			"Oni",new Position(2758, 4743), RegionInstanceType.KINGS),
	SHENRON(-30449, 201, "Shenron", 3308, new int[] { 19624 },
			"Shenron",new Position(2758, 4743), RegionInstanceType.KINGS),
	SUBZERO(-30448, 202, "SubZero", 3308, new int[] { 19624 },
			"SubZero",new Position(2758, 4743), RegionInstanceType.KINGS),
	ZEUS(-30447, 203, "Zeus", 3308, new int[] { 19624 },
			"Zeus",new Position(2758, 4743), RegionInstanceType.KINGS),
	IPOTANE(-30446, 8010, "Ipotane", 3308, new int[] { 19624 },
			"Ipotane",new Position(2758, 4743), RegionInstanceType.KINGS),
	VINDICTA(-30445, 9807, "Vindicta", 3308, new int[] { 19624 },
			"Vindicta",new Position(2758, 4743), RegionInstanceType.KINGS),
	HANTO(-30444, 250, "Hanto warrior", 3308, new int[] { 19624 },
			"Hanto warrior",new Position(2758, 4743), RegionInstanceType.KINGS),
	RADITZ(-30443, 449, "Raditz", 3308, new int[] { 19624 },
			"Raditz",new Position(2758, 4743), RegionInstanceType.KINGS),
	GOKU(-30442, 452, "Raditz", 3308, new int[] { 19624 },
			"Raditz",new Position(2758, 4743), RegionInstanceType.KINGS),
	BOTANIC(-30441, 2342, "Botanic Guardian", 3308, new int[] { 19624 },
			"Botanic Guardian",new Position(2758, 4743), RegionInstanceType.KINGS),
	ENRAGED_GUARDIAN(-30440, 2949, "Enraged Guardian", 3308, new int[] { 19624 },
			"Enraged Guardian",new Position(2758, 4743), RegionInstanceType.KINGS),
	ELEMENTAL_GUARDIAN(-30439, 505, "Elemental Guardian", 3308, new int[] { 19624 },
			"Elemental Guardian",new Position(2758, 4743), RegionInstanceType.KINGS),
	INNUYASHA(-30438, 185, "Inuyasha", 3308, new int[] { 19624 },
			"Inuyasha",new Position(2758, 4743), RegionInstanceType.KINGS),
	TOLOROKOTH(-30437, 6430, "Tolrokoth", 3308, new int[] { 19624 },
			"Tolrokoth",new Position(2758, 4743), RegionInstanceType.KINGS),
	TIER_1(-30436, 9116, "Faceless Magician", 3308, new int[] { 19624 },
			"Faceless Magician",new Position(2758, 4743), RegionInstanceType.KINGS),
	TIER_2(-30435, 9117, "Lotus Magician", 3308, new int[] { 19624 },
			"Lotus Magician",new Position(2758, 4743), RegionInstanceType.KINGS),
	TIER_3(-30434, 9118, "Shadow Magician", 3308, new int[] { 19624 },
			"Shadow Magician",new Position(2758, 4743), RegionInstanceType.KINGS),



	;

	InstanceData(int buttonid, int npcid, String text, int endamount, int rewards[], String name, Position position,
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
