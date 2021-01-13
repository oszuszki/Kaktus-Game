package com.game.entities;

import com.game.appearance.Map;
import com.game.appearance.MapBuilding;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Player {

    private static int x = 100;
    private static int y = 100;
    private static int height = 64;
    private static int width = 64;
    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;

    public static void move() {

        if(up == false && MapBuilding.map1[((y + 64) / 32)][((x) / 32)] != 1 && MapBuilding.map1[((y + 64) / 32)][((x) / 32) + 1] != 1
                && MapBuilding.map1[((y + 64) / 32)][((x) / 32) + 2] != 1) {
            y += 6;
            Map.bg_y -= 1;
            down = true;
        }

        if(right == true && MapBuilding.map1[((y) / 32)][((x + 68) / 32)] != 1 && MapBuilding.map1[((y) / 32) + 1][((x + 68) / 32)] != 1) {
            x += 6;
            //System.out.println(x);
            //System.out.println(y);
            Map.bg_x -= 1;
        }
        if(left == true && MapBuilding.map1[((y) / 32)][((x - 8) / 32)] != 1 && MapBuilding.map1[((y) / 32 + 1)][((x - 4) / 32)] != 1) {
            x -= 6;
            Map.bg_x += 1;
        }
        if(up == true && MapBuilding.map1[((y - 8) / 32)][(x / 32)] != 1 && MapBuilding.map1[((y - 8) / 32)][(x / 32) + 1] != 1
                && MapBuilding.map1[((y - 8) / 32)][(x / 32) + 2] != 1) {
            y -= 50;
            Map.bg_y += 6;
            up = false;
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
            down = true;
        if (k == KeyEvent.VK_A)
            left = true;
        if (k == KeyEvent.VK_W){
            up = true;
            down = false;
        }
    }
    public static void keyReleased(int k) {
        if (k == KeyEvent.VK_D)
            right = false;
        if (k == KeyEvent.VK_S)
            down = false;
        if (k == KeyEvent.VK_A)
            left = false;
        if (k == KeyEvent.VK_W)
            up = false;
    }
    }
