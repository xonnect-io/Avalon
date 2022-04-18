package com.ruse.world.content.upgrading;

import com.ruse.model.Item;
import lombok.Getter;

import java.util.ArrayList;

import static com.ruse.world.content.upgrading.Upgradeables.UpgradeType.*;

@Getter
public enum Upgradeables {

    ABYSSAL_WHIP(WEAPON, new Item(4151, 1), new Item(18686, 1), 125, 60),
    DARK_BOW(WEAPON, new Item(11235, 1), new Item(18799, 1), 125, 60),
    SOL(WEAPON, new Item(15486, 1), new Item(5095, 1), 125, 60),
    DEMON_MAUL(WEAPON, new Item(18353, 1), new Item(22078, 1), 125, 60),

    BRUTAL_TENTACLE(WEAPON, new Item(18686, 1), new Item(22077, 1), 250, 45),
    BRUTAL_MINIGUN(WEAPON, new Item(18799, 1), new Item(19136, 1), 250, 45),
    ANKOUE_MAUL(WEAPON, new Item(22078, 1), new Item(22079, 1), 250, 45),
    SHKRUU_KATANA(WEAPON, new Item(22077, 1), new Item(20549, 1), 500, 35),
    SORROW_BOW(WEAPON, new Item(19136, 1), new Item(20173, 1), 500, 35),
    GANOPURP_STAFF(WEAPON, new Item(6936, 1), new Item(8809, 1), 500, 35),
    HEAVY_CHAINSAW(WEAPON, new Item(22079, 1), new Item(22080, 1), 500, 35),
    TRINITY_BLADE(WEAPON, new Item(20549, 1), new Item(22084, 1), 4200, 25),
    BLASTBOMB_HANDCANNON(WEAPON, new Item(20173, 1), new Item(22083, 1), 4200, 25),
    WOOS_STAFF(WEAPON, new Item(8809, 1), new Item(22092, 1), 4200, 25),
    WOOS_2H_SWORD(WEAPON, new Item(22080, 1), new Item(16137, 1), 4200, 25),
    CORRUPT_WHIP(WEAPON, new Item(22084, 1), new Item(18750, 1), 5000, 15),
    CORRUPT_MINIGUN(WEAPON, new Item(22083, 1), new Item(18636, 1), 5000, 15),
    CORRUPT_STAFF(WEAPON, new Item(22092, 1), new Item(18629, 1), 5000, 15),
    WRATH_HAMMER(WEAPON, new Item(16137, 1), new Item(17698, 1), 5000, 15),
    AGONY_SWORD(WEAPON, new Item(18750, 1), new Item(8087, 1), 5000, 25),
    AGONY_CROSSBOW(WEAPON, new Item(18636, 1), new Item(8088, 1), 5000, 25),
    AGONY_STAFF(WEAPON, new Item(18629, 1), new Item(8089, 1), 5000, 25),


    HAT(ARMOUR, new Item(1038, 1), new Item(1050, 1), 104000, 50),
    RING(ACCESSORY, new Item(1040, 1), new Item(1050, 1), 15000000, 25),
    IDD(MISC, new Item(1042, 1), new Item(1050, 1), 250000000, 100),

    ;

    private UpgradeType type;
    private Item required, reward;
    private int cost, successRate;
    private boolean rare;

    Upgradeables(UpgradeType type, Item required, Item reward, int cost, int successRate, boolean rare) {
        this.type = type;
        this.required = required;
        this.reward = reward;
        this.cost = cost;
        this.successRate = successRate;
        this.rare = rare;
    }

    Upgradeables(UpgradeType type, Item required, Item reward, int cost, int successRate) {
        this.type = type;
        this.required = required;
        this.reward = reward;
        this.cost = cost;
        this.successRate = successRate;
        this.rare = false;
    }
    
    public static ArrayList<Upgradeables> getForType(UpgradeType type){
        ArrayList<Upgradeables> upgradeablesArrayList = new ArrayList<>();
        for (Upgradeables upgradeables : values()){
            if (upgradeables.getType() == type){
                upgradeablesArrayList.add(upgradeables);
            }
        }
        return upgradeablesArrayList;
    }
    

    public enum UpgradeType{

        WEAPON, ARMOUR, ACCESSORY, MISC;

    }


}
