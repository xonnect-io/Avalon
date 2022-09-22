package com.ruse.world.content.minigames.impl;

import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.BoxLoot;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;

public class TreasureHunter {

    public static final Position TELEPORT_AREA = new Position(2015, 5022, 0);
    public static final int CHEST_ID = 41207;

    public static int NPC_1 = 9815, NPC_2 = 9816, NPC_3 = 9817, NPC_4 = 9818;
    public static int KEY_1 = 23103;
    public static int KEY_2 = 23104;
    public static int KEY_3 = 23105;
    public static int KEY_4 = 23106;
    public static Item MASTER_KEY = new Item(23107);
    private HashMap<Item, Integer> auraDrops = new HashMap<>();


    public static boolean combineKeys(Player player, Item used, Item usedWith) {

        if (used.getId() >= KEY_1 && used.getId() <= KEY_4 && usedWith.getId() >= KEY_1 && usedWith.getId() <= KEY_4) {
            if (player.getInventory().contains(new Item[]{new Item(KEY_1), new Item(KEY_2), new Item(KEY_3), new Item(KEY_4)})) {
                player.getInventory().deleteItemSet(new Item[]{new Item(KEY_1), new Item(KEY_2), new Item(KEY_3), new Item(KEY_4)});
                if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                        player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAMMUS_PET.npcId ||
                        player.getSummoning() != null && player.getSummoning().getFamiliar() != null && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DEMON_PET.npcId ||
                        player.getSummoning() != null && player.getSummoning().getFamiliar() != null && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.GOLEM_PET.npcId ||
                        player.getSummoning() != null && player.getSummoning().getFamiliar() != null && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DRAGON_PET.npcId) {
                            if (Misc.getRandom(100) <= 95) {
                                player.getInventory().add(MASTER_KEY);
                                player.sendMessage("You've successfully created the Master Key.");
                                System.out.println("Hitting here with pet");
                    }
                }
                else if (Misc.getRandom(100) <= 75){
                    player.getInventory().add(MASTER_KEY);
                    player.sendMessage("You've successfully created the Master Key.");
                    System.out.println("Hitting here with no pet");
                }else{
                    player.sendMessage("You've failed the Master Key creation.");
                }
                return true;
            }
        }
        return false;
    }

    public static void useKeyOnChest(Player player, Item item) {
        if (item.getId() == MASTER_KEY.getId() && player.getInventory().contains(MASTER_KEY.getId())) {
            player.getInventory().delete(MASTER_KEY);
            player.getAchievementTracker().progress(AchievementData.TREASURE_HUNTER, 1);
            handleRewards(player);
        }
    }

    public static void handleRewards(Player player) {
        Box box = BoxLoot.getLoot(loot, player);
        player.getInventory().add(box.getId(), box.getAmount());
        player.getPointsHandler().incrementTreasureHunterKC(1);
        DailyTask.TREASURE_HUNTER.tryProgress(player);
    }


    public static Box[] loot = { //
            new Box(12855, 10000, 20000, 50D),
            new Box(5022, 1500, 7000, 50D),
            new Box(15290, 1, 7, 15D),
            new Box(10025, 1, 4, 15D),
            new Box(7956, 1, 3, 20),
            new Box(19116, 1, 1, 10),
            new Box(19115, 1, 1, 5),
            new Box(19114, 1, 1, 1),
            new Box(20488, 1, 1, 5),
            new Box(23044, 1, 1, 15),
            new Box(6769, 1, 0.5D, true),
            new Box(23161, 1, 0.5D, true),
            new Box(23162, 1, 0.5D, true),
            new Box(23163, 1, 0.5D, true),
            new Box(23164, 1, 0.5D, true),
            new Box(22110, 1, 0.01D, true),
    };

    public static Box[] petloot = { //
            new Box(12855, 10000, 20000, 50D),
            new Box(5022, 1500, 7000, 50D),
            new Box(15290, 1, 7, 30D),
            new Box(10025, 1, 4, 30D),
            new Box(7956, 1, 3, 40),
            new Box(19116, 1, 1, 20),
            new Box(19115, 1, 1, 10),
            new Box(20488, 1, 1, 10),
            new Box(23044, 1, 1, 30),
            new Box(6769, 1, 2D, true),
            new Box(23161, 1, 2D, true),
            new Box(23162, 1, 2D, true),
            new Box(23163, 1, 2D, true),
            new Box(23164, 1, 2D, true),
            new Box(22110, 1, 0.02D, true),
    };

}
