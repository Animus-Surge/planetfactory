package com.surge.pfactory.engine.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.event.InputEvent;

import com.surge.pfactory.game.State;

public class TileRenderer extends BaseComponent {

    public Tile[][] map;

    public int scaleX, scaleY;

    public TileRenderer(Point location, Dimension scale, int mapScaleX, int mapScaleY) {
        super(location, scale);
        map = new Tile[mapScaleY][mapScaleX];
        scaleX = mapScaleX;
        scaleY = mapScaleY;

        //Generate the map

        for (int y = 0; y < scaleY; y++) {
            for (int x = 0; x < scaleX; x++) {
                map[y][x] = new Tile(location, scale, x, y);
            }
        }
    }

    public Tile[][] getMap() {
        return map;
    }

    public Tile getTile(int x, int y) {
        return map[y][x];
    }

    @Override
    public void render(Graphics g) {
        for(int y = 0; y < scaleY; y++) {
            for (int x = 0; x < scaleX; x++) {
                map[y][x].render(g);
            }
        }
    }
    
    @Override
    public void update() {
        for(int y = 0; y < scaleY; y++) {
            for(int x = 0; x < scaleX; x++) {
                map[y][x].update();
            }
        }
        super.update();
    }

    @Override
    public void inputEvent(InputEvent event) {
        for(int y = 0; y < scaleY; y++) {
            for(int x = 0; x < scaleX; x++) {
                if (State.eventBlocked) return;
                map[y][x].inputEvent(event);
            }
        }
        super.inputEvent(event);
    }
}
