package com.ruse.world.content;

import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.minigames.impl.DisassembleValue;
import com.ruse.world.entity.impl.player.Player;

public class CharmDisassemble {

	private Player player;

	public CharmDisassemble(Player player) {
		this.player = player;
	}

	static int anim = 11904;
	static int token = 23321;

	public enum CharmData {
		SUFFERING_CHARM(23403, new Item[]{new Item(token, 200)}, 35500, anim);

		CharmData(int id, Item[] rewards, int experience, int animation) {
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
				"Disassemble for 200 Suffered Crystals", "Nevermind", 6338));
		;
	}

}

