package com.ruse.world.content.boxes;


import com.ruse.model.definitions.ItemDefinition;
import com.ruse.world.content.casketopening.Box;

public class ZombieRaidLoot {

	public static Box[] LOOT = {

			new Box(ItemDefinition.UPGRADE_TOKEN_ID, 500, 2500,100), // Upgrade tokens
			new Box(18404, 1, 1,50), // Raid box
			new Box(18404, 2, 2,25), // Raid box x 2
	};

}
