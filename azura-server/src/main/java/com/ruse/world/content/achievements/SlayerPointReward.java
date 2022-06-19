package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;

public class SlayerPointReward implements NonItemReward {

    private final int amount;

    public SlayerPointReward(int amount) {
        this.amount = amount;
    }

    @Override
    public void giveReward(Player player) {
        player.getPointsHandler().setSlayerPoints(amount, true);
    }

    @Override
    public String rewardDescription() {
        return " Slayer: " + amount ;
    }
}
