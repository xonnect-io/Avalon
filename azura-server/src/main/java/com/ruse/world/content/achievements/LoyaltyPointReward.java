package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;

public class LoyaltyPointReward implements NonItemReward {

    private final int amount;

    public LoyaltyPointReward(int amount) {
        this.amount = amount;
    }

    @Override
    public void giveReward(Player player) {
        player.getPointsHandler().incrementLoyaltyPoints(player.getPointsHandler().getLoyaltyPoints() + amount);
    }

    @Override
    public String rewardDescription() {
        return " Loyalty: " + amount ;
    }
}
