package com.surge.pfactory.engine.components;

import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.event.InputEvent;

public abstract class BaseComponent {

    //event types
    public static final int EVENT_MOUSE = 0;
    public static final int EVENT_KEY = 1;

    //event modifiers
    public static final int EVENT_PRESSED = 0;
    public static final int EVENT_RELEASED = 1;

    public Point location;
    public Point globalPosition; //TODO: use this for any time we're moving the camera
    public Dimension scale;
    public Rectangle boundingBox;

    public ArrayList<BaseComponent> children = new ArrayList<>();
    public BaseComponent parent;

    public BaseComponent(Point location, Dimension scale) {
        this.location = location;
        this.scale = scale;

        //TODO: child element handling

        globalPosition = location;
        boundingBox = new Rectangle(globalPosition, scale);
    }

    public void setParent(BaseComponent newParent) {
        this.parent = newParent;
        //TODO: remove the old children from the old
    }

    public void addComponent(BaseComponent component) {
        children.add(component);
    }

    public abstract void render(Graphics g);

    public void inputEvent(InputEvent event) {
        children.forEach(child -> child.inputEvent(event));
    }

    public void update() {
        children.forEach(child -> child.update());
    }

}
