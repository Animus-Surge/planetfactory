package com.surge.pfactory.game.objects;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class FactoryBuilding extends Building {

    private class BuildingTimer extends TimerTask {

        @Override
        public void run() {
            recipeComplete = true;
        }
        
    }

    //TODO: recipe handling

    public Timer buildTimeTimer;
    public ArrayList<FactoryBuildingPort> ports;
    public boolean recipeComplete = false;
    private final BuildingTimer event;

    public void setBuildTime(long millis) {
        if (buildTimeTimer != null)
            buildTimeTimer.cancel();
        buildTimeTimer = new Timer();
        buildTimeTimer.scheduleAtFixedRate(event, 0, millis);
        ports = new ArrayList<>();
    }

    public FactoryBuilding(String name) {
        super(name);
        event = new BuildingTimer();
    }

    public void addPort(FactoryBuildingPort port) {
        ports.add(port);
    }
    
}
