package com.ruse.world.content.globalBosses;
import com.ruse.model.Position;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;

public class SlayerBossSystem {
	public static int getLeft() {
		return totalCount - slayerTasks;
		}
	public static final int totalCount = 500;
	public static int slayerTasks = 0;
	
	public static void commandSpawnBoss() {
		NPC npc = new NPC(9129, new Position(3488, 4704));
		World.register(npc);
		World.sendMessage("Doom Guardian has Arrived! fight him now at ::doom");
		slayerTasks = 0;
	}
	public static void spawnBoss() {
		if(slayerTasks < 500) {
			return;
		}

		NPC npc = new NPC(9129, new Position(3488, 4704));
		World.register(npc);
		World.sendMessage("Doom Guardian has Arrived! fight him now at ::doom");
		slayerTasks = 0;
	}
	public static void callBoss() {
		if(slayerTasks > 124 && slayerTasks < 126) {
		World.sendMessage("<shad=1>@or2@We are 25% to spawning the Slayer boss, keep slaying!");
		if(slayerTasks > 249 && slayerTasks < 251) {
			World.sendMessage("<img=832> <shad=1>@or2@We are halfway to spawning the Slayer boss, keep slaying!");
			return;
				}
			}
		}
}
