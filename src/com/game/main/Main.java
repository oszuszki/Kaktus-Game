package com.game.main;

import com.game.panels.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String [] args) {
        GraphicsEnvironment graphics =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        System.out.println(graphics);
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        System.out.println(device);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new GamePanel(), BorderLayout.CENTER);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);

        device.setFullScreenWindow(frame);
    }
}
