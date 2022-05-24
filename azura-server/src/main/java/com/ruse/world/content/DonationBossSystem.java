package com.ruse.world.content;
import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;

public class DonationBossSystem {

	public static int getLeft() {
		return totalCount - amntDonated;
		}

	public static final int totalCount = 100;
	public static int amntDonated = 0;
	public static NPC currentSpawn;

	public static void forceSpawn() {

		if (currentSpawn != null){
			System.out.println("Already spawned.");
			return;
		}
		currentSpawn = new NPC(3830, new Position(3491, 2779));

		String message = "The Donation boss has spawned, Visit ::donoboss to fight him!";
		World.register(currentSpawn);
		World.sendMessage(message);
		DiscordMessager.sendDonationBossLog("The Donation boss has spawned, Visit ::donoboss to fight him!");
		GameSettings.broadcastMessage = message;
		GameSettings.broadcastTime = 100;
		amntDonated = 100;
	}

	public static void spawnBoss() {
		if(amntDonated < 100) {
			System.out.println("$100 donation limit has not been reached.");
			return;
		}

		if (currentSpawn != null){
			System.out.println("Already spawned.");
			return;
		}

		String message = "The Avalon Guardian has spawned!";
		NPC npc = new NPC(3830, new Position(3491, 2779));
		World.register(npc);
		World.sendMessage(message);
		GameSettings.broadcastMessage = message;
		DiscordMessager.sendDonationBossLog("The Donation boss has spawned, Visit ::donoboss to fight him!");
		GameSettings.broadcastTime = 100;
		amntDonated = 0;
	}

	public static int getAmntDonated() {
		return amntDonated;
	}

	public static void callBoss() {
		if(amntDonated == 50) {
		World.sendMessage("<shad=1>@or2@We are 50% to spawning the Donation boss, Thank you for supporting Avalon");
			return;
				}
			}
}
