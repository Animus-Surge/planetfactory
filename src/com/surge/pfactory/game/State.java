package com.surge.pfactory.game;

import com.surge.pfactory.game.objects.Tile;

/**
 * Global game state
 */
public class State {

    //Global constants
    
    //Gamestate variables
    public Tile[][] map;

    public int stardust;
    public int researchPoints;

    //Global flags
    public boolean wantQuit = false;

    public class MainLoop extends Thread {

        //Main loop system
        @Override
        public void run() {



        }

    }


}
