package com.ruse.world.content.skill.impl.slayer;

import com.ruse.model.Position;
import com.ruse.model.Skill;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.world.content.PlayerPanel;
import com.ruse.world.entity.impl.player.Player;

public enum SlayerMaster {
	BOSS_SLAYER(90, 9000, new Position(2667, 4015)),
	EASY_SLAYER(1, 1597, new Position(2853, 9374)),
	MEDIUM_SLAYER(70, 8275, new Position(2174, 5016)),
	HARD_SLAYER(80, 9085, new Position(2019, 5009))

	;

	private SlayerMaster(int slayerReq, int npcId, Position telePosition) {
		this.slayerReq = slayerReq;
		this.npcId = npcId;
		this.position = telePosition;
	}

	private int slayerReq;
	private int npcId;
	private Position position;

	public static SlayerMaster forNpcId(int id) {
		for (SlayerMaster master : SlayerMaster.values()) {
			if (master.npcId == id) {
				return master;
			}
		}
		return EASY_SLAYER;
	}

	public int getSlayerReq() {
		return this.slayerReq;
	}

	public int getNpcId() {
		return this.npcId;
	}

	public Position getPosition() {
		return this.position;
	}
	public String getSlayerMasterName() {
		String name = "";
		NpcDefinition def = NpcDefinition.forId(getNpcId());
		if(def != null && def.getName() != null) {
			name = def.getName();
		}
		return name;
	}
	public static SlayerMaster forId(int id) {
		for (SlayerMaster master : SlayerMaster.values()) {
			if (master.ordinal() == id) {
				return master;
			}
		}
		return null;
	}

	public static void changeSlayerMaster(Player player, SlayerMaster master) {
		player.getPacketSender().sendInterfaceRemoval();

		int level = master.getSlayerReq();

		String masterName = "Easy task";
		if(master == SlayerMaster.MEDIUM_SLAYER) {
			masterName = "Medium task";
		} else if(master == SlayerMaster.HARD_SLAYER) {
			masterName = "Hard task";
		} else if(master == SlayerMaster.BOSS_SLAYER) {
			masterName = "Boss Slayer Master";
		}

		if (player.getSkillManager().getCurrentLevel(Skill.SLAYER) < level) {
			player.getPacketSender().sendMessage("You need a Slayer level of at least " + master.getSlayerReq()
					+ " to access " + masterName + "'s.");
			player.getPacketSender().sendInterfaceRemoval();
			return;
		}

		if(player.getSlayer().getSlayerMaster() != master) {
			player.getPacketSender().sendMessage("You've successfully changed Slayer difficulties.");
		}
		player.getSlayer().setSlayerMaster(master);
		PlayerPanel.refreshPanel(player);

	}
}
