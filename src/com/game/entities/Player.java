package com.game.entities;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private static int x = 10;
    private static int y = 10;
    private static int height = 50 , width = 50;
    private static boolean right = false;
    private static boolean left = false;
    private static boolean jump = false;
    private static boolean fall = false;

    public static void move() {
        if(right == true) {
            x = x + 10;
        }
        if(jump == true) {
            y = y - 10;
        }
        if(left == true) {
            x = x - 10;
        }
        if(fall == true) {
            y = y + 10;
        }
    }

    public static void draw(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(x, y, width, height);
    }

    public static void keyPressed(int k) {
        if (k == KeyEvent.VK_ESCAPE)
            System.exit(0);
        if (k == KeyEvent.VK_D)
            right = true;
        if (k == KeyEvent.VK_S)
            fall = true;
        if (k == KeyEvent.VK_A)
            left = true;
        if (k == KeyEvent.VK_W)
            jump = true;
    }
    public static void keyReleased(int k) {
        if (k == KeyEvent.VK_D)
            right = false;
        if (k == KeyEvent.VK_S)
            fall = false;
        if (k == KeyEvent.VK_A)
            left = false;
        if (k == KeyEvent.VK_W)
            jump = false;
    }
    }
