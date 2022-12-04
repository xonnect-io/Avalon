package com.ruse.model.container.impl;

import com.ruse.world.entity.impl.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Costumes {


    AVALON_SET(23458, 10, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23281, 23282, 23283, 23284, 23285}),
    NEPHILIM_SET(23460, 10, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23220, 23221, 23222, 23223, 23224}),
    HANTO_SET(23462, 2, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{11763,11764, 11765, 11766, 11767}),
    RADITZ_SET(23464, 2, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{9481,9482, 9483, 23518, 23519}),
    GOKU_SET(23466, 3, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{9478,9479, 9480, 23520, 16265}),
    INUYASHA_SET(23468, 3, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{5068,5069, 5070, 5071, 5072}),
    FALLEN_ANGEL_SET(23470, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{22100,22101, 22102, 22103, 22104}),
    GARFIELD_SET(23472, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{14068,14069, 14070, 14071, 14072}),

    OMEGA(23390, 2, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23794,23795, 23796, 23797, 23798}),
    UNKNOWN(7677, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23804,23805, 23806, 23807, 23808}),
    LUCIFER(23403, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23809,23810, 23811, 23812, 23813}),
    DIVINE(23395, 10, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23814,23815, 23816, 23817, 23818}),
    KISMET(23384, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23819,23820, 23821, 23822, 23823}),
    LUCKY(23385, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23824,23825, 23826, 23827, 23828}),
    TURKEY(23454, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23448,23449, 23450, 23451, 23452}),
    ELF(17746, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23528,23529, 23530, 23531, 23532}),
    KRAMPUS(17778, 10, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{17747,17748, 17749, 17750, 17751}),
    GRANDMASTER(23509, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT},
            new int[]{23497, 23498, 23499}),
    LEGENDS(23484, 5, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{4684,4685, 4686, 8273, 8274}),
    REAPER(23482, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23259,23260, 23261, 23262, 23263}),
    NECROMANCER(23550, 15, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23799,23800, 23801, 23802, 23803}),
    SANTA_COSMETIC(13258, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{1050,14595, 14602, 14603, 14605}),
    ARMADYL_COSMETIC(13267, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT},
            new int[]{11718,11720, 11722}),
    NOOBIE_COSMETIC(13269, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT},
            new int[]{19900,10939, 10940}),
    DRAGON_RIDER(23456, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{14050,14051, 14052, 14053, 14054}),
    COSTUME_1(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23396,23397, 23398, 23400, 23399}),
    COSTUME_2(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT, Equipment.AMULET_SLOT},
            new int[]{10612,5553, 5555, 5556, 5557, 19335}),
    COSTUME_3(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.CAPE_SLOT, Equipment.FEET_SLOT, Equipment.SHIELD_SLOT, Equipment.AMULET_SLOT},
            new int[]{17614,17616, 17618, 17606,17622,17620,17624,11195}),
    COSTUME_4(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.WEAPON_SLOT, Equipment.FEET_SLOT},
            new int[]{13328,13329, 13330, 13333, 13332,}),
        COSTUME_5(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT, Equipment.WEAPON_SLOT,Equipment.CAPE_SLOT,},
            new int[]{3067,3068, 3069, 3071, 3070,3072,3073}),
    COSTUME_6(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT},
            new int[]{3074,3075, 3076}),
    COSTUME_7(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT, Equipment.AMULET_SLOT},
            new int[]{10612,5553, 5555, 5556, 5557, 19335}),
    COSTUME_8(-1, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.CAPE_SLOT, Equipment.FEET_SLOT, Equipment.SHIELD_SLOT, Equipment.AMULET_SLOT},
            new int[]{17614,17616, 17618, 17606,17622,17620,17624,11195}),
    ;
    private int itemId;
    private double damageBoost;
    private int[] costumeSlots;
    private int[] costumeItems;

    public static Costumes forID(int id, Player player) {
        for (Costumes c : Costumes.values()) {
            if (c.getItemId() == id)
                return c;
            else if (player.isSet1 ()) {
                return Costumes.COSTUME_2;
            } else if (player.isSet2 ()) {
                return Costumes.COSTUME_1;
            } else if (player.isSet3 ()) {
                return Costumes.COSTUME_3;
            } else if (player.isSet4 ()) {
                return Costumes.COSTUME_4;
            } else if (player.isSet5 ()) {
                return Costumes.COSTUME_5;
            } else if (player.isSet6 ()) {
                return Costumes.COSTUME_6;
            } else if (player.isSet7 ()) {
                return Costumes.COSTUME_7;
            } else if (player.isSet8 ()) {
                return Costumes.COSTUME_8;
            } else return null;
        }
        return null;
    }


    public static int getItem(int id, int slot, Player player) {
        Costumes costume = forID(id, player);
        if (costume == null)
            return -1;

        for (int i = 0; i < costume.getCostumeSlots().length; i++) {
            if (costume.getCostumeSlots()[i] == slot) {
                return costume.getCostumeItems()[i];
            }
        }
        return -1;
    }

}
