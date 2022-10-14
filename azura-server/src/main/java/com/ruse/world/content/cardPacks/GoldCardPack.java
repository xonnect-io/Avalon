package com.ruse.world.content.cardPacks;

import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.casketopening.Box;
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
        if (player.getInventory().getFreeSlots() < 6) {
            player.getPacketSender().sendMessage("You do not have enough free inventory slots to do this.");
            return;
        }
        cardbeingused = itemId;
        player.getPacketSender().sendInterface(23780); // Open the interface.

        player.getPacketSender().sendItemOnInterface(23787, 23278, 1);
    }
    public static List<Box> bronzeRewards = Arrays.asList(
            new Box(15359, 3,5,55,false, "bronze"),
            new Box(15358, 3,5,55,false, "bronze"),
            new Box(19115, 75,200,55,false, "bronze"),
            new Box(19114, 50,100,55,false, "bronze"),
            new Box(23174, 1,3,55,false, "bronze"),
            new Box(15290, 100,300,55,false, "bronze"),
            new Box(15289, 25,75,55,false, "bronze"),
            new Box(23046, 1,1,55,false, "bronze"),
            new Box(20488, 5,15,55, false,"bronze"),
            new Box(3739, 1,1,55, false,"bronze"),
            new Box(3738, 1,1,55, false,"bronze"),
            new Box(3737, 1,1,55, false,"bronze"),
            new Box(8087, 1,1,55, false,"bronze"),
            new Box(8088, 1,1,55, false,"bronze"),
            new Box(8089, 1,1,55, false,"bronze"),
            new Box(11137, 100,200,55, false,"bronze"),
            new Box(19888, 1,1,55, false,"bronze"),
            new Box(18823, 1,1,55, false,"bronze"),
            new Box(23264, 25,50,55, false,"bronze")

    );

    public static List<Box> silverRewards = Arrays.asList(
            new Box(21220, 450,750,55,  false,"silver"),
            new Box(23215, 125,250,55,  false,"silver"),
            new Box(22219, 50,100,55, false,"silver"),
            new Box(21218, 20,30,55,  false,"silver"),
            new Box(22006, 20,30,55,  false,"silver"),
            new Box(20489, 5,10,55,  false,"silver"),
            new Box(10946, 15,30,55,  false,"silver"),
            new Box(6769, 2,5,55, false,"silver"),
            new Box(4278, 500,1000,55, false,"silver"),
            new Box(15359,10,20,55, false,"silver"),
            new Box(15358,10,20,55, false,"silver"),
            new Box(19114,250,500,55, false,"silver"),
            new Box(23174,10,20,55, false,"silver"),
            new Box(15290,1000,1500,55, false,"silver"),
            new Box(15289,160,250,55, false,"silver"),
            new Box(23048,1,1,55, false,"silver"),
            new Box(23049,1,1,55, false,"silver"),
            new Box(20488,50,75,55, false,"silver"),
            new Box(11137,500,1000,55, false,"silver")
    );

    public static List<Box> goldRewards = Arrays.asList(

            new Box(23264,150,250,55, false,"gold"),
            new Box(21220,3500,5000,55, false,"gold"),
            new Box(23215,750,1000,55, false,"gold"),
            new Box(22219,400,500,55, false,"gold"),
            new Box(21218,100,150,55, false,"gold"),
            new Box(22006,125,250,55, false,"gold"),
            new Box(15003,2,4,55, false,"gold"),
            new Box(15002,1,2,55, false,"gold"),
            new Box(23002,1,2,55, false,"gold"),
            new Box(15004,1,1,55, false,"gold"),
            new Box(10934,1,1,55, false,"gold"),
            new Box(18818,1,1,55, false,"gold"),
            new Box(18888,1,1,55, false,"gold"),
            new Box(18881,1,1,55, false,"gold"),
            new Box(18883,1,1,55, false,"gold"),
            new Box(19810,1,1,55, false,"gold"),
            new Box(10942,1,1,55, false,"gold"),
            new Box(9084,1,1,55, false,"gold"),
            new Box(10947,10,25,55, false,"gold"),
            new Box(3737,1,1,55, false,"gold"),
            new Box(3738,1,1,55, false,"gold"),
            new Box(3739,1,1,55, false,"gold")
            );

    public static List<Box> diamondRewards = Arrays.asList(
            new Box(12630,1,1,55, false,"diamond"),
            new Box(9083,1,1,55, false,"diamond"),
            new Box(20591,1,1,55, false,"diamond"),
            new Box(10949,2,3,55, false,"diamond"),
            new Box(3578,1,1,55, false,"diamond"),
            new Box(14999,1,1,55, false,"diamond"),
            new Box(22121,1,1,55, false,"diamond"),
            new Box(23240,1,1,55, false,"diamond"),
            new Box(10943,1,1,55, false,"diamond"),
            new Box(23002,1,2,55, false,"diamond"),
            new Box(5012,1,1,55, false,"diamond"),
            new Box(12535,1,1,55, false,"diamond"),
            new Box(17011,1,1,55, false,"diamond"),
            new Box(4685,1,1,55, false,"diamond"),
            new Box(4686,1,1,55, false,"diamond"),
            new Box(20489,20,25,55, false,"diamond"),
            new Box(10946,50,75,55, false,"diamond"),
            new Box(6769,10,12,55, false,"diamond"),
            new Box(19114,1000,1500,55, false,"diamond"),
            new Box(23174,25,30,55, false,"diamond"),
            new Box(20488,100,200,55, false,"diamond"),
            new Box(23264,500,750,55, false,"diamond"),
            new Box(23215,1500,2000,55, false,"diamond"),
            new Box(15003,3,6,55, false,"diamond"),
            new Box(15002,1,3,55, false,"diamond"),
            new Box(10934,1,3,55, false,"diamond"),
            new Box(22113,1,1,55, false,"diamond"),
            new Box(22114,1,1,55, false,"diamond"),
            new Box(22105,1,1,55, false,"diamond"),
            new Box(3578,1,2,55, false,"diamond"),
            new Box(14999,1,2,55, false,"diamond"),
            new Box(22121,1,2,55, false,"diamond"),
            new Box(23240,1,2,55, false,"diamond"),
            new Box(10935,1,2,55, false,"diamond"),
            new Box(23002,2,4,55, false,"diamond"),
            new Box(15004,1,2,55, false,"diamond"),
            new Box(10946,75,125,55, false,"diamond"),
            new Box(6769,10,20,55, false,"diamond"),
            new Box(19114,1500,3000,55, false,"diamond"),
            new Box(23174,50,75,55, false,"diamond"),
            new Box(15002,2,5,55, false,"diamond")
    );


    public static List<Box> tanzaniteRewards = Arrays.asList(
            new Box(10934,5,7,55,true, "tanzanite"),
            new Box(10943,1,2,55,true, "tanzanite"),
            new Box(23225,1,1,55,true, "tanzanite"),
            new Box(23174,50,100,55,true, "tanzanite"),
            new Box(23239,3,6,55,true, "tanzanite"),
            new Box(22110,1,1,55,true, "tanzanite"),
            new Box(7995,1,1,55,true, "tanzanite"),
            new Box(23253,1,2,55,true, "tanzanite"),
            new Box(10935,2,4,55,true, "tanzanite"),
            new Box(3578,2,4,55, true,"tanzanite"),
            new Box(22121,2,4,55,true, "tanzanite"),
            new Box(23240,2,4,55,true, "tanzanite"),
            new Box(23254,1,1,55, true,"tanzanite"),
            new Box(4442,1,1,55,true, "tanzanite")
    );


    public static int getRarityColor(Box reward){
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
        Box reward;
        List <Box> rewardstype;//default
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
            int amount = reward.getAmount();
            player.getPacketSender().sendSpriteChange(23694+i, getRarityColor(reward));
            player.getPacketSender().sendItemOnInterface(23687+i, reward.getId(), amount);
            player.getInventory().add(reward.getId(),amount);
            if (rewardstype == tanzaniteRewards) {
                World.sendMessage("<img=832> @red@" +player.getUsername() + " <col=ff812f>has just received @red@"
                        + "x" + (amount) + " "
                        + ItemDefinition.forId(reward.getId()).getName() + "<col=ff812f> from a @red@ Celestial's Card Pack!");
            }

        }
    }

    public static Box getRandomItem(List<Box> items) {
        return items.get(new Random().nextInt(items.size()));
    }
}
