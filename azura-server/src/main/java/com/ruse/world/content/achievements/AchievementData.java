package com.ruse.world.content.achievements;

import com.ruse.model.Item;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//  63; keep track of the latest string used (update if you add new achievements)

public enum AchievementData {
	//Easy
	SUPPORT_AVALON(0, AchievementType.EASY, 1, "SUPPORT AVALON","Vote for Avalon",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000),new VotingPointReward(1)
    ),
    //Medium
	SUPPORTER(1, AchievementType.MEDIUM, 10, "Supporter","Vote for Avalon 10 times",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000),new VotingPointReward(1)
    ),
	//Hard
	MEGA_SUPPORTER(2, AchievementType.HARD, 50, "Mega Supporter", "Vote for Avalon 50 times",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000),new VotingPointReward(1)
    ),

    //Expert
    VETERAN_VOTER(3, AchievementType.EXPERT, 500, "Veteran Voter", "Vote for Avalon 250 times",
        new Item[] {new Item(19114, 1)},
        new LoyaltyPointReward(2000),new VotingPointReward(1)
),


	
    ;

    public static final AchievementData[] values = AchievementData.values();
    public static final AchievementData[][] arraysByType = new AchievementData[AchievementType.values().length][];

    public static void checkDuplicateIds() {
        Set<Integer> ids = new HashSet<>();
        for (AchievementData achievement : values) {
            if (ids.contains(achievement.id)) {
                System.err.println("AchievementData sharing the same id!!! Shutting Down. Each achievement must have a unique id.");
                for (AchievementData data : values) {
                    if (data.id == achievement.id) {
                        System.out.println(data.name() + " id: " + data.id);
                    }
                }
                System.exit(0);
            }
            ids.add(achievement.id);
        }
    }

    final int id;
    final AchievementType type;
    final String title;
	String desc;
    final int progressAmount;
    final Item[] itemRewards;
    final NonItemReward[] nonItemRewards;

    AchievementData(int id, AchievementType type, int progressAmount, String title,String desc, Item[] itemRewards, NonItemReward... nonItemRewards) {
        this.id = id;
        this.type = type;
        this.progressAmount = progressAmount;
        this.title = title;
		this.desc = desc;
        this.itemRewards = itemRewards;
        this.nonItemRewards = nonItemRewards;
    }

    @Override
    public String toString() {
        return WordUtils.capitalize(this.name().toLowerCase().replaceAll("_", " "));
    }

    public static AchievementData[] getAchievementsOfType(AchievementType type){
        int index = type.ordinal();
        if (arraysByType[index] != null) {
            return arraysByType[index];
        }
        arraysByType[index] = Arrays.stream(AchievementData.values).filter(a -> a.type.equals(type)).toArray(AchievementData[]::new);
        return arraysByType[index];
    }

}
