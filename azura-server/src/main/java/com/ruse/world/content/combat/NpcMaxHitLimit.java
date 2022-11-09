package com.ruse.world.content.combat;

import com.ruse.world.entity.impl.npc.NPC;

public class NpcMaxHitLimit {

    public static double limit(NPC npc, double damage, CombatType type) {
        int maxLimit;
        switch (npc.getId()) {
            // case 187:  // goku
            //case 8009: // hulk
            case 9894:
                maxLimit = 2_500_000;
                break;

            case 187:
                maxLimit = 2_500_000;
                break;
            case 3779:
                maxLimit = 2_500_000;
                break;
            case 8013:
                maxLimit = 2_500_000;
                break;
            case 9017:
                maxLimit = 2_500_000;
                break;
            case 3305:
                maxLimit = 2_500_000;
                break;
            case 4972:
                maxLimit = 2_500_000;
                break;
            case 3830:
                maxLimit = 2_500_000;
                break;
            case 587:
                maxLimit = 2_500_000;
                break;
            case 9318:
                maxLimit = 2_500_000;
                break;
            case 9319:
                maxLimit = 2_500_000;
                break;
            case 9312:
                maxLimit = 2_500_000;
                break;
            case 9129:
                maxLimit = 2_500_000;
                break;
            case 1:
                maxLimit = 80000;
                break;
            default:
                return damage;
        }
        return Math.min(maxLimit, damage);
    }
}
