package com.ruse.world.content.combat;

import com.ruse.world.entity.impl.npc.NPC;

public class NpcMaxHitLimit {

    public static double limit(NPC npc, double damage, CombatType type) {
        int maxLimit;
        switch (npc.getId()) {
            case 9129: //slayer champion
            case 9312: //Nephilim Warrior
            case 9319: //Zenyte Golem
            case 587:  //Ironman boss
            case 9318: //Onyx Panther
            case 3830: //Vozzath
            case 4972: //Dragon king
            case 3305: //Naraku
            case 9017: //Nightmare Boss
            case 8013: //Vote Boss
            case 3779: //Terrorstep
            case 187://Hellraiser
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
