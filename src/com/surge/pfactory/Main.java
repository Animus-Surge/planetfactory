package com.surge.pfactory;

import com.surge.pfactory.engine.Engine;

class Main {

    public static void main(String[] args) {
        Engine engine = Engine.createInstance("Planet Factory", 800, 600);
    }

}