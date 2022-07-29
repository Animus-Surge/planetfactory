package com.surge.pfactory.engine;

import javax.swing.*;
import java.awt.*;

/**
 * Planet Factory Graphics Engine
 * 
 * @author Surge
 * @version 1.0
 * @since 1.0
 */
public class Engine implements Runnable {

    public Dimension size;
    public String title;

    public Window renderFrame;

    private Engine(Dimension size, String title) {
        JFrame frame = new JFrame(title);
        frame.setSize(size);
        frame.setMinimumSize(size);
        frame.setPreferredSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renderFrame = new Window(size);
        frame.add(renderFrame);
        frame.setVisible(true);
    }

    public static Engine createInstance(String title, int width, int height) {
        return new Engine(new Dimension(width, height), title);
    }

    class Window extends JPanel {

        Dimension size;

        public Window(Dimension size) {
            setSize(size);
            this.size = size;
        }

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, size.width, size.height);

            g.setColor(Color.LIGHT_GRAY);
            for(int x = 0; x < size.width; x += 16) {
                g.drawLine(x, 0, x, size.height);
            }
        }

    }

    //Render thread
    @Override
    public void run() {
        //TODO
    }
    
}
