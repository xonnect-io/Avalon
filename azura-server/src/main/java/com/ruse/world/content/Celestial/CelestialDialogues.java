package com.ruse.world.content.Celestial;

import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;
    /*
     * Project Avalon
     * Author @Avalon (AlwaysDreaming.io@gmail.com)
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
                String line2 = "- Be an Assassin Master";
                String line3 = "- Sacrifice x2 Owner items (Cape, Aura, Bracelet, Ring or Amulet)";
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

    public static Dialogue totalPointsReceived(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.STATEMENT;
            }

            @Override
            public int npcId() {
                return player.getSlayer().getSlayerMaster().getNpcId();
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                int pointsReceived = 4;
                /*
                 * if(player.getSlayerMaster() == Slayer) //medium task pointsReceived = 7;
                 * if(player.getSlayerMaster().getTaskLevel() == 2) //hard/elite tasks
                 * pointsReceived = 10;
                 */
                int per5 = pointsReceived * 3;
                int per10 = pointsReceived * 5;
                return new String[] { "You currently receive " + pointsReceived + " points per task,",
                        "" + per5 + " bonus points per 5 task-streak and",
                        "" + per10 + " bonus points per 10 task-streak." };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(9906);
            }

        };
    }

    public static Dialogue chooseDifficulty(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.OPTION;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                return new String[] { "Easy", "Medium","Hard",
                };
            }

            @Override
            public void specialAction() {

            }
        };
    }

    public static Dialogue inviteDuo(final Player player, final Player inviteOwner) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return null;
            }

            @Override
            public String[] dialogue() {
                return new String[] { "" + inviteOwner.getUsername() + " has invited you to form a duo Slayer team.", };
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
                        return new String[] { "Accept " + inviteOwner.getUsername() + "'s invitation",
                                "Decline " + inviteOwner.getUsername() + "'s invitation"

                        };
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(34);
                        player.getSlayer().setDuoInvitation(inviteOwner.getUsername());
                    }
                };
            }
        };
    }
}

