package com.ruse.model.container.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Costumes {


    AVALON_SET(23458, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23281, 23282, 23283, 23284, 23285}),
    NEPHILIM_SET(23460, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23220, 23221, 23222, 23223, 23224}),
    HANTO_SET(23462, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{11763,11764, 11765, 11766, 11767}),
    RADITZ_SET(23464, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{9481,9482, 9483, 24391, 24392}),
    GOKU_SET(23466, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{9478,9479, 9480, 24393, 16265}),
    INUYASHA_SET(23468, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{5068,5069, 5070, 5071, 5072}),
    FALLEN_ANGEL_SET(23470, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{22100,22101, 22102, 22103, 22104}),
    GARFIELD_SET(23472, 0, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{14068,14069, 14070, 14071, 14072}),
    ;
    private int itemId;
    private double damageBoost;
    private int[] costumeSlots;
    private int[] costumeItems;

    public static Costumes forID(int id) {
        for (Costumes c : Costumes.values()) {
            if (c.getItemId() == id)
                return c;
        }
        return null;
    }


    public static int getItem(int id, int slot) {
        Costumes costume = forID(id);
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
