package com.surge.pfactory.game.objects;

import java.util.Timer;
import java.util.TimerTask;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Building {

    private class BuildingTimer extends TimerTask {

        @Override
        public void run() {
            recipeComplete = true;
        }
        
    }

    public final String name;

    public Timer buildTimeTimer;
    public boolean recipeComplete = false;
    private final BuildingTimer event;

    public Building(String name) {
        this.name = name;
        this.event = new BuildingTimer();
    }

    public void setBuildTime(long millis) {
        buildTimeTimer.cancel();
        buildTimeTimer = new Timer();
        buildTimeTimer.scheduleAtFixedRate(event, 0, millis);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
    }

    public abstract void update();
    
}
