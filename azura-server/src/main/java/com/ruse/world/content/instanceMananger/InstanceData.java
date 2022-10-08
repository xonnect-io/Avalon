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
			"Ember Giant",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TREE_BASILISK(-30464, 1718, "Tree Gorgon", 35, new int[] { 19624 },
			"Tree Basilisk",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	AQUANITE(-30463, 9172, "Aquanite", 35, new int[] { 19624 },
			"Aquanite",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	GIANT_SPIDER(-30462, 117, "Arachne", 35, new int[] { 19624 },
			"Arachne",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	CASH_DRAGONS(-30461, 500, "Cash Dragon", 35, new int[] { 19624 },
			"Cash Dragon",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	DEMON_GODDESS(-30460, 501, "Demon Goddess", 35, new int[] { 19624 },
			"Demon Goddess",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ENERGY_SKELETONS(-30459, 503, "Energy Skeleton", 35, new int[] { 19624 },
			"Energy Skeleton",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TUROTHS(-30458, 1627, "Turoth", 35, new int[] { 19624 },
			"Turoth",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	LORD(-30457, 603, "Lord", 35, new int[] { 19624 },
			"Lord",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SHADOW_HUNTERS(-30456, 12843, "Shadow Hunter", 35, new int[] { 19624 },
			"Shadow Hunter",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	GOLEM(-30455, 53, "Jynx Golem", 35, new int[] { 19624 },
			"Jynx Golem",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SHETANI(-30454, 8018, "Shetani", 35, new int[] { 19624 },
			"Shetani",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TITANIUM_RIPPER(-30453, 13635, "Titanium Ripper", 35, new int[] { 19624 },
			"Titanium Ripper",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TITAN(-30452, 8008, "Avatar Titan", 35, new int[] { 19624 },
			"Avatar Titan",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	WYVERNS(-30451, 3308, "Legendary Wyvern", 3308, new int[] { 19624 },
			"Legendary Wyvern",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ONI(-30450, 3117, "Oni", 3308, new int[] { 19624 },
			"Oni",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SHENRON(-30449, 201, "Shenron", 3308, new int[] { 19624 },
			"Shenron",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SUBZERO(-30448, 202, "SubZero", 3308, new int[] { 19624 },
			"SubZero",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ZEUS(-30447, 203, "Zeus", 3308, new int[] { 19624 },
			"Zeus",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	IPOTANE(-30446, 8010, "Ipotane", 3308, new int[] { 19624 },
			"Ipotane",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	VINDICTA(-30445, 9807, "Vindicta", 3308, new int[] { 19624 },
			"Vindicta",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	BORK(-30444, 7134, "Bork", 3308, new int[] { 19624 },
			"Bork",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	HANTO(-30443, 250, "Hanto warrior", 3308, new int[] { 19624 },
			"Hanto warrior",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	RADITZ(-30442, 449, "Raditz", 3308, new int[] { 19624 },
			"Raditz",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	GOKU(-30441, 452, "Goku", 3308, new int[] { 19624 },
			"Goku",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	BOTANIC(-30440, 2342, "Botanic Guardian", 3308, new int[] { 19624 },
			"Botanic Guardian",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ENRAGED_GUARDIAN(-30439, 2949, "Enraged Guardian", 3308, new int[] { 19624 },
			"Enraged Guardian",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ELEMENTAL_GUARDIAN(-30438, 505, "Elemental Guardian", 3308, new int[] { 19624 },
			"Elemental Guardian",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	INNUYASHA(-30437, 185, "Inuyasha", 3308, new int[] { 19624 },
			"Inuyasha",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TOLOROKOTH(-30436, 6430, "Tolrokoth", 3308, new int[] { 19624 },
			"Tolrokoth",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TIER_1(-30435, 9116, "Faceless Magician", 3308, new int[] { 19624 },
			"Faceless Magician",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TIER_2(-30434, 9117, "Lotus Magician", 3308, new int[] { 19624 },
			"Lotus Magician",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TIER_3(-30433, 9118, "Shadow Magician", 3308, new int[] { 19624 },
			"Shadow Magician",new Position(2758, 4743), RegionInstanceType.INSTANCE),



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
