package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;

public interface NonItemReward {
    void giveReward(Player player);

    String rewardDescription();
}
