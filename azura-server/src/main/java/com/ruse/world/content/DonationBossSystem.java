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
	public static final int totalCount = 500;
	public static int amntDonated = 0;
	
	public static void forceSpawn() {
		String message = "The Donation boss has spawned, Visit ::donoboss to fight him!";
		NPC npc = new NPC(3830, new Position(3491, 2779));
		World.register(npc);
		World.sendMessage(message);
		DiscordMessager.sendDonationBossLog("The Donation boss has spawned, Visit ::donoboss to fight him!");
		GameSettings.broadcastMessage = message;
		GameSettings.broadcastTime = 100;
		amntDonated = 500;
	}

	public static void spawnBoss() {
		if(amntDonated < 500) {
			return;
		}
		String message = "The Donation boss has spawned, Visit ::donoboss to fight him!";
		NPC npc = new NPC(3830, new Position(3491, 2779));
		World.register(npc);
		World.sendMessage(message);
		GameSettings.broadcastMessage = message;
		DiscordMessager.sendDonationBossLog("The Donation boss has spawned, Visit ::donoboss to fight him!");
		GameSettings.broadcastTime = 100;
		amntDonated = 0;
	}

	public static void callBoss() {
		if(amntDonated > 249 && amntDonated < 251) {
		World.sendMessage("<shad=1>@or2@We are 50% to spawning the Donation boss, Thank you for supporting Avalon");
			return;
				}
			}
}
