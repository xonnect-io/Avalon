package com.ruse.world.content.osrscollectionlog;


import com.ruse.world.entity.impl.player.Player;
import lombok.var;

import java.util.HashMap;


public class CollectionLogButtons {

    private static final HashMap<Integer, Collection> BOSS_LOG_BUTTONS = new HashMap<>();
    private static final HashMap<Integer, Collection> MYSTERY_BOX_LOG_BUTTONS = new HashMap<>();
    private static final HashMap<Integer, Collection> KEYS_LOG_BUTTONS = new HashMap<>();
    private static final HashMap<Integer, Collection> OTHER_LOG_BUTTONS = new HashMap<>();

    static {
        int button_index;//The start button
        button_index = -4485;
        //We must store the button twice, using prefix increment operator, once for the background sprite.
        for (final Collection collection : Collection.getAsList(LogType.BOSSES)) {
            BOSS_LOG_BUTTONS.put(button_index++, collection);
        }
        button_index = -4485;
        for (final Collection collection : Collection.getAsList(LogType.MYSTERY_BOX)) {
            MYSTERY_BOX_LOG_BUTTONS.put(button_index++, collection);
        }
        button_index = -4485;
        for (final Collection collection : Collection.getAsList(LogType.KEYS)) {
            KEYS_LOG_BUTTONS.put(button_index++, collection);
        }
        button_index = -4485;
        for (final Collection collection : Collection.getAsList(LogType.OTHER)) {
            OTHER_LOG_BUTTONS.put(button_index++, collection);
        }
    }

    public static boolean onButtonClick(Player player, int button) {
        if(button == -4533) {
            player.getCollectionLog2().open(LogType.BOSSES);
            player.getPacketSender().sendConfig(1106, 0);
            return true;
        }

        if(button == -4532) {
           player.getCollectionLog2().open(LogType.MYSTERY_BOX);
            player.getPacketSender().sendConfig(1106, 1);
            return true;
        }

        if(button == -4531) {
            player.getCollectionLog2().open(LogType.KEYS);
            player.getPacketSender().sendConfig(1106, 2);
            return true;
        }

        if(button == -4530) {
            player.getCollectionLog2().open(LogType.OTHER);
            player.getPacketSender().sendConfig(1106, 3);
            return true;
        }

        if(button == -4516) {
            var collection = player.getLogtoCheck();
            player.getCollectionLog2().claimReward(collection);
            return true;
        }

        if (player.getCollectionLogOpen() == LogType.BOSSES && BOSS_LOG_BUTTONS.containsKey(button)) {
            player.getCollectionLog2().sendInterface(BOSS_LOG_BUTTONS.get(button));
            return true;
        } else if (player.getCollectionLogOpen() == LogType.MYSTERY_BOX && MYSTERY_BOX_LOG_BUTTONS.containsKey(button)) {
            player.getCollectionLog2().sendInterface(MYSTERY_BOX_LOG_BUTTONS.get(button));
            return true;
        } else if (player.getCollectionLogOpen() == LogType.KEYS && KEYS_LOG_BUTTONS.containsKey(button)) {
            player.getCollectionLog2().sendInterface(KEYS_LOG_BUTTONS.get(button));
            return true;
        } else if (player.getCollectionLogOpen() == LogType.OTHER && OTHER_LOG_BUTTONS.containsKey(button)) {
            player.getCollectionLog2().sendInterface(OTHER_LOG_BUTTONS.get(button));
            return true;
        }
        return false;
    }

}
