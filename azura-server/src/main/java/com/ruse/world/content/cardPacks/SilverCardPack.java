package com.ruse.world.content.cardPacks;

import com.ruse.model.Item;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SilverCardPack {
    public static final int[] CARD_IDS = {
            /*blue card*/ 23277
    };
    public static boolean isCard(final int itemId) {
        for (int nest : CARD_IDS) {
            if (nest == itemId) {
                return true;
            }
        }
        return false;
    }
    public static int cardbeingused = -1;
    public static final void openCard(Player player, int itemId) {
        if (player.getInventory().getFreeSlots() <= 0) {
            player.getPacketSender().sendMessage("You do not have enough free inventory slots to do this.");
            return;
        }
        cardbeingused = itemId;
        player.getPacketSender().sendInterface(23580); // Open the interface.

        player.getPacketSender().sendItemOnInterface(23587, 23277, 1);
    }
    public static List<Item> bronzeRewards = Arrays.asList(
            new Item(4446, 1, "bronze"),
            new Item(19886, 1, "bronze"),
            new Item(1486, 1, "bronze"),
            new Item(20489, 1, "bronze"),
            new Item(20489, 2, "bronze"),
            new Item(10946, 10, "bronze"),
            new Item(10946, 7, "bronze"),
            new Item(10946, 5, "bronze"),
            new Item(15288, 20, "bronze"),
            new Item(15288, 15, "bronze"),
            new Item(15288, 10, "bronze"),
            new Item(5022, 1_000_000, "bronze"),
            new Item(5022, 750_000,"bronze"),
            new Item(6769, 1,"bronze"),
            new Item(10942, 1, "bronze"),
            new Item(4278, 200, "bronze"),
            new Item(4278, 250, "bronze"),
            new Item(4278, 300, "bronze")

    );

    public static List<Item> silverRewards = Arrays.asList(
            new Item(15359, 3, "silver"),
            new Item(15359, 5, "silver"),
            new Item(15358, 3, "silver"),
            new Item(15358, 5, "silver"),
            new Item(19115, 200, "silver"),
            new Item(19114, 100, "silver"),
            new Item(19114, 50, "silver"),
            new Item(23174, 3, "silver"),
            new Item(15290, 200, "silver"),
            new Item(15290, 250, "silver"),
            new Item(15290, 300, "silver"),
            new Item(15289, 40, "silver"),
            new Item(15289, 50, "silver"),
            new Item(15289, 75, "silver"),
            new Item(23046, 1, "silver"),
            new Item(20488, 15, "silver"),
            new Item(20488, 10, "silver"),
            new Item(3739, 1, "silver"),
            new Item(3738, 1, "silver"),
            new Item(3737, 1, "silver"),
            new Item(8087, 1, "silver"),
            new Item(8088, 1, "silver"),
            new Item(8089, 1, "silver"),
            new Item(11137, 200, "silver"),
            new Item(19888, 1, "silver"),
            new Item(18823, 1, "silver"),
            new Item(23264, 30, "silver"),
            new Item(23264, 50, "silver")
    );

    public static List<Item> goldRewards = Arrays.asList(
            new Item(21220, 1000,  "gold"),
            new Item(21220, 750,  "gold"),
            new Item(23215, 250,  "gold"),
            new Item(23215, 200,  "gold"),
            new Item(22219, 75,  "gold"),
            new Item(22219, 100,  "gold"),
            new Item(21218, 30,  "gold"),
            new Item(21218, 25,  "gold"),
            new Item(22006, 25,  "gold"),
            new Item(22006, 50,  "gold"),
            new Item(20489, 10,  "gold"),
            new Item(10946, 30,  "gold"),
            new Item(10946, 20, "gold"),
            new Item(6769, 2, "gold"),
            new Item(6769, 5, "gold"),
            new Item(4278, 750, "gold"),
            new Item(4278, 1000, "gold"),
            new Item(15359,10, "gold"),
            new Item(15359,20, "gold"),
            new Item(15358,10, "gold"),
            new Item(15358,20, "gold"),
            new Item(19114,500, "gold"),
            new Item(19114,250, "gold"),
            new Item(23174,10, "gold"),
            new Item(23174,20, "gold"),
            new Item(15290,1000, "gold"),
            new Item(15290,1250, "gold"),
            new Item(15290,1500, "gold"),
            new Item(15289,160, "gold"),
            new Item(15289,200, "gold"),
            new Item(15289,250, "gold"),
            new Item(23048,1, "gold"),
            new Item(23049,1, "gold"),
            new Item(20488,50, "gold"),
            new Item(20488,75, "gold"),
            new Item(11137,1000, "gold")
    );

    public static List<Item> diamondRewards = Arrays.asList(

            new Item(23264,150, "diamond"),
            new Item(23264,250, "diamond"),
            new Item(21220,5000, "diamond"),
            new Item(21220,4000, "diamond"),
            new Item(23215,1250, "diamond"),
            new Item(23215,1000, "diamond"),
            new Item(22219,400, "diamond"),
            new Item(22219,500, "diamond"),
            new Item(21218,150, "diamond"),
            new Item(21218,100, "diamond"),
            new Item(22006,125, "diamond"),
            new Item(22006,250, "diamond"),
            new Item(15003,4, "diamond"),
            new Item(15002,2, "diamond"),
            new Item(23002,2, "diamond"),
            new Item(15004,1, "diamond"),
            new Item(10934,1, "diamond"),
            new Item(18818,1, "diamond"),
            new Item(18888,1, "diamond"),
            new Item(18881,1, "diamond"),
            new Item(18883,1, "diamond"),
            new Item(19810,1, "diamond"),
            new Item(10942,1, "diamond"),
            new Item(9084,1, "diamond"),
            new Item(10947,25, "diamond"),
            new Item(3737,1, "diamond"),
            new Item(3738,1, "diamond"),
            new Item(3739,1, "diamond")
    );


    public static List<Item> tanzaniteRewards = Arrays.asList(
            new Item(12630,1, "tanzanite"),
            new Item(9083,1, "tanzanite"),
            new Item(20591,1, "tanzanite"),
            new Item(10949,3, "tanzanite"),
            new Item(3578,1, "tanzanite"),
            new Item(14999,1, "tanzanite"),
            new Item(22121,1, "tanzanite"),
            new Item(23240,1, "tanzanite"),
            new Item(10943,1, "tanzanite"),
            new Item(23002,2, "tanzanite"),
            new Item(15004,2, "tanzanite"),
            new Item(5012,1, "tanzanite"),
            new Item(12535,1, "tanzanite"),
            new Item(17011,1, "tanzanite"),
            new Item(4684,1, "tanzanite"),
            new Item(4685,1, "tanzanite"),
            new Item(4686,1, "tanzanite"),
            new Item(20489,25, "tanzanite"),
            new Item(10946,75, "tanzanite"),
            new Item(10946,50, "tanzanite"),
            new Item(6769,10, "tanzanite"),
            new Item(6769,12, "tanzanite"),
            new Item(19114,1500, "tanzanite"),
            new Item(23174,30, "tanzanite"),
            new Item(20488,200, "tanzanite"),
            new Item(23264,750, "tanzanite"),
            new Item(23215,2000, "tanzanite"),
            new Item(15003,6, "tanzanite"),
            new Item(15002,3, "tanzanite"),
            new Item(10934,3, "tanzanite"),
            new Item(22113,1, "tanzanite"),
            new Item(22114,1, "tanzanite"),
            new Item(22115,1, "tanzanite"),
            new Item(22105,1, "tanzanite"),
            new Item(23253,1, "tanzanite"),
            new Item(3578,2, "tanzanite"),
            new Item(14999,2, "tanzanite"),
            new Item(22121,2, "tanzanite"),
            new Item(23240,2, "tanzanite"),
            new Item(10935,2, "tanzanite"),
            new Item(23002,4, "tanzanite"),
            new Item(15004,2, "tanzanite"),
            new Item(10946,125, "tanzanite"),
            new Item(6769,20, "tanzanite"),
            new Item(19114,3000, "tanzanite"),
            new Item(23174,75, "tanzanite"),
            new Item(15002,5, "tanzanite")
    );

    public static int getRarityColor( Item reward){
        int spriteId = 1673;//blank
        switch(reward.getRarityofItem()){
            case "bronze":
                spriteId = 1674;
                break;
            case "silver":
                spriteId = 1675;
                break;
            case "gold":
                spriteId = 1676;
                break;
            case "diamond":
                spriteId = 1677;
                break;
            case "tanzanite":
                spriteId = 1678;
                break;

        }

        return spriteId;
    }
    public static void testcard(Player player){
        if(!player.getInventory().contains(cardbeingused)){
            player.sendMessage("You have no more cards left.");
            return;
        }
        player.getPacketSender().sendItemOnInterface(23587, -1, 1);
        player.getPacketSender().sendInterface(23480); // Open the interface.

        for (int i = 23487; i < 23493; i++)
            player.getPacketSender().sendItemOnInterface(i, -1, 1);


        player.getInventory().delete(cardbeingused, 1);
        Item reward;
        List <Item> rewardstype;//default
        for(int i = 0; i < 6; i++){
            int chance = Misc.random(100);
            if(chance >=35 && chance < 70){
                rewardstype = silverRewards;//30% chance

            }else if(chance >=18 && chance <35){//20% chance
                rewardstype = goldRewards;

            }else if(chance >=3 && chance < 18){//10% chance
                rewardstype = diamondRewards;

            }else if(chance < 3){//1% chance
                rewardstype = tanzaniteRewards;

            } else {
                rewardstype = bronzeRewards;
            }

            reward = getRandomItem(rewardstype);
            player.getPacketSender().sendSpriteChange(23494+i, getRarityColor(reward));
            player.getPacketSender().sendItemOnInterface(23487+i, reward.getId(), reward.getAmount());
            player.getInventory().add(reward.getId(),reward.getAmount());


        }
    }

    public static Item getRandomItem(List<Item> items) {
        return items.get(new Random().nextInt(items.size()));
    }
}
