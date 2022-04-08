package com.ruse.world.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.combat.CombatBuilder.CombatDamageCache;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class GogetaBossDrop {
	
	public static int[] COMMONLOOT = { 19114,19114,20488,15289};

	public static int[] UNCOMMONLOOT = { 10946};
	
	public static int[] RARELOOT = {12608,10946,10946,10946,13323,13324,13325,13326,13327};
	
	public static int[] SUPERRARELOOT = {11314,6769,6769,6769};

	
	public static void handleDrop(NPC npc) {
		if (npc.getCombatBuilder().getDamageMap().size() == 0) {
			return;
		}

		Map<Player, Integer> killers = new HashMap<>();

		for (Entry<Player, CombatDamageCache> entry : npc.getCombatBuilder().getDamageMap().entrySet()) {

			if (entry == null) {
				continue;
			}

			long timeout = entry.getValue().getStopwatch().elapsed();

			if (timeout > CombatFactory.DAMAGE_CACHE_TIMEOUT) {
				continue;
			}

			Player player = entry.getKey();

			if (player.getConstitution() <= 0 || !player.isRegistered()) {
				continue;
			}

			killers.put(player, entry.getValue().getDamage());

		}

		npc.getCombatBuilder().getDamageMap().clear();

		List<Entry<Player, Integer>> result = sortEntries(killers);
		int count = 0;

		for (Entry<Player, Integer> entry : result) {

			Player killer = entry.getKey();
			int damage = entry.getValue();

			if (++count < 50) {
				handleDrop(npc, killer, damage);
			}

		}

	}

	public static void giveLoot(Player player, NPC npc, Position pos) {
		int chance = Misc.getRandom(100);
		int common = COMMONLOOT[Misc.getRandom(COMMONLOOT.length - 1)];
		@SuppressWarnings("unused")
		int uncommon = UNCOMMONLOOT[Misc.getRandom(UNCOMMONLOOT.length - 1)];
		int rare = RARELOOT[Misc.getRandom(RARELOOT.length - 1)];
		int superrare = SUPERRARELOOT[Misc.getRandom(SUPERRARELOOT.length - 1)];

			if (chance >= 50 && chance <= 94) {
				player.getInventory().add(common, 1);
			}
			if (common == 19114) {
				player.getInventory().add(common, 5);
			}
			if (chance <= 95) {
				player.getInventory().add(10506, 10_000);
				player.getInventory().add(5022, 1_000);
				player.getInventory().add(989, 2);
				player.getInventory().add(2025, 3);
				player.getInventory().add(22117, 1);
				return;
			}
			if (chance >= 96 && chance <= 98) {
				player.getInventory().add(uncommon, 1);
				player.getInventory().add(10506, 10_000);
				player.getInventory().add(5022, 1_000);
				player.getInventory().add(989, 2);
				player.getInventory().add(2025, 3);
				player.getInventory().add(22117, 1);
				String itemName = (new Item(uncommon).getDefinition().getName());
				String itemMessage = Misc.anOrA(itemName) + " " + itemName;
				World.sendMessage("<img=28>@blu@Goku Drop:@red@ " + player.getUsername() + " @blu@received @red@" + itemMessage + " @blu@from Goku!");
				return;
			}	
			if (chance == 99) {
				player.getInventory().add(rare, 1);
				player.getInventory().add(10506, 10_000);
				player.getInventory().add(5022, 1_000);
				player.getInventory().add(989, 2);
				player.getInventory().add(2025, 3);
				player.getInventory().add(22117, 1);
				String itemName = (new Item(rare).getDefinition().getName());
				String itemMessage = Misc.anOrA(itemName) + " " + itemName;
				World.sendMessage("<img=28>@blu@Goku Drop:@red@ " + player.getUsername() + " @blu@received @red@" + itemMessage + " @blu@from Goku!");
				return;
			}
			if (rare == 10946) {
				player.getInventory().add(rare, 3);
				}
			if (chance == 100) {
				player.getInventory().add(superrare, 1);
				player.getInventory().add(10506, 10_000);
				player.getInventory().add(5022, 1_000);
				player.getInventory().add(989, 2);
				player.getInventory().add(2025, 3);
				player.getInventory().add(22117, 1);
				String itemName = (new Item(superrare).getDefinition().getName());
				String itemMessage = Misc.anOrA(itemName) + " " + itemName;
				World.sendMessage("<img=28>@blu@Goku Drop:@red@ " + player.getUsername() + " @blu@received @red@" + itemMessage + " @blu@from Goku!");
				return;
			}
	}


	/**
	 * 
	 * @param npc
	 * @param player
	 * @param damage
	 */
	private static void handleDrop(NPC npc, Player player, int damage) {
		Position pos = npc.getPosition();
		giveLoot(player, npc, pos);
	}

	/**
	 * 
	 * @param map
	 * @return
	 */
	static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortEntries(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {

			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}

		});

		return sortedEntries;

	}

	
}
