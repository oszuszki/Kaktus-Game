package com.game.entities;

import com.game.appearance.Map;
import com.game.appearance.MapBuilding;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Player {

    private static int x = 60;
    private static int y = 400;
    private static final int height = 64;
    private static final int width = 64;
    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;

    private static final double jumpSpeed = 8;
    private static double currentJumpSpeed = jumpSpeed;
    private static final boolean topCollision = false;
    private static final double maxFallSpeed = 8;
    private static double currentFallSpeed = 0.3;

    public static void move() {

        if(MapBuilding.map1[((y) / 32)][((x + 68) / 32)] == 1 || MapBuilding.map1[((y) / 32) + 1][((x + 68) / 32)] == 1
                || ((y % 32) > 5 && MapBuilding.map1[((y) / 32) + 2][((x + 68) / 32)] == 1)) {
            right = false;

        }
        if(MapBuilding.map1[((y) / 32)][((x - 5) / 32)] == 1 || MapBuilding.map1[((y) / 32 + 1)][((x - 5) / 32)] == 1
                || ((y % 32) > 5 && MapBuilding.map1[((y) / 32 + 2)][((x - 4) / 32)] == 1)) {
            left = false;
        }
        if(MapBuilding.map1[((y - 4) / 32)][(x / 32)] == 1 || MapBuilding.map1[((y - 4) / 32)][(x / 32) + 1] == 1
                || ((x % 32) > 5 && MapBuilding.map1[((y - 4) / 32)][(x / 32) + 2] == 1)) {
            up = false;
            currentJumpSpeed = jumpSpeed;
            down = true;
        }
        if(MapBuilding.map1[((y + 68) / 32)][((x) / 32)] == 1 || MapBuilding.map1[((y + 68) / 32)][((x) / 32) + 1] == 1
                || ((x % 32) > 5 && MapBuilding.map1[((y + 68) / 32)][((x) / 32) + 2] == 1)) {
            down = false;
        }  else {
            if (!topCollision && !up) {
                down = true;
            }
        }

        if(right){
            x += 6;
            System.out.println(y / 32);
            System.out.println(y % 32);
        }

        if(left){
            x -= 6;
            System.out.println(y / 32);
            System.out.println(y % 32);
        }

        if (up) {
            y -= currentJumpSpeed;
            currentJumpSpeed -= .2;
            if (currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                up = false;
                down = true;
            }
        }

        if (down) {
            y += currentFallSpeed;
            if (currentFallSpeed < maxFallSpeed) {
                currentFallSpeed += .3;
            }
        }
        if (!down) {
            currentFallSpeed = .3;
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
        if (k == KeyEvent.VK_W && !up && !down)
            up = true;
    }
    public static void keyReleased(int k) {
        if (k == KeyEvent.VK_D)
            right = false;
        if (k == KeyEvent.VK_A)
            left = false;

    }
    }
