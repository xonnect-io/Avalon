package com.ruse.world.entity.impl;

import com.ruse.model.GroundItem;
import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

public class GlobalItemSpawner {

    public static Position ROCKCAKE_POSITION = new Position(3667, 2994, 0);
    public static Position STARTER_SPADE = new Position(2336, 4120, 0);
    public static Position STARTER_SPADE2 = new Position(2336, 4120, 4);
    private static long timer = System.currentTimeMillis();

    public static void startup() {
        if (System.currentTimeMillis() - timer > 1000 * 60) {
            World.sendGlobalGroundItems();
        }
    }

    public static void spawnGlobalGroundItems(Player player) {
        long a = System.currentTimeMillis();
        nullCheckAndSpawn(player, new Item(952, 1), new Position(3571, 3312, 0));
        long b = System.currentTimeMillis();
        nullCheckAndSpawn(player, new Item(1351, 1), new Position(2693, 9560, 0));
        nullCheckAndSpawn(player, new Item(1949, 1), new Position(3142, 3453, 0));
        nullCheckAndSpawn(player, new Item(1005, 1), new Position(3143, 3453, 0));
        nullCheckAndSpawn(player, new Item(4168, 1), new Position(3205, 3212, 0));
        nullCheckAndSpawn(player, new Item(3727, 1), new Position(3209, 3212, 0));
        nullCheckAndSpawn(player, new Item(7509, 1), ROCKCAKE_POSITION);
        nullCheckAndSpawn(player, new Item(952, 1), STARTER_SPADE);
        nullCheckAndSpawn(player, new Item(952, 1), STARTER_SPADE2);
        nullCheckAndSpawn(player, new Item(7546, 1), new Position (3167,3310,0));
        nullCheckAndSpawn(player, new Item(4682, 1), new Position(3245, 3210, 0));
        timer = System.currentTimeMillis();
    }
    public static void spawnEGG(Player player) {
        long a = System.currentTimeMillis();
        nullCheckAndSpawn(player, new Item(10537, 1), player.getPosition());
        long b = System.currentTimeMillis();
        timer = System.currentTimeMillis();
    }

    private static void nullCheckAndSpawn(Player player, Item item, Position pos) {
        if (GroundItemManager.getGroundItem(player, item, pos) == null) {
            GroundItemManager.spawnGroundItem(player,
                    new GroundItem(item, pos, player.getUsername(), false, 60*60, false, 0)); // each player will have
            // an instance of the
            // shovel, will last
            // 60*60 seconds (1 hr)
        }
    }

}
