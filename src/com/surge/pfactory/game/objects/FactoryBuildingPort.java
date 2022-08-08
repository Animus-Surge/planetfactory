package com.surge.pfactory.game.objects;

import java.awt.Point;

/**
 * Used in conjunction with a {@link com.surge.pfactory.game.objects.FactoryBuilding} to allow functionality
 * of conveyors
 */
public class FactoryBuildingPort {
    
    public static final int PORT_NORTH = 0;
    public static final int PORT_EAST = 1;
    public static final int PORT_SOUTH = 2;
    public static final int PORT_WEST = 3;

    public static final int PORT_INPUT = 4;
    public static final int PORT_OUTPUT = 5;

    public int direction, polarity;
    public Point tileIndex;

    public FactoryBuildingPort(int portDir, int polarity, Point tileIndex) {
        this.direction = portDir;
        this.polarity = polarity;
        this.tileIndex = tileIndex;
    }

    public int getDirection() {
        return direction;
    }

}
