package com.ruse.world.content;

import com.ruse.model.GameMode;
import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.RandomUtility;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

public class MysteryBoxOpener {

	private Player player;

	public MysteryBoxOpener(Player player) {
		this.player = player;
	}

	private int openBox = -1;

	public int getOpenBox() {
		return openBox;
	}

	private int[] common, uncommon, rare;

	public void display(int boxId, String name, int[] common, int[] uncommon, int[] rare) {
		player.getPacketSender().sendInterface(48030);
		openBox = boxId;
		this.common = common;
		this.uncommon = uncommon;
		this.rare = rare;
		updateInterface(boxId, name, common, uncommon, rare);
	}

	private void updateInterface(int boxId, String name, int[] common, int[] uncommon, int[] rare) {

		for(int i = 0; i < 3; i++) {
			player.getPacketSender().resetItemsOnInterface(48051 + i * 10,150);
		}
		player.getPacketSender().sendString(48035, name);
		player.getPacketSender().sendItemOnInterface(48045, boxId, 0, 1);

		for (int i = 0; i < common.length; i++) {
			player.getPacketSender().sendItemOnInterface(48051, common[i], i, 1);
		}

		for (int i = 0; i < uncommon.length; i++) {
			player.getPacketSender().sendItemOnInterface(48061, uncommon[i], i, 1);
		}

		for (int i = 0; i < rare.length; i++) {
			player.getPacketSender().sendItemOnInterface(48071, rare[i], i, 1);
		}

	}

	public void open(int boxId) {
		int reward = -1;
		int chance = RandomUtility.inclusiveRandom(0, 100);
		String name = ItemDefinition.forId(boxId).getName();

		if (chance > 95) {
			reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];
			if ( reward == 10942 || reward == 6769 || reward == 10935 || reward == 10934 || reward == 10943) { // OH LOL oh lol
				reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];
				World.sendMessage("@blu@<img=832>News: @red@"+ player.getUsername() + " @blu@has received @red@" + ItemDefinition.forId(reward).getName() + " @blu@from a @red@ " + ItemDefinition.forId(boxId).getName()+ "" );
			}
		} else if (chance > 65) {
			reward = uncommon[RandomUtility.exclusiveRandom(0, uncommon.length)];
		}
		else if (chance >= 0) {
			reward = common[RandomUtility.exclusiveRandom(0, common.length)];
		}

		player.getInventory().delete(boxId, 1);
		player.getInventory().add(reward, 1);
	}

	public void openAll(int boxId) {
		if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
			player.getPacketSender().sendMessage("You can not do this as an Ultimate Ironman.");
			return;
		}
		int amount = player.getInventory().getAmount(boxId);
		Map<Integer, Integer> rewards = new HashMap<>();
		for (int i = 0; i < amount; i++) {
			int reward = -1;
			int chance = RandomUtility.inclusiveRandom(0, 100);
			String name = ItemDefinition.forId(boxId).getName();
			if (chance > 95) {
				reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];

				if ( reward == 10942 || reward == 6769 || reward == 10935 || reward == 10934 || reward == 10943) {
					reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];
					World.sendMessage("@blu@<img=832>News: @red@"+ player.getUsername() +" @blu@has received @red@" + ItemDefinition.forId(reward).getName() + " @blu@from a @red@ " + ItemDefinition.forId(boxId).getName()+ "" );
				}

			} else if (chance > 65) { //65% of 100% = 35% (remainder)
				reward = uncommon[RandomUtility.exclusiveRandom(0, uncommon.length)];
			} else if (chance >= 0) { //0% of 100% = 55% (remainder)
				reward = common[RandomUtility.exclusiveRandom(0, common.length)]; // ye its correct.
			}

			rewards.merge(reward, 1, Integer::sum);

		}
		player.getInventory().delete(boxId, amount);
		boolean bank = amount <= player.getInventory().getFreeSlots();
		rewards.forEach((key, value) -> {
			if (bank) {
				player.getInventory().add(new Item(key, value), false);
			} else {
				Item item = new Item(key, value);
				player.depositItemBank(item, false);
			}
		});
		player.getInventory().refreshItems();

		if(!bank) {
			player.sendMessage("@blu@Your rewards have been added to your bank.");
		}

	}

}
