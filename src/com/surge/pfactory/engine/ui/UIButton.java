package com.surge.pfactory.engine.ui;

import java.awt.Color;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

import com.surge.pfactory.engine.Engine;

public class UIButton extends UIPanel {

    //Flags
    public boolean hover = false;
    public boolean pressed = false;

    public UIButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {
        //System.out.println(Engine.getGlobalMousePosition());
        if(boundingBox.contains(Engine.getGlobalMousePosition())) { //Meaning its being hovered over
            hover = true;
            color = Color.cyan;
        } else {
            hover = false;
            color = Color.gray;
        }

        if (pressed) {
            if(!hover)
                color = Color.green;
            else
                color = Color.cyan;
        }

    }

    @Override
    public void inputEvent(InputEvent event) {
        if (event instanceof MouseEvent) {
            MouseEvent evt = (MouseEvent)event;

            if (hover && evt.getButton() == MouseEvent.BUTTON1) {
                pressed = !pressed; //TODO: additional functionality and also an onClick method
            }
        }
    }
    
}
