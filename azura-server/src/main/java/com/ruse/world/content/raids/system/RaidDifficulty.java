package com.ruse.world.content.raids.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum
RaidDifficulty {

    EASY("Easy",
            new RaidRequirement(10_000)
    ),
    INTERMEDIATE("Medium",
            new RaidRequirement(20_000, 100)
    ),
    ADVANCED("Hard",
            new RaidRequirement(30_000, 250)
    );

    @Getter
    private String name;

    @Getter
    private RaidRequirement godsRequirement;

}