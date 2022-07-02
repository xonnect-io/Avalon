package com.ruse.world.content.quests;

import com.ruse.world.entity.impl.player.Player;


public class QuestInterfaceHandler {
    private final Player player;

    public QuestInterfaceHandler(Player player) {this.player = player;}
    public void openQuestOne() {
        player.getPacketSender().sendInterface(77830);
        player.getPacketSender().sendString(77833, "The Curse of Arrav");
        player.getPacketSender().sendString(77836, (player.questOneStarted == true) ?
                "@gre@ - I have Spoken with Arrav and offered my help." : "@red@ - Speak to Arrav and accept the Quest");
        player.getPacketSender().sendString(77837, "");
        player.getPacketSender().sendString(77838, (player.getQuestOneStep1() == true) ?
                "@gre@ - Obtain a full canopic jar" : "@red@ - Obtain a full canopic jar");
        player.getPacketSender().sendString(77839, "");
        player.getPacketSender().sendString(77840, (player.getQuestOneStep2() == true) ?
                "@gre@ - Kill Zemouregal and obtain Arrav's Heart" : "@red@ - Kill Zemouregal and obtain Arrav's Heart");
        player.getPacketSender().sendString(77841, "");
        player.getPacketSender().sendString(77842, (player.getQuestOneStep3() == true) ?
                "@gre@ - Return the Heart to Arrav" : "@red@ - Return the Heart to Arrav");
        player.getPacketSender().sendString(77843, "");
        player.getPacketSender().sendString(77844, "");
        player.getPacketSender().sendString(77845, "");
        player.getPacketSender().sendString(77846, "");
        player.getPacketSender().sendString(77847, "");
        player.getPacketSender().sendString(77848, "");
        player.getPacketSender().sendString(77849, "");
        player.getPacketSender().sendString(77850, "");
        player.getPacketSender().sendString(77851, "");
    }
}