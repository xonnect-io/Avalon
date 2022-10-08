package com.ruse.world.content.raids;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Item;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.Cases;
import com.ruse.world.content.boxes.SODRaidLoot;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class SODRaids {

    public static void start(RaidsParty party) {

        Player p = party.getOwner();
        p.getPacketSender().sendInterfaceRemoval();

        if (party.hasEnteredRaids()) {
            p.getPacketSender().sendMessage("your party is already in a raids!");
            return;
        }

        if (party.getOwner() != p) {
            p.getPacketSender().sendMessage("Only the party leader can start the fight.");
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
        World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.SOD, height, null));

        for (Player member : party.getPlayers()) {
            member.getPacketSender().sendInterfaceRemoval();
            member.setRegionInstance(null);
            member.getMovementQueue().reset();
            member.getClickDelay().reset();
            member.moveTo(new Position(3445, 3978 , height));
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
            member.setEnteredSODRaids(false);
            member.setRaidsParty(party);
        }
        party.setDeathCount(0);
        party.setKills(0);
        party.sendMessage("The Unholy Spirits welcome you to the Souls of Suffering.");
        party.setCurrentPhase(1);
        party.setHeight(height);
        party.startSODRaid();

    }

    public static NPC addNpc(RaidsParty party, int npcId, double mult) {
        NPC npc = (new NPC(npcId, new Position(2244 + Misc.getRandom(16), 4104 + Misc.getRandom(19), party.getHeight())));
        npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        return npc;
    }

    public static void firstWave(RaidsParty party) {
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 2500;

            NPC npc = new NPC(SODRaidData.firstWaveNpc, new Position(3422, 3978, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startSODTask(party, npcs, 1);
                stop();
            }
        });
    }

    public static void secondWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 5000;
            NPC npc = new NPC(SODRaidData.secondWaveNpc, new Position(3402, 3986, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startSODTask(party, npcs, 2);
                stop();
            }
        });
    }

    public static void thirdWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 10000;
            NPC npc = new NPC(SODRaidData.thirdWaveNpc, new Position(3403, 4017, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);

        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startSODTask(party, npcs, 3);
                stop();
            }
        });
    }

    public static void fourthWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 20000;

            NPC npc = new NPC(SODRaidData.fourthWaveNpc, new Position(3435, 4017, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startSODTask(party, npcs, 4);
                stop();
            }
        });
    }

    public static void fifthWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();

        double mult = 100000;

        NPC npc = new NPC(SODRaidData.fifthWaveNpc, new Position(3420, 3998, party.getHeight()));
        npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npcs.add(npc);

        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startSODTask(party, npcs, 5);
                stop();
            }
        });
    }

    public static void startSODTask(RaidsParty party, ArrayList<NPC> npcs, int wave) {
        TaskManager.submit(new Task(1, false) {

            @Override
            public void execute() {

                TaskManager.submit(new Task(1, false) {
                    int tick = 0;

                    @Override
                    protected void execute() {
                        if ((party.getOwner().getLocation() != Locations.Location.SOD)
                                || party.getPlayers().size() <= 0) {
                            party.sendMessage("@red@Your party has failed to complete the Souls of Suffering Raid!");
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
                                fourthWave(party);
                            else if (wave == 4)
                                fifthWave(party);
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
                                party.sendMessage("@red@The fourth wave has started!");
                            else if (wave == 5)
                                party.sendMessage("@red@The final wave of suffering has started!");
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

    public static void spawnNpc(RaidsParty party, NPC npc) {
        World.register(npc);
        Player player = randomPlayer(party);
        npc.getMovementQueue().setFollowCharacter(player);
        npc.getCombatBuilder().attack(player);
    }

    public static void handleDeath(RaidsParty party, Player player) {
        party.getPlayers().remove(player);
        party.remove(player, true);
        player.sendMessage("@red@You died and were removed from the raid party.");
    }

    public static Player randomPlayer(RaidsParty party) {
        return party.getPlayers().get(Misc.getRandom(party.getPlayers().size() - 1));
    }

    public static void finishRaid(RaidsParty party) {
        party.enteredDungeon(false);

        for (Player member : party.getPlayers()) {
            member.getPacketSender().sendInterfaceRemoval();
        }

        TaskManager.submit(new Task(3, false) {

            @Override
            public void execute() {
                party.sendMessage("@red@Your party has defeated the Souls of Suffering!");

                for (Player player : party.getPlayers()) {
                    Box[] loot = SODRaidLoot.LOOT;
                    player.setSODRaidsKC(player.getSODRaidsKC() + 1);
                    player.setEnteredSODRaids(false);
                    Box drop = getLoot(loot, party.getPlayers().size());
                    player.getSeasonPass().addXp(2);
                    double amt = drop.getMin() + Misc.getRandom(drop.getMax() - drop.getMin());

                    player.sendMessage("Souls of Suffering raids completed: @red@" + player.getSODRaidsKC());

                    if (player.getInventory().getFreeSlots() > 0) {
                        player.getInventory().add(new Item(drop.getId(), (int) amt));
                    } else {
                        player.getBank(0).add(new Item(drop.getId(), (int) amt));
                        party.sendMessage("@red@Your inventory is full, your raids rewards were banked!");
                    }

                    player.sendMessage("<shad=1>@yel@You have received X" + (int) amt + " "+ ItemDefinition.forId(drop.getId()).getName() + " for your participation!" );

                    if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.X2_RAIDS) {
                        player.getInventory().add(new Item(drop.getId(), (int) amt));
                        player.sendMessage("<col=005fbe>You received x2 loot whilst X2 Raids Perk is active!");
                    }
                    Cases.grantCasket(player, 10);
                }

                party.moveTo(SODRaidData.lobbyPosition);

                party.setDeathCount(0);
                party.setKills(0);
                party.setCurrentPhase(1);
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

    public static void destroyInstance(RaidsParty party) {

        for (Player member : party.getPlayers()) {
            member.setEnteredSODRaids(false);
        }
        party.moveTo(SODRaidData.lobbyPosition);
        party.enteredDungeon(false);
        party.getPlayers().clear();

        for (NPC npc : party.getNpcs()) {
            if (npc != null && npc.getPosition().getZ() == party.getHeight())
                World.deregister(npc);
        }
    }

}
