package com.surge.pfactory.engine.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Image;

public class Sprite extends BaseComponent {

    public Image texture;

    public Sprite(Point location, Dimension scale) {
        super(location, scale);
        
    }

    public void setTexture(String path) {
        //TODO
    }

    @Override
    public void render(Graphics g) {
        
        
    }
    


}
