package com.ruse.world.content;

import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;

public class AfkSystem {
	public static int getLeft() {
		return totalCount - thievedCount;
		}
	public static String getAfkStealsLeft() {
		return Misc.insertCommasToNumber(String.valueOf(totalCount - thievedCount));
	}
	public static final int totalCount = 80000;
	public static int thievedCount = 0;
		

	public static void spawnBoss() {
		if(thievedCount < 80000) {
			return;
		}
		DiscordMessager.sendAFKBossLog("Tribal goblin has awoken! Hop online and teleport to ::afkboss to fight him");
		World.sendMessage("@blu@Tribal goblin@red@ has awoken! teleport to ::afkboss to fight him");
		thievedCount = 0;
	}

	public static void executeSpawn() {
		AfkSystem.thievedCount += 80000;
		DiscordMessager.sendAFKBossLog("Tribal goblin has awoken! Hop online and teleport to ::afkboss to fight him");
		World.sendMessage("@blu@Tribal goblin@red@ has awoken! teleport to ::afkboss to fight him");
	}
}
