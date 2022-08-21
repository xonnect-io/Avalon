package com.ruse.world.content.membership;

import com.ruse.world.entity.impl.player.Player;


public class MembershipInterfaceHandler {
    boolean bonuses = false;

    private final Player player;

    public MembershipInterfaceHandler(Player player) {this.player = player;}
    public void openBenefitTab() {
            player.getPacketSender().sendString(28024, (player.isMembershipUnlocked() == true) ?
                    "@gre@20% DR and 10% DDR boost" : "@or2@20% DR and 10% DDR boost");
        player.getPacketSender().sendString(28025, (player.isMembershipUnlocked() == true) ?
                "@gre@15% Chance to deal X2 DMG" : "@or2@15% Chance to deal X2 DMG");
        player.getPacketSender().sendString(28026, (player.isMembershipUnlocked() == true) ?
                "@gre@10% Chance to double KC" : "@or2@10% Chance to double KC");
        player.getPacketSender().sendString(28027, (player.isMembershipUnlocked() == true) ?
                "@gre@10% Chance to keep boxes" : "@or2@10% Chance to keep boxes");

        player.getPacketSender().sendInterface(28002);
        player.getPacketSender().sendString(28006, ("Resets: " + MembershipManager.theEndDate()));
        player.getPacketSender().sendString(28030, (player.isMembershipUnlocked() == true) ?
                "Membership: @gre@Active" : "Membership: @red@Inactive");
    }
    public void openCosmeticTab() {
        player.getPacketSender().sendInterface(60600);
        player.getPacketSender().sendString(60606, ("Resets: " + MembershipManager.theEndDate()));
        player.getPacketSender().sendString(60630, (player.isCosmeticUnlocked() == true) ?
                "Membership: @gre@Active" : "Membership: @red@Inactive");
        player.getPacketSender().sendItemOnInterface(60623, 23404, 0, 1);
        player.getPacketSender().sendItemOnInterface(60624, 23405,0, 1);
        player.getPacketSender().sendItemOnInterface(60625, 23406,0, 1);

    }
}