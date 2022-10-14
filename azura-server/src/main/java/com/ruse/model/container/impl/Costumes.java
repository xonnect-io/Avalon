package com.ruse.model.container.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Costumes {


    AVALON_SET(23458, 10, new int[]{Equipment.HEAD_SLOT, Equipment.BODY_SLOT, Equipment.LEG_SLOT, Equipment.HANDS_SLOT, Equipment.FEET_SLOT},
            new int[]{23281, 23282, 23283, 23284, 23285}),

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
