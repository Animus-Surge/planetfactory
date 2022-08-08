package com.surge.pfactory.game.objects.buildings;

import com.surge.pfactory.game.objects.FactoryBuilding;

public class MinerBuilding extends FactoryBuilding {

    public double miningSpeed;

    public MinerBuilding(String name, double miningSpeed) {
        super(name);
        this.miningSpeed = miningSpeed;
    }

    @Override
    public void update() {
        
        if (parent.resource != null) {
            
        }

    }
    
}
