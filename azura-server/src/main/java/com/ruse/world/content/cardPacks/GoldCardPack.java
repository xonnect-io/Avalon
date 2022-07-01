package com.ruse.world.content.cardPacks;

import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GoldCardPack {
    public static final int[] CARD_IDS = {
            /*blue card*/ 23278
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
        player.getPacketSender().sendInterface(23780); // Open the interface.

        player.getPacketSender().sendItemOnInterface(23787, 23278, 1);
    }
    public static List<Item> bronzeRewards = Arrays.asList(
            new Item(15359, 3, "bronze"),
            new Item(15359, 5, "bronze"),
            new Item(15358, 3, "bronze"),
            new Item(15358, 5, "bronze"),
            new Item(19115, 200, "bronze"),
            new Item(19114, 100, "bronze"),
            new Item(19114, 50, "bronze"),
            new Item(23174, 3, "bronze"),
            new Item(15290, 200, "bronze"),
            new Item(15290, 250, "bronze"),
            new Item(15290, 300, "bronze"),
            new Item(15289, 40, "bronze"),
            new Item(15289, 50, "bronze"),
            new Item(15289, 75, "bronze"),
            new Item(23046, 1, "bronze"),
            new Item(20488, 15, "bronze"),
            new Item(20488, 10, "bronze"),
            new Item(3739, 1, "bronze"),
            new Item(3738, 1, "bronze"),
            new Item(3737, 1, "bronze"),
            new Item(8087, 1, "bronze"),
            new Item(8088, 1, "bronze"),
            new Item(8089, 1, "bronze"),
            new Item(11137, 200, "bronze"),
            new Item(19888, 1, "bronze"),
            new Item(18823, 1, "bronze"),
            new Item(23264, 30, "bronze"),
            new Item(23264, 50, "bronze")

    );

    public static List<Item> silverRewards = Arrays.asList(
            new Item(21220, 1000,  "silver"),
            new Item(21220, 750,  "silver"),
            new Item(23215, 250,  "silver"),
            new Item(23215, 200,  "silver"),
            new Item(22219, 75,  "silver"),
            new Item(22219, 100,  "silver"),
            new Item(21218, 30,  "silver"),
            new Item(21218, 25,  "silver"),
            new Item(22006, 25,  "silver"),
            new Item(22006, 50,  "silver"),
            new Item(20489, 10,  "silver"),
            new Item(10946, 30,  "silver"),
            new Item(10946, 20, "silver"),
            new Item(6769, 2, "silver"),
            new Item(6769, 5, "silver"),
            new Item(4278, 750, "silver"),
            new Item(4278, 1000, "silver"),
            new Item(15359,10, "silver"),
            new Item(15359,20, "silver"),
            new Item(15358,10, "silver"),
            new Item(15358,20, "silver"),
            new Item(19114,500, "silver"),
            new Item(19114,250, "silver"),
            new Item(23174,10, "silver"),
            new Item(23174,20, "silver"),
            new Item(15290,1000, "silver"),
            new Item(15290,1250, "silver"),
            new Item(15290,1500, "silver"),
            new Item(15289,160, "silver"),
            new Item(15289,200, "silver"),
            new Item(15289,250, "silver"),
            new Item(23048,1, "silver"),
            new Item(23049,1, "silver"),
            new Item(20488,50, "silver"),
            new Item(20488,75, "silver"),
            new Item(11137,1000, "silver")
    );

    public static List<Item> goldRewards = Arrays.asList(

            new Item(23264,150, "gold"),
            new Item(23264,250, "gold"),
            new Item(21220,5000, "gold"),
            new Item(21220,4000, "gold"),
            new Item(23215,1250, "gold"),
            new Item(23215,1000, "gold"),
            new Item(22219,400, "gold"),
            new Item(22219,500, "gold"),
            new Item(21218,150, "gold"),
            new Item(21218,100, "gold"),
            new Item(22006,125, "gold"),
            new Item(22006,250, "gold"),
            new Item(15003,4, "gold"),
            new Item(15002,2, "gold"),
            new Item(23002,2, "gold"),
            new Item(15004,1, "gold"),
            new Item(10934,1, "gold"),
            new Item(18818,1, "gold"),
            new Item(18888,1, "gold"),
            new Item(18881,1, "gold"),
            new Item(18883,1, "gold"),
            new Item(19810,1, "gold"),
            new Item(10942,1, "gold"),
            new Item(9084,1, "gold"),
            new Item(10947,25, "gold"),
            new Item(3737,1, "gold"),
            new Item(3738,1, "gold"),
            new Item(3739,1, "gold")
    );

    public static List<Item> diamondRewards = Arrays.asList(
            new Item(12630,1, "diamond"),
            new Item(9083,1, "diamond"),
            new Item(20591,1, "diamond"),
            new Item(10949,3, "diamond"),
            new Item(3578,1, "diamond"),
            new Item(14999,1, "diamond"),
            new Item(22121,1, "diamond"),
            new Item(23240,1, "diamond"),
            new Item(10943,1, "diamond"),
            new Item(23002,2, "diamond"),
            new Item(15004,2, "diamond"),
            new Item(5012,1, "diamond"),
            new Item(12535,1, "diamond"),
            new Item(17011,1, "diamond"),
            new Item(4685,1, "diamond"),
            new Item(4686,1, "diamond"),
            new Item(20489,25, "diamond"),
            new Item(10946,75, "diamond"),
            new Item(10946,50, "diamond"),
            new Item(6769,10, "diamond"),
            new Item(6769,12, "diamond"),
            new Item(19114,1500, "diamond"),
            new Item(23174,30, "diamond"),
            new Item(20488,200, "diamond"),
            new Item(23264,750, "diamond"),
            new Item(23215,2000, "diamond"),
            new Item(15003,6, "diamond"),
            new Item(15002,3, "diamond"),
            new Item(10934,3, "diamond"),
            new Item(22113,1, "diamond"),
            new Item(22114,1, "diamond"),
            new Item(22105,1, "diamond"),
            new Item(3578,2, "diamond"),
            new Item(14999,2, "diamond"),
            new Item(22121,2, "diamond"),
            new Item(23240,2, "diamond"),
            new Item(10935,2, "diamond"),
            new Item(23002,4, "diamond"),
            new Item(15004,2, "diamond"),
            new Item(10946,125, "diamond"),
            new Item(6769,20, "diamond"),
            new Item(19114,3000, "diamond"),
            new Item(23174,75, "diamond"),
            new Item(15002,5, "diamond")
    );


    public static List<Item> tanzaniteRewards = Arrays.asList(
            new Item(10934,7, "tanzanite"),
            new Item(10943,2, "tanzanite"),
            new Item(23225,1, "tanzanite"),
            new Item(23174,100, "tanzanite"),
            new Item(23239,6, "tanzanite"),
            new Item(22110,1, "tanzanite"),
            new Item(7995,1, "tanzanite"),
            new Item(23253,2, "tanzanite"),
            new Item(10935,4, "tanzanite"),
            new Item(3578,4, "tanzanite"),
            new Item(22121,4, "tanzanite"),
            new Item(23240,4, "tanzanite"),
            new Item(23254,1, "tanzanite"),
            new Item(23255,1, "tanzanite")
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
        player.getPacketSender().sendItemOnInterface(23787, -1, 1);
        player.getPacketSender().sendInterface(23680); // Open the interface.

        for (int i = 23687; i < 23693; i++)
            player.getPacketSender().sendItemOnInterface(i, -1, 1);


        player.getInventory().delete(cardbeingused, 1);
        Item reward;
        List <Item> rewardstype;//default
        for(int i = 0; i < 6; i++){
            int chance = Misc.random(100);
            if(chance < 3) {//3% chance
                rewardstype = tanzaniteRewards;

            }else if(chance >=3 && chance < 15) {//12% chance
                rewardstype = diamondRewards;

            }else if(chance >=15 && chance <38){//23% chance
                rewardstype = goldRewards;

            }else if(chance >=38 && chance < 70){
                rewardstype = silverRewards;//30% chance

            } else {
                rewardstype = bronzeRewards; //31% chance
            }

            reward = getRandomItem(rewardstype);
            player.getPacketSender().sendSpriteChange(23694+i, getRarityColor(reward));
            player.getPacketSender().sendItemOnInterface(23687+i, reward.getId(), reward.getAmount());
            player.getInventory().add(reward.getId(),reward.getAmount());
            if (rewardstype == tanzaniteRewards) {
                World.sendMessage("<img=832> @red@" +player.getUsername() + " <col=ff812f>has just received @red@"
                        + "x" + (reward.getAmount()) + " "
                        + ItemDefinition.forId(reward.getId()).getName() + "<col=ff812f> from a @red@ Gold Card Pack!");
            }

        }
    }

    public static Item getRandomItem(List<Item> items) {
        return items.get(new Random().nextInt(items.size()));
    }
}
