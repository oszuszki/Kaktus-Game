package com.game.entities;

import com.game.appearance.Map;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private static int x = 5;
    private static int y = 5;
    private static int height = 64;
    private static int width = 64;
    private static boolean right = false;
    private static boolean left = false;
    private static boolean jump = false;
    private static boolean fall = false;

    public Player(int width, int height) {
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
    }

    public static void move() {
        if(right == true) {
            x += 8;
            //System.out.println(x);
            //System.out.println(y);
            Map.bg_x -= 1;
        }
        if(left == true) {
            x -= 8;
            Map.bg_x += 1;
        }
        if(jump == true) {
            y -= 8;
            Map.bg_y += 1;
        }

        if(fall == true) {
            y += 8;
            Map.bg_y -= 1;
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
