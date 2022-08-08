package com.surge.pfactory.engine.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class UIPanel extends UIElement {

    public Dimension size;
    public Rectangle boundingBox;

    public Color color = Color.darkGray;

    public UIPanel(int x, int y, int width, int height) {
        super(x, y);
        this.size = new Dimension(width, height);

        this.boundingBox = new Rectangle(position, size);
    }

    public UIPanel(Point p, Dimension size) {
        super(p);
        this.size = size;

        this.boundingBox = new Rectangle(position, size);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        g.setColor(Color.BLACK);
        g.drawRect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        super.render(g);
    }
}
