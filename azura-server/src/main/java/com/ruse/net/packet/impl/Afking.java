package com.ruse.net.packet.impl;


import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Graphic;
import com.ruse.model.Position;
import com.ruse.model.definitions.WeaponAnimations;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.entity.impl.player.Player;

public class Afking {
    static int chairanimation = 3363;

    public static void afk(final Player player)
    {

        if (!player.idleEventUsed && !player.getCombatBuilder().isBeingAttacked())
        {
            player.idleEventUsed = true;

            player.setPositionToFace(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));

            player.getCharacterAnimations().setStandingAnimation(chairanimation);

            final GameObject object3 = new GameObject(player.throneId, new Position(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()),10,2);
            player.toRemove.add(object3);


            CustomObjects.spawnGlobalObject(object3);


            TaskManager.submit(new Task(2, player, true) {
                @Override
                protected void execute() {
                    if (player.idleEventUsed) {

                        player.performGraphic(new Graphic(277));

                        player.updateAppearance();

                    } else {
                        stop();
                    }
                }
                @Override
                public void stop() {
                    resetAfk(player,false);


                }
            });


        }
    }

    public static void resetAfk(Player player, boolean ignore)
    {
        if (player.idleEventUsed)
        {
            if (!ignore)
            {
                player.performAnimation(new Animation(65535));

                WeaponAnimations.update(player);
            }

            player.updateAppearance();
            player.idleEventUsed = false;

            for (int index = 0; index < player.toRemove.size(); index++)
            {

                if (player.toRemove.get(index).getId() == player.throneId)
                {

                    CustomObjects.deleteGlobalObject(player.toRemove.get(index));

                    break;
                }
            }
            player.toRemove.clear();
        }

    }


}
