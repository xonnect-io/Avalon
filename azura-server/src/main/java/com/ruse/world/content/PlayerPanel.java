package com.ruse.world.content;

import com.ruse.GameSettings;
import com.ruse.motivote3.doMotivote;
import com.ruse.util.Misc;
import com.ruse.util.StringUtils;
import com.ruse.world.World;
import com.ruse.world.content.randomevents.LootChest;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.impl.slayer.SlayerTasks;
import com.ruse.world.entity.impl.player.Player;

public class PlayerPanel {

    public static void refreshCurrentTab(Player player) {
        refreshPanel(player);
    }

    public static void refreshPanel(Player player) {
        int interfaceID = 111201;
        int players = (int) World.getPlayers().size() + GameSettings.players;
        String[] Messages;
        Messages = new String[]{
                //
                "Main",
                "Players Online: @whi@" + ((players)),
                "Server Time: @whi@" + Misc.getCurrentServerTime(),
                //
                "Events",
                "Server Perk:  @whi@" +
                        ( ServerPerks.getInstance().getActivePerk() != null ?
                        ServerPerks.getInstance().getActivePerk().getName() :"N/A"),
                "Bonus Skill: @whi@" + StringUtils.capitalizeFirst(DoubleXPSkillEvent.currentSkill.toString()),
                "Loot Chest: " +
                        (LootChest.getLocation() != null ?
                        LootChest.getLocation().playerPanelFrame : "@whi@N/A"),
                //
                "Globals",
                "Tribal Goblin: @whi@" + AfkSystem.getLeft() + " @whi@Steals left.",
                "Hellraiser: @whi@" + HellraiserSystem.getLeft() + " @whi@kills left.",
                (VoteBossDrop.currentSpawn == null
                        ? "Vote Boss: @whi@" + doMotivote.getVoteCount() + "/60 please vote!"
                        : "Vote Boss:@whi@ Alive ::Vboss"),
                (GlobalBoss4.currentBoss == null
                ? "Dragon King: @whi@" + GlobalBoss4.timeLeft() : "Dragon King: @whi@Alive ::dk"),
                (GlobalBoss2.currentBoss == null
                ? "Nightmare boss: @whi@" + GlobalBoss2.timeLeft() : "Nightmare boss : @whi@Alive ::nm"),
                (GlobalBoss3.currentBoss == null
                ? "Naraku boss: @whi@" + GlobalBoss3.timeLeft() : "Naraku boss : @whi@Alive ::naraku"),
                (GlobalBoss5.currentBoss == null
                ? "Ironman boss: @whi@" + GlobalBoss5.timeLeft(): "Ironman boss : @whi@Alive ::iron"),
                "Avalon Guard: @whi@" + GuardianSpawnSystem.getLeft()  + " @whi@tickets left",
                "Nephilim: @whi@" + NephilimSpawnSystem.getLeft()  + " @whi@tokens left",
                "",
                "",
        };

        for (int i = 0; i < Messages.length; i++) {
            player.getPacketSender().sendString(interfaceID++, Messages[i]);
        }


        interfaceID = 111401;

        Messages = new String[]{"Main",
                "Time Played: @whi@"
                        + Misc.getHoursPlayed((player.getTotalPlayTime() + player.getRecordedLogin().elapsed())),
                "Username: @whi@" + player.getUsername(),
                "Total Donated: @whi@$" + player.getAmountDonated(),
                "Mode: @whi@"
                        + Misc.capitalizeString(player.getGameMode().toString().toLowerCase().replace("_", " ")),
                "Rank: @whi@" + Misc.formatText(player.getRights().toString().toLowerCase()),

                "Droprate bonus: @whi@" + CustomDropUtils.drBonus(player, player.getSlayer().getSlayerTask().getNpcId()) + "%",
                "Double drop bonus: @whi@" + CustomDropUtils.getDoubleDropChance(player, player.getSlayer().getSlayerTask().getNpcId()) + "%",
                //"Triple drop bonus: @whi@" + CustomDropUtils.getTripleDropChance(player) + "%",
                //"Exp Lock: " + (player.experienceLocked() ? "Locked" : "@gre@Unlocked") + "",
                (player.getMinutesVotingDR() <= 0 ? "Voting 100% DR Boost: @whi@VOTE FIRST" :"Voting x2 DR Boost: @whi@" + player.getMinutesVotingDR() + "min"),
                (player.getMinutesVotingDMG() <= 0 ? "Voting 100% DMG Boost: @whi@ VOTE FIRST" :"Voting x2 DMG Boost: @whi@" + player.getMinutesVotingDMG() + "min"),


                //
                "Slayer Information",
                "Master: @whi@" + Misc
                        .formatText(player.getSlayer().getSlayerMaster().toString().toLowerCase().replaceAll("_", " ")),
                (player.getSlayer().getSlayerTask() == SlayerTasks.NO_TASK
                        ? "Task: @whi@" + player.getSlayer().getSlayerTask().getName()
                        : "Task: @whi@" + player.getSlayer().getSlayerTask().getName()
                        + "s"),
                "Amount: @whi@" + player.getSlayer().getAmountToSlay(),
                "Streak: @whi@" + player.getSlayer().getTaskStreak(),
                "Slayer Multiplier: @whi@ " + player.getPointsHandler().getSlayerRate() + "%",
                // (player.getSlayer().getDuoPartner() != null
                //        ? "Duo Partner: @whi@" + player.getSlayer().getDuoPartner()
                //      : "Duo Partner: @whi@N/A"),

                //
                "Points & Statistics",
                "NPC kill Count: @whi@ " + player.getPointsHandler().getNPCKILLCount(),
                "Boss Points: @whi@ " + player.getPointsHandler().getBossPoints(),
                "Donator Points: @whi@" + player.getPointsHandler().getDonatorPoints(),
                "Voting Points: @whi@ " + player.getPointsHandler().getVotingPoints(),
                "Slayer Points: @whi@" + player.getPointsHandler().getSlayerPoints(),
                "Loyalty Points: @whi@" + (int) player.getPointsHandler().getLoyaltyPoints(),
              //  "Prestige Points: @whi@" + player.getPointsHandler().getPrestigePoints(),
              //  "Total Prestige: @whi@" + player.getPointsHandler().getTotalPrestiges(),
              //  "Event Points: @whi@ " + player.getPointsHandler().getEventPoints(),
             //   "Commendations: @whi@ " + player.getPointsHandler().getCommendations(),
              //  "Dung. Tokens: @whi@ " + player.getPointsHandler().getDungeoneeringTokens(),
              //  "Penguin Multiplier: @whi@ " + player.getPointsHandler().getPengRate() + "%",
               // "Barrows Points: @whi@" + player.getPointsHandler().getBarrowsPoints(),
               // "Pk Points: @whi@" + player.getPointsHandler().getPkPoints(),

        };

        for (int i = 0; i < Messages.length; i++) {
            player.getPacketSender().sendString(interfaceID++, Messages[i]);
        }

        interfaceID = 111601;
        player.getPacketSender().sendString(interfaceID++, "View Commands");
        player.getPacketSender().sendString(interfaceID++, "View Achievements");
        player.getPacketSender().sendString(interfaceID++, "View Drop Tables");
        player.getPacketSender().sendString(interfaceID++, "View Collection Log");
        player.getPacketSender().sendString(interfaceID++, "View Kill Tracker");
        player.getPacketSender().sendString(interfaceID++, "View Possible Loot");
        player.getPacketSender().sendString(interfaceID++, "View Item Stats");
        player.getPacketSender().sendString(interfaceID++, "Change Password");
        player.getPacketSender().sendString(interfaceID++, "Edit Pin");


    }

}