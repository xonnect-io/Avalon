package com.ruse.world.content.dissolving;

import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.minigames.impl.DisassembleValue;
import com.ruse.world.entity.impl.player.Player;

public class OwnerDisassemble {

	private Player player;

	public OwnerDisassemble(Player player) {
		this.player = player;
	}

	static int anim = 11904;
	static int token = 13379;

	public enum DisassembleData {
		OWNER_CAPE(7995, new Item[]{new Item(token, 1)}, 75500, anim),
		OWNER_AURA(22111, new Item[]{new Item(token, 1)}, 75500, anim),
		OWNER_AMULET(23230, new Item[]{new Item(token, 1)}, 75500, anim),
		OWNER_RING(23231, new Item[]{new Item(token, 1)}, 75500, anim),
		OWNER_BRACELET(23232, new Item[]{new Item(token, 1)}, 75500, anim);

		DisassembleData(int id, Item[] rewards, int experience, int animation) {
			this.id = id;
			this.rewards = rewards;
			this.experience = experience;
			this.animation = animation;
		}

		private int id, experience, animation;
		private Item[] rewards;

		public int getId() {
			return id;
		}

		public int getExperience() {
			return experience;
		}

		public int getAnimation() {
			return animation;
		}

		public Item[] getRewards() {
			return rewards;
		}

		public ItemDefinition getDefinition() {
			return ItemDefinition.forId(id);
		}
	}

	public void handleDialogue(int id) {
		DialogueManager.start(player, new DisassembleValue(player,
				"Disassemble for x 1 Owner Fragment", "Nevermind", 6120));
		;
	}

}

