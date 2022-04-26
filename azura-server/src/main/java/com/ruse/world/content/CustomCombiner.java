package com.ruse.world.content;

import com.ruse.model.Item;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

public class CustomCombiner {

    private Player player;

    public CustomCombiner(Player player) {
        this.player = player;
    }

    enum CustomCombinerData {
    	//ROW 1
    	ELITE_MELEE_WEAPON(new Item(8087,-1), new Item(8410, 1), new Item(12855, 3000000), new Item(8087, 1),new Item(4151, 1), new Item(18686, 1),new Item(22077, 1), new Item(20549, 1), new Item(22084, 1), new Item(18750, 1)),
        ELITE_MELEE_HELM(new Item(11320,-1), new Item(8828, 1), new Item(12855, 2000000), new Item(11320, 1),new Item(8810, 1), new Item(11140, 1),new Item(5022, 40000), new Item(6927, 1)),
        ELITE_MELEE_BODY(new Item(11321,-1), new Item(8829, 1), new Item(12855, 2000000), new Item(11321, 1), new Item(19749, 1), new Item(8335, 1),new Item(5022, 40000), new Item(6928, 1)),
        ELITE_MELEE_LEGS(new Item(11322,-1), new Item(8833, 1), new Item(12855, 2000000), new Item(11322, 1), new Item(22080, 1), new Item(19114, 2),new Item(5022, 40000), new Item(6929, 1)),
        EXCECUTION_HELMET(new Item(8828,-1), new Item(4684, 1), new Item(12855, 3000000), new Item(8828, 1), new Item(15642, 1),new Item(15645, 1), new Item(10947, 1)),
        SUPREME_GLOVES(new Item(5071,-1),new Item(18883, 1),new Item(5071, 1),new Item(14063, 1), new Item(10947, 1), new Item(12855, 4_000_000), new Item(5022, 1_000_000)),
        //ROW 2
        ELITE_RANGED_WEAPON(new Item(8088,-1), new Item(8411, 1), new Item(12855, 3000000), new Item(8088, 1),  new Item(11235, 1), new Item(18799, 1),new Item(19136, 1), new Item(20173, 1), new Item(22083, 1), new Item(18636, 1)),
        ELITE_RANGED_HELM(new Item(11340,-1), new Item(15642, 1), new Item(12855, 2000000), new Item(11340, 1), new Item(8811, 1), new Item(8334, 1),new Item(5022, 40000), new Item(6930, 1)),
        ELITE_RANGED_BODY(new Item(11341,-1), new Item(15643, 1), new Item(12855, 2000000), new Item(11341, 1), new Item(11195, 1), new Item(16137, 1),new Item(5022, 40000), new Item(6931, 1)),
        ELITE_RANGED_LEGS(new Item(11342,-1), new Item(15644, 1), new Item(12855, 2000000), new Item(11342, 1), new Item(19115, 2), new Item(19114, 2),new Item(5022, 40000), new Item(6932, 1)),
        EXCECUTION_BODY(new Item(8829,-1), new Item(4685, 1), new Item(12855, 3000000), new Item(8829, 1), new Item(15643, 1),new Item(15646, 1), new Item(10947, 1)),
        SUPREME_BOOTS(new Item(18881,-1),new Item(18881, 1), new Item(3107, 1), new Item(5072, 1), new Item(21960, 1), new Item(10947, 1), new Item(12855, 4_000_000)),
        //ROW 3
    	ELITE_MAGE_WEAPON(new Item(8089,-1), new Item(8412, 1), new Item(12855, 3000000), new Item(8089, 1), new Item(15486, 1), new Item(5095, 1),new Item(6936, 1), new Item(8809, 1), new Item(22092, 1), new Item(18629, 1)),
        ELITE_MAGE_HELM(new Item(11421,-1), new Item(15645, 1), new Item(12855, 2000000), new Item(11421, 1),  new Item(8812, 1), new Item(4367, 1),new Item(5022, 40000), new Item(6933, 1)),
        ELITE_MAGE_BODY(new Item(11422,-1), new Item(15646, 1), new Item(12855, 2000000), new Item(11422, 1),  new Item(19115, 2), new Item(19892, 1),new Item(5022, 40000), new Item(6934, 1)),
        ELITE_MAGE_LEGS(new Item(11423,-1), new Item(15647, 1), new Item(12855, 2000000), new Item(11423, 1),  new Item(15401, 1), new Item(8329, 1),new Item(5022, 40000), new Item(6935, 1)),
        EXCECUTION_LEGS(new Item(8833,-1), new Item(4686, 1), new Item(12855, 3000000), new Item(8833, 1), new Item(15644, 1),new Item(15647, 1), new Item(10947, 1)),
        SUPREME_SHIELD(new Item(15832,-1),new Item(19810, 1), new Item(15832, 1), new Item(17702, 1), new Item(7544, 1), new Item(10947, 1), new Item(12855, 5_000_000), new Item(5022, 1_000_000)),
        //ROW 4
        EXECUTION_TBOW(new Item(8411,-1),new Item(5012, 1), new Item(8411, 3), new Item(8088, 3), new Item(10947, 3), new Item(12855, 7_500_000)),
        EXECUTION_VITUR(new Item(8410,-1),new Item(12535, 1), new Item(8410, 3), new Item(8087, 3), new Item(10947, 3), new Item(12855, 7_500_000)),
        STAFF_OF_EXECUTION(new Item(8412,-1),new Item(17011, 1), new Item(8412, 3), new Item(8089, 3), new Item(10947, 3), new Item(12855, 7_500_000)),
        LIGHT_EXECUTION_TBOW(new Item(5012,-1),new Item(5011, 1),new Item(5012, 1), new Item(10949, 3)), 
        LIGHT_EXECUTION_VITUR(new Item(12535,-1),new Item(12537, 1),new Item(12535, 1), new Item(10949, 3)), 
        LIGHT_STAFF_OF_EXECUTION(new Item(17011,-1),new Item(17013, 1),new Item(17011, 1), new Item(10949, 3)),
        DARK_EXECUTION_TBOW(new Item(5011,-1),new Item(22113, 1),new Item(5011, 1), new Item(22112, 5), new Item(5022, 10_000_000), new Item(12855, 20_000_000)),
        DARK_EXECUTION_VITUR(new Item(12535,-1),new Item(22115, 1),new Item(12535, 1), new Item(22112, 5), new Item(5022, 10_000_000), new Item(12855, 20_000_000)),
        DARK_STAFF_OF_EXECUTION(new Item(17013,-1),new Item(22114, 1),new Item(17013, 1), new Item(22112, 5), new Item(5022, 10_000_000), new Item(12855, 20_000_000)),

        BLOOD_BOW(new Item(22113,-1),new Item(23226, 1),new Item(22113, 1),new Item(5011, 1), new Item(22133, 100), new Item(5022, 10_000_000), new Item(12855, 35_000_000)),
        BLOOD_VITUR(new Item(22115,-1),new Item(8136, 1),new Item(22115, 1),new Item(12537, 1), new Item(22133, 100), new Item(5022, 10_000_000), new Item(12855, 35_000_000)),
        BLOOD_STAFF(new Item(22114,-1),new Item(23227, 1),new Item(22114, 1),new Item(17013, 1), new Item(22133, 100), new Item(5022, 10_000_000), new Item(12855, 35_000_000)),

        
        LUCIFER_HEAD(new Item(4684,-1),new Item(22100, 1),new Item(4684, 1), new Item(22106, 2)),
        LUCIFER_PLATEBODY(new Item(4685,-1),new Item(22101, 1),new Item(4685, 1), new Item(22106, 2)),
        LUCIFER_PLATELEGS(new Item(4686,-1),new Item(22102, 1),new Item(4686, 1), new Item(22106, 2)),
        LUCIFER_WINGS(new Item(20400,-1),new Item(22105, 1),new Item(20400, 1), new Item(22106, 2)),
        LUCIFER_GLOVES(new Item(18885,-1),new Item(22104, 1),new Item(18885, 1), new Item(22106, 2)),
        LUCIFER_BOOTS(new Item(18887,-1),new Item(22103, 1),new Item(18887, 1), new Item(22106, 2)),
        OWNER_CAPE(new Item(22105,-1),new Item(7995, 1),new Item(22307, 1), new Item(12855, 100_000_000)),
        UPGRADED_OWNER_CAPE(new Item(11000,-1),new Item(22109, 1),new Item(11000, 1), new Item(7995, 1)),
        OWNER_AURA(new Item(11000,-1),new Item(22111, 1),new Item(11000, 1), new Item(12630, 1)),
        LIGHT_ATTACHMENT(new Item(14472,-1),new Item(10949, 1),new Item(14472, 1), new Item(10947, 5), new Item(12855, 500_000)),
        DARK_ATTACHMENT(new Item(14474,-1),new Item(22112, 1),new Item(14474, 1), new Item(10947, 5), new Item(12855, 500_000)),
        RAGE_POTION(new Item(17540,-1),new Item(23225, 1),new Item(17540, 1),new Item(12855, 50_000_000));
    	//ROW 5

        //ROW 6

       // MEGA3(new Item(18881, 1),new Item(18887, 1), new Item(9080, 1), new Item(9081, 1), new Item(9082, 1));
        CustomCombinerData(Item upgradedItem, Item reward, Item... requirements) { // Upgrade item, chance, requirements
            this.upgradedItem = upgradedItem;
            this.reward = reward;
            this.requirements = requirements;
        }

        private Item upgradedItem, reward;
        private Item[] requirements;

    }

    private Item selectedItem = null;

    private final CustomCombinerData[] VALUES = CustomCombinerData.values();

    public void open() {
        player.getPacketSender().sendInterface(30330);
        updateInterface();
    }

    private void updateInterface() {
        int index = 0;
        for (CustomCombinerData data : VALUES) {
            player.getPacketSender().sendItemOnInterface(30351, data.reward.getId(), index, data.reward.getAmount());
            index++;
        }
    }

    public void handleSelection(Item item) {
        selectedItem = item;

        for(CustomCombinerData data : VALUES) {
            if(data.reward.getId() == selectedItem.getId()) {
                player.getPacketSender().resetItemsOnInterface(30340, 17);
                player.getPacketSender().sendCombinerItemsOnInterface(30340, data.requirements);
                player.getPacketSender().sendItemOnInterface(30336, data.reward.getId(), 0, data.reward.getAmount());
                break;
            }
        }

    }

    public void combine() {

        if (selectedItem == null) {
            player.sendMessage("@red@You haven't selected an item yet.");
            return;
        }

        for (CustomCombinerData data : VALUES) {
            if (data.reward.getId() == selectedItem.getId()) {
                if (player.getInventory().containsAll(data.requirements) && player.getInventory().containsAll(data.upgradedItem)) {
                    player.getInventory().delete(data.upgradedItem);	
                    player.getInventory().deleteItemSet(data.requirements);
                    player.getInventory().add(data.reward);
                    World.sendMessage("<img=5>@blu@[Max Invention]<img=5> @red@" + player.getUsername() + "@blu@ Has invented " + selectedItem.getDefinition().getName());
                } else {
                    player.sendMessage("@red@You don't have the required items for this invention.");
                }
                break;
            }
        }

    }


}
