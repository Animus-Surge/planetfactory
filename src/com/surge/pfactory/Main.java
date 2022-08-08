package com.surge.pfactory;

import com.surge.pfactory.engine.Engine;
import com.surge.pfactory.game.State;

class Main {

    public static void main(String[] args) {
        //TODO: extra functionality, such as update checking or whatnot
        State.init();

        Engine engine = Engine.instance("Planet Factory", 800, 600);
        engine.run();
        
    }

}