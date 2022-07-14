package com.ruse.world.content.osrscollectionlog;


import com.ruse.model.Item;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *     Collection(int attributeKey, LogType logType, String name, int[] key, Boolean rewardClaimed, Item[] reward, Item... obtainables) {
 *
 *
 */
public enum Collection {


    BARROWS(Player.BARROWS_CHESTS_OPENED, LogType.BOSSES, "Barrows", new int[] {CollectionLog.BARROWS_KEY}, Player.BARROWS_KEY_LOG_CLAIMED, new Item[] { new Item(19114,3) },
            //Drops
            new Item(4708), new Item(4710), new Item(4712), new Item(4714),
            new Item(4716), new Item(4718), new Item(4720), new Item(4722),
            new Item(4724), new Item(4726), new Item(4728), new Item(4730),
            new Item(4732), new Item(4734), new Item(4736), new Item(4738),
            new Item(4724), new Item(4726), new Item(4728), new Item(4730),
            new Item(4745), new Item(4747), new Item(4749), new Item(4751),
            new Item(4753), new Item(4755), new Item(4757), new Item(4759)),

    CALLISTO(Player.CALLISTOS_KILLED, LogType.BOSSES, "Callisto", new int[] {CollectionLog.CALLISTO}, Player.CALLISTO_LOG_CLAIMED, new Item[] { new Item(19115,3) },
            //Drops
            new Item(4155), new Item(4153)),

    CHAOS_ELEMENTAL(Player.CHAOS_ELEMENTALS_KILLED, LogType.BOSSES, "Chaos Elemental", new int[]{CollectionLog.CHAOS_ELE}, Player.CHAOS_ELEMENTAL_LOG_CLAIMED, new Item[] { new Item(19116) },
            //Drops
            new Item(11995), new Item(7158), new Item(15261)),


    // mystery boxes
    DONATOR_MYSTERY_BOX(Player.DONATOR_MYSTERY_BOXES_OPENED, LogType.MYSTERY_BOX, "Mystery box", new int[] {CollectionLog.MYSTERY_BOX}, Player.DONATOR_MYSTERY_BOX_LOG_CLAIMED, new Item[] { new Item(19116,5) },
         new Item(1037, 1),
    new Item(1038, 1),
    new Item(1040, 1),
   new Item(1042, 1),
    new Item(1044, 1),
 new Item(1046, 1),
   new Item(1048, 1),
    new Item(1050, 1),
   new Item(1053, 1),
   new Item(1055, 1),
   new Item(1057, 1)),




    // keys
    CRYSTAL_KEY(Player.CRYSTAL_KEYS_OPENED, LogType.KEYS, "Crystal key", new int[] {CollectionLog.CRYSTAL_KEY}, Player.CRYSTAL_KEY_LOG_CLAIMED, new Item[] { new Item(19116,10) },
            //Drops
            new Item(14499, 1), // dagon'hai hat
            new Item(14497, 1), // dagon'hai robe top
            new Item(14501, 1)), // dagon'hai robe bottom

//other
    ZOMBIE_RAIDS(Player.RAIDS_COMPLETED, LogType.OTHER, "Zombie Raids", new int[] {CollectionLog.ZOMBIE_RAIDS}, Player.RAIDS_LOG_CLAIMED, new Item[] { new Item(19116) },
            //Drops
            new Item(12855),
        new Item(15289),
        new Item(19115)
    )
    ;

    private int attributeKey;
    private final LogType logType;
    private final String name;
    private final int[] key;
    private final Boolean rewardClaimed;
    private final Item[] reward;
    private final Item[] obtainables;

    Collection(int attributeKey, LogType logType, String name, int[] key, Boolean rewardClaimed, Item[] reward, Item... obtainables) {
        this.attributeKey = attributeKey;
        this.logType = logType;
        this.name = name;
        this.key = key;
        this.rewardClaimed = rewardClaimed;
        this.reward = reward;
        this.obtainables = obtainables;
    }

    public int getAttributeKey() {
        return attributeKey;
    }
public void increaseKills(){
        this.attributeKey++;
}
    public String getName() {
        return name;
    }

    public int[] getKey() {
        return key;
    }

    public Boolean getRewardClaimedKey() {
        return rewardClaimed;
    }
    public void setRewardClaimedKey(Boolean rewardClaimed) {
         rewardClaimed = rewardClaimed;
    }
    public Item[] getReward() {
        return reward;
    }

    public Item[] getObtainables() {
        return obtainables;
    }

    public LogType getLogType() {
        return logType;
    }

    /**
     * The amount of items we can obtain.
     */
    public int totalCollectables() {
        return obtainables.length;
    }

    /**
     * Gets all the data for a specific type.
     * @param logType the log type that is being sorted at alphabetical order
     */
    public static List<Collection> getAsList(LogType logType) {
        return Arrays.stream(values()).filter(type -> type.getLogType() == logType).sorted(Comparator.comparing(Enum::name)).collect(Collectors.toList());
    }
}
