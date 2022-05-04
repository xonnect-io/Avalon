package com.ruse.world.content.skill.impl.summoning;

import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;

public class BossPets {

	@Getter
	public enum BossPet {

		//AENEAS(9020, 9021, 23018),
		//TLAHUICOLE(9020, 9021, 23018),
		//NEYTIRI(9020, 9021, 23018),
		//ATTICUS(9020, 9021, 23018),
		//ELEANOR(9020, 9021, 23018),
		//SOREN(9020, 9021, 23018),
		//CASSIUS(9020, 9021, 23018),
		//ZORA(9020, 9021, 23018),
		//ANAIS(9020, 9021, 23018),
		//ASTAIRE(9020, 9021, 23018),
		//GAEL(9020, 9021, 23018),
		//SKILLING(9020, 9021, 23018),
		//MONSTEROUS(9020, 9021, 23018),
		//SLAYER(9020, 9021, 23018),
		//COLLECTOR(9020, 9021, 23018),
		//MASTER(9020, 9021, 23018),


		// PETS

		BROWN_CAT(770, 770, 500,"10% Magic damage boost"),
		BLACK_CAT(771, 771, 500,"10% Magic damage boost"),
		WHITE_CAT(769, 769, 500,"10% Magic damage boost"),

		DOG(6960, 6960, 500,"10% Magic damage boost"),
		TERRIER(6958, 6958, 500,"10% Magic damage boost"),
		BULLDOG(6968, 6968, 500,"10% Magic damage boost"),
		DALMATION(6964, 6964, 500,"10% Magic damage boost"),
		// UPGRADABLE PETS
		SCORP_PET(271, 271, 500,"10% Magic damage boost"),
		UNICORN_PET(133, 133, 500,"10% Magic damage boost"),
		GRIZZLY_PET(105,105, 500,"10% Magic damage boost"),
		WOLF_PET(4414, 4414, 500,"10% Magic damage boost"),
		GORILLA_PET(3001, 3001, 500,"10% Magic damage boost"),
		VEGETA_PET(5001, 5001, 500,"10% Magic damage boost"),
		YOSHI_PET(3377, 3377, 500,"10% Magic damage boost"),
		ETERNAL_PET(4969, 4969, 500,"10% Magic damage boost"),
		CHARIZARD_PET(1890, 1890, 500,"10% Magic damage boost"),
		DONKEY_KONG_PET(1894, 1894, 500,"10% Magic damage boost"),
		SONIC_PET(1893, 1893, 500,"10% Magic damage boost"),
		MARIO_PET(1892, 1892, 500,"10% Magic damage boost"),
		SUPER_STAR_PET(1904, 1904, 500,"10% Magic damage boost"),
		BUMBLEBEE(1902, 1902, 500,"10% Magic damage boost"),
		DBZ(302, 11314, 500,"10% Magic damage boost"),
		EEARTHQUAKE(3309, 3309, 500,"10% Magic damage boost"),
		VOTEPET(8802, 8802, 500,"10% Magic damage boost"),
		GRINCH(189, 189, 500,"10% Magic damage boost"),
		HOOKER(4444, 4444, 500,"10% Magic damage boost"),
		FREEZA1(350, 350, 500,"10% Magic damage boost"),
		FREEZA2(351, 351, 500,"10% Magic damage boost"),
		FREEZA3(352, 352, 500,"10% Magic damage boost"),
		SUPERCELL(928, 928, 500,"10% Magic damage boost"),
		FATBUU(4000, 4000, 500,"10% Magic damage boost"),
		SUPERBUU(4001, 4001, 500,"10% Magic damage boost"),
		JOKERSPET(184, 184, 500,"10% Magic damage boost"),
		ICEQUEENPET(6431, 6431, 500,"10% Magic damage boost"),
		// ETERNAL_PET(4969, 4969, 463),
		//
		PETRACOON(6913, 6913, 500,"10% Magic damage boost"),
		PETSQ(6919, 6919, 500,"10% Magic damage boost"),
		PETMONKEY(6942, 6942, 500,"10% Magic damage boost"),
		PETVULTURE(6945, 6945, 500,"10% Magic damage boost"),
		ADMINPET(1801, 1801, 500,"10% Magic damage boost"),
		ZORBAK(1906, 1906, 500,"10% Magic damage boost"),
		PET_CHAOS_ELEMENTAL(3200, 3033, 500,"10% Magic damage boost"),
		PET_KING_BLACK_DRAGON(50, 3030, 500,"10% Magic damage boost"),
		PET_GENERAL_GRAARDOR(6260, 3031, 500,"10% Magic damage boost"),
		PET_TZTOK_JAD(2745, 3032, 500,"10% Magic damage boost"),
		PET_CORPOREAL_BEAST(8133, 3034, 500,"10% Magic damage boost"),
		PET_KREE_ARRA(6222, 3035, 500,"10% Magic damage boost"),
		PET_KRIL_TSUTSAROTH(6203, 3036, 500,"10% Magic damage boost"),
		PET_COMMANDER_ZILYANA(6247, 3037, 500,"10% Magic damage boost"),
		PET_DAGANNOTH_SUPREME(2881, 3038, 500,"10% Magic damage boost"),
		PET_DAGANNOTH_PRIME(2882, 3039, 500,"10% Magic damage boost"),
		PET_DAGANNOTH_REX(2883, 3040, 500,"10% Magic damage boost"),
		PET_FROST_DRAGON(51, 3047, 500,"10% Magic damage boost"),
		PET_TORMENTED_DEMON(8349, 3048, 500,"10% Magic damage boost"),
		PET_KALPHITE_QUEEN(1158, 3050, 500,"10% Magic damage boost"),
		PET_SLASH_BASH(2060, 3051, 500,"10% Magic damage boost"),
		PET_PHOENIX(8549, 3052, 500,"10% Magic damage boost"),
		PET_BANDOS_AVATAR(4540, 3053, 500,"10% Magic damage boost"),
		PET_NEX(918, 3054, 500,"10% Magic damage boost"),
		PET_JUNGLE_STRYKEWYRM(9467, 3055, 500,"10% Magic damage boost"),
		PET_DESERT_STRYKEWYRM(9465, 3056, 500,"10% Magic damage boost"),
		PET_ICE_STRYKEWYRM(9463, 3057, 500,"10% Magic damage boost"),
		PET_GREEN_DRAGON(941, 3058, 500,"10% Magic damage boost"),
		PET_BABY_BLUE_DRAGON(52, 3059, 500,"10% Magic damage boost"),
		PET_BLUE_DRAGON(55, 3060, 500,"10% Magic damage boost"),
		PET_BLACK_DRAGON(54, 3061, 500,"10% Magic damage boost"),
		// customs below
		PET_SKELETON_HELLHOUND(1575, 6302, 500,"10% Magic damage boost"),
		PET_MAZE_GUARDIAN(3102, 6303, 500,"10% Magic damage boost"),
		PET_SKELETON_WARLORD(6105, 6304, 500,"10% Magic damage boost"),
		PET_PENGUIN(131, 6305, 500,"10% Magic damage boost"),
		PET_DRUID(14, 6306, 500,"10% Magic damage boost"),
		PET_MONKEY_GUARD(1455, 6307, 500,"10% Magic damage boost"),
		PET_CLOCKWORK_CAT(3598, 6308, 500,"10% Magic damage boost"),
		PET_JUBBLY_BIRD(3476, 6309, 500,"10% Magic damage boost"),
		PET_DUST_DEVIL(1624, 6310, 500,"10% Magic damage boost"),
		PET_CHINCHOMPA(5080, 6312, 500,"10% Magic damage boost"),
		PET_GOLEM(1920, 6313, 500,"10% Magic damage boost"),
		PET_CHAOS_DWARF(119, 6314, 500,"10% Magic damage boost"),
		PET_SHARK(467, 6315, 500,"10% Magic damage boost"),
		PET_GOBLIN_COOK(3413, 6316, 500,"10% Magic damage boost"),
		PET_FIRE_ELEMENTAL(1019, 6317, 500,"10% Magic damage boost"),
		PET_TREE_SPIRIT(655, 6318, 500,"10% Magic damage boost"),
		PET_LEPRECHAUN(3021, 6319, 500,"10% Magic damage boost"),
		PET_EVIL_CHICKEN(3375, 6320, 500,"10% Magic damage boost"),
		PET_ABYSSAL_DEMON(1615, 6311, 500,"10% Magic damage boost"),
		PET_ZULRAH_GREEN(2042, 6322, 500,"10% Magic damage boost"),
		PET_ZULRAH_BLUE(2042, 6323, 500,"10% Magic damage boost"),
		PET_ZULRAH_RED(2042, 6324, 500,"10% Magic damage boost"),
		PET_WILDYWYRM(3334, 3062, 500,"10% Magic damage boost"),


		MAGE_PET(9031, 23041, 500,"10% Magic damage boost"),
		MELEE_PET(9032, 23042,500, "10% Melee damage boost"),
		RANGED_PET(9033, 23043, 500,"10% Ranged damage boost"),
		KILJAEDEN_PET(9826, 23114, 500,"15% Overall damage boost"),

		SKREEG_PET(9827, 23115, 400,"10% Drop rate boost\\n10% Double Drop rate boost"),
		ORIX_PET(9828, 23116, 400,"20% Drop rate boost\\n20% Double Drop rate boost"),
		CRYSTAL_ORC_PET(9829, 23117, 500,"25% Drop rate boost\\n25% Double Drop rate boost"),
		RAMMUS_PET(9822, 23164, 400,"20% Upgrade boost"),

		DEMON_PET(9819, 23161, 300,"10% Overall damage boost\\n10% Drop rate boost\\n10% Double Drop rate boost"),
		GOLEM_PET(9821, 23163, 400,"15% Overall damage boost\\n15% Drop rate boost\\n15% Double Drop rate boost"),
		DRAGON_PET(9820, 23162, 1500,"25% Overall damage boost\\n25% Drop rate boost\\n25% Double Drop rate boost"),

		FENRIR_PET(9830, 23108, 300,"2X EXP Boost\\n25% off on skill island shops"),
		GREEN_FENRIR_PET(9831, 23109, 300,"10% Overall damage boost,\\n 10% Drop rate boost,\\n 10% Double Drop rate boost,\\n while doing minigames"),
		RED_FENRIR_PET(9832, 23110,300, "2X Slayer Tickets on Task \\n20% Overall dmg boost on task"),
		HEIMDALL_PET(9834, 23112, 400,"Collects all items on the\\nground to the bank."),
		ODIN_PET(9833, 23111, 400,
				"20% Overall damage boost\\n25% DR, DDR, Upgrade Boost\\n Collects items on ground to bank\\n 2X EXP Boost"),

		GORVEK_PET(9808, 23081),
		VINDICTA_PET(9809, 23082),
		AVARYSS_PET(9803, 23083),
		CONJKOINED_PET(9804,  23084),
		NYMORA_PET(9805, 23085),

		DEMON_LIGHT_PET(9840, 23151),
		BAT_LIGHT_PET(9841, 23152),
		GOBLIN_LIGHT_PET(9842, 23153),
		LAVA_HOUND_PET(9843,  23154),
		MUTATED_HOUND_PET(9844,  23155),

		SCORPION_PET(9847, 23156),
		ZOMBIE_PET(9848,  23157),
		;

		BossPet(int npcId, int itemId) {
			this.npcId = npcId;
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

		public int npcId, itemId, zoom = 800;
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
