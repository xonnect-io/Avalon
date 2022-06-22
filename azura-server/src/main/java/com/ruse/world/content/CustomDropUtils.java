package com.ruse.world.content;

import com.ruse.GameSettings;
import com.ruse.model.GameMode;
import com.ruse.model.PlayerRights;
import com.ruse.model.container.impl.Equipment;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.entity.impl.player.Player;
import mysql.impl.Donation;

public class CustomDropUtils {

    /**
     * Increases Drop Rate
     *
     * @param player
     * @return
     */
    public static int drBonus(Player player, int npc) {
        int percentBoost = 0;
        //Auras
        if (player.getEquipment().contains(23271)) { //Celestial Aura
            percentBoost += 60;
        }
        if (player.getEquipment().contains(23241)) { //Owner's Aura (u)
            percentBoost += 45;
        }
        if (player.getEquipment().contains(22111)) { //Owner's Aura (u)
            percentBoost += 35;
        }
        if (player.getEquipment().contains(12630)) { //Donator's Aura
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23049)) { //Tier 6 Aura
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23048)) { //Tier 5 Aura
            percentBoost += 16;
        }
        if (player.getEquipment().contains(23047)) { //Tier 4 Aura
            percentBoost += 13;
        }
        if (player.getEquipment().contains(15449)) { //Extreme Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15450)) { //Extreme Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(4373)) { //Elite winged Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23046)) { //Tier 3 Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23045)) { //Tier 2 Aura
            percentBoost += 6;
        }
        if (player.getEquipment().contains(12608)) { //Tier 1 Aura
            percentBoost += 5;
        }
        if (player.getEquipment().contains(23044)) { //Tier 1 Aura
            percentBoost += 3;
        }

        //End Auras

        //Start Rings

        if (player.getEquipment().contains(23280)) { //Celestial ring
            percentBoost += 75;
        }

        if (player.getEquipment().contains(23280)) { //Owner ring (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(23280)) { //Owner ring
            percentBoost += 50;
        }
        if (player.getEquipment().contains(232588)) { //Plutonic ring
            percentBoost += 40;
        }
        if (player.getEquipment().contains(18818)) { //Collecter ring III
            percentBoost += 30;
        }
        if (player.getEquipment().contains(20093)) { //Cursed ring
            percentBoost += 20;
        }
        if (player.getEquipment().contains(18823)) { //Collecter ring II
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8335)) { //Art's ring
            percentBoost += 20;
        }
        if (player.getEquipment().contains(4446)) { //Collecter ring I
            percentBoost += 10;
        }
        if (player.getEquipment().contains(3324)) { //Ring of wealth(i)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(2572)) { //Ring of wealth(i)
            percentBoost += 5;
        }
        //End rings

        // Start boots

        if (player.getEquipment().contains(23285)) { //Avalon boots
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23224)) { //Nephilim boots
            percentBoost += 40;
        }
        if (player.getEquipment().contains(22103)) { //Fallen Angel's boots
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23263)) { //Reapers boots
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23263)) { //Reapers boots
            percentBoost += 30;
        }
        if (player.getEquipment().contains(18887)) { //Colossal boots
            percentBoost += 25;
        }
        if (player.getEquipment().contains(18881)) { //Deity boots
            percentBoost += 20;
        }
        if (player.getEquipment().contains(9058)) { //Creeper boots
            percentBoost += 15;
        }
        if (player.getEquipment().contains(21612)) { //Custom extreme boots
            percentBoost += 10;
        }
        if (player.getEquipment().contains(20089)) { //Cursed boots
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8274)) { //Legends boots
            percentBoost += 10;
        }
        //End boots

        //Start gloves
        if (player.getEquipment().contains(23292)) { //Celestial bracelet
            percentBoost += 75;
        }
        if (player.getEquipment().contains(23235)) { //Owner bracelet (u)
            percentBoost += 60;
        }

        if (player.getEquipment().contains(23232)) { //Owner bracelet
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23284)) { //Avalon gloves
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23223)) { //Nephilim gloves
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23289)) { //Tanzanite gloves
            percentBoost += 40;
        }
        if (player.getEquipment().contains(22104)) { //Fallen Angel's gloves
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23262)) { //Reaper's gloves
            percentBoost += 30;
        }
        if (player.getEquipment().contains(18885)) { //Colossal gloves
            percentBoost += 25;
        }
        if (player.getEquipment().contains(18883)) { //Deity gloves
            percentBoost += 20;
        }
        if (player.getEquipment().contains(9057)) { //Creeper gloves
            percentBoost += 15;
        }
        if (player.getEquipment().contains(15118)) { //Extreme gloves
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21611)) { //Custom Extreme gloves
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8273)) { //Legends gloves
            percentBoost += 10;
        }
        if (player.getEquipment().contains(20091)) { //Cursed gloves
            percentBoost += 10;
        }
        //End gloves

        //Start capes

        if (player.getEquipment().contains(23268)) { //Cloak of Summer
            percentBoost += 80;
        }
        if (player.getEquipment().contains(23270)) { //Celestial cape
            percentBoost += 75;
        }
        if (player.getEquipment().contains(22109)) { //Owner cape (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(22105)) { //Fallen Angel's Wings
            percentBoost += 50;
        }
        if (player.getEquipment().contains(7995)) { //Owner cape
            percentBoost += 50;
        }
        if (player.getEquipment().contains(20400)) { //Enraged cape
            percentBoost += 40;
        }
        if (player.getEquipment().contains(20591)) { //rage cape
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23133)) { //Legends wings
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20099)) { //Cursed cape
            percentBoost += 10;
        }
        //End capes

        //Start amulets
         if (player.getEquipment().contains(23293)) { //Celestial amulet
                    percentBoost += 75;
               }
        if (player.getEquipment().contains(23293)) { //Owner amulet (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(23293)) { //Owner amulet
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23258)) { //Plutonic amulet
            percentBoost += 40;
        }
        if (player.getEquipment().contains(18888)) { //Collectors amulet III
            percentBoost += 30;
        }
        if (player.getEquipment().contains(20092)) { //Cursed amulet
            percentBoost += 20;
        }
        if (player.getEquipment().contains(19888)) { //Collectors amulet II
            percentBoost += 20;
        }
        if (player.getEquipment().contains(19886)) { //Collectors amulet I
            percentBoost += 10;
        }
        //end amulets

        //start shield
        if (player.getEquipment().contains(22117)) { //Zenyte shield
            percentBoost += 35;
        }
        if (player.getEquipment().contains(18889)) { //Colossal Spirit shield
            percentBoost += 25;
        }
        if (player.getEquipment().contains(19810)) { //Deity Spirit shield
            percentBoost += 20;
        }
        if (player.getEquipment().contains(20090)) { //Cursed Spirit shield
            percentBoost += 10;
        }
        if (player.getEquipment().contains(4018)) { //Extreme offhand
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21610)) { //Custom extreme teddybear
            percentBoost += 10;
        }
        //end shield

        //start weapons

        if (player.getEquipment().contains(23228)) { //Divine bow
            percentBoost += 90;
        }
        if (player.getEquipment().contains(23267)) { //Daemon bow
            percentBoost += 90;
        }
        if (player.getEquipment().contains(23227)) { //Blood legends sword
            percentBoost += 40;
        }
        if (player.getEquipment().contains(8136)) { //Blood legends sword
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23226)) { //Blood legends bow
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23062)) { //Nephilim staff
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23063)) { //Nephilim sword
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23061)) { //Nephilim bow
            percentBoost += 40;
        }
        if (player.getEquipment().contains(22114)) { //Dark legends staff
            percentBoost += 35;
        }
        if (player.getEquipment().contains(22115)) { //Dark legends sword
            percentBoost += 35;
        }
        if (player.getEquipment().contains(22113)) { //Dark legends bow
            percentBoost += 35;
        }
        if (player.getEquipment().contains(17013)) { //Light legends staff
            percentBoost += 30;
        }
        if (player.getEquipment().contains(12537)) { //Light legends sword
            percentBoost += 30;
        }
        if (player.getEquipment().contains(5011)) { //Light legends bow
            percentBoost += 30;
        }
        if (player.getEquipment().contains(3260)) { //Supreme blade
            percentBoost += 25;
        }
        if (player.getEquipment().contains(17011)) { //Legends staff
            percentBoost += 25;
        }
        if (player.getEquipment().contains(12535)) { //Legends sword
            percentBoost += 25;
        }
        if (player.getEquipment().contains(5012)) { //Legends bow
            percentBoost += 25;
        }
        if (player.getEquipment().contains(8410)) { //Elite sword(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8411)) { //Elite bow(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8412)) { //Elite staff(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8253)) { //Elite staff(aoe)
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20098)) { //Defiled minigun
            percentBoost += 10;
        }
        if (player.getEquipment().contains(4017)) { //Extreme glaive
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8087)) { //Dragon rider lance
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8088)) { //Judicator crossbow
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8089)) { //Purifier staff
            percentBoost += 10;
        }
        //end weapons

        //start platelegs
        if (player.getEquipment().contains(23283)) { //Avalon platelegs
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23222)) { //Nephilim platelegs
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23288)) { //Tanzanite platelegs
            percentBoost += 30;
        }
        if (player.getEquipment().contains(22102)) { //Fallen angel's platelegs
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23261)) { //Reapers platelegs
            percentBoost += 20;
        }
        if (player.getEquipment().contains(4686)) { //Legends platelegs
            percentBoost += 15;
        }
        if (player.getEquipment().contains(9056)) { //Creeper platelegs
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20088)) { //Cursed platelegs
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15117)) { //Extreme platelegs
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21609)) { //Extreme platelegs
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8833)) { //Elite legs(melee)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15644)) { //Elite legs(range)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(13847)) { //Elite legs(magic)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(11322)) { //Dragon rider platelegs
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11342)) { //Judicator platelegs
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11423)) { //Purifier robe bottoms
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14912)) { //Demonic torva
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14918)) { //Nature pernix chaps
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14923)) { //Icey virtus chaps
            percentBoost += 5;
        }
        //end platelegs


        //start platebody

        if (player.getEquipment().contains(23282)) { //Avalon platebody
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23221)) { //Nephilim platebody
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23287)) { //Tanzanite platebody
            percentBoost += 30;
        }
        if (player.getEquipment().contains(22101)) { //Fallen angel's platebody
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23260)) { //Reapers platebody
            percentBoost += 20;
        }
        if (player.getEquipment().contains(4685)) { //Legends platebody
            percentBoost += 15;
        }
        if (player.getEquipment().contains(9055)) { //Creeper platebody
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20087)) { //Cursed platebody
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15116)) { //Extreme platebody
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21608)) { //Extreme platebody
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8829)) { //Elite platebody(melee)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15643)) { //Elite platebody(range)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15646)) { //Elite platebody(magic)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(11321)) { //Dragon rider platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11341)) { //Judicator platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11422)) { //Purifier robe top
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14911)) { //Demonic torva platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14917)) { //Nature pernix platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14922)) { //Icey virtus chaps
            percentBoost += 5;
        }
        //end platebody

        //start helmet
        if (player.getEquipment().contains(23281)) { //Avalon helmet
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23220)) { //Nephilim helmet
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23286)) { //Tanzanite helmet
            percentBoost += 30;
        }
        if (player.getEquipment().contains(22100)) { //Fallen angel's helmet
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23072)) { //Boss slayer helmet [5]
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23259)) { //Reaper helmet
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23074)) { //Boss slayer helmet [4]
            percentBoost += 16;
        }
        if (player.getEquipment().contains(4684)) { //Legends helmet
            percentBoost += 15;
        }
        if (player.getEquipment().contains(9054)) { //Creeper helmet
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23070)) { //Boss slayer helmet [3]
            percentBoost += 12;
        }
        if (player.getEquipment().contains(20086)) { //Cursed helmet
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15115)) { //Extreme helmet
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21607)) { //Custom Extreme helmet
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8828)) { //Elite helmet(melee)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15642)) { //Elite helmet(range)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15645)) { //Elite helmet(magic)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23069)) { //Boss slayer helmet [2]
            percentBoost += 8;
        }
        if (player.getEquipment().contains(18419)) { //Universal partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(18416)) { //Water partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(18418)) { //Velvet partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(18417)) { //Firehell partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(11320)) { //Dragon rider helmet
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11340)) { //Judicator helmet
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11421)) { //Purifier hood
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14910)) { //Demon torva helmet
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14916)) { //Nature pernix cowl
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14921)) { //Icey Virtus mask
            percentBoost += 5;
        }
        //end helmet

        if (npc == 9312) {
            percentBoost += player.getNephilimBonus();
        }
        if (npc == 3830) {
            percentBoost += player.getGuardianBonus();
        }
        if (npc == player.getSlayer().getSlayerTask().getNpcId()) {
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071) {
                percentBoost += 5;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069 || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                percentBoost += 7;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                percentBoost += 10;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                percentBoost += 15;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                percentBoost += 20;
            }
        }

        if (!player.isInsideRaids()) {

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.WOLF_PET.npcId) {
                percentBoost += 1;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.GORILLA_PET.npcId) {
                percentBoost += 3;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.MARIO_PET.npcId) {
                percentBoost += 5;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DONKEY_KONG_PET.npcId) {
                percentBoost += 7;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VEGETA_PET.npcId) {
                percentBoost += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YOSHI_PET.npcId) {
                percentBoost += 15;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ZORBAK_PET.npcId) {
                percentBoost += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {
                percentBoost += 60;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FENRIR_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.GREEN_FENRIR_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RED_FENRIR_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.HELLRAISER.npcId) {
                percentBoost += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {
                percentBoost += 70;
            }
        }

        if (player.getInventory().contains(23254)) {
            percentBoost *= 1.5;
        }
        if(ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_DR) {
            percentBoost *= 2;
        }
        /**
         * Donator Rank bonusses
         */
        if(player.getAmountDonated() >= Donation.TANZANITE_DONATION_AMOUNT || player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 100;
        } else if(player.getAmountDonated() >= Donation.ZENYTE_DONATION_AMOUNT) {
            percentBoost += 75;
        } else if(player.getAmountDonated() >= Donation.ONYX_DONATION_AMOUNT) {
            percentBoost += 45;
        } else if(player.getAmountDonated() >= Donation.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 30;
        } else if(player.getAmountDonated() >= Donation.RUBY_DONATION_AMOUNT) {
            percentBoost += 20;
        } else if(player.getAmountDonated() >= Donation.EMERALD_DONATION_AMOUNT) {
            percentBoost += 15;
        } else if(player.getAmountDonated() >= Donation.SAPPHIRE_DONATION_AMOUNT) {
            percentBoost += 5;
        }

        if (player.getInventory().contains(4440)) {
            percentBoost *= 1.5;
        }

        if (GameSettings.DOUBLEDR == true) {
            percentBoost *= 2;
        }

        if (player.getDoubleDRTimer() > 0) {
            percentBoost += 100;
        }
        if (player.getMinutesVotingDR() > 0) {
            percentBoost += 100;
        }

        if (GameSettings.DOUBLE_DROP) {
            percentBoost += 100;
        }


        if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
            percentBoost += 6;
        }
        if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN || player.getGameMode() == GameMode.IRONMAN) {
            percentBoost += 10;
        }
        if (player.getGameMode() == GameMode.VETERAN_MODE) {
            percentBoost += 15;
        }
        if (PrayerHandler.isActivated(player,PrayerHandler.GNOMES_GREED)) {
            percentBoost += 10;
        }

        return percentBoost;
    }


    public static int getDoubleDropChance(Player player, int npc) {
        int percentBoost = 0;

        Equipment equipment = player.getEquipment();
        if (equipment.contains(23092)
                || equipment.contains(23093)
                || equipment.contains(23094)) {// valor rings
			percentBoost += 10;
        }

        if (npc == 8013 && System.currentTimeMillis() + 43200000 > player.lastVoteTime) {
            percentBoost =+ 100;
        }
        if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_DROPS) {
            percentBoost =+ 100;
        }

        if (player.getEquipment().contains(23044)) { //Tier 1 Aura
            percentBoost += 5;
        }
        if (player.getEquipment().contains(23045)) { //Tier 2 Aura
            percentBoost += 7;
        }
        if (player.getEquipment().contains(23046)) { //Tier 3 Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23047)) { //Tier 4 Aura
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23048)) { //Tier 5 Aura
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23049)) { //Tier 6 Aura
            percentBoost += 20;
        }

        if (player.getGameMode() == GameMode.IRONMAN || player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
            percentBoost += 5;
        }
        if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
            percentBoost += 3;
        }
        if (player.getGameMode() == GameMode.VETERAN_MODE) {
			percentBoost += 7;
        }

		// creator set:
		if (player.getEquipment().contains(23127))
			percentBoost += 4;
		if (player.getEquipment().contains(23128))
			percentBoost += 4;
		if (player.getEquipment().contains(23129))
			percentBoost += 4;
		if (player.getEquipment().contains(23130))
			percentBoost += 3;
		if (player.getEquipment().contains(23131))
			percentBoost += 3;
		if (player.getEquipment().contains(23132))
			percentBoost += 3;
		if (player.getEquipment().contains(23133))
			percentBoost += 4;
		//


        if (npc == player.getSlayer().getSlayerTask().getNpcId()) {
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071) {
                percentBoost += 5;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069 || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                percentBoost += 7;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                percentBoost += 10;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                percentBoost += 15;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                percentBoost += 20;
            }
        }

        if (player.getDoubleDDRTimer() > 0) {
            percentBoost += 100;
        }

        /**
         * Donator Rank bonusses
         */
        if (player.getAmountDonated() >= Donation.TANZANITE_DONATION_AMOUNT || player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 30;
        } else
             if (player.getAmountDonated() >= Donation.ZENYTE_DONATION_AMOUNT) {
            percentBoost += 25;
        } else
            if (player.getAmountDonated() >= Donation.ONYX_DONATION_AMOUNT) {
            percentBoost += 20;
        } else
            if (player.getAmountDonated() >= Donation.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 15;
        } else
            if (player.getAmountDonated() >= Donation.RUBY_DONATION_AMOUNT) {
            percentBoost += 10;
        } else
            if (player.getAmountDonated() >= Donation.EMERALD_DONATION_AMOUNT) {
            percentBoost += 7;
        } else
            if (player.getAmountDonated() >= Donation.SAPPHIRE_DONATION_AMOUNT) {
            percentBoost += 5;
        }


        if (PrayerHandler.isActivated(player,PrayerHandler.GNOMES_GREED)) {
            percentBoost += 10;
        }

        return percentBoost;
    }

}
