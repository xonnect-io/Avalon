package com.ruse.world.content.event_chest;

import com.ruse.model.Item;

public enum RewardsEnum {

	TIER_1(TierType.TIER_1,
			
			new Item[] { new Item(962, 1)}, //Rare reward #1
			new Item[] { new Item(962, 1)}, //Rare reward #2
			new Item[] { new Item(962, 1)}, //Rare reward #3
			
			new Item[] { new Item(1050, 1), //Common rewards
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(898, 1),
					new Item(16049, 1),
					new Item(3090, 1),
					new Item(5258, 1),
					new Item(5259, 1),
					new Item(5260, 1),
					new Item(5261, 1),
					new Item(5262, 1),
					new Item(14601, 1),
					new Item(14603, 1),
					new Item(14602, 1) }),
	
	TIER_2(TierType.TIER_2,
			new Item[] { new Item(962, 1)}, //Rare reward #1
			new Item[] { new Item(962, 1)}, //Rare reward #2
			new Item[] { new Item(962, 1)}, //Rare reward #3

			new Item[] { new Item(1050, 1), //Common rewards
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(1050, 1),
					new Item(898, 1),
					new Item(16049, 1),
					new Item(3090, 1),
					new Item(5258, 1),
					new Item(5259, 1),
					new Item(5260, 1),
					new Item(5261, 1),
					new Item(5262, 1),
					new Item(14601, 1),
					new Item(14603, 1),
					new Item(14602, 1)

			}
	);

	private TierType tierType;

	private Item[] firstGoldReward;

	private Item[] secondGoldReward;

	private Item[] thirdGoldReward;

	private Item[] regularRewards;

	RewardsEnum(TierType tierType, Item[] firstGoldReward, Item[] secondGoldReward, Item[] thirdGoldReward,
			Item[] regularRewards) {
		this.tierType = tierType;
		this.firstGoldReward = firstGoldReward;
		this.secondGoldReward = secondGoldReward;
		this.thirdGoldReward = thirdGoldReward;
		this.regularRewards = regularRewards;
	}

	public TierType getTierType() {
		return tierType;
	}

	public Item[] getFirstGoldReward() {
		return firstGoldReward;
	}

	public Item[] getSecondGoldReward() {
		return secondGoldReward;
	}

	public Item[] getThirdGoldReward() {
		return thirdGoldReward;
	}

	public Item[] getRegularRewards() {
		return regularRewards;
	}
}
