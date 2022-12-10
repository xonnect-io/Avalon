package com.ruse.world.content.afk;

import com.ruse.world.World;

public class AfkSystem {

	private static final int TOTAL_COUNT = 80000;
	public static int thievedCount = 0;

	public static int getLeft() {
		return TOTAL_COUNT - thievedCount;
	}

	public static void executeSpawn() {
		thievedCount += TOTAL_COUNT;
		World.sendMessage(String.format("@blu@<img=832>Terrorstep@red@ has awoken! teleport to ::afkboss to fight him"));
	}
}
