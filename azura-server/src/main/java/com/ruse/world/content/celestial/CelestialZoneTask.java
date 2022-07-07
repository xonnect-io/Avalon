package com.ruse.world.content.celestial;

import com.ruse.engine.task.Task;

import com.ruse.engine.task.TaskManager;

/*
 * Project Avalon
 * Author @Avalon (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/23/2022
 */

public class CelestialZoneTask {
    public static int tick = 0;
    public static void startTask() {
        TaskManager.submit(new Task(1,false) {
            @Override
            public void execute() {
                if(tick == 1000) {
                    CelestialPortal.despawn(true);
            }
                if(tick == 18000) {
                    CelestialPortal.spawn();
                }
                if(tick == 19000) {
                    CelestialPortal.despawn(true);
                    tick = 1001;
                }
                tick++;
                //System.out.println("Celestial Tick: " + tick);
                stop();
            }
        });
}
}