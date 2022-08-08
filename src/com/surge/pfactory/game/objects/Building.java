package com.surge.pfactory.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.surge.pfactory.engine.components.Tile;

/**
 * Defines a basic building with no functionality
 * 
 */
public abstract class Building {

    //TODO: building rotation

    public final String name;
    public Tile parent;

    public Point originTile = new Point(0, 0); //Defines where the center tile is for the building. Defaults to (0, 0)

    public int sizeTilesX, sizeTilesY;

    public Building(String name) {
        this.name = name;
        sizeTilesX = 1;
        sizeTilesY = 1;
    }

    public void setSize(int tx, int ty) {
        sizeTilesX = tx;
        sizeTilesY = ty;
    }

    public void setParent(Tile parent) {
        this.parent = parent;
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        //First find the position of the building

        int dpx = parent.globalPosition.x + 3;
        int dpy = parent.globalPosition.y + 3;

        g.fillRect(dpx, dpy, 29, 29);
    }

    public abstract void update();
    
}
