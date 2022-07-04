package com.ruse.world.content.quests;

import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;

/*
 * Project Avalon
 * Author @Avalon (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/23/2022
 */
public class QuestDialogues {

    /**
     * Dialogues that can't be handled by XML
     */

    public static Dialogue questBloodRunsDeepIntro(final Player player) {
        return new Dialogue() {


            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 6040;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I need your help adventurer.";
                return new String[]{"" + line1 + ""};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "This sick man has showed up at my house";
                        String line2 = "He washed ashore, and has been asleep since.";
                        return new String[]{"" + line1 + "", "" + line2 + "", ""};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }


                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.NPC_STATEMENT;
                            }

                            @Override
                            public int npcId() {
                                return 6040;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "We have to help this sick old man!";
                                String line2 = "Travel into his dreams and obtain a Lecturn";
                                String line3 = "You then need to successfully fight off the Army.";
                                return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8621);
                            }

                            @Override
                            public Dialogue nextDialogue() {
                                return new Dialogue() {

                                    @Override
                                    public DialogueType type() {
                                        return DialogueType.NPC_STATEMENT;
                                    }

                                    @Override
                                    public int npcId() {
                                        return 6040;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "Afterwards, you will have to enter the Spiritual Realm";
                                        String line2 = "and retrieve the Prophecy Tablet.";
                                        String line3 = "Use it on the Lecturn to Craft a Daggonoth Lair Teleport";
                                        String line4 = "Their you will need to Defeat the Daggonoth Mother";
                                        return new String[]{"" + line1 + "", "" + line2
                                                + "", "" + line3 + "", "" + line4};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(8621);
                                    }

                                    @Override
                                    public Dialogue nextDialogue() {
                                        return new Dialogue() {

                                            @Override
                                            public DialogueType type() {
                                                return DialogueType.NPC_STATEMENT;
                                            }

                                            @Override
                                            public int npcId() {
                                                return 6040;
                                            }

                                            @Override
                                            public DialogueExpression animation() {
                                                return DialogueExpression.NORMAL;
                                            }

                                            @Override
                                            public String[] dialogue() {
                                                String line1 = "After you defeat the Dagganoth Mother";
                                                String line2 = "obtain the Enchanted herbs and return them to me.";
                                                String line3 = "I will then reward you for helping me save the man.";
                                                return new String[]{"" + line1 + "", "" + line2
                                                        + "", "" + line3};
                                            }

                                            @Override
                                            public void specialAction() {
                                                player.setDialogueActionId(8621);
                                            }



                                            @Override
                                            public Dialogue nextDialogue() {
                                                return new Dialogue() {

                                                    @Override
                                                    public DialogueType type() {
                                                        return DialogueType.OPTION;
                                                    }

                                                    @Override
                                                    public int npcId() {
                                                        return 6040;
                                                    }

                                                    @Override
                                                    public DialogueExpression animation() {
                                                        return DialogueExpression.NORMAL;
                                                    }

                                                    @Override
                                                    public String[] dialogue() {
                                                        String line1 = "Help Ksenia retrieve the Enchanted Herbs.";
                                                        String line2 = "No thanks, i didn't sign up for this.";
                                                        return new String[]{"" + line1 + "", "" + line2};
                                                    }

                                                    @Override
                                                    public void specialAction() {
                                                        player.setDialogueActionId(8621);
                                                    }
                                                };
                                            }
                                        };
                                    }

                                };
                            }
                        };
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepAccept(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Im not afraid of anything, You can count on me.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }
            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Good luck on your quest, adventurer!";
                        String line2 = "Speak to me when you're ready to teleport.";
                        return new String[]{"" + line1 + "", "" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }

        };

    }

    public static Dialogue questBloodRunsDeepDream(final Player player) {
        return new Dialogue() {
                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 305;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Hello Adventurer, i was starting to wonder if we would ";
                        String line2 = "make it out alive, now hurry! we don't have all day ";
                        String line3 = "You need to craft a lectern using ingredients obtained here.";
                        String line4 = "This will require 25 Iron nails and 10 Drowsy Branches.";
                        return new String[]{"" + line1+ "", "" + line2+ "", "" + line3+ "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 305;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "You will also need to kill 50 Spirit Dagonoths.";
                        String line2 = "Good luck adventurer, and may the Avalon Gods be with you.";
                        return new String[]{"" + line1+ "", "" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepEnterRealm(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 6040;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Excellent work adventurer, I have another request to ask.";
                String line2 = "King Vargas holds an ancient tablet that can be used on";
                String line3 = "the lectern, granting us a teleport to the Dagonoth Cave.";
                String line4 = "Speak with King Vargas in the Spiritual Realm, tell him I sent you.";
                return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Rumor has it a ghost haunts the Lumbridge Graveyard";
                        String line2 = "whom will take you into the Spiritual Realm.";
                        String line3 = "Father Reen has a Ghostspeak amulet for you";
                        String line4 = "Speak with him at Lumbridge to obtain it.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepFatherReen(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 2899;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Hello adventurer, what brings you around Lumbridge?";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public int npcId() {
                        return 2899;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "I have a ghost haunting me.";
                        String line2 = "I'm looking for a Ghost-speak Amulet";
                        String line3 = "Nothing, I'm leaving.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepFatherReen2(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 2899;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I have a ghost haunting me at night, what do i do?";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 2899;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "No need to fear my child, this is quite common.";
                        String line2 = "You can use a Holy symbol on this amulet here,";
                        String line3 = "to achieve the ability to talk to ghosts.";
                        String line4 = "Pick up the Holy symbol behind the pew over there.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
                    }

                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.ITEM_STATEMENT;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                player.getInventory().add(23369, 1);
                                return new String[]{"" + "Father Reen gives you an Holy amulet."};
                            }

                            @Override
                            public String[] item() {
                                return new String[] { "" + 552 + "", "180", "" + "Holy amulet" + "" };
                            }
                        };
                    }
                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepLumbridgeGhost(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 1541;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Hello, I hear you can help me get to the Spirit Realm.";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 1541;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "The Spirit Realm? Who told you this?";
                        String line2 = "WAIT!!? How can you understand me?";
                        return new String[]{"" + line1 + "","" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
                    }

                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.PLAYER_STATEMENT;
                            }

                            @Override
                            public int npcId() {
                                return 1541;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "Ksenia has sent me, she needs my help.";
                                String line2 = "I have crafted a ghost-speak amulet to talk to you.";
                                String line3 = "She said I need to talk to King Vargas in the Realm";
                                String line4 = "to obtain the Prophecy tablet.";
                                return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8625);
                            }

                            @Override
                            public Dialogue nextDialogue() {
                                return new Dialogue() {

                                    @Override
                                    public DialogueType type() {
                                        return DialogueType.NPC_STATEMENT;
                                    }

                                    @Override
                                    public int npcId() {
                                        return 1541;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        player.setTalkedToGhost(true);
                                        String line1 = "Very well traveler, I will open a rift for you.";
                                        String line2 = "Make sure you have the proper equipment before entering.";
                                        String line3 = "The Spirit Realm has been known for it's tales.";
                                        String line4 = "The Rift is located in the Shed, When you are ready.";
                                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(8625);
                                    }
                                };
                            }

                        };
                    }

                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepLumbridgeGhostGibberish(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1541;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Wooo wooo wooooo";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8625);
            }
        };
    }

    public static Dialogue questBloodRunsDeepFatherReen3(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 2899;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I'm in search of an ghost-speak amulet.";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 2899;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "A ghost-speak Amulet? You should know";
                        String line2 = "Speaking to ghosts can lead to some terrible";
                        String line3 = "outcomes, these cheeky ghosts haunt the Lumbridge";
                        String line4 = "Graveyard. Some nights you can hear them boo-ing.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
                    }

                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.NPC_STATEMENT;
                            }

                            @Override
                            public int npcId() {
                                return 2899;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "I have a Holy Amulet that can be used with";
                                String line2 = "an Holy Symbol. Together they make a ghost-speak";
                                String line3 = "Amulet. You can gather the holy symbol from behind";
                                String line4 = "the church pew over there. Good luck, adventurer.";
                                return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8625);
                            }

                            @Override
                            public Dialogue nextDialogue() {
                                return new Dialogue() {

                                    @Override
                                    public DialogueType type() {
                                        return DialogueType.ITEM_STATEMENT;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        player.getInventory().add(23369, 1);
                                        return new String[]{"" + "Father Reen gives you an Holy amulet."};
                                    }

                                    @Override
                                    public String[] item() {
                                        return new String[] { "" + 552 + "", "180", "" + "Holy amulet" + "" };
                                    }
                                };
                            }

                        };
                    }

                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepDreamComplete(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 305;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Excellent work adventurer, speak to Ksenia for your next assignment";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


        };
    }


    public static Dialogue questBloodRunsDeepDecline(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Sorry Ksenia, this doesn't sound to safe for me.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Come back when you are ready, adventurer.";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepInProgress(final Player player) {
        return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public int npcId() {
                        return -1;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Teleport";
                        String line2 = "Cancel";
                        return new String[]{"" + line1 + "", "" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8622);
                    }
                };
        };
    }