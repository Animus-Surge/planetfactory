package com.surge.pfactory.engine.ui;

import java.util.ArrayList;

import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.Graphics;

/**
 * Root UI system node
 */
public class UIElement {

    //TODO: global and local positioning system for UI objects

    public ArrayList<UIElement> children = new ArrayList<>();
    public UIElement parent;

    public Point position;

    public UIElement(int x, int y) {
        this.position = new Point(x, y);
    }

    public UIElement(Point p) {
        this.position = p;
    }

    public void addChild(UIElement child) {
        children.add(child);
        child.parent = this;
    }

    public void render(Graphics g) {
        children.forEach(child -> child.render(g));
    }
    public void update() {
        children.forEach(child -> child.update());
    }

    public void inputEvent(InputEvent event) {
        children.forEach(child -> child.inputEvent(event));
    }
    
}
