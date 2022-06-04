package com.ruse.world.content.teleport;

import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.motivote3.doMotivote;
import com.ruse.world.content.*;

/**
 * The teleport data.
 * 
 * @author snz
 */
/**
 * @ plugin interferences system has been initialize for only 10 because of the set vaules inserted/note
 * note for me//
 * @author snz
 *
 */
public enum TeleportData {
	/*
	 * Monsters
	 */

	MINOTAUR(28307, 28307, 28307, 28231,"Minotaurs", "Minotaurs",
			"@or1@Health:@whi@ 250","","", TeleportType1.MONSTERS, new Position(2527, 2527, 0), 5, false, 1719, -1,
			new int[][] {{10025, 1}, {7956, 2}, {989,3 }, {6199, 2}, {5022, 3}, {5021, 6}, {14525, 1}, {11858, 1}, {19582, 1}, {536, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},600 ),

	LAVA_HOUND(28308, 28308, 28308, 28232,"Ember Giants", "Ember Giants",
			"@or1@Health:@whi@ 500","","", TeleportType1.MONSTERS, new Position(3424, 4126, 0), 5, false, 9838, -1,
			new int[][] {{7956, 1}, {989, 1}, {4882, 1}, {4894, 1}, {4900,1 }, {4888, 1}, {20460, 1}, {20456, 1}, {18747, 1}, {6199, 1}, {5022, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 600),

	TREE_BASILISK( 28309, 28309, 28309, 28233,"Tree Basilisk", "Tree Basilisk",
			"@or1@Health:@whi@ 500","","",  TeleportType1.MONSTERS, new Position(2196, 5083, 0), 10, false, 1718, -1,
			new int[][] {{7956, 1}, {989, 1}, {17043, 1}, {17175, 1},  {17321, 1}, {18332, 1}, {15026, 1}, {10696, 1}, {6199, 1}, {5022, 1}, {-1, 1}, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 550),

	BAT( 28310, 28310, 28310, 28234,"Bat of light", "Bat of light",
			"@or1@Health:@whi@ 500","","",  TeleportType1.MONSTERS, new Position(2388, 5019, 0), 0, false, 9836, -1,
			new int[][] {{7956, 1}, {989, 1}, {14733, 1}, {14732, 1},  {14734, 1}, {14377, 1}, {10865, 1}, {12864, 1}, {6199, 1}, {5022, 15}, {-1, 1}, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 1500),

	GIANT_SPIDERS( 28311, 28311, 28311, 28235,"Giant Spiders", "Giant Spiders",
			"@or1@Health:@whi@ 12,000","","",  TeleportType1.MONSTERS, new Position(2721, 4446, 0), 10, false, 117, -1,
			new int[][] {{12855, 1000}, {5022, 100}, {22214, 3}, {22219, 2}, {781, 1}, {19811, 1}, {19473, 1}, {19472, 1}, {17291,1 }, {3909,1 }, {11235,1 }, {6199,1 }, {2435,30 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},720),

	CASH_DRAGON( 28312, 28312, 28312, 28238, "Cash dragons", "Cash dragons",
			"@or1@Health:@whi@ 14,000","","",  TeleportType1.MONSTERS, new Position(2911, 3613, 0), 10, false, 500, -1,
			new int[][] {{5022, 100}, {21221, 1}, {22214, 3}, {6199, 1}, {989, 1},  {15270, 1}, {3025, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 1500),

	DEMON_GODDESS( 28313, 28313, 28313, 28239, "Demon Goddesses", "Demon Goddesses",
			"@or1@Health:@whi@ 16,000","","",  TeleportType1.MONSTERS, new Position(2784, 4445, 0), 10, false, 501, -1,
			new int[][] {{12855, 1000}, {5022, 100}, {22214, 3}, {22219, 1}, {781, 1},  {8834, 1}, {8835, 1}, {8860, 1}, {8861, 1}, {8862, 1}, {15830, 1}, {18686, 1}, {18799,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 1500),

	ENERGY_SKELETON(28314, 28314, 28314, 28240, "Energy Skeletons", "Energy Skeletons",
			"@or1@Health:@whi@ 20,000","","",  TeleportType1.MONSTERS,  new Position(2088, 3995, 0), 10, false, 503, -1,
			new int[][] {{12855, 1150}, {5022, 115}, {22214, 3}, {22219, 1}, {781, 1}, {19931, 1}, {19933, 1}, {19934, 1}, {19919,1 }, {19917,1 }, {7927,1}, {18830,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},700),

	TUROTH(28315, 28315, 28315, 28241, "Turoths", "Turoths",
			"@or1@Health:@whi@ 333,333","","",  TeleportType1.MONSTERS,  new Position(3154, 5556, 0), 10, false, 1627, -1,
			new int[][] {{12855, 1250}, {5022, 125},{22214, 1}, {22219, 1}, {781, 1}, {8816, 1}, {8817,1}, {8818, 1}, {3905,1 }, {14018,1 }, {5022,10 }, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),

	FALLEN_WARRIOR(28316, 28316, 28316, 28239, "Fallen Warrior", "Fallen Warrior",
			"@or1@Health:@whi@ 333,333","","",  TeleportType1.MONSTERS,  new Position(1955, 5154, 0), 10, false, 9011, -1,
			new int[][] {{12855, 500}, {5022, 100},{15288, 1}, {15358, 1}, {15359, 1}, {-1, 1}, {-1,1}, {-1, 1}, {-1,1 }, {-1,1 }, {-1,1 }, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),

	
	/*
	 * Bosses
	 */

	TRUMP( 28307, 28307, 28307, 28231,"Donald Trump", "Donald Trump",
			"@or1@Health:@whi@ 5,000","","",  TeleportType1.BOSSES, new Position(3040, 2846, 0), 10, false, 250, -1,
			new int[][] { {10946, 1}, {6833, 1}, {11763, 1}, {11764, 1},{11765, 1}, {11766, 1}, {11767, 1}, {18686, 1}, {18799,1}, {3318, 1}, {15418, 1}, {6199, 2}, {5022, 9}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},780),

	RADITZ( 28308, 28308, 28308, 28232, "Raditz", "Raditz",
			"@or1@Health:@whi@ 10,000","","",  TeleportType1.BOSSES, new Position(2911, 3991, 0), 10, false, 449, -1,
			new int[][] {{10946, 1}, {18768, 1}, {7545, 1}, {7543, 1}, {7544, 1}, {9481, 1}, {9482, 1}, {9483, 1}, {12855, 300}, {5022, 300}, {12855, 70}, {5022, 70}, {7956, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},780),

	GOKU( 28309, 28309, 28309, 28233, "Goku", "Goku",
			"@or1@Health:@whi@ 50,000","","",  TeleportType1.BOSSES,new Position(3358, 9307, 0), 10, false, 452, -1,
			new int[][] {{18838, 1}, {9478, 1}, {9479, 1}, {9480, 1}, {16265, 1}, {15832, 1}, {16249, 1}, {6833, 1}, {18768, 1}, {12855,300}, {5022,300}, {12855,70}, {7956,2}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},780),

	BOTANIC(28310, 28310, 28310, 28234,"Botanic Guardian", "Botanic Guardian",
			"@or1@Health:@whi@ 600,000","","",  TeleportType1.BOSSES, new Position(2586, 9449, 0), 10, false, 2342, -1,
			new int[][] {{3738, 1}, {3723, 1}, {3724, 1}, {3725, 1}, {12855, 1000}, {12855, 1000}, {12855, 1000}, {12855, 1000}, {989, 3}, {6199,3 }, {5022,3 }, {5021,3 }, {-1,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

	ENRAGED_GUARDIAN( 28311, 28311, 28311, 28235, "Enraged Guardian", "Enraged Guardian",
			"@or1@Health:@whi@ 600,000","","",  TeleportType1.BOSSES, new Position(3039, 3995, 0), 10, false, 2949, -1,
			new int[][] {{3737, 1}, {3720, 1}, {3721, 1}, {3722, 1}, {12855, 1000}, {12855, 1000},{12855, 1000}, {12855, 1000}, {989, 3}, {6199, 3}, {5022, 3}, {5021, 3}, {-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

	ELEMENTAL_GUARDIAN( 28312, 28312, 28312, 28236, "Elemental Guardian", "Elemental Guardian",
			"@or1@Health:@whi@ 600,000","","",  TeleportType1.BOSSES,new Position(2781, 4576, 0), 10, false, 505, -1,
			new int[][] {{3739, 1}, {3726, 1}, {3728, 1}, {3730, 1}, {12855, 1000}, {12855, 1000},{12855, 1000}, {12855, 1000}, {989, 3}, {6199, 3}, {5022, 3}, {5021, 3}, {-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

	INYUASHA(28313, 28313, 28313, 28237,"Inuyasha", "Inuyasha",
			"@or1@Health:@whi@ 500,000","","",  TeleportType1.BOSSES, new Position(2328, 5409, 0), 10, false, 185, -1,
			new int[][] {{5073, 1000}, {5068, 1}, {5069, 1}, {5070, 1}, {5071, 1}, {5072, 1},{8335, 1}, {10946, 1}, {12855, 1000}, {12855, 1000}, {12855, 1000}, {12855, 1000}, {989, 3}, {19114, 1}, {19115, 1}, {19116, 1}, {5022, 3}},750),

	TOLROKOTH( 28314, 28314, 28314, 28238, "Tolrokoth", "Tolrokoth",
			"@or1@Health:@whi@ 500,000","","",  TeleportType1.BOSSES, new Position(1887, 5468, 0), 10, false, 6430, -1,
			new int[][] {{14067, 1}, {14060, 1}, {14061, 1}, {14062, 1}, {14066, 1}, {14065, 1}, {14063, 1}, {14064, 1}, {12855, 70}, {989, 2}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1200),

	DEITY_DEMON(28315, 28315, 28315, 28239,"Demons of Deity", "Demons of Deity",
			"@or1@Health:@whi@ 450,000","","",  TeleportType1.BOSSES, new Position(2842, 9387, 0), 10, false, 440, -1,
			new int[][] {{10947, 1}, {15290, 2}, {15289, 2}, {19116, 3}, {15290, 1}, {989, 1}, {6199, 3}, {5022, 3},{5021, 3},{-1, 1},{-1, 1}, {-1, 1}, {-1,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

	MUTATED_HOUND( 28316, 28316, 28316, 28240,"Mutated Hound", "Mutated Hound",
			"@or1@Health:@whi@ 2,500,000","","",  TeleportType1.BOSSES, new Position(3421, 4777, 0), 10, false, 9839, -1,
			new int[][] {{14472, 1}, {10949, 1}, {10947, 2}, {10946, 1}, {15290,2}, {15289, 1}, {19116, 3}, {5022, 3}, {19115, 3}, {19114,3}, {15290, 1}, {989,3}, {6199,3}, {12855, 140}, {5022, 140}, {5021, 3}},1250),

	VALDIS( 28317, 28317, 28317, 28241,"Elite Valdis", "Elite Valdis",
			"@or1@Health:@whi@ 2,500,000","","",  TeleportType1.BOSSES, new Position(2529, 4573, 0), 10, false, 205, -1,
			new int[][] {{18830, 10}, {4373, 1}, {10947, 2}, {20488, 2}, {19115,3}, {19116,5}, {19114, 1}, {1486, 1}, {15289, 1}, {12855,1000}, {15290, 1}, {12855,1000}, {12855,1000}, {12855, 1000}, {989, 3}, {6199, 3}},750),


	COLLOSAL_AVATAR( 28318, 28318, 28318, 28242,"Collosal Avatar", "Collosal Avatar",
			"@or1@Health:@whi@ 2,500,000","","",  TeleportType1.BOSSES, new Position(2375, 4947, 0), 10, false, 4540, -1,
			new int[][] {{9080, 1},{9081, 1}, {9082, 1}, {20099, 1}, {15288, 1}, {15289,2}, {15290, 3}, {20488, 2}, {19115, 3}, {19116, 3}, {19114, 1}, {15289, 1}, {12855,10000}, {12855, 7500}, {12855, 5000}, {989, 3}, {6199, 3}},1350),

	INFERNAL_DEMON( 28319, 28319, 28319, 28243,"Plutonic Demon", "Plutonic Demon",
			"@or1@Health:@whi@ 2,500,000", "","",  TeleportType1.BOSSES, new Position(2728, 4505, 0), 10, false, 12810, -1,
			new int[][] {{22005, 1}, {15288, 1}, {15289, 2}, {15290, 3}, {20488,2}, {19115, 3}, {19116, 5}, {19114, 1}, {15289, 1}, {12855, 1000}, {15290, 1}, {12855,1000}, {12855, 1000}, {12855, 1000}, {989, 3}, {6199, 3}, {5022, 3}},1150),

	FALLEN_ANGEL( 28320, 28320, 28320, 28244,"Fallen Angel", "Fallen Angel",
			"@or1@Health:@whi@ 6,666,666","","",  TeleportType1.BOSSES, new Position(2335, 3998, 0), 10, false, 9012, -1,
			new int[][] {{12855, 1000}, {5022, 500},{19000, 1}, {7956, 15}, {22106, 1}, {15288, 1}, {10946, 1}, {6769, 1}, {-1,-1 }, {-1,-1 }, {-1,-1 }, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1020),

	MIDNIGHT_GOBLIN( 28321, 28321, 28321, 28245,"Midnight Goblin", "Midnight Goblin",
			"@or1@Health:@whi@ 7,500,000","","",  TeleportType1.BOSSES, new Position(2522, 4648, 0), 10, false, 9837, -1,
			new int[][] {{14474, 1},{22112, 1}, {15288, 3}, {15289, 4}, {15290, 10}, {20488,3}, {7956, 100}, {19115, 7}, {19116, 15}, {19114, 3}, {12855, 2500}, {5022, 2500}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1100),

	BLOOD_DEMON(28322, 28322, 28322, 28246, "Blood Demon", "Blood Demon",
			"@or1@Health:@whi@ 10,000,000","","",  TeleportType1.BOSSES,  new Position(3026, 5233, 0), 10, false, 9813, -1,
			new int[][] {{23238, 1}, {23239, 1},{23252, 1}, {15288, 3}, {15289, 4}, {15290, 10}, {20488, 3}, {7956, 100}, {19115,7 }, {19116,15 }, {19114,3 }, {12855,2500 }, {5022,2500 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},820),
	/*
	 * Minigames
	 */

	STARTER_ZONE( 28307, 28307, 28307, 28231, "Starter Progression", "Starter Progression",
			"@or1@Health:@whi@ 1,000","","",  TeleportType1.MINIGAMES, new Position(1, 1, 0), -1, false, 9001, -1,
			new int[][] {{22077, 1}, {19136, 1}, {6936, 1}, {12855,5000}, {7956, 3}, {19116, 2}, {19115, 3}, {10025, 3}, {19114, 3}, {6833,1}, {14018,1}, {989,50}, {15288,1}, {5022, 50000}, {14639, 100}, {8334, 1}, {19892, 1}},600),

	OUTBREAK(28308, 28308, 28308, 28232, "Pyramid Outbreak", "Pyramid Outbreak",
			"@or1@Health: @whi@25,000","","",  TeleportType1.MINIGAMES, new Position(3487, 9235, 0), -1, false, 4476, -1,
			new int[][] {{4151, 1}, {11235, 1}, {15486, 1}, {18353, 1}, {7462, 1}, {15031, 1}, {6585, 1}, {7956,1}, {22077, 1}, {6927, 1}, {6928,1}, {6929,1}, {19136,1}, {6930, 1}, {6931, 1}, {6932, 1}, {6936, 1}},600),

	UNKNOWN(28309, 28309, 28309, 28233, "Unknown Crypt", "Unknown Crypt",
			"@or1@Health@whi@ 100,000","","",  TeleportType1.MINIGAMES, new Position(1773,5132,0), -1, false, 823, -1,
			new int[][] {{19116, 2}, {19115, 2}, {19114, 1}, {15289, 1}, {15288, 1}, {10946, 1}, {6769, 1}, {4446,1}, {19886, 1}, {-1, -1}, {-1,-1}, {-1,-1}, {-1,-1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},1250),

	DUNG(28310, 28310, 28310, 28234, "Legends Raids", "Legends Raids",
			"@or1@Health: @whi@2,500,000","","",  TeleportType1.MINIGAMES,new Position(2222, 4115, 0), -1, false, 585, -1,
			new int[][] {{12855, 5000}, {19886, 1}, {4446, 1}, {1486, 1}, {20489, 1}, {10946, 1}, {15002, 1}, {15288, 5}, {5022, 500_000}, {6769, 1}, {15004,1}, {5012,1}, {12535,1}, {17011, 1}, {4684, 1}, {4685, 1}, {4686, 1}},1450),

	IOA(28311, 28311, 28311, 28235, "Isles of Avalon", "Isles of Avalon",
			"@or1@Health: @whi@1,500,000","","",  TeleportType1.MINIGAMES, new Position(2195, 5037, 0), -1, false, 9024, -1,
			new int[][] {{12855,2_500}, {5022, 1000}, {23165, 1}, {23166, 1}, {23167,1}, {23168, 1}, {23169, 1}, {23170, 1}, {23092, 1}, {23093, 1}, {23094, 1}, {-1, -1}, {-1, 1}, {-1, -1}, {-1, 1}, {-1, 1}, {-1, -1}},1200),
	SOD(28312, 28312, 28312, 28236, "Sanctum of Death", "Sanctum of Death",
			"@or1@Health: @whi@500,000"," ","",  TeleportType1.MINIGAMES, new Position(1739, 5238, 0), -1, false, 9816, -1,
			new int[][] {{12855, 20_000}, {5022, 7000}, {15290, 7}, {10025, 4}, {7956, 3}, {19116,1}, {19115, 1}, {20488, 1}, {23044, 1}, {6769,1}, {23161,1}, {23162,1}, {23163,1}, {23164, 1}, {22110, 1}, {-1, -1}, {-1, -1}},3000),

	TH(28313, 28313, 28313, 28237, "Treasure Hunter", "Treasure Hunter",
			"@or1@Health: @whi@500,000"," ","",  TeleportType1.MINIGAMES, new Position(2015, 5022, 0), -1, false, 9816, -1,
			new int[][] {{12855, 20_000}, {5022, 7000}, {15290, 7}, {10025, 4}, {7956, 3}, {19116,1}, {19115, 1}, {20488, 1}, {23044, 1}, {6769,1}, {23161,1}, {23162,1}, {23163,1}, {23164, 1}, {22110, 1}, {-1, -1}, {-1, -1}},3000),

	/*
	 * Dungeons
	 */

	EASY_DUNGEON(28307, 28307, 28307, 28231, "Dreaded Dungeon", "Betrayed Dungeon",
			"@or1@Health:@whi@ 20,000","","",  TeleportType1.DUNGEONS, new Position(1887, 5221, 0), 10, false, 1727, -1,
			new int[][] {{12855, 1000}, {5022, 75}, {7956, 1}, {22214, 1},{19116, 2}, {23215, 1}, {779, 1}, {-1,-1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},600),

	MEDIUM_DUNGEON(28308, 28308, 28308, 28232, "Violent Tunnels", "Cursed Dungeon",
			"@or1@Health:@whi@ 75,000","","",  TeleportType1.DUNGEONS, new Position(2334, 5222, 0), 10, false, 1741, -1,
			new int[][] {{12855, 2000}, {5022, 75}, {7956, 3}, {22214, 1},{19116, 2}, {23215, 1}, {779, 2}, {-1,-1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},600),

	HARD_DUNGEON(28309, 28309, 28309, 28233, "Deserted Labyrinth", "Cursed Dungeon",
			"@or1@Health:@whi@ 1,000,000","","",  TeleportType1.DUNGEONS, new Position(2081, 5532, 0), 10, false, 6792, -1,
			new int[][] {{12855, 2500}, {5022, 250}, {22214, 5}, {22219, 1},{-1, 1}, {-1, 1}, {-1, 1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},900),

	/*
	 * Global bosses
	 */
	KC_BOSS(28307, 28307, 28307, 28231, "Hellraiser", "Hellraiser",
			"@or1@Health:@whi@ 100,000,000","@or1@To Spawn: @whi@" + HellraiserSystem.getLeft() + " kills left","",
			TeleportType1.GLOBALS, new Position(3109, 5530, 0), 79, false, 187, -1,
			new int[][] {{23229, 1}, {12855, 10_000}, {5022, 1000},{989, 2},{2025, 3},{6769, 1},{10946, 3},{10946, 1},{11314, 1},{13323, 1}, {13324, 1}, {13325, 1}, {13326, 1}, {13327, 1}, {-1, -1}, {-1, -1}, {-1, -1}},1350),

	AFK_BOSS(28308, 28308, 28308, 28232, "Afk boss", "Afk boss",
			"@or1@Health:@whi@ 75,000,000", "@or1@To Spawn:@whi@ " + AfkSystem.getLeft() + " steals left","",
			TeleportType1.GLOBALS, new Position(2013, 4505, 0), 79, false, 3779, -1,
			new int[][] {{23229, 1}, {15290, 1}, {2023, 3},{20481, 1},{989, 1},{19116, 2},{19115, 10},{15288, 1},{10946, 1},{6769, 1}, {10942, 1}, {10947, 1}, {20511, 1}, {14068, 1}, {14069, 1}, {14070, 1}, {14071, 1}},1500),


	VBOSS(28309, 28309, 28309, 28233, "Vote boss", "Vote boss",
			"@or1@Health:@whi@ 1,500,000,000","@or1@To Spawn: @whi@" + (VoteBossDrop.currentSpawn == null ?  doMotivote.getVoteCount() + "/50 please vote!"
			: "Alive ::Vboss"),"", TeleportType1.GLOBALS, new Position(2848, 4577, 0), 79, false, 8013, -1,
			new int[][] {{23229, 2}, {23020, 1}, {15501, 1},{11137, 1},{2026, 25},{10025, 5},{15290, 1},{20488, 1},{15358, 1},{15359, 1}, {11316, 1}, {20489, 1}, {15003, 1}, {15002, 1}, {4446, 1}, {19886, 1}, {10946, 1}},1600),


	NIGHTMARE(28310, 28310, 28310, 28234, "Nightmare", "Nightmare",
			"@or1@Health:@whi@ 300,000,000","@or1@To Spawn: @whi@" + (GlobalBoss2.currentBoss == null
			?  GlobalBoss2.timeLeft() : "@whi@Alive ::nm"),"", TeleportType1.GLOBALS, new Position(2980, 2771, 0), 79, false, 9017, -1,
			new int[][] {{23229, 1}, {12855, 5000}, {5022, 1000},{989, 2},{10942, 1},{6769, 1},{10946, 1},{9084, 1},{10947, 1},{15290, 1}, {15289, 1}, {15288, 1}, {20488, 1}, {19114, 5}, {19115, 10}, {19116, 15}, {18719, 1}},1500),

	NARAKU(28311, 28311, 28311, 28235, "Naraku", "Naraku",
			"@or1@Health:@whi@ 300,000,000","@or1@To Spawn: @whi@" + (GlobalBoss3.currentBoss == null
			?  GlobalBoss3.timeLeft() : "@whi@Alive ::naraku"),"", TeleportType1.GLOBALS, new Position(3420, 9563, 0), 79, false, 3305, -1,
			new int[][] {{23229, 1}, {12855, 5000}, {5022, 1000},{989, 2},{6769, 1},{10946, 1},{17646, 1},{17648, 1},{17650, 1},{17684, 1}, {17676, 1}, {17672, 1}, {17660, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1350),

	DRAGON_KING(28312, 28312, 28312, 28236, "Dragon King", "Dragon King",
			"@or1@Health:@whi@ 300,000,000","@or1@To Spawn: @whi@" + (GlobalBoss4.currentBoss == null
			?  GlobalBoss4.timeLeft() : "@whi@Alive ::dk"),"", TeleportType1.GLOBALS, new Position(2139, 5019, 0), 79, false, 4972, -1,
			new int[][] {{23229, 1}, {12855, 5000}, {5022, 1000},{989, 2},{20488, 10},{19114, 5},{10942, 1},{6769, 1},{10946, 1},{14176, 1}, {14172, 1}, {14174, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1800),

	DONATION_BOSS(28313, 28313, 28313, 28237, "Avalon Guardian", "Avalon Guardian",
			"@or1@Health:@whi@ 3,000,000,000","@or1@To Spawn: @whi@" + (DonationBossSystem.currentSpawn == null
			? DonationBossSystem.getAmntDonated() + "/100 donated"
			: "Alive ::spirit"),"", TeleportType1.GLOBALS, new Position(3491, 2772, 0), 79, false, 3830, -1,
			new int[][] {{23229, 2}, {19114, 2}, {11137, 10},{12855, 10_000},{15289, 1},{15288, 1},{15003, 1},{15002, 1},{10946, 1},{6769, 1}, {10942, 1}, {14999, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1900),

	IRON(28314, 28314, 28314, 28238, "Iron", "Iron",
			"@or1@Health:@whi@ 150,000,000","@or1@To Spawn: @whi@" + (GlobalBoss5.currentBoss == null
			?  GlobalBoss5.timeLeft() : "Alive ::iron"),"", TeleportType1.GLOBALS, new Position(3808, 2842, 0), 79, false, 587, -1,
			new int[][] {{12855, 10_000}, {5022, 10_000}, {19000, 10},{15289, 1},{15289, 1},{15288, 1},{15288, 1},{15288, 1},{22116, 1},{22120, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1500),


	NEPHILIM(28315, 28315, 28315, 28239, "Nephilim Warrior", "Nephilim Warrior",
			"@or1@Health:@whi@ 4,000,000,000","@or1@To Spawn: @whi@" + NephilimSpawnSystem.getLeft() + " tokens left","",
			TeleportType1.GLOBALS, new Position(2013, 4505, 0), 79, false, 9312, -1,
			new int[][] {{23229, 3}, {19114, 3}, {11137, 10},{12855, 20_000},{15288, 1},{10946, 1},{6769, 1},{10942, 1},{15002, 1},{15004, 1}, {14999, 1}, {23253, 1}, {23220, 1}, {23221, 1}, {23222, 1}, {23223, 1}, {23224, 1}},1100),


	/*
	 * Cities
	 */
	NEW_39(28307, 28307, 28307, 28231, "Al Kharid", "Al Kharid","","","",  TeleportType1.CITIES, new Position(3292, 3176, 0), -1, false, 18, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_40(28308, 28308, 28308, 28232, "Ardougne", "Ardougne","","","",  TeleportType1.CITIES, new Position(2662, 3307, 0),  -1, false, 1316, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_41(28309, 28309, 28309, 28233,"Camelot", "Camelot","","","",  TeleportType1.CITIES, new Position(2757, 3477, 0), -1, false, 21, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_42(28310, 28310, 28310, 28234, "Canafis", "Canasfis","","","",  TeleportType1.CITIES, new Position(3496, 3486, 0),  -1, false, 23, 1684, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_43(28311, 28311, 28311, 28235, "Draynor", "Draynor","","","",  TeleportType1.CITIES, new Position(3105, 3251, 0),  -1, false, 3271, 970, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_44(28312, 28312, 28312, 28236, "Edgeville", "Edgeville","","","",  TeleportType1.CITIES, new Position(3094, 3503, 0),  -1, false, 306, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_45(28313, 28313, 28313, 28237,"Falador", "Falador","","","",  TeleportType1.CITIES, new Position(2965, 3379, 0), -1, false, 19, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_46(28314, 28314, 28314, 28238,"Varrock", "Varrock","","","",  TeleportType1.CITIES, new Position(3213, 3424, 0), -1, false, 547, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_47(28315, 28315, 28315, 28239,"Home", "Home","","","",  TeleportType1.CITIES, GameSettings.HOME_CORDS, -1, false, 1617, 8013, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_48(28316, 28316, 28316, 28240,"Karamaja", "Karamaja","","","",  TeleportType1.CITIES, new Position(2918, 3176, 0), -1, false,  520, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_49(28317, 28317, 28317, 28241,"Lumbridge", "Lumbridge","","","",  TeleportType1.CITIES, new Position(3224, 3219, 0), -1, false, 3, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	NEW_50(28318, 28318, 28318, 28242, "Yanille", "Yanille","","","",  TeleportType1.CITIES, new Position(2607, 3093, 0), -1, false, 4247, -1, new int[][] {{-1, -1}, {-1, -1}, {-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1},{-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),

	;
	

	/** The name of the teleport. */
	private final int[][] items;
	public int[][] getItems() {
		return items;
	}

	private final String name;


	
	private final String fullname;

	private final String description;
	
	private final String req1;
	
	private final String req2;
	/** The type of the teleport. */
	private final TeleportType1 type;

	public final int buttonId;

	private int cblvl;

	private boolean wildy;

	private int npcId, spriteId;

	public int getSpriteId() {
		return spriteId;
	}

	public void setSpriteId(int spriteId) {
		this.spriteId = spriteId;
	}

	private int clickingid, textButtonId, backgroundButtonId;
	
	public int getTextButtonId() {
		return textButtonId;
	}

	public int getBackgroundButtonId() {
		return backgroundButtonId;
	}

	private Position position;

	private final int adjustedZoom;
	/** Creates a new <code>Teleport<code>. */ //might have to make it multidimensioanl
	//the format of the enumid
	TeleportData( int buttonId, int clickingid, int textButtonId, int backgroundButtonId, String name,
			String fullname,String description,String req1,String req2, TeleportType1 type, Position position,
			int cblvl, boolean wildy, int npcId, int spriteId, int[][] items,int adjustedZoom) {
		//npcid is 3rd to last parameter
		//this.index = (index);
		this.buttonId = buttonId;
		this.clickingid = clickingid;
		this.textButtonId = textButtonId;
		this.backgroundButtonId = backgroundButtonId;
		this.name = name;
		this.fullname = fullname;
		this.description = description;
		this.req1 = req1;
		this.req2 = req2;
		this.type = type;
		this.cblvl = cblvl;
		this.wildy = wildy;
		this.npcId = npcId;
		this.position = position;
		this.spriteId = spriteId;
		this.items = items;
		this.adjustedZoom = adjustedZoom;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	public int getAdjustedZoom() {
		return adjustedZoom;
	}
	public String getFullName() {
		return fullname;
	}
	public String getDescription() {
		return description;
	}
	public String getReq1() {
		return req1;
	}
	public String getReq2() {
		return req2;
	}

	public TeleportType1 getType() {
		return type;
	}

	public int getCblvl() {
		return cblvl;
	}

	public int getClickingId() {
		return clickingid;
	}

	public boolean getWildy() {
		return wildy;
	}

	public int getButtonId() {
		return buttonId;
	}

	public int getNpcId() {
		return npcId;
	}

}