package com.surge.pfactory.engine.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

import com.surge.pfactory.game.objects.Resource;
import com.surge.pfactory.engine.util.EMath;
import com.surge.pfactory.game.objects.Building;

public class Tile extends BaseComponent {

    public int iX, iY;

    public Building building;
    public Resource resource;

    public Color color = Color.GRAY;

    //Debug
    public boolean state = false;

    public Tile(Point location, Dimension scale, int tIndexX, int tIndexY) {
        super(location, scale);
        iX = tIndexX;
        iY = tIndexY;

        globalPosition = new Point(location.x + (iX * scale.width), location.y + (iY * scale.height));
        //reset the bounding box
        boundingBox = new Rectangle(globalPosition, scale);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(state ? Color.BLUE : color);
        g.fillRect(location.x + (scale.width * iX), location.y + (scale.height * iY), scale.width, scale.height);
        g.setColor(Color.BLACK);
        g.drawRect(location.x + (scale.width * iX), location.y + (scale.height * iY), scale.width, scale.height);
    }

    @Override
    public void update() {
        if (building != null) building.update();

        
    }

    @Override
    public void inputEvent(InputEvent event) {
        if(event instanceof MouseEvent) {
            //cast it so we can work with it
            MouseEvent evt = (MouseEvent) event;

            if (boundingBox.contains(evt.getPoint())) {
                if (evt.getButton() == MouseEvent.BUTTON1) {
                    state = !state;
                }
            }
        }

        else if (event instanceof KeyEvent) {
            KeyEvent evt = (KeyEvent) event;

            if(evt.getKeyCode() == KeyEvent.VK_SPACE) {
                int red = (int)(Math.random() * 256) - 1;
                int green = (int)(Math.random() * 256) - 1;
                int blue = (int)(Math.random() * 256) - 1;

                color = new Color(EMath.clamp(red, 255, 0), EMath.clamp(green, 255, 0), EMath.clamp(blue, 255, 0));
            }
        }
    }
}
