package com.ruse.world.content.raids.shadows;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.Cases;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class Shadows {

    public static void start(ShadowRaidParty party) {

        Player p = party.getOwner();
        p.getPacketSender().sendInterfaceRemoval();

        if (party.hasEnteredRaids()) {
            p.getPacketSender().sendMessage("your party is already in a raids!");
            return;
        }

        if (party.getOwner() != p) {
            p.getPacketSender().sendMessage("Only the party leader can start the raid.");
            return;
        }

        for (Player member : party.getPlayers()) {
            if (member != null) {
                member.getPacketSender().sendInterfaceRemoval();
                if (member.getSummoning().getFamiliar() != null) {
                    member.getPacketSender()
                            .sendMessage("You must dismiss your familiar before being allowed to enter a dungeon.");
                    p.getPacketSender().sendMessage(
                            "" + p.getUsername() + " has to dismiss their familiar before you can enter the dungeon.");
                    return;
                }
            }
        }

        party.enteredDungeon(true);
        final int height = p.getIndex() * 4;
        World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.SHADOWS_OF_DARKNESS, height, null));

        for (Player member : party.getPlayers()) {
            member.getPacketSender().sendInterfaceRemoval();
            member.setRegionInstance(null);
            member.getMovementQueue().reset();
            member.getClickDelay().reset();
            member.moveTo(new Position(3216, 2887, height));
            PrayerHandler.deactivateAll(member);
            CurseHandler.deactivateAll(member);
            TaskManager.submit(new Task(2, false) {

                @Override
                public void execute() {
                    PrayerHandler.deactivateAll(member);
                    CurseHandler.deactivateAll(member);
                    stop();
                }
            });
            member.getSkillManager().stopSkilling();
            member.getPacketSender().sendClientRightClickRemoval();
            member.getPacketSender().sendCameraNeutrality();
            member.setInsideRaids(false);
            member.setEnteredShadowRaids(false);
            member.setShadowRaidsParty(party);
        }
        party.setDeathCount(0);
        party.setKills(0);
        party.sendMessage("You arrive in a cold, empty, dungeon of darkness.");
        party.setCurrentPhase(1);
        party.setHeight(height);
        party.startShadowRaid();

    }
    public static void firstWave(ShadowRaidParty party) {
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 25000000;

            NPC npc = new NPC(ShadowData.firstWaveNpc, new Position(3216, 2891, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(5, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 1);
                stop();
            }
        });
    }

    public static void secondWave(ShadowRaidParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 25000000;
            NPC npc = new NPC(ShadowData.secondWaveNpc, new Position(3237, 2891, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(5, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 2);
                stop();
            }
        });
    }

    public static void thirdWave(ShadowRaidParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 25000000;
            NPC npc = new NPC(ShadowData.thirdWaveNpc, new Position(3225, 2907, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);

        TaskManager.submit(new Task(5, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 3);
                stop();
            }
        });
    }
    public static void finalWave(ShadowRaidParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 25000000;
        NPC npc = new NPC(ShadowData.finalWaveNpc, new Position(3206, 2913, party.getHeight()));
        npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npcs.add(npc);

        TaskManager.submit(new Task(5, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 4);
                stop();
            }
        });
    }

    public static void startTask(ShadowRaidParty party, ArrayList<NPC> npcs, int wave) {
        TaskManager.submit(new Task(1, false) {

            @Override
            public void execute() {

                TaskManager.submit(new Task(1, false) {
                    int tick = 0;

                    @Override
                    protected void execute() {
                        if ((party.getOwner().getLocation() != Locations.Location.SHADOWS_OF_DARKNESS)
                                || party.getPlayers().size() <= 0) {
                            party.sendMessage("@red@Your party has failed to complete the Shadows of Darkness Raid!");
                            destroyInstance(party);
                            stop();
                            
                            
                        }

                        if (!party.hasEnteredRaids())
                            stop();

                        int count = 0;
                        for (NPC npc : npcs) {
                            if (npc.getConstitution() <= 0)
                                count++;
                        }
                        if (count >= npcs.size()) {
                            if (wave == 1)
                                secondWave(party);
                            else if (wave == 2)
                                thirdWave(party);
                            else if (wave == 3)
                                finalWave(party);
                            else
                                finishRaid(party);
                            stop();
                        }

                        if (tick == 3) {
                            if (wave == 1)
                                party.sendMessage("@red@The first wave has started!");
                            else if (wave == 2)
                                party.sendMessage("@red@The second wave has started!");
                            else if (wave == 3)
                                party.sendMessage("@red@The third wave has started!");
                            else if (wave == 4)
                                party.sendMessage("@red@The final wave has started!");
                            for (NPC npc : npcs) {
                                spawnNpc(party, npc);
                            }
                        }

                        tick++;
                    }

                });

                stop();
            }
        });

    }

    public static void spawnNpc(ShadowRaidParty party, NPC npc) {
        World.register(npc);
        Player player = randomPlayer(party);
        npc.getMovementQueue().setFollowCharacter(player);
        npc.getCombatBuilder().attack(player);
    }

    public static void handleDeath(ShadowRaidParty party, Player player) {
        player.moveTo(new Position(3280, 2891 , party.getHeight()));
        player.sendMessage("@red@You died and were sent to beginning of the shadows.");
    }

    public static Player randomPlayer(ShadowRaidParty party) {
        return party.getPlayers().get(Misc.getRandom(party.getPlayers().size() - 1));
    }

    public static void finishRaid(ShadowRaidParty party) {

        party.enteredDungeon(false);

        for (Player member : party.getPlayers()) {
        member.getPacketSender().sendInterfaceRemoval();
    }

        TaskManager.submit(new Task(3, false) {

        @Override
        public void execute() {
            party.sendMessage("@red@Your party has defeated the Shadows of Darkness!");

            for (Player player : party.getPlayers()) {
                for (Player member : party.getPlayers()) {
                    member.getInventory().add(23370, 1);
                    member.getSeasonPass().addXp(2);
                    Cases.grantCasket(player, 10);
                    if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.RAIDS_LOOT) {
                        member.getInventory().add(23370, 1);
                    }
                    member.getAchievementTracker().progress(AchievementData.RAIDER, 1);
                    member.getPointsHandler().incrementSufferingKC(1);
                }
                party.moveTo(ShadowData.lobbyPosition);
                player.getShadowRaidsParty().enteredDungeon(false);
                party.setDeathCount(0);
                party.setKills(0);
                party.setCurrentPhase(1);

            }
            party.getPlayers().clear();
            stop();
        }
    });

}


    public static Box getLoot(Box[] loot, int size) {

        Box[] possibleDrops = new Box[loot.length];
        int possibleDropsCount = 0;
        for (Box drop : loot) {
            if (Misc.getRandom(100 * size) <= drop.getRate()) {
                possibleDrops[possibleDropsCount++] = drop;
            }
        }

        if (possibleDropsCount > 0) {
            return possibleDrops[Misc.getRandom((possibleDropsCount - 1))];
        } else {
            return loot[Misc.getRandom((possibleDropsCount - 1))];
        }
    }

    public static void destroyInstance(ShadowRaidParty party) {

        for (Player member : party.getPlayers()) {
            member.setEnteredShadowRaids(false);
        }
        party.moveTo(ShadowData.lobbyPosition);
        party.enteredDungeon(false);
        party.getPlayers().clear();

        for (NPC npc : party.getNpcs()) {
            if (npc != null && npc.getPosition().getZ() == party.getHeight())
                World.deregister(npc);
        }
    }

}
