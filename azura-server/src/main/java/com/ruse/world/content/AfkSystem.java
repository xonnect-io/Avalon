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
		World.sendMessage("@blu@<img=368>SubZero<img=368>@red@ has awoken! teleport to ::SubZero to fight him");
		thievedCount = 0;
	}

	public static void commandSpawnBoss() {
		AfkSystem.thievedCount += 80000;
		World.sendMessage("@blu@<img=368>SubZero<img=368>@red@ has awoken! teleport to ::SubZero to fight him");
		thievedCount = 0;
	}
}
