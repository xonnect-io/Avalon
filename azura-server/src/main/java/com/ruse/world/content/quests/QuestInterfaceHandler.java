package com.ruse.world.content.quests;

import com.ruse.world.entity.impl.player.Player;


public class QuestInterfaceHandler {
    private final Player player;

    public QuestInterfaceHandler(Player player) {this.player = player;}
    public void openQuestOne() {
        player.getPacketSender().sendInterface(77830);
        player.getPacketSender().sendString(77833, "Blood Runs Deep");
        player.getPacketSender().sendString(77836, (player.questOneStarted == true) ?
                "@gre@ - I have Spoken with Ksenia and offered my help." : "@red@ - Speak to Ksenia and accept the Quest");
        player.getPacketSender().sendString(77837, "");
        player.getPacketSender().sendString(77838, (player.getQuestOneStep1() == true) ?
                "@gre@ - Travel to The sick man's dream world" : "@red@ - Travel to The sick man's dream world");
        player.getPacketSender().sendString(77839, "");
        player.getPacketSender().sendString(77840, (player.getQuestOneStep2() == true) ?
                "@gre@ - Help Ksenia find a Lectern inside the dream" : "@red@- Help Ksenia find a Lectern inside the dream");
        player.getPacketSender().sendString(77841, " ");
        player.getPacketSender().sendString(77842, (player.getQuestOneStep3() == true) ?
                "@gre@ - Fight off the Dagganoth Army" : "@red@ - Fight off the Dagganoth Army");
        player.getPacketSender().sendString(77843, " ");
        player.getPacketSender().sendString(77844, (player.getQuestOneStep4() == true) ?
                "@gre@ - Access the spiritual Realm" : "@red@ - Access the spiritual Realm");
        player.getPacketSender().sendString(77845, " ");
        player.getPacketSender().sendString(77846, (player.getQuestOneStep5() == true) ?
                    "@gre@ - Retrieve the Prophecy tablet" : "@red@ - Retrieve the Prophecy tablet");
        player.getPacketSender().sendString(77847, " ");
        player.getPacketSender().sendString(77848, (player.getQuestOneStep6() == true) ?
                "@gre@ Craft the Daggonoth Lair Teleport" : "@red@ - Craft the Daggonoth Lair Teleport");
        player.getPacketSender().sendString(77849, "");
        player.getPacketSender().sendString(77850, (player.getQuestOneStep7() == true) ?
                "@gre@ - Defeat the Daggonoth Mother & Return the Enchanted Herbs" : "@red@ - Defeat the Daggonoth Mother & Return the Enchanted Herbs");
        player.getPacketSender().sendString(77851, " ");
    }
}