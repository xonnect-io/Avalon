package com.ruse.world.content.skill.impl.thieving;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Item;
import com.ruse.model.Skill;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.achievement.Achievements;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.CasketOpening;
import com.ruse.world.content.skill.impl.mining.MiningData;
import com.ruse.world.entity.impl.player.Player;

public class Stalls {

    public static void stealFromStall(Player player, GameObject  gameObject, int lvlreq, int xp, Item reward, String message) {
        if (player.getInventory().getFreeSlots() < 1) {
            player.getPacketSender().sendMessage("You need some more inventory space to do this.");
            return;
        }
        if (player.getCombatBuilder().isBeingAttacked()) {
            player.getPacketSender()
                    .sendMessage("You must wait a few seconds after being out of combat before doing this.");
            return;
        }
        if (!player.getClickDelay().elapsed(2000))
            return;
        if (player.getSkillManager().getMaxLevel(Skill.THIEVING) < lvlreq) {
            player.getPacketSender()
                    .sendMessage("You need a Thieving level of at least " + lvlreq + " to steal from this stall.");
            return;
        }

        if (gameObject.getId() == 22772)
            Achievements.doProgress(player, Achievements.Achievement.STEAL_100_LAMP_STALLS);

        if (gameObject.getId() == 22774) {
            Achievements.doProgress(player, Achievements.Achievement.STEAL_250_ARMOUR_STALLS);
            Achievements.doProgress(player, Achievements.Achievement.STEAL_750_ARMOUR_STALLS);
        }

        player.performAnimation(new Animation(881));
        player.getPacketSender().sendInterfaceRemoval();
        player.getSkillManager().addExperience(Skill.THIEVING, xp);
        player.getClickDelay().reset();
        {
            player.getPacketSender().sendMessage(message);
            player.getInventory().add(reward);
        }
        player.getSkillManager().stopSkilling();
    }
}
