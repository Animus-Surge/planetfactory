package com.surge.pfactory.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.surge.pfactory.engine.Engine;

import com.surge.pfactory.game.State;

public class MouseHandler implements MouseListener, MouseMotionListener {

    public boolean[] buttons = new boolean[3];

    //Input callback methods
    @Override
    public void mouseClicked(MouseEvent e) {
        State.eventBuffer.add(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()-1] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()-1] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Might use, we'll see
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Engine.instance.globalMousePosition = e.getPoint();
    }
    
}
