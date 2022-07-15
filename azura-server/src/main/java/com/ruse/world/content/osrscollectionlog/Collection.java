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

    //Monsters
    ARACHNES(Player.SPIDERS_KILLED, LogType.MONSTERS, "Arachnes", new int[] {CollectionLog.ARACHNES}, Player.ARACHNES_LOG_CLAIMED, new Item[] { new Item(19114,3) },
            //Drops
            new Item(22219), new Item(781), new Item(19811), new Item(19473),
            new Item(19472), new Item(17291), new Item(3909), new Item(11235)),
    DEMON_GODDESS(Player.DEMON_GODDESS_KILLED, LogType.MONSTERS, "Demon Goddess", new int[] {CollectionLog.DEMON_GODDESS}, Player.DEMON_GODDESS_LOG_CLAIMED, new Item[] { new Item(19114,3) },
            //Drops
            new Item(22219), new Item(781),new Item(8860), new Item(8861), new Item(8862), new Item(15830),
            new Item(8834), new Item(8835)
            ),
    ENERGY_SKELETONS(Player.ENERGY_SKELETONS_KILLED, LogType.MONSTERS, "Energy Skeleton", new int[] {CollectionLog.ENERGY_SKELETONS}, Player.ENERGY_SKELETONS_LOG_CLAIMED, new Item[] { new Item(19114,5) },
            //Drops
             new Item(22219), new Item(781),new Item(19931), new Item(19933), new Item(19934),
            new Item(19919), new Item(19917), new Item(7927)),
    TUROTH(Player.TUROTH_KILLED, LogType.MONSTERS, "Turoth", new int[] {CollectionLog.TUROTH}, Player.TUROTH_LOG_CLAIMED, new Item[] { new Item(19114,5) },
            //Drops
            new Item(22219), new Item(781), new Item(8817), new Item(8818), new Item(3905),
            new Item(14018)),
    FALLEN_WARRIOR(Player.FALLEN_WARRIOR_KILLED, LogType.MONSTERS, "Fallen Warrior", new int[] {CollectionLog.FALLEN_WARRIOR}, Player.FALLEN_WARRIOR_LOG_CLAIMED, new Item[] { new Item(6769,3) },
            //Drops
            new Item(15288), new Item(15358), new Item(15359), new Item(10946)),
    CAVE_DRONE(Player.CAVE_DRONE_KILLED, LogType.MONSTERS, "Cave Drone", new int[] {CollectionLog.CAVE_DRONE}, Player.CAVE_DRONE_LOG_CLAIMED, new Item[] { new Item(10942,2) },
            //Drops
            new Item(22219), new Item(9688)),
    CAVE_MUTANT(Player.CAVE_MUTANT_KILLED, LogType.MONSTERS, "Cave Mutant", new int[] {CollectionLog.CAVE_MUTANT}, Player.CAVE_MUTANT_LOG_CLAIMED, new Item[] { new Item(10942,2) },
            //Drops
            new Item(22219), new Item(9689)),
    CAVE_SNAIL(Player.CAVE_SNAIL_KILLED, LogType.MONSTERS, "Cave Snail", new int[] {CollectionLog.CAVE_SNAIL}, Player.CAVE_SNAIL_LOG_CLAIMED, new Item[] { new Item(10942,2) },
            //Drops
            new Item(22219), new Item(9687)),



    //Zones
    DUSTCLAW(Player.DUSTCLAWS_KILLED, LogType.ZONES, "Dustclaw", new int[] {CollectionLog.DUSTCLAW}, Player.DUSTCLAW_LOG_CLAIMED, new Item[] { new Item(10025,3) },
         new Item(10025, 1)),
    LORD(Player.LORDS_KILLED, LogType.ZONES, "Inferior Elite Lord", new int[] {CollectionLog.LORD}, Player.LORD_LOG_CLAIMED, new Item[] { new Item(10025,5) },
            new Item(10025, 1)),
    SHADOW(Player.SHADOW_KILLED, LogType.ZONES, "Shadow hunter", new int[] {CollectionLog.SHADOW}, Player.SHADOW_LOG_CLAIMED, new Item[] { new Item(10025,5) },
            new Item(10025, 1)),
    GOLEM(Player.GOLEM_KILLED, LogType.ZONES, "Joyx Golem", new int[] {CollectionLog.GOLEM}, Player.GOLEM_LOG_CLAIMED, new Item[] { new Item(10025,6) },
            new Item(10025, 1),new Item(675, 1),new Item(702, 1),new Item(700, 1),
            new Item(701, 1),new Item(17708, 1),new Item(17602, 1),new Item(19153, 1),
            new Item(19142, 1),new Item(19141, 1)),
    SHETANI(Player.SHETANI_KILLED, LogType.ZONES, "Shetani", new int[] {CollectionLog.SHETANI}, Player.SHETANI_LOG_CLAIMED, new Item[] { new Item(10025,6) },
            new Item(10025, 1),new Item(5095, 1),new Item(19140, 1),
            new Item(19139, 1),new Item(19138, 1)),
    RIPPER(Player.RIPPER_KILLED, LogType.ZONES, "Titanium Ripper", new int[] {CollectionLog.RIPPER}, Player.RIPPER_LOG_CLAIMED, new Item[] { new Item(10025,8) },
            new Item(10025, 1),new Item(15922, 1),new Item(15933, 1),
            new Item(16021, 1)),
    AVATAR(Player.AVATAR_KILLED, LogType.ZONES, "Avatar Titan", new int[] {CollectionLog.AVATAR}, Player.AVATAR_LOG_CLAIMED, new Item[] { new Item(10025,10) },
            new Item(10025, 1),new Item(17600, 1),new Item(19944, 1),
            new Item(703, 1),new Item(704, 1),new Item(705, 1),
            new Item(19946, 1),new Item(19945, 1)),
    WYVERNS(Player.WYVERNS_KILLED, LogType.ZONES, "Legendary Wyvern", new int[] {CollectionLog.WYVERN}, Player.WYVERNS_LOG_CLAIMED, new Item[] { new Item(19114,15) },
            new Item(17712, 1),new Item(17638, 1),new Item(17640, 1),new Item(15593, 1),
            new Item(16140, 1),new Item(2021, 1),new Item(12860, 1),new Item(12565, 1),
            new Item(20173, 1),new Item(8803, 1),new Item(8804, 1),new Item(8805, 1),new Item(8812, 1)),
    ONI(Player.ONI_KILLED, LogType.ZONES, "Oni", new int[] {CollectionLog.ONI}, Player.ONI_LOG_CLAIMED, new Item[] { new Item(19114,25) },
            new Item(15289, 1),new Item(10025, 1),new Item(17714, 1),new Item(17686, 1),new Item(15924, 1),
            new Item(16023, 1),new Item(15935, 1),new Item(15888, 1),new Item(15818, 1),new Item(12994, 1),
            new Item(16272, 1),new Item(8809, 1),new Item(8806, 1),new Item(8807, 1),new Item(8808, 1)),
    SHENRON(Player.SHENRON_KILLED, LogType.ZONES, "Super Shenron", new int[] {CollectionLog.SHENRON}, Player.SHENRON_LOG_CLAIMED, new Item[] { new Item(19114,50) },
            new Item(15289, 1),new Item(10025, 1),new Item(12284, 1),new Item(15005, 1),new Item(15006, 1),
            new Item(15007, 1),new Item(15008, 1),new Item(15100, 1),new Item(15200, 1),new Item(15201, 1),
            new Item(20549, 1), new Item(8800, 1),new Item(8801, 1),new Item(8802, 1)),
    SUBZERO(Player.SUBZERO_KILLED, LogType.ZONES, "SubZero", new int[] {CollectionLog.SUBZERO}, Player.SUBZERO_LOG_CLAIMED, new Item[] { new Item(20488,15) },
            new Item(8803, 1),new Item(8804, 1),new Item(8805, 1),new Item(20173, 1),new Item(15289, 1),
            new Item(10025, 1),new Item(20542, 1),new Item(13300, 1),new Item(13301, 1),new Item(13304, 1),
            new Item(18683, 1),new Item(15511, 1),new Item(13306, 1),new Item(18817, 1),new Item(13302, 1),new Item(13305, 1)),
    ZEUS(Player.ZEUS_KILLED, LogType.ZONES, "Almight Zeus", new int[] {CollectionLog.ZEUS}, Player.ZEUS_LOG_CLAIMED, new Item[] { new Item(20488,25) },
            new Item(8803, 1),new Item(8804, 1),new Item(8805, 1),new Item(20173, 1),new Item(20488, 1),
            new Item(21218, 1), new Item(15289, 1), new Item(10025, 1),new Item(15230, 1),new Item(15231, 1),
            new Item(15232, 1),new Item(15233, 1),new Item(15234, 1),new Item(17662, 1),
            new Item(15235, 1), new Item(15236, 1), new Item(21031, 1),new Item(21032, 1),new Item(21033, 1),
            new Item(21034, 1),new Item(21035, 1)),
    IPOTANE(Player.IPOTANE_KILLED, LogType.ZONES, "Ipotane", new int[] {CollectionLog.IPOTANE}, Player.IPOTANE_LOG_CLAIMED, new Item[] { new Item(20488,25) },
            new Item(8803, 1),new Item(8804, 1),new Item(8805, 1),
            new Item(20173, 1),new Item(15289, 1),new Item(20488, 1),
            new Item(10025, 1),new Item(13640, 1),new Item(15448, 1),
            new Item(21934, 1),new Item(19918, 1),new Item(19913, 1),
            new Item(13964, 1),new Item(3107, 1),new Item(15401, 1)
    ),
    VINDICTA(Player.VINDICTA_KILLED, LogType.ZONES, "Vindicta", new int[] {CollectionLog.VINDICTA}, Player.VINDICTA_LOG_CLAIMED, new Item[] { new Item(20488,50) },
            new Item(23082, 1),new Item(10947, 1),new Item(22084, 1),new Item(8326, 1),
            new Item(8327, 1),new Item(8328, 1),new Item(22083, 1),new Item(8330, 1),new Item(8331, 1),
            new Item(8332, 1),new Item(22092, 1),new Item(8323, 1),new Item(8324, 1),new Item(8325, 1),
            new Item(15289, 1),new Item(20488, 1),new Item(10025, 1)
    ),


    BEAST(Player.BEAST_KILLED, LogType.ZONES, "Skeleton Brute", new int[] {CollectionLog.BRUTE}, Player.BEAST_LOG_CLAIMED, new Item[] { new Item(20488,50) },
            new Item(10025, 1)),

    //Bosses
    HANTO_WARRIORS(Player.HANTO_KILLED, LogType.BOSSES, "Crystal key", new int[] {CollectionLog.CRYSTAL_KEY}, Player.HANTO_LOG_CLAIMED, new Item[] { new Item(19116,10) },
            //Drops
            new Item(14499, 1),
            new Item(14497, 1),
            new Item(14501, 1)),
    //Boxes
    MYSTERY_BOX(Player.MYSTERY_BOXES_OPENED, LogType.BOXES, "Mystery Box", new int[] {CollectionLog.MYSTERY_BOX}, Player.MYSTERY_BOX_LOG_CLAIMED, new Item[] { new Item(19116,10) },
            //Drops
            new Item(12855, 1), new Item(1149, 1), new Item(1249, 1),
            new Item(3204, 1), new Item(1305, 1), new Item(1215, 1),
            new Item(1377, 1), new Item(1434, 1), new Item(7158, 1),
            new Item(989, 1), new Item(536, 1), new Item(6739, 1),
            new Item(11728, 1), new Item(15259, 1), new Item(6570, 1),
            new Item(3320, 1), new Item(3318, 1), new Item(4888, 1),
            new Item(18332, 1), new Item(14377, 1), new Item(18686, 1),
            new Item(18799, 1), new Item(5095, 1), new Item(13996, 1),
            new Item(18834, 1), new Item(19140, 1), new Item(13913, 1),
            new Item(18801, 1), new Item(19139, 1), new Item(13919, 1),
            new Item(18800, 1), new Item(19138, 1), new Item(14915, 1),
            new Item(14919, 1), new Item(14924, 1)

    ),
    //Minigames
    LEGENDS_RAIDS(Player.LEGEND_RAIDS_COMPLETED, LogType.MINIGAMES, "Zombie Raids", new int[] {CollectionLog.ZOMBIE_RAIDS}, Player.LEGEND_RAIDS_LOG_CLAIMED, new Item[] { new Item(19116) },
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
