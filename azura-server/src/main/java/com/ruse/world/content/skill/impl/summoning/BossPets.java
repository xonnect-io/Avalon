package com.ruse.world.content.skill.impl.summoning;

import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;

public class BossPets {

	@Getter
	public enum BossPet {

		// UPGRADABLE PETS
		WOLF_PET(4414, 4414,459),
		GORILLA_PET(3001,3001, 460),
		MARIO_PET(1892, 1892,5508),
		DONKEY_KONG_PET(1894,1894, 5506),
		VEGETA_PET(5001,5001, 461),
		YOSHI_PET(3377,3377, 462),
		TOLROKOTH_PET(6431,6431, 14067),
		ZORBAK_PET(1906,1906, 11319),
		RAICHU_PET(1801,1801, 11318),

		HOOKER(4444,4444, 20511),
		//Boss pets & Minigame pets
		FALLEN_ANGEL_PET(9013,9013, 22107),
		FENRIR_PET(9830,9830, 23108),
		GREEN_FENRIR_PET(9831,9831, 23109),
		RED_FENRIR_PET(9832,9832, 23110),
		VOTE_PET(8802,8802, 11316),
		HELLRAISER(302,302, 11314),
		RAMMUS_PET(9822,9822, 23164),
		DEMON_PET(9819,9819, 23161),
		GOLEM_PET(9821,9821, 23163),
		DRAGON_PET(9820,9820, 23162),
		IRONS_PET(9016,9016, 22116),
		SUMMER_SURFER(9120,9120, 23323),
		FACELESS_MAGICIAN(9121,9121, 23324),
		LOTUS_MAGICIAN(9122,9122, 23325),
		SHADOW_MAGICIAN(9123,9123, 23326),
		LESARKUS_WARRIOR(9124,9124, 23387),
		VAMPIRE_WARRIOR(9125,9125, 23388),
		ELF_WARRIOR(9126, 9126,23389),
		BLOOD_DEMON_PET(204,204, 23252),
		VINDICTA_PET(9809,9809, 23082),
		BORK_PET(225,225, 23381),
		SPIRIT_OF_SCORPIUS(4594,4594, 23436),
		EVIL_SCORPIUS(4592,4592, 23437),
		NECROMANCER(9895,9895, 22954),
		;

		BossPet(int npcId, int itemId) {
			this.npcId = npcId;
			this.itemId = itemId;
		}

		BossPet(int npcId, int spawnNpcId, int itemId) {
			this.npcId = npcId;
			this.spawnNpcId = spawnNpcId;
			this.itemId = itemId;
		}
		BossPet(int npcId, int itemId, String boost) {
			this.npcId = npcId;
			this.itemId = itemId;
			this.boost = boost;
		}
		BossPet(int npcId, int itemId, int zoom, String boost) {
			this.npcId = npcId;
			this.itemId = itemId;
			this.zoom = zoom;
			this.boost = boost;
		}

		public int npcId,spawnNpcId, itemId, zoom = 800;
		public String boost = "None";

		public static BossPet forId(int itemId) {
			for (BossPet p : BossPet.values()) {
				if (p != null && p.itemId == itemId) {
					return p;
				}
			}
			return null;
		}

		public static BossPet forSpawnId(int spawnNpcId) {
			for (BossPet p : BossPet.values()) {
				if (p != null && p.npcId == spawnNpcId) {
					return p;
				}
			}
			return null;
		}
	}

	public static boolean pickup(Player player, NPC npc) {
		BossPet pet = BossPet.forSpawnId(npc.getId());
		if (pet != null) {
			if (player.getInventory().getFreeSlots() < 1) {
				player.getPacketSender().sendMessage("You need a free inventory space to pick up a pet.");
				return false;
			}
			if (player.getSummoning().getFamiliar() != null
					&& player.getSummoning().getFamiliar().getSummonNpc() != null
					&& player.getSummoning().getFamiliar().getSummonNpc().isRegistered()) {
				if (player.getSummoning().getFamiliar().getSummonNpc().getId() == pet.npcId
						&& player.getSummoning().getFamiliar().getSummonNpc().getIndex() == npc.getIndex()) {
					player.getSummoning().unsummon(true, true);
					player.getPacketSender().sendMessage("You pick up your pet.");
					return true;
				} else {
					player.getPacketSender().sendMessage("This is not your pet to pick up.");
				}
			} else {
				player.getPacketSender().sendMessage("This is not your pet to pick up.");
			}
		}
		return false;
	}

}
