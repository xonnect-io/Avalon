package com.ruse.world.entity.impl.player;

import com.ruse.GameSettings;
import com.ruse.model.GameMode;
import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.world.World;
import com.ruse.world.content.PlayerPanel;
import com.ruse.world.content.clan.ClanChatManager;
//import sun.management.counter.perf.PerfLongArrayCounter;

//import com.arlania.world.content.discordbot.Main;

/**
 * Start screen functionality.
 *
 * @author Joey wijers
 */
public class StartScreen {
    public static void open(Player player) {
        sendNames(player);
        player.getPacketSender().sendInterface(116000);
        player.getPacketSender().sendConfig(5331, 0);
        player.selectedGameMode = GameModes.NORMAL;
        check(player, GameModes.NORMAL);
        sendStartPackItems(player, GameModes.NORMAL);
        sendDescription(player, GameModes.NORMAL);
    }

    public static void sendDescription(Player player, GameModes mode) {
        player.getPacketSender().sendString(116101,  mode.line1 + "\\n" + mode.line2 + "\\n" + mode.line3 + "\\n" + mode.line4 + "\\n" + mode.line5 + "\\n" + mode.line6 );
    }

    public static void sendStartPackItems(Player player, GameModes mode) {
        final int START_ITEM_INTERFACE = 116201;
        for (int i = 0; i < 28; i++) {
            int id = -1;
            int amount = 0;
            try {
                id = mode.starterPackItems[i].getId();
                amount = mode.starterPackItems[i].getAmount();
            } catch (Exception e) {

            }
            player.getPacketSender().sendItemOnInterface(START_ITEM_INTERFACE + i, id, amount);
        }
    }

    public static boolean handleButton(Player player, int buttonId) {
        final int CONFIRM = 116010;
        if (buttonId == CONFIRM) {
            if (player.didReceiveStarter() == true) {
                return true;
            }
            player.getPacketSender().sendInterfaceRemoval();
            player.setReceivedStarter(true);
            handleConfirm(player);
            addStarterToInv(player);
            ClanChatManager.join(player, "help");
            player.setPlayerLocked(false);
            player.getPacketSender().sendInterface(3559);
            player.getAppearance().setCanChangeAppearance(true);
            player.setNewPlayer(false);
            World.sendMessage("<img=18><shad=1><col=ffca3c>[New Arrival] " + player.getUsername() + " has just logged into @cya@Avalon<col=ffca3c> for the first time!");
            player.sendMessage(
                    "You wake up in an unfamiliar place, perhaps searching around would benefit greatly.");
            player.getPacketSender().sendRights();
            if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
                player.moveTo(new Position(2333, 4119, 4));
                player.setGroupIronmanLocked(true);
                player.sendMessage("@blu@Speak to the Ironman Manager to create a group or get invited to a group.");
            } else {
                player.moveTo(GameSettings.STARTER_BED);
            }
            return true;
        }
        for (GameModes mode : GameModes.values()) {
            if (mode.checkClick == buttonId || mode.textClick == buttonId) {
                selectMode(player, mode);
                return true;
            }
        }
        return false;

    }

    public static void handleConfirm(Player player) {

        // System.out.println("Game mode: " + player.selectedGameMode);

        if (player.selectedGameMode == GameModes.VETERAN_MODE) {
            GameMode.set(player, GameMode.VETERAN_MODE, false);
        } else if (player.selectedGameMode == GameModes.IRONMAN) {
            GameMode.set(player, GameMode.IRONMAN, false);
        } else if (player.selectedGameMode == GameModes.ULTIMATE_IRONMAN) {
            GameMode.set(player, GameMode.ULTIMATE_IRONMAN, false);
            player.getPacketSender().sendMessage("<img=5> @red@" + player.getUsername()
                    + ", you can un-note items by using them on a banker or bank!");
        } else if (player.selectedGameMode == GameModes.GROUP_IRON) {
            GameMode.set(player, GameMode.GROUP_IRONMAN, false);
        } else {
            GameMode.set(player, GameMode.NORMAL, false);
        }
        PlayerPanel.refreshPanel(player);

    }

    public static void addStarterToInv(Player player) {
        for (Item item : player.selectedGameMode.starterPackItems) {
            player.getInventory().add(item);
        }
    }

    public static void selectMode(Player player, GameModes mode) {
        player.selectedGameMode = mode;
        check(player, mode);
        sendStartPackItems(player, mode);
        sendDescription(player, mode);
    }

    public static void check(Player player, GameModes mode) {
        for (GameModes gameMode : GameModes.values()) {
            if (player.selectedGameMode == gameMode) {
                player.getPacketSender().sendConfig(gameMode.configId, 1);
                continue;
            }
            player.getPacketSender().sendConfig(gameMode.configId, 0);
        }
    }

    public static void sendNames(Player player) {
        for (GameModes mode : GameModes.values()) {
            player.getPacketSender().sendString(mode.stringId, mode.name);
        }
    }

    public enum GameModes {
        NORMAL("Normal", 52761, 116005, 1, 0,
                new Item[]{new Item( 1153, 1), new Item(1115, 1), new Item(1067, 1) ,
                        new Item(18365, 1), new Item(16995, 1), new Item(16879, 1),
                        new Item(13281, 1), new Item(20054, 1),  new Item(1478, 1),
                        new Item(10499, 1), new Item(459, 1),  new Item(290, 2),
                        new Item(15031, 1), new Item(6570, 1)
                },
                "In this game mode",
                "Play the game without any restrictions.",
                "@whi@0.0% Droprate bonus", "", "", "", ""),


        IRONMAN("Ironman", 52762, 116006, 1, 1,
                new Item[]{new Item( 16691, 1),
                        new Item(17239, 1), new Item(16669, 1) ,
                        new Item(18365, 1), new Item(16995, 1), new Item(16879, 1),
                        new Item(13281, 1),new Item(20054, 1),  new Item(1478, 1),
                        new Item(10499, 1),new Item(459, 1),new Item(630, 1),
                        new Item(18740, 1)
                },
                "Ironman mode is a very intense gamemode",
                "You are not allowed to trade or stake",
                "You will not get a npc drop if you didn solo",
                "This is for players who like a challenge",
                "@whi@6.0% Droprate bonus", "", ""),


        ULTIMATE_IRONMAN("Ultimate Iron", 52763, 116007, 1, 2,
                new Item[]{ new Item( 4977, 1), new Item(4989, 1), new Item(4995, 1) ,
                        new Item(18365, 1), new Item(16995, 1), new Item(16879, 1),
                        new Item(13281, 1),  new Item(20054, 1),  new Item(1478, 1),
                        new Item(10499, 1), new Item(459, 1),new Item(630, 1),
                        new Item(18740, 1)
                },
                "Ultimate ironman is harder than ironman",
                "@red@Same as ironman mode, but you can't banks",
                "This is for players who like a challenge",
                "@whi@10.0% Droprate bonus", "", "", ""),


        GROUP_IRON("Group Ironman", 52778, 116008, 1, 4,
                new Item[]{ new Item( 13700, 1),new Item(13701, 1), new Item(13702, 1) ,
                        new Item(18365, 1), new Item(16995, 1), new Item(16879, 1),
                        new Item(13281, 1),new Item(20054, 1),  new Item(1478, 1),
                        new Item(10499, 1), new Item(459, 1), new Item(630, 1),
                        new Item(18740, 1)
                },
                "Group Ironman mode is a very fun gamemode",
                "Same rules as ironman mode",
                "You can have a group with up to five players",
                "You can trade other players in your group",
                "You have a shared bank with your group",
                "@whi@10.0% Droprate bonus", ""),


        VETERAN_MODE("Veteran", 52774, 116009, 1, 3,
                new Item[]{new Item( 1153, 1),new Item(1115, 1), new Item(1067, 1) ,
                        new Item(18365, 1), new Item(16995, 1), new Item(16879, 1),
                        new Item(13281, 1),  new Item(20054, 1),  new Item(1478, 1),
                        new Item(10499, 1), new Item(459, 1),  new Item(290, 2),
                        new Item(15031, 1), new Item(6570, 1)
                },
                "This is probably the hardest game mode",
                "@red@The EXP rate in this mode is the hardest",
                "This mode is for players that love grinding",
                "@whi@15.0% Droprate bonus", "", "", ""),

        ;
        private String name;
        private int stringId;
        private int checkClick;
        private int textClick;
        private int configId;
        private Item[] starterPackItems;
        private String line1;
        private String line2;
        private String line3;
        private String line4;
        private String line5;
        private String line6;
        private String line7;

        private GameModes(String name, int stringId, int checkClick, int textClick, int configId, Item[] starterPackItems, String line1, String line2, String line3, String line4, String line5, String line6, String line7) {
            this.name = name;
            this.stringId = stringId;
            this.checkClick = checkClick;
            this.textClick = textClick;
            this.configId = configId;
            this.starterPackItems = starterPackItems;
            this.line1 = line1;
            this.line2 = line2;
            this.line3 = line3;
            this.line4 = line4;
            this.line5 = line5;
            this.line6 = line6;
            this.line7 = line7;
        }
    }
}
