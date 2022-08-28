package com.ruse.world.content.instanceManagerSlayer;

import com.ruse.model.Position;
import com.ruse.model.RegionInstance.RegionInstanceType;

/**
 * 
 * @author Adam_#6723
 *
 */

public enum SlayerInstanceData {

	SYMBIOTE(-17465, 1727, "Symbiote", 1, new int[] { 19624 },
			"Symbiote",new Position(2758, 4743), RegionInstanceType.INSTANCE),

	ELEMENTAL_MOSS(-17464, 1740, "Elemental Moss", 1, new int[] { 19624 },
			"Elemental Moss",new Position(2758, 4743), RegionInstanceType.INSTANCE),

	LEOPARD(-17463, 1733, "Leopard", 1, new int[] { 19624 },
			"Leopard",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	DINO(-17462, 6870, "Dino", 1, new int[] { 19624 },
			"Dino",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	SPIRIT_CRITTER(-17461, 6871, "Spirit Critter", 1, new int[] { 19624 },
			"Spirit Critters",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ELEMENTAL_FIRE(-17460, 1741, "Elemental Fire", 1, new int[] { 19624 },
			"Elemental Fire",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	WILD_GRAAHK(-17459, 1734, "Wild Graahk", 1, new int[] { 19624 },
			"Wild Graahk",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	RUSTED_GARGOYLE(-17458, 1712, "Rusted Gargoyle", 1, new int[] { 19624 },
			"Rusted Gargoyle",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	TRAPPER(-17457, 1710, "Trapper", 1, new int[] { 19624 },
			"Trapper",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	ZAMORAK_BAT(-17456, 1725, "Zamorak Bat", 1, new int[] { 19624 },
			"Zamorak Bat",new Position(2758, 4743), RegionInstanceType.INSTANCE),

	CAVE_DRONE(-17455, 6799, "Cave Drone", 1, new int[] { 19624 },
			"Cave Drone",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	CAVE_SNAIL(-17454, 6792, "Cave Snail", 1, new int[] { 19624 },
			"Cave Snail",new Position(2758, 4743), RegionInstanceType.INSTANCE),
	CAVE_MUTANT(-17453, 6798, "Cave Mutant", 1, new int[] { 19624 },
			"Cave Mutant",new Position(2758, 4743), RegionInstanceType.INSTANCE),

	;

	SlayerInstanceData(int buttonid, int npcid, String text, int endamount, int rewards[], String name, Position position,
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

