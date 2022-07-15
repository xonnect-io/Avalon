package com.ruse.world.content.osrscollectionlog;



import com.ruse.model.Item;
import com.ruse.util.Color;
import com.ruse.world.entity.impl.player.Player;
import lombok.var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import static com.ruse.world.content.osrscollectionlog.CollectionLogUtility.*;


/**
 * @author PVE
 * @Since juli 15, 2020
 */
public class CollectionLog {
    //MONSTERS
    public static final int ARACHNES = 117;
    public static final int DEMON_GODDESS = 501;
    public static final int ENERGY_SKELETONS = 503;
    public static final int TUROTH = 1627;
    public static final int FALLEN_WARRIOR = 9011;
    public static final int CAVE_DRONE = 6799;
    public static final int CAVE_MUTANT = 6798;
    public static final int CAVE_SNAIL = 6792;

    //ZONES
    public static final int DUSTCLAW = 1614;
    public static final int LORD = 603;
    public static final int SHADOW = 12843;
    public static final int GOLEM = 53;
    public static final int SHETANI = 8018;
    public static final int RIPPER = 13635;
    public static final int AVATAR = 8008;
    public static final int WYVERN = 3308;
    public static final int ONI = 3117;
    public static final int SHENRON = 201;
    public static final int SUBZERO = 202;
    public static final int ZEUS = 203;
    public static final int IPOTANE = 8010;
    public static final int VINDICTA = 9807;

    public static final int BRUTE = 6329;

    public static final int BARROWS_KEY = 120_000;
    public static final int ZOMBIE_RAIDS = 99999;
    public static final int MYSTERY_BOX = 6199;
    public static final int CRYSTAL_KEY = 989;

    private final Player player;

    public CollectionLog(Player player) {
        this.player = player;
    }

    public HashMap<Collection, ArrayList<Item>> collectionLog = new HashMap<>();
    public HashMap<Collection, Integer> collectionLogofkills = new HashMap<>();
    public HashMap<Collection, Boolean> collectionLogofrewards = new HashMap<>();


    public int totalObtained(Collection collection) {
        int obtained = 0;
        Item[] items = collection.getObtainables();
        ArrayList<Item> obtainedItems = collectionLog.get(collection);
        for (Item item : items) {
            if (obtainedItems != null) {
                int amount = obtainedItems.stream().filter(i -> i.getId() == item.getId()).findAny().orElse(new Item(0, 0)).getAmount();
                if (amount > 0)
                    obtained++;
            }
        }
        return obtained;
    }
    public int totalkillsforthatnpc(Collection collection) {

      var kills = collectionLogofkills.get(collection);
      if(kills == null)
        return 1;
        return kills;
    }
    public boolean collectedrewardsforthatnpc(Collection collection) {

        var rewards = collectionLogofrewards.getOrDefault(collection, false);
        if(rewards == null)
            return false;
        return rewards;
    }
    public int sumTotalObtained() {
        int globalTotal = 0;
        List<Collection> log = Collection.getAsList(LogType.BOSSES);
        int total = log.size();
        Collection col;
        for (int i = 0; i < total; i++){
            col = log.get(i);
            globalTotal+= col.totalCollectables();
        }
        log = Collection.getAsList(LogType.MONSTERS);
        total = log.size();
        for (int i = 0; i < total; i++){
            col = log.get(i);
            globalTotal+= col.totalCollectables();
        }
       log = Collection.getAsList(LogType.ZONES);
        total = log.size();
        for (int i = 0; i < total; i++){
            col = log.get(i);
            globalTotal+= col.totalCollectables();
        }
        log = Collection.getAsList(LogType.MINIGAMES);
        total = log.size();
        for (int i = 0; i < total; i++){
            col = log.get(i);
            globalTotal+= col.totalCollectables();
        }
        log = Collection.getAsList(LogType.BOXES);
        total = log.size();
        for (int i = 0; i < total; i++){
            col = log.get(i);
            globalTotal+= col.totalCollectables();
        }
        return globalTotal;
    }
    public int totalAmountToCollect() {
        int globalTotal = 0;
        List<Collection> log = Collection.getAsList(LogType.BOSSES);
        int total = log.size();
        for (int i = 0; i < total; i++){

            globalTotal+= totalObtained(log.get(i));
        }
        log = Collection.getAsList(LogType.MONSTERS);
        total = log.size();
        for (int i = 0; i < total; i++){
            globalTotal+= totalObtained(log.get(i));
        }
       log = Collection.getAsList(LogType.ZONES);
        total = log.size();
        for (int i = 0; i < total; i++){
            globalTotal+= totalObtained(log.get(i));
        }
        log = Collection.getAsList(LogType.MINIGAMES);
        total = log.size();
        for (int i = 0; i < total; i++){

            globalTotal+= totalObtained(log.get(i));
        }
        log = Collection.getAsList(LogType.BOXES);
        total = log.size();
        for (int i = 0; i < total; i++){

            globalTotal+= totalObtained(log.get(i));
        }
        return globalTotal;
    }
    public void claimReward(Collection collection) {

        Collection logToCheck = player.getLogtoCheck();

        if (collection == logToCheck) {
            final int totalCollectables = collection.totalCollectables();
            if (totalCollectables == totalObtained(logToCheck)) {
                boolean alreadyClaimed = player.getCollectionLog2().collectedrewardsforthatnpc(logToCheck);
                if (alreadyClaimed) {
                    player.sendMessage("You have already claimed this collection log reward.");
                    return;
                }
                player.getInventory().addItems(logToCheck.getReward(),true);
                player.getCollectionLog2().collectionLogofrewards.put(logToCheck, true);
                player.sendMessage(Color.PURPLE.wrap("You have collected the reward for completing " + Color.BLUE.wrap(logToCheck.getName()) + " " + Color.PURPLE.wrap("collection log.")));
            } else {
                player.sendMessage(Color.RED.wrap("This collection log is not yet complete."));
            }
        }
    }

    public void sendInterface(Collection collection) {

        for (int i = 0 ; i < 60 ; i++) {
            player.getPacketSender().sendItemOnInterface(ITEM_CONTAINER,  -1,i, -1);
        }

        for (int i = 0 ; i < 4 ; i++) {
            player.getPacketSender().sendItemOnInterface1(REWARD_ITEM_CONTAINER, -1,i, -1);
        }

        int obtained = 0;
        final int obtainables = collection.totalCollectables();
        var kills = collectionLogofkills.get(collection);
        Item[] items = collection.getObtainables();
        var obtainedItems = collectionLog.get(collection);
        int slot = 0;

        for (Item item : items) {
            item.setAmount(0);
            if (obtainedItems != null) {
                int amount = obtainedItems.stream().filter(i -> i.getId() == item.getId()).findAny().orElse(new Item(0, 0)).getAmount();
                if (amount > 0)
                    obtained++;
                item.setAmount(amount);
            }

        }
        for (Item item : items) {
            player.getPacketSender().sendItemOnInterface(ITEM_CONTAINER,  item.getId(),slot++, item.getAmount());

        }

        player.getPacketSender().setScrollBar(54150, (int) (Collection.getAsList(collection.getLogType()).size() * 15.1));
        player.getPacketSender().setScrollBar(SCROLL_BAR, items.length * 7 + 2);


        player.getPacketSender().sendString(NAME_STRING, "@lre@" + collection.getName());
        player.getPacketSender().sendString(OBTAINED_STRING, "@lre@Obtained: " + getColor(obtained, obtainables) + obtained + "/" + obtainables);
        String plural = collection.getLogType() == LogType.BOXES ? "Opened: " : "Kills: ";
       player.getPacketSender().sendString(KILLS_STRING, "@lre@ " + " " + "" + plural + "@whi@" + (kills == null ? "0" : kills));

        int pos = 0;
        for (Item item : collection.getReward()){
            player.getPacketSender().sendItemOnInterface1(REWARD_ITEM_CONTAINER, item.getId(), pos++, item.getAmount());

        }
       player.setLogtoCheck(collection);
    }
    public void registerkill(int npcid) {
        Arrays.stream(Collection.values()).filter(e -> Arrays.stream(e.getKey()).anyMatch(n -> n == npcid)).findFirst().ifPresent(c -> {
            int beforekills = player.getCollectionLog2().totalkillsforthatnpc(c);
            player.getCollectionLog2().collectionLogofkills.put(c, beforekills++);
        });
    }
    public void open(LogType logType) {
        final List<Collection> log = Collection.getAsList(logType);
        final int total = log.size();
        for (int index = 0; index < 60; index++) {
            player.getPacketSender().sendString(NAMES_STARTING_LINE + index, "");
        }
        for (int index = 0; index < total; index++) {
            player.getPacketSender().sendString((NAMES_STARTING_LINE) + index, log.get(index).getName());
        }
        player.setLogtoCheck(log.get(0));
        sendInterface(log.get(0));
        player.getPacketSender().sendString(61002, "Collection Log - "+totalAmountToCollect() +"/"+ sumTotalObtained()+"");

        player.setCollectionLogOpen(logType);
        player.getPA().sendInterface(61000);
    }

    private String getColor(int obtained, int max) {
        return obtained == 0 ? "@red@" : obtained >= max ? "@gre@" : "@yel@";
    }

    private static final HashMap<Collection, Item> unlockableItems = new HashMap<>();

    public HashMap<Collection, Item> getUnlockableItems() {
        return unlockableItems;
    }

    static {
        for (Collection collection : Collection.values()) {
            for (Item item : collection.getObtainables()) {
                unlockableItems.put(collection, item);
            }
        }
    }


}
