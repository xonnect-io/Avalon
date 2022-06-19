package com.ruse.world.content.cardPacks;

import com.ruse.model.Item;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DiamondCardPack {
    public static final int[] CARD_IDS = {
            /*blue card*/ 23279
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
    public static final void useCard(Player player, int itemId) {
        if (player.getInventory().getFreeSlots() <= 0) {
            player.getPacketSender().sendMessage("You do not have enough free inventory slots to do this.");
            return;
        }
        cardbeingused = itemId;
        player.getPacketSender().sendInterface(23180); // Open the interface.

        player.getPacketSender().sendItemOnInterface(23187, itemId, 1);
    }
    public static List<Item> silverRewards = Arrays.asList(
            new Item(386, 50,"silver"), // shark
            new Item(892, 50,"silver") // rune arrows
    );
    public static List<Item> diamondRewards = Arrays.asList(
            new Item(8, 1,"diamond"), // cannon stand
            new Item(11118, 1,"diamond"), // Combat Bracelet
            new Item(2570, 1,"diamond"), // ring of life
            new Item(6918, 1,"diamond"), // set 24 Infinity Armor 1
            new Item(6916, 1,"diamond"), // set 25 Infinity Armor 2
            new Item(6924, 1,"diamond"), // set 26 Infinity Armor 3
            new Item(6922, 1,"diamond"), // set 27 Infinity Armor 4
            new Item(6920, 1,"diamond"), // set 28 Infinity Armor 5
            new Item(11712, 1,"diamond"), // set 15 Godsword shard 2
            new Item(7400, 1,"diamond"), // echanted
            new Item(7399, 1,"diamond"), // echanted
            new Item(7398, 1,"diamond"), // enchanted
            new Item(4089, 1,"diamond"), // blue mystic
            new Item(4091, 1,"diamond"), // blu mystic
            new Item(4093, 1,"diamond"), // blu mystic
            new Item(4095, 1,"diamond"), // blu mystic
            new Item(4097, 1,"diamond"), // blu Mystic
            new Item(892, 100,"diamond"), // rune arrows
            new Item(4675, 1,"diamond"), // ancient staff
            new Item(3025, 25,"diamond") // super restore

    );
    public static List<Item> goldRewards = Arrays.asList(

            new Item(18350, 1,"gold"), //
            new Item(18356, 1,"gold"), //
            new Item(18352, 1,"gold"), //
            new Item(18354, 1,"gold"), //

            new Item(23020, 1,"gold"), // Vote Scroll
            new Item(2579, 1,"gold"), // set 41 Ranger Boots
            new Item(2581, 1,"gold"), // set 42 Robin Hood Hat
            new Item(19352, 1,"gold") // dragon sq (or) kit

    );    public static List<Item> tanzaniteRewards = Arrays.asList(
            new Item(6199, 1,"tanzanite"), // Mystery Box
            new Item(6570, 1,"tanzanite"), // Firecape

            new Item(18350, 1,"tanzanite"), //
            new Item(18356, 1,"tanzanite"), //
            new Item(18352, 1,"tanzanite"), //
            new Item(18354, 1,"tanzanite"), //

            new Item(23020, 1,"tanzanite"), // Vote Scroll
            new Item(2579, 1,"tanzanite"), // set 41 Ranger Boots
            new Item(2581, 1,"tanzanite"), // set 42 Robin Hood Hat
            new Item(19352, 1,"tanzanite") // dragon sq (or) kit

    );
    public static List<Item> bronzeRewards = Arrays.asList(

            new Item(2631, 1, "bronze"), // highway mask
            new Item(2643, 1,"bronze"), // black cavalier
            new Item(9470, 1,"bronze"), // gnome scarf
            new Item(10589, 1,"bronze"), // Granite Helm
            new Item(10564, 1,"bronze"), // Granite Body
            new Item(6809, 1,"bronze"), // Granite legs
            new Item(14499, 1,"bronze"), // dagon'hai hat
            new Item(14497, 1,"bronze"), // dagon'hai robe top
            new Item(14501, 1,"bronze"), // dagon'hai robe bottom
            new Item(6, 1,"bronze"), // cannon base
            new Item(12, 1,"bronze"), // cannon furnace
            new Item(10, 1,"bronze"), // cannon barrels

            new Item(11710, 1,"bronze"), // set 14 Godsword shard 1
            new Item(11714, 1,"bronze"), // set 16 Godsword shard 3
            new Item(11732, 1,"bronze"), // set 17 Dragon Boots
            new Item(15332, 1,"bronze"), // set 23 Overload


            new Item(2453, 25,"bronze") // antifire


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
        player.getPacketSender().sendItemOnInterface(23187, -1, 1);
        player.getPacketSender().sendInterface(23080); // Open the interface.

        for (int i = 23087; i < 23093; i++)
            player.getPacketSender().sendItemOnInterface(i, -1, 1);


        player.getInventory().delete(cardbeingused, 1);
        Item reward;
        List <Item> rewardstype;//default
        for(int i = 0; i < 6; i++){
            int chance = Misc.random(100);
            if(chance >=30 && chance < 60){
                rewardstype = silverRewards;//30% chance

            }else if(chance >=10 && chance <30){//20% chance
                rewardstype = goldRewards;

            }else if(chance >=0 && chance < 10){//10% chance
                rewardstype = diamondRewards;

            }else if(chance == 0){//1% chance
                rewardstype = tanzaniteRewards;

            } else {
                rewardstype = bronzeRewards;
            }

            reward = getRandomItem(rewardstype);
            player.getPacketSender().sendSpriteChange(23094+i, getRarityColor(reward));
            player.getPacketSender().sendItemOnInterface(23087+i, reward.getId(), reward.getAmount());
            player.getInventory().add(reward.getId(),reward.getAmount());


        }
    }

    public static Item getRandomItem(List<Item> items) {
        return items.get(new Random().nextInt(items.size()));
    }
}
