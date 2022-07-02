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

    public static Dialogue questCurseOfArravIntro(final Player player) {
        return new Dialogue() {


            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 5983;
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
                        return 5983;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "My Heart was stolen by A powerful necromancer,";
                        String line2 = "who goes by the name Zemouregal.";
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
                                return 5983;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "The first step to retrieving my heart";
                                String line2 = "is by obtaining a canopic jar.";
                                String line3 = "Speak to Ali the Wise in Shantay pass to get the jar.";
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
                                        return 5983;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "Once you retrieve the empty canopic jar you must fill it.";
                                        String line2 = "You need to put dwellberries and sacred oil in the jar.";
                                        String line3 = "You can receive sacred oil from the Apothecary in Varrock.";
                                        String line4 = "You can pick dwellberries near the Goblin Village";
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
                                                return 5983;
                                            }

                                            @Override
                                            public DialogueExpression animation() {
                                                return DialogueExpression.NORMAL;
                                            }

                                            @Override
                                            public String[] dialogue() {
                                                String line1 = "After you gather all the ingredients,";
                                                String line2 = "Fill the jar with them and return to me";
                                                String line3 = "I will then send you to Zemouregal's cave to obtain my heart.";
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
                                                        return 5983;
                                                    }

                                                    @Override
                                                    public DialogueExpression animation() {
                                                        return DialogueExpression.NORMAL;
                                                    }

                                                    @Override
                                                    public String[] dialogue() {
                                                        String line1 = "Help Arrav retrieve his heart.";
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


    public static Dialogue questCurseOfArravAccept(final Player player) {
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
                        return 5983;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Good luck on your quest, adventurer!";
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

    public static Dialogue questCurseOfArravDecline(final Player player) {
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
                String line1 = "Sorry Arrav, i seek to live another day.";
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
                        return 5983;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Come back when you are not scared to die.";
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
}