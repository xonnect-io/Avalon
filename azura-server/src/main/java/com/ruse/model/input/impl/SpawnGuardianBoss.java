package com.ruse.model.input.impl;

import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.model.input.EnterAmount;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.GuardianSpawnSystem;
import com.ruse.world.content.GuardianSpawnSystem;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class SpawnGuardianBoss extends EnterAmount {


	@Override
	public void handleAmount(Player player, int amount) {
		player.getPacketSender().sendInterfaceRemoval();
		int highTierTickets = player.getInventory().getAmount(23174);

		if (highTierTickets > amount) {
			highTierTickets = amount;
		}
		if (highTierTickets == 0) {
			player.getPacketSender().sendMessage("You don't have any High-tier tickets in your Inventory!");
		}

		if (amount > GuardianSpawnSystem.getLeft()) {
			highTierTickets = GuardianSpawnSystem.getLeft();
		}

		player.getInventory().delete(23174, highTierTickets);
		GuardianSpawnSystem.highTierCount += highTierTickets;

		if (GuardianSpawnSystem.highTierCount <= 99) {
			World.sendMessage("<col=4141ff><img=856>[Avalon Guardian]<img=856> @or2@" + player.getUsername() + " has contributed " + highTierTickets + " High-Tier Tickets.");
			World.sendMessage("<col=4141ff><img=856>[Avalon Guardian]<img=856> @blu@" + GuardianSpawnSystem.getLeft() + " @or2@more High-Tier Tickets left for Avalon Guardian spawn.");
			//DiscordMessager.sendNephilimBossLog(GuardianSpawnSystem.getLeft() + " more High-Tier Tickets left for Avalon Guardian spawn.");
			return;

		}  if (GuardianSpawnSystem.highTierCount == 100) {
			String message = "The Avalon Guardian has appeared ::Guardian";
			NPC npc = new NPC(3830, new Position(3445, 4113, 1)); //NPC npc = new NPC(3830, new Position(3491, 2782));
			World.register(npc);
			World.sendMessage("<col=4141ff><img=856>[Avalon Guardian]<img=856> @or2@" + player.getUsername() + " has contributed " + highTierTickets + " High-Tier Tickets.");
			DiscordMessager.sendDonationBossLog("");
			World.sendBroadcastMessage("@bla@The Avalon Guardian has appeared ::Guardian");
			GameSettings.broadcastMessage = "The Avalon Guardian has appeared ::guardian";
			GameSettings.broadcastTime = 100;
			for (Player players : World.getPlayers()) {
				if (players == null) {
					continue;
				}
				players.getPacketSender().sendBroadCastMessage(message, 100);
			}
		}
	}
}
