package com.ruse.model.input.impl;

import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.model.input.EnterAmount;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.globalBosses.NephilimSpawnSystem;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
public class SpawnNephilimBoss extends EnterAmount {


	@Override
	public void handleAmount(Player player, int amount) {
		player.getPacketSender().sendInterfaceRemoval();
		int ticketAmount = player.getInventory().getAmount(23257);

		if (ticketAmount > amount) {
			ticketAmount = amount;
		}

		if (amount > NephilimSpawnSystem.getLeft()) {
			ticketAmount = NephilimSpawnSystem.getLeft();
		}

		player.getInventory().delete(23257, ticketAmount);
		NephilimSpawnSystem.sacrificedCount += ticketAmount;

		if (NephilimSpawnSystem.sacrificedCount <= 249) {
			World.sendMessage("@red@<img=856>[Nephilim Warrior]<img=856> @epi@" + player.getUsername() + " has contributed " + ticketAmount + " Nephilim tokens.");
			World.sendMessage("@red@<img=856>[Nephilim Warrior]<img=856> @blu@" + NephilimSpawnSystem.getLeft() + " @epi@more Nephilim tokens left for Nephilim Warrior spawn.");
			//DiscordMessager.sendNephilimBossLog(NephilimSpawnSystem.getLeft() + " more Nephilim tokens left for Nephilim Warrior spawn.");
			return;

		}  if (NephilimSpawnSystem.sacrificedCount == 250) {
			String message = "The Nephilim Warrior has appeared ::Nephilim";
			NPC npc = new NPC(9312, new Position(2145, 3302));
			World.register(npc);
			World.sendMessage("@red@<img=856>[Nephilim Warrior]<img=856> @epi@" + player.getUsername() + " has contributed " + ticketAmount + " Nephilim tokens.");

			DiscordMessager.sendNephilimBossLog("");
			World.sendBroadcastMessage("@bla@The Nephilim Warrior has appeared ::Nephilim");
			GameSettings.broadcastMessage = "The Nephilim Warrior has appeared ::Nephilim";
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
