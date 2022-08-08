package com.surge.pfactory.game;

import com.surge.pfactory.engine.components.TileRenderer;
import com.surge.pfactory.engine.ui.UIButton;
import com.surge.pfactory.engine.ui.UIElement;
import com.surge.pfactory.engine.ui.UIPanel;
import com.surge.pfactory.game.objects.Building;

import java.util.LinkedList;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;

import java.awt.event.InputEvent;

/**
 * Global game state
 */
public class State {

    //Global constants
    //In Globals.java

    //Gamestate variables
    public static TileRenderer renderer;
    public static UIElement ui;

    public static int stardust;
    public static int researchPoints;

    //Global flags
    public static boolean wantQuit = false;

    public static Building selectedBuilding = null;

    public static void init() {
        //Initializes variables and creates a world

        //TODO: initialize the UI

        //Debug amount
        stardust = 99_999_999;
        researchPoints = 99_999_999;

        renderer = new TileRenderer(new Point(8, 44), new Dimension(32, 32), 24, 16);
        ui = new UIPanel(new Point(0, 0), new Dimension(800, 38));

        UIButton testbutton = new UIButton(10, 3, 64, 32);
        ui.addChild(testbutton);
    }

    public static void render(Graphics g) {
        //Render the map
        renderer.render(g);
        //Render the UI
        ui.render(g);
    }

    public static void update() {
        ui.update();
        renderer.update();
    }

    //User input handling

    public static LinkedList<InputEvent> eventBuffer = new LinkedList<>();

    /**
     * If the event was handled, and the handler blocked the event from being passed on to the next layer
     */
    public static boolean eventBlocked = false;

    public static void pollEvents() {
        InputEvent event = eventBuffer.poll();
        if (event != null) {
            //In this part of this function, we can do global events, like manually toggling a
            //menu or selecting a building to build.


            //If we did something, then we would return if the event is blocking.

            ui.inputEvent(event);
            if (!eventBlocked) {
                renderer.inputEvent(event);
            }
        }
    }
}
