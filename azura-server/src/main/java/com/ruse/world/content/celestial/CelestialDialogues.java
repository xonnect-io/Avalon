package com.ruse.world.content.celestial;

import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;
    /*
     * Project Avalon
     * Author @Avalon (AlwaysDreaming.ai@gmail.com)
     * Created on - 6/23/2022
     */
public class CelestialDialogues {

    /**
     * Dialogues that can't be handled by XML
     */
    public static Dialogue main(final Player player) {
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
                return DialogueExpression.NO_EXPRESSION;
            }

            @Override
            public String[] dialogue() {
                return new String[] { "How to become a Celestial?", "What is the Celestial Zone?",
                        "What is the Celestial Energy?", "Cancel" };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
            }

        };
    }

    public static Dialogue becomingCelestial(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1821;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "To become a Celestial you must:";
                String line2 = "- Complete x50 Souls of Suffering Waves";
                String line3 = "- Sacrifice x2 Owner Fragments";
                return new String[] { "" + line1 + "", "" + line2 + "", "" + line3 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return null;
                    }

                    @Override
                    public String[] dialogue() {
                        return new String[] { "How to become a Celestial?", "What is the Celestial Zone?",
                                "What is Celestial Energy?", "Cancel" };
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8221);
                    }
                };
            }
        };
    }

    public static Dialogue celestialZone(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1821;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "The Celestial zone opens for 10 minutes every 3 hours.";
                String line2 = "Complete tasks in the Celestial Zone to get Celestial Energy";
                return new String[] { "" + line1 + "", "" + line2 + ""};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return null;
                    }

                    @Override
                    public String[] dialogue() {
                        return new String[] { "How to become a Celestial?", "What is the Celestial Zone?",
                                "What is Celestial Energy?", "Cancel" };
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8221);
                    }
                };
            }
        };
    }

    public static Dialogue celestialEnergy(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1821;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Celestial Energy can only be obtained from the Celestial Zone.";
                String line2 = "Celestial Energy is used to craft Celestial items.";
                return new String[] { "" + line1 + "", "" + line2 + ""};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return null;
                    }

                    @Override
                    public String[] dialogue() {
                        return new String[] { "How to become a Celestial?", "What is the Celestial Zone?",
                                "What is Celestial Energy?", "Cancel" };
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8221);
                    }
                };
            }
        };
    }
        public static Dialogue sacrifice(final Player player) {
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
                    String line1 = "Sacrifice x2 Owner fragments";
                    String line2 = "No, keep my Owner fragments";
                    return new String[] { "" + line1 + "", "" + line2 + ""};
                }

                @Override
                public void specialAction() {
                    player.setDialogueActionId(8102);
                }
            };
        }

}

