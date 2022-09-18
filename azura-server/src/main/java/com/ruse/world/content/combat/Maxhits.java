package com.ruse.world.content.combat;

import com.ruse.model.Locations;
import com.ruse.model.PlayerRights;
import com.ruse.model.Skill;
import com.ruse.model.container.impl.Equipment;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.effect.EquipmentBonus;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.weapon.FightStyle;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.DropUtils;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.content.skill.impl.summoning.Familiar;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class Maxhits {

    public static int melee(Character entity, Character victim) {
        double maxHit = 0;
        if (entity.isNpc()) {
            NPC npc = (NPC) entity;
            maxHit = npc.getDefinition().getMaxHit();
            if (npc.getStrengthWeakened()[0]) {
                maxHit -= (int) (0.10 * maxHit);
            } else if (npc.getStrengthWeakened()[1]) {
                maxHit -= (int) (0.20 * maxHit);
            } else if (npc.getStrengthWeakened()[2]) {
                maxHit -= (int) (0.30 * maxHit);
            }
        } else if (entity.isPlayer()) {
            Player player = (Player) entity;

            double base = 0;
            double effective = getEffectiveStr(player);
            double strengthBonus = player.getBonusManager().getOtherBonus()[0];
            double specialBonus = 1;

            // Use our multipliers to adjust the maxhit...

            base = 1.4 + effective / 10 + strengthBonus / 80 + effective * strengthBonus / 640;

            // Special effects also affect maxhit
            if (player.isSpecialActivated() && player.getCombatSpecial().getCombatType() == CombatType.MELEE) {
                specialBonus = player.getCombatSpecial().getStrengthBonus();
            }

            if (specialBonus > 1) {
                base = Math.round(base) * specialBonus;
            } else {
                base = (int) base;
            }

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()) {
                    if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071
                            || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069) {
                        base *= 1.05;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                        base *= 1.07;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                        base *= 1.10;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                        base *= 1.15;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                        base *= 1.25;
                    }
                }
            }
            Familiar playerFamiliar = player.getSummoning().getFamiliar();

            if (playerFamiliar != null) {
                double bonus = DropUtils.getDamageBonus(playerFamiliar.getSummonNpc().getId());
                base *= bonus;
            }
            if (player.getInventory().contains(23413))
                base *= 1.75;
           else if (player.getInventory().contains(4442)) {
                base *= 1.5;
            }
            if (player.getEquipment().contains(7539)) {
                base *= 1.5;
            }

            int MeleeDamage = Misc.getRandom(1,100);
            if (player.isMembershipUnlocked() == true && MeleeDamage > 90) {
                base *= 2;
            }

            if (player.getWarriorMaster() == true) {
                base *= 1.2;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                base *= 1.15;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {// admin pet
                base *= 1.25;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SUMMER_SURFER.npcId) {// admin pet
                base *= 1.20;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {// admin pet
                base *= 1.30;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {// admin pet
                base *= 1.25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {// admin pet
                base *= 1.25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {// admin pet
                base *= 1.25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {// admin pet
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {// admin pet
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {// admin pet
                base *= 1.25D;
            }
            if(ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_DMG) {
                base *= 2;
            }

            if(player.getRights() == PlayerRights.OWNER) {
                base *= 5.5;
            }
            if(player.getRights() == PlayerRights.TANZANITE_DONATOR) {
                base *= 1.75;
            }
            if (player.getRights() == PlayerRights.ZENYTE_DONATOR) {
                base *= 1.5;
            }
            if (player.getRights() == PlayerRights.ONYX_DONATOR) {
                base *= 1.35;
            }
            if (player.getRights() == PlayerRights.DIAMOND_DONATOR) {
                base *= 1.25;
            }
            if (player.getRights() == PlayerRights.RUBY_DONATOR) {
                base *= 1.15;
            }
            if (player.getRights() == PlayerRights.EMERALD_DONATOR) {
                base *= 1.10;
            }
            if(player.getRights() == PlayerRights.SAPPHIRE_DONATOR) {
                base *= 1.10;
            }
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 20592 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15916 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 13800) {
                base *= 2;
            }

            maxHit = base * 10;


            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1906) {
                maxHit *= 1.1D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1801) {// admin pet
                maxHit *= 1.15D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9013) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9016) {// admin pet
                maxHit *= 1.25D;
            }

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()
                        && victim.getConstitution() >= ((NPC) victim).getDefaultConstitution()) {
                    int percent = -1;
                    if (player.getEquipment().contains(23071)) {
                        percent = Misc.getRandom(5);
                    } else if (player.getEquipment().contains(23069)) {
                        percent = Misc.getRandom(10);
                    } else if (player.getEquipment().contains(23070)) {
                        percent = Misc.getRandom(15);
                    } else if (player.getEquipment().contains(23074)) {
                        percent = Misc.getRandom(20);
                    } else if (player.getEquipment().contains(23072)) {
                        percent = Misc.getRandom(25);
                    } else if (player.getEquipment().contains(23073)) {
                        percent = Misc.getRandom(30);
                    }

                    if (Misc.random(99) + 1 <= percent) {
                        maxHit = victim.getConstitution() * 10;
                    }
                }
            }

            if (player.getEquipment().contains(23230) || player.getEquipment().contains(23231) ||
                    player.getEquipment().contains(23232) || player.getEquipment().contains(23233) ||
                    player.getEquipment().contains(23234) || player.getEquipment().contains(23235) ||
                    player.getEquipment().contains(7995) || player.getEquipment().contains(22109)) {
                maxHit *= 1.2;
            }

            if (player.getEquipment().contains(23280) || player.getEquipment().contains(23292) ||
                    player.getEquipment().contains(23293) || player.getEquipment().contains(23270)) {
                maxHit *= 1.35;
            }

            if (player.getDoubleDMGTimer() > 0) {
                maxHit *= 2;
            }
            if (player.getMinutesVotingDMG() > 0) {
                maxHit *= 2;
            }

            if (player.getEquipment().contains(11676) && player.getEquipment().contains(8839)
                    && player.getEquipment().contains(8840) && player.getEquipment().contains(8842)) {
                maxHit *= 1.2;
            }

            if (player.getLocation() == Locations.Location.FREE_FOR_ALL_ARENA) {
                maxHit = Misc.getRandom(0,30);
            }
        }

        // Dharoks effect
        if (CombatFactory.fullDharoks(entity)) {
            int hitpoints = entity.getConstitution() / 10;
            if (entity.isNpc()) {
                int missingHealth = ((NPC) entity).getDefinition().getHitpoints() - hitpoints;
                double addToHit = missingHealth * 0.01 + 1;
                maxHit *= addToHit;
            } else {
                int missingHealth = ((Player) entity).getSkillManager().getMaxLevel(Skill.CONSTITUTION) - hitpoints;
                double addToHit = missingHealth * 0.01 + 1;
                maxHit *= addToHit;
                if (maxHit >= 990)
                    maxHit = 990;
            }
        }

        if (victim != null && victim.isNpc()) {
            maxHit = NpcMaxHitLimit.limit((NPC) victim, maxHit, CombatType.MELEE);
        }

        return (int) Math.floor(maxHit);
    }

    public static int ranged(Character entity, Character victim) {
        double maxHit = 0;

        if (entity.isNpc()) {
            NPC npc = (NPC) entity;
            maxHit = npc.getDefinition().getMaxHit() / 10;
        } else if (entity.isPlayer()) {
            Player player = (Player) entity;

            double rangedStrength = player.getBonusManager().getOtherBonus()[1];
            double rangeLevel = player.getSkillManager().getCurrentLevel(Skill.RANGED);

            // Prayers
            double prayerMod = 1.0;
            if (PrayerHandler.isActivated(player, PrayerHandler.SHARP_EYE) || CurseHandler.isActivated(player, CurseHandler.LEECH_RANGED)) {
                prayerMod = 1.05;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.HAWK_EYE)) {
                prayerMod = 1.10;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.EAGLE_EYE)) {
                prayerMod = 1.15;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.RIGOUR)) {
                prayerMod = 1.23;
            } else if (CurseHandler.isActivated(player, CurseHandler.TURMOIL)) {
                prayerMod = 1.25;
            } else if (PrayerHandler.isActivated(player,PrayerHandler.SOUL_LEECH)) {
                prayerMod = 1.15 + +(player.getLeechedBonuses()[2] * 0.01);
                if (Misc.getRandom(100) <= 1) {
                    player.setDoubleDMGTimer(1);
                    player.getPacketSender().sendMessage("Coup de grace activated");
                }
            }

            double otherBonuses = 1;

            if (EquipmentBonus.voidRange(player)) {// , CombatType.RANGED)) {
                if (player.getCurrentClanChat() != null
                        && player.getCurrentClanChat().getName().equalsIgnoreCase("debug")) {
                    player.getPacketSender().sendMessage("Void buff applied");
                }
                otherBonuses = 1.2;
            }
            if (EquipmentBonus.voidmRange(player)) {// , CombatType.RANGED)) {
                if (player.getCurrentClanChat() != null
                        && player.getCurrentClanChat().getName().equalsIgnoreCase("debug")) {
                    player.getPacketSender().sendMessage("Master Void buff applied");
                }
                otherBonuses = 1.2;
            }

            // Do calculations of maxhit...
            double effectiveRangeDamage = (int) (rangeLevel * prayerMod * otherBonuses);

            double baseDamage = 1.6 + effectiveRangeDamage / 10 + rangedStrength / 80 + effectiveRangeDamage * rangedStrength / 640;

            double specialBonus = 1;
            // Special attacks!
            if (player.isSpecialActivated() && player.getCombatSpecial().getCombatType() == CombatType.RANGED) {
                specialBonus = player.getCombatSpecial().getStrengthBonus();
            }

            maxHit = (int) baseDamage * specialBonus;

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()) {
                    if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071
                            || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069) {
                        maxHit *= 1.05;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                        maxHit *= 1.07;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                        maxHit *= 1.10;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                        maxHit *= 1.15;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                        maxHit *= 1.25;
                    }
                }
            }
            if (player.getInventory().contains(23413))
                maxHit *= 1.75;
            else if (player.getInventory().contains(4442)) {
                maxHit *= 1.5;
            }
            if (player.getEquipment().contains(7539)) {
                maxHit *= 1.5;
            }

            if (player.getEquipment().contains(23230) || player.getEquipment().contains(23231) ||
                    player.getEquipment().contains(23232) || player.getEquipment().contains(23233) ||
                    player.getEquipment().contains(23234) || player.getEquipment().contains(23235) ||
                    player.getEquipment().contains(7995) || player.getEquipment().contains(22109)) {
                maxHit *= 1.2;
            }

            if (player.getEquipment().contains(23280) || player.getEquipment().contains(23292) ||
                    player.getEquipment().contains(23293) || player.getEquipment().contains(23270)) {
                maxHit *= 1.35;
            }
            int RangeDamage = Misc.getRandom(1, 100);
            if (player.isMembershipUnlocked() == true && RangeDamage > 90) {
                maxHit *= 2;
            }
            if (player.getArcherMaster() == true) {
                maxHit *= 1.2;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                maxHit *= 1.15D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {// admin pet
                maxHit *= 1.25D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SUMMER_SURFER.npcId) {// admin pet
                maxHit *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {// admin pet
                maxHit *= 1.30D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if(ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_DMG) {
                maxHit *= 2;
            }
            if(player.getRights() == PlayerRights.TANZANITE_DONATOR) {
                maxHit *= 1.75D;
            }
            if (player.getRights() == PlayerRights.ZENYTE_DONATOR) {
                maxHit *= 1.5D;
            }
            if (player.getRights() == PlayerRights.ONYX_DONATOR) {
                maxHit *= 1.35D;
            }
            if (player.getRights() == PlayerRights.DIAMOND_DONATOR) {
                maxHit *= 1.25D;
            }
            if (player.getRights() == PlayerRights.RUBY_DONATOR) {
                maxHit *= 1.15D;
            }
            if (player.getRights() == PlayerRights.EMERALD_DONATOR) {
                maxHit *= 1.10D;
            }
            if(player.getRights() == PlayerRights.SAPPHIRE_DONATOR) {
                maxHit *= 1.10D;
            }
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 20592 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15916 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 13800) {
                maxHit *= 2;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1906) {
                maxHit *= 1.1D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1801) {// admin pet
                maxHit *= 1.15D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9013) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9016) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getEquipment().contains(23034) &&
                    player.getEquipment().contains(23035) &&
                    player.getEquipment().contains(23036)) {
                maxHit *= 1.10;
            }

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()
                        && victim.getConstitution() >= ((NPC) victim).getDefaultConstitution()) {
                    int percent = -1;
                    if (player.getEquipment().contains(23071)) {
                        percent = Misc.getRandom(5);
                    } else if (player.getEquipment().contains(23069)) {
                        percent = Misc.getRandom(10);
                    } else if (player.getEquipment().contains(23070)) {
                        percent = Misc.getRandom(15);
                    } else if (player.getEquipment().contains(23074)) {
                        percent = Misc.getRandom(20);
                    } else if (player.getEquipment().contains(23072)) {
                        percent = Misc.getRandom(25);
                    } else if (player.getEquipment().contains(23073)) {
                        percent = Misc.getRandom(30);
                    }
                    if (Misc.random(99) + 1 <= percent) {
                        maxHit = victim.getConstitution();
                    }
                }
            }
            if (player.getDoubleDMGTimer() > 0) {
                maxHit *= 2;
            }
            if (player.getMinutesVotingDMG() > 0) {
                maxHit *= 2;
            }
            if (player.getEquipment().contains(11675) && player.getEquipment().contains(8839)
                    && player.getEquipment().contains(8840) && player.getEquipment().contains(8842)) {
                maxHit *= 1.2;
            }
            if (player.getLocation() == Locations.Location.FREE_FOR_ALL_ARENA) {
                maxHit = Misc.getRandom(0,25);
            }
        }

        maxHit *= 10;

        if (victim != null && victim.isNpc()) {
            maxHit = (int) NpcMaxHitLimit.limit((NPC) victim, maxHit, CombatType.RANGED);
        }
        return (int) Math.floor(maxHit);
    }

    public static int magic(Character entity, Character victim) {
        double maxHit = 0;

        if (entity.isNpc()) {
            NPC npc = (NPC) entity;
            maxHit = npc.getDefinition().getMaxHit() / 10;
        } else if (entity.isPlayer()) {
            Player player = (Player) entity;

            double magicStrength = player.getBonusManager().getOtherBonus()[3];
            double magicLevel = player.getSkillManager().getCurrentLevel(Skill.MAGIC);

            // Prayers
            double prayerMod = 1.0;
            if (PrayerHandler.isActivated(player, PrayerHandler.MYSTIC_WILL) || CurseHandler.isActivated(player, CurseHandler.LEECH_MAGIC)) {
                prayerMod = 1.05;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.MYSTIC_LORE)) {
                prayerMod = 1.10;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.MYSTIC_MIGHT)) {
                prayerMod = 1.15;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.AUGURY)) {
                prayerMod = 1.23;
            } else if (CurseHandler.isActivated(player, CurseHandler.TURMOIL)) {
                prayerMod = 1.25;
            } else if(PrayerHandler.isActivated(player, PrayerHandler.SOUL_LEECH)){
                prayerMod = 1.25 + +(player.getLeechedBonuses()[2] * 0.01);
                if (Misc.getRandom(100) <= 1) {
                    player.setDoubleDMGTimer(1);
                    player.getPacketSender().sendMessage("Coup de grace activated");
                }
            }
            double otherBonuses = 1;

            // Void hits 10% more
            // Do calculations of maxhit...
            double effectiveMagicDamage = (int) (magicLevel * prayerMod * otherBonuses);


            double baseDamage = 2 + effectiveMagicDamage / 10 + magicStrength / 80 + effectiveMagicDamage * magicStrength / 640;

            double specialBonus = 1;
            // Special attacks!
            if (player.isSpecialActivated() && player.getCombatSpecial().getCombatType() == CombatType.MAGIC) {
                specialBonus = player.getCombatSpecial().getStrengthBonus();
            }

            maxHit = (int) baseDamage * specialBonus;

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()) {
                    if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071
                            || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069) {
                        maxHit *= 1.05;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                        maxHit *= 1.07;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                        maxHit *= 1.10;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                        maxHit *= 1.15;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                        maxHit *= 1.25;
                    }
                }
            }
            if (player.getEquipment().contains(23230) || player.getEquipment().contains(23231) ||
                    player.getEquipment().contains(23232) || player.getEquipment().contains(23233) ||
                    player.getEquipment().contains(23234) || player.getEquipment().contains(23235) ||
                    player.getEquipment().contains(7995) || player.getEquipment().contains(22109)) {
                maxHit *= 1.2;
            }

            if (player.getEquipment().contains(23280) || player.getEquipment().contains(23292) ||
                    player.getEquipment().contains(23293) || player.getEquipment().contains(23270)) {
                maxHit *= 1.35;
            }
            if (player.getEquipment().contains(23048)) { //Tier 5 Aura
                maxHit *= 1.05D;
            }
            if (player.getEquipment().contains(23049)) { //Tier 6 Aura
                maxHit *= 1.10D;
            }
            if (player.getInventory().contains(23413))
                maxHit *= 1.75;
            else if (player.getInventory().contains(4442)) {
                maxHit *= 1.5;
            }
            if (player.getEquipment().contains(7539)) {
                maxHit *= 1.5;
            }
            int MagicDamage = Misc.getRandom(1, 100);
            if (player.isMembershipUnlocked() == true && MagicDamage > 90) {
                maxHit *= 2;
            }
            if (player.getMagicianMaster() == true) {
                maxHit *= 1.2;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                maxHit *= 1.15D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {// admin pet
                maxHit *= 1.25D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SUMMER_SURFER.npcId) {// admin pet
                maxHit *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {// admin pet
                maxHit *= 1.30D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {// admin pet
                maxHit *= 1.25D;
            }

            if(ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_DMG) {
                maxHit *= 2;
            }
            if(player.getRights() == PlayerRights.TANZANITE_DONATOR) {
                maxHit *= 1.75D;
            }
            if (player.getRights() == PlayerRights.ZENYTE_DONATOR) {
                maxHit *= 1.5D;
            }
            if (player.getRights() == PlayerRights.ONYX_DONATOR) {
                maxHit *= 1.35D;
            }
            if (player.getRights() == PlayerRights.DIAMOND_DONATOR) {
                maxHit *= 1.25D;
            }
            if (player.getRights() == PlayerRights.RUBY_DONATOR) {
                maxHit *= 1.15D;
            }
            if (player.getRights() == PlayerRights.EMERALD_DONATOR) {
                maxHit *= 1.10D;
            }
            if(player.getRights() == PlayerRights.SAPPHIRE_DONATOR) {
                maxHit *= 1.10D;
            }
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 20592 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15916 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 13800) {
                maxHit *= 2;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1906) {
                maxHit *= 1.1D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1801) {// admin pet
                maxHit *= 1.15D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9013) {// admin pet
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9016) {// admin pet
                maxHit *= 1.25D;
            }
            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()
                        && victim.getConstitution() >= ((NPC) victim).getDefaultConstitution()) {
                    int percent = -1;
                    if (player.getEquipment().contains(23071)) {
                        percent = Misc.getRandom(5);
                    } else if (player.getEquipment().contains(23069)) {
                        percent = Misc.getRandom(10);
                    } else if (player.getEquipment().contains(23070)) {
                        percent = Misc.getRandom(15);
                    } else if (player.getEquipment().contains(23074)) {
                        percent = Misc.getRandom(20);
                    } else if (player.getEquipment().contains(23072)) {
                        percent = Misc.getRandom(25);
                    } else if (player.getEquipment().contains(23073)) {
                        percent = Misc.getRandom(30);
                    }
                    if (Misc.random(99) + 1 <= percent) {
                        maxHit = victim.getConstitution();
                    }
                }
            }
            if (player.getDoubleDMGTimer() > 0) {
                maxHit *= 2;
            }
            if (player.getMinutesVotingDMG() > 0) {
                maxHit *= 2;
            }

            if (player.getEquipment().contains(11674) && player.getEquipment().contains(8839)
                    && player.getEquipment().contains(8840) && player.getEquipment().contains(8842)) {
                maxHit *= 1.2;
            }
            if (player.getLocation() == Locations.Location.FREE_FOR_ALL_ARENA) {
                maxHit = Misc.getRandom(0,28);
            }
        }

        maxHit *= 10;


        if (victim != null && victim.isNpc()) {
            maxHit = (int) NpcMaxHitLimit.limit((NPC) victim, maxHit, CombatType.RANGED);
        }
        return (int) Math.floor(maxHit);
    }

    public static double getEffectiveStr(Player player) {
        double styleBonus = 0;
        FightStyle style = player.getFightType().getStyle();

        double otherBonus = 1;

        double prayerMod = 1.0;
        double random = Math.random() * 10;
        if (PrayerHandler.isActivated(player, PrayerHandler.BURST_OF_STRENGTH) || CurseHandler.isActivated(player, CurseHandler.LEECH_STRENGTH)) {
            prayerMod = 1.05;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.SUPERHUMAN_STRENGTH)) {
            prayerMod = 1.1;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.ULTIMATE_STRENGTH)) {
            prayerMod = 1.15;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.CHIVALRY)) {
            prayerMod = 1.18;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.PIETY)) {
            prayerMod = 1.23;
        } else if (CurseHandler.isActivated(player, CurseHandler.TURMOIL)) {
            prayerMod = 1.25;
        } else if(PrayerHandler.isActivated(player, PrayerHandler.SOUL_LEECH)) {
            prayerMod = 1.15 + +(player.getLeechedBonuses()[2] * 0.01);
            if (Misc.getRandom(100) <= 1) {
                player.setDoubleDMGTimer(1);
                player.getPacketSender().sendMessage("Coup de grace activated");

            }
        }

        int number = (int) (player.getSkillManager().getCurrentLevel(Skill.STRENGTH) * prayerMod * otherBonus + styleBonus);
        return number;
    }

}
