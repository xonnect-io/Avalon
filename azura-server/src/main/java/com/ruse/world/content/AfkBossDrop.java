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

public class AfkBossDrop {
	
	public static int[] COMMONLOOT = { 19116,19116,19115};

	public static int[] UNCOMMONLOOT = { 15288,15288,10946};
	
	public static int[] RARELOOT = {10946,10946,14068,14069,14070,14071,14072,14703};
	
	public static int[] SUPERRARELOOT = {20511,10947,10942,6769,6769,6769,10942,6769,10947};
	
	
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
		int chance = Misc.getRandom(1000);
		int common = COMMONLOOT[Misc.getRandom(COMMONLOOT.length - 1)];
		@SuppressWarnings("unused")
		int uncommon = UNCOMMONLOOT[Misc.getRandom(UNCOMMONLOOT.length - 1)];
		int rare = RARELOOT[Misc.getRandom(RARELOOT.length - 1)];
		int superrare = SUPERRARELOOT[Misc.getRandom(SUPERRARELOOT.length - 1)];

		if (chance >= 100 && chance <= 990) {
		player.getInventory().add(common, 1);
		}
		if (common == 19114) {
			player.getInventory().add(common, 5);
			}
			if (chance <= 990) {
			player.getInventory().add(15290, 1);
			player.getInventory().add(5020, 10_000);
			player.getInventory().add(989, 1);
			player.getInventory().add(2023, 3);
			player.getInventory().add(22117, 1);
			player.getInventory().add(20481, 1);
			return;
		}
			if (chance >= 991 && chance <= 998) {
				player.getInventory().add(uncommon, 1);
				player.getInventory().add(15290, 1);
				player.getInventory().add(5020, 10_000);
				player.getInventory().add(989, 1);
				player.getInventory().add(2023, 3);
				player.getInventory().add(22117, 1);
				player.getInventory().add(20481, 1);
				String itemName = (new Item(uncommon).getDefinition().getName());
				String itemMessage = Misc.anOrA(itemName) + " " + itemName;
				World.sendMessage("<img=28>@blu@SubZero Drop:@red@ " + player.getUsername() + " @blu@received @red@" + itemMessage + " @blu@from SubZero!");
			return;
			}	
			if (chance == 999) {
				player.getInventory().add(rare, 1);
				player.getInventory().add(15290, 1);
				player.getInventory().add(5020, 10_000);
				player.getInventory().add(989, 1);
				player.getInventory().add(2023, 3);
				player.getInventory().add(22117, 1);
				player.getInventory().add(20481, 1);
				String itemName = (new Item(rare).getDefinition().getName());
				String itemMessage = Misc.anOrA(itemName) + " " + itemName;
				World.sendMessage("<img=28>@blu@SubZero Drop:@red@ " + player.getUsername() + " @blu@received @red@" + itemMessage + " @blu@from SubZero!");	
			return;
			}
			if (rare == 10946) {
				player.getInventory().add(rare, 3);
				}
			if (chance == 1000) {
				player.getInventory().add(superrare, 1);
				player.getInventory().add(15290, 1);
				player.getInventory().add(5020, 10_000);
				player.getInventory().add(989, 1);
				player.getInventory().add(2023, 3);
				player.getInventory().add(22117, 1);
				player.getInventory().add(20481, 1);
				String itemName = (new Item(superrare).getDefinition().getName());
				String itemMessage = Misc.anOrA(itemName) + " " + itemName;
				World.sendMessage("<img=28>@blu@SubZero Drop:@red@ " + player.getUsername() + " @blu@received @red@" + itemMessage + " @blu@from SubZero!");
				return;
			}
	}
	
	private static void displayPopup(Player player, Item item) {
		for (int i = 8145; i <= 8195; i++) {
			player.getPacketSender().sendString(i, "");
		}
		player.getPacketSender().sendString(8144, "@bla@<img=368>SubZero Reward Log");
		player.getPacketSender().sendString(8146, "@bla@<img=368>SubZero Reward ");
		player.getPacketSender().sendString(8147, "@yel@You have contributed towards killing SubZero");
		player.getPacketSender().sendString(8149, "@dre@You are Awarded Rare 1x " + item.getDefinition().getName());
		player.getPacketSender().sendString(8150, "@bla@You are Awarded uncommon 15000x AFK tickets ");
		player.getPacketSender().sendString(8151, "@bla@You are Awarded uncommon 1x Summoning charm box");
		player.getPacketSender().sendString(8152, "@bla@You are Awarded Common 5x Lazycat Bones");
		player.getPacketSender().sendInterface(8134);
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
