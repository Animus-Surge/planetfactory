package com.surge.pfactory.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.surge.pfactory.game.State;

public class KeyHandler implements KeyListener {

    public boolean[] keys = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e) {
        //Likely will only be used for textboxes, we'll see
    }

    @Override
    public void keyPressed(KeyEvent e) {
        State.eventBuffer.add(e);

        try {
            keys[e.getKeyCode()] = true;

            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) State.wantQuit = true; //Debug only
        } catch(ArrayIndexOutOfBoundsException ex) {} //Fail silently
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            keys[e.getKeyCode()] = false;
        } catch(ArrayIndexOutOfBoundsException ex) {} //Fail silently 
    }

    public boolean isKeyDown(int keycode) {
        try {
            return keys[keycode];
        } catch(ArrayIndexOutOfBoundsException ex) {} //Fail silently and just return false
        return false;
    }
    
}
