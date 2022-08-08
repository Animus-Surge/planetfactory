package com.surge.pfactory.engine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.surge.pfactory.game.State;

public class WindowEventHandler implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) { //Could do something like initialize the scene manager or something
    }

    @Override
    public void windowClosing(WindowEvent e) {
        State.wantQuit = true;
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
