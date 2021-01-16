package com.game.entities;

import com.game.appearance.MapBuilding;
import com.game.panels.GamePanel;

import static com.game.appearance.MapBuilding.y;
import static com.game.appearance.MapBuilding.x;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Player {

    private static final int height = 64;
    private static final int width = 64;
    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;

    private static final double jumpSpeed = 8;
    private static double currentJumpSpeed = jumpSpeed;
    private static final double maxFallSpeed = 8;
    private static double currentFallSpeed = 0.3;

    public static int lvlCounter = 1;
    public static boolean newLvl = true;

    private static int left_animation;
    private static int right_animation;
    private static int lFramecounter;
    private static int rFramecounter;

    public static void collision() {
        if(MapBuilding.map[((y) / 32)][((x + 64) / 32)] == 2 || MapBuilding.map[((y) / 32) + 1][((x + 64) / 32)] == 2
                || ((y % 32) > 5 && MapBuilding.map[((y) / 32) + 2][((x + 64) / 32)] == 2)) {
            lvlCounter += 1;
            newLvl = true;
        }
    }

    public static void move() {

        collision();

        if(MapBuilding.map[((y) / 32)][((x + 64) / 32)] == 1 || MapBuilding.map[((y) / 32) + 1][((x + 64) / 32)] == 1
                || ((y % 32) > 5 && MapBuilding.map[((y) / 32) + 2][((x + 64) / 32)] == 1)) {
            right = false;

        }
        if(MapBuilding.map[((y) / 32)][((x - 5) / 32)] == 1 || MapBuilding.map[((y) / 32 + 1)][((x - 5) / 32)] == 1
                || ((y % 32) > 5 && MapBuilding.map[((y) / 32 + 2)][((x - 4) / 32)] == 1)) {
            left = false;
        }
        if(MapBuilding.map[((y - 4) / 32)][(x / 32)] == 1 || MapBuilding.map[((y - 4) / 32)][(x / 32) + 1] == 1
                || ((x % 32) > 5 && MapBuilding.map[((y - 4) / 32)][(x / 32) + 2] == 1)) {
            up = false;
            currentJumpSpeed = jumpSpeed;
            down = true;
        }
        if(MapBuilding.map[((y + 66) / 32)][((x) / 32)] == 1 || MapBuilding.map[((y + 66) / 32)][((x) / 32) + 1] == 1
                || ((x % 32) > 5 && MapBuilding.map[((y + 66) / 32)][((x) / 32) + 2] == 1)) {
            down = false;
        }  else {
            if (!up) {
                down = true;
            }
        }


        if(right){
            x += 6;
        }

        if(left){
            x -= 6;
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

    public static void animation (Graphics g) {

        g.setColor(Color.blue);
        g.drawRect(x,y ,64, 64);

        if (!right && !left){
            if (left_animation > right_animation)
                g.drawImage(GamePanel.images[9],  x, y , null);
            else
                g.drawImage(GamePanel.images[9],  x, y , null);
        }


        if (left) {
            right_animation = 0;
            switch (lFramecounter) {
                case 0, 2, 4, 6, 8, 10 -> {
                    g.drawImage(GamePanel.images[10], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 12, 14, 16, 18, 20 -> {
                    g.drawImage(GamePanel.images[11], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 22, 24, 26, 28, 30 -> {
                    g.drawImage(GamePanel.images[12], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 32, 34, 36, 38, 40 -> {
                    g.drawImage(GamePanel.images[13], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 42, 44, 46, 48, 50 -> {
                    g.drawImage(GamePanel.images[14], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 52, 54, 56, 58, 60 -> {
                    g.drawImage(GamePanel.images[15], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 62, 64, 66, 68, 70 -> {
                    g.drawImage(GamePanel.images[16], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 72, 74, 76, 78 -> {
                    g.drawImage(GamePanel.images[17], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 80 -> {
                    g.drawImage(GamePanel.images[17], x, y, null);
                    lFramecounter = 0;
                }
            }
        }

        if (right) {
            left_animation = 0;
            switch (rFramecounter) {
                case 0, 2, 4, 6, 8, 10 -> {
                    g.drawImage(GamePanel.images[1], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 12, 14, 16, 18, 20 -> {
                    g.drawImage(GamePanel.images[2], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 22, 24, 26, 28, 30 -> {
                    g.drawImage(GamePanel.images[3], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 32, 34, 36, 38, 40 -> {
                    g.drawImage(GamePanel.images[4], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 42, 44, 46, 48, 50 -> {
                    g.drawImage(GamePanel.images[5], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 52, 54, 56, 58, 60 -> {
                    g.drawImage(GamePanel.images[6], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 62, 64, 66, 68, 70 -> {
                    g.drawImage(GamePanel.images[7], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 72, 74, 76, 78 -> {
                    g.drawImage(GamePanel.images[8], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 80 -> {
                    g.drawImage(GamePanel.images[8], x, y, null);
                    rFramecounter = 0;
                }
            }
        }
    }

    public static void draw(Graphics g) {

        animation(g);
        //g.setColor(Color.red);
        //g.drawRect(x, y, width, height);

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
