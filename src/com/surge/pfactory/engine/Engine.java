package com.surge.pfactory.engine;

import javax.swing.*;

import com.surge.pfactory.engine.input.KeyHandler;
import com.surge.pfactory.engine.input.MouseHandler;
import com.surge.pfactory.game.State;

import java.awt.*;

/**
 * Planet Factory Graphics Engine
 * 
 * @author Surge
 * @version 1.0
 * @since 1.0
 */
public class Engine implements Runnable {

    /*
     * Engine to do list
     * 
     * - Dynamic FPS
     * - FPS counter
     * - Decentralized rendering
     */

    public Dimension size;
    public String title;

    public Window renderFrame;
    public JFrame frame;

    public final MouseHandler mouseHandler;
    public final KeyHandler keyHandler;

    public Point globalMousePosition = new Point(0, 0);

    private Engine(Dimension size, String title) {
        //Initialize input managers
        mouseHandler = new MouseHandler();
        keyHandler = new KeyHandler();
        
        //Initialize the frame and render panel
        frame = new JFrame(title);
        frame.setSize(size);
        frame.setMinimumSize(size);
        frame.setPreferredSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(keyHandler);
        frame.addWindowListener(new WindowEventHandler());
        renderFrame = new Window(size);
        renderFrame.addMouseListener(mouseHandler);
        renderFrame.addMouseMotionListener(mouseHandler);
        frame.add(renderFrame);
        frame.setVisible(true);
    }

    //Input behaviours

    // Mouse
    public static Point getGlobalMousePosition() {
        if(instance == null) return new Point(0, 0);
        return instance.globalMousePosition;
    }

    public static boolean getMouseButtonDown(int button) {
        return instance.mouseHandler.buttons[button];
    }

    // Keyboard
    public static boolean getKeyDown(int key) {
        try {
            return instance.keyHandler.isKeyDown(key-1);
        } catch(ArrayIndexOutOfBoundsException ignored) {
            return false;
        }
    }

    //Singleton system, only allows for one instance of the engine active at one time

    public static Engine instance;

    public static Engine instance(String title, int width, int height) {
        if (instance == null)
            instance = new Engine(new Dimension(width, height), title);
        return instance;
    }

    class Window extends JPanel {

        Dimension size;

        public Window(Dimension size) {
            setSize(size);
            this.size = size;
        }

        @Override
        public void paintComponent(Graphics g) {
            //Screens and components handled in gamestate
            State.render(g);
            //ENGINE TODO: gamestate objects instead of it being a root class, makes it more modular
        }

    }

    //Render thread
    @Override
    public void run() {

        while (!State.wantQuit) {
            renderFrame.repaint();

            State.update();
            State.pollEvents();
        }

        frame.dispose();
        System.exit(0);

    }
    
}
