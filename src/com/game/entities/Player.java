package com.game.entities;

import com.game.appearance.MapBuilding;
import com.game.panels.GamePanel;

import static com.game.appearance.MapBuilding.y;
import static com.game.appearance.MapBuilding.x;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Player {

    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;
    private static boolean canJump = false;

    private static boolean dStillPressed = false;
    private static boolean aStillPressed = false;

    private static final double jumpSpeed = 8;
    private static double currentJumpSpeed = jumpSpeed;
    private static final double maxFallSpeed = 8;
    private static double currentFallSpeed = .3;

    public static int lvlCounter = 1;
    public static boolean newLvl = true;

    private static int left_animation;
    private static int right_animation;
    private static int lFramecounter;
    private static int rFramecounter;

    public static void specialCollision() {
        if(MapBuilding.map[((y) / 32)][((x + 64) / 32)] == 2 || MapBuilding.map[((y) / 32) + 1][((x + 64) / 32)] == 2
                || ((y % 32) > 5 && MapBuilding.map[((y) / 32) + 2][((x + 64) / 32)] == 2)) {
            lvlCounter += 1;
            newLvl = true;
        }

    }

    public static void move() {

        specialCollision();

        if(MapBuilding.map[((y + 66) / 32)][((x) / 32)] == 1 || MapBuilding.map[((y + 66) / 32)][((x) / 32) + 1] == 1
                || ((x % 32) > 5 && MapBuilding.map[((y + 66) / 32)][((x) / 32) + 2] == 1)
        || MapBuilding.map[((y + 130) / 32)][((x) / 32)] == 1 || MapBuilding.map[((y + 130) / 32)][((x) / 32) + 1] == 1)
            canJump = true;
        if(MapBuilding.map[((y) / 32)][((x + 64) / 32)] == 1 || MapBuilding.map[((y + 34) / 32)][((x + 64) / 32)] == 1
                || ((y % 32) > 5 && MapBuilding.map[((y + 66) / 32)][((x + 64) / 32)] == 1)) {
            right = false;
        }
        if(MapBuilding.map[((y) / 32)][((x - 6) / 32)] == 1 || MapBuilding.map[((y + 34) / 32)][((x - 6) / 32)] == 1
                || ((y % 32) > 5 && MapBuilding.map[((y + 66) / 32)][((x - 4) / 32)] == 1)) {
            left = false;
        }
        if(MapBuilding.map[((y - 3) / 32)][(x / 32)] == 1 || MapBuilding.map[((y - 3) / 32)][(x / 32) + 1] == 1
                || ((x % 32) > 5 && MapBuilding.map[((y - 3) / 32)][(x / 32) + 2] == 1)) {
            up = false;
            currentJumpSpeed = jumpSpeed;
            down = true;
        }
        if(MapBuilding.map[((y + 64) / 32)][((x) / 32)] == 1 || MapBuilding.map[((y + 64) / 32)][((x) / 32) + 1] == 1
                || ((x % 32) > 5 && MapBuilding.map[((y + 64) / 32)][((x) / 32) + 2] == 1)) {
            down = false;
            y -= (y % 32);
        }  else {
            if (!up) {
                down = true;
            }
        }

        if(up || down) {
            if(dStillPressed && !(MapBuilding.map[((y) / 32)][((x + 64) / 32)] == 1 || MapBuilding.map[((y) / 32) + 1][((x + 64) / 32)] == 1
                    || ((y % 32) > 5 && MapBuilding.map[((y) / 32) + 2][((x + 64) / 32)] == 1)))
                right = true;
            if(aStillPressed && !(MapBuilding.map[((y) / 32)][((x - 6) / 32)] == 1 || MapBuilding.map[((y) / 32 + 1)][((x - 6) / 32)] == 1
                    || ((y % 32) > 5 && MapBuilding.map[((y) / 32 + 2)][((x - 4) / 32)] == 1)))
                left = true;
        }

        if(right){
            x += 6;
        }

        if(left){
            x -= 6;
        }

        if (up && !down) {
            y -= currentJumpSpeed;
            currentJumpSpeed -= .2;
            if (currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                up = false;
                down = true;
                canJump = false;
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
                g.drawImage(GamePanel.images[19],  x, y , null);
        }


        if (left) {
            right_animation = 0;
            left_animation = 1;
            switch (lFramecounter) {
                case 0, 2, 4, 6, 8 -> {
                    g.drawImage(GamePanel.images[10], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 10, 12, 14, 16 -> {
                    g.drawImage(GamePanel.images[11], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 18, 20, 22, 24 -> {
                    g.drawImage(GamePanel.images[12], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 26, 28, 30, 32 -> {
                    g.drawImage(GamePanel.images[13], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 34, 36, 38, 40 -> {
                    g.drawImage(GamePanel.images[14], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 42, 44, 46, 48 -> {
                    g.drawImage(GamePanel.images[15], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 50, 52, 54, 56 -> {
                    g.drawImage(GamePanel.images[16], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 58, 60, 62 -> {
                    g.drawImage(GamePanel.images[17], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 64 -> {
                    g.drawImage(GamePanel.images[17], x, y, null);
                    lFramecounter = 0;
                }
            }
        }

        if (right) {
            left_animation = 0;
            right_animation = 1;
            switch (rFramecounter) {
                case 0, 2, 4, 6, 8 -> {
                    g.drawImage(GamePanel.images[1], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 10, 12, 14, 16 -> {
                    g.drawImage(GamePanel.images[2], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 18, 20, 22, 24 -> {
                    g.drawImage(GamePanel.images[3], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 26, 28, 30, 32 -> {
                    g.drawImage(GamePanel.images[4], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 34, 36, 38, 40 -> {
                    g.drawImage(GamePanel.images[5], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 42, 44, 46, 48 -> {
                    g.drawImage(GamePanel.images[6], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 50, 52, 54, 56 -> {
                    g.drawImage(GamePanel.images[7], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 58, 60, 62 -> {
                    g.drawImage(GamePanel.images[8], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 64 -> {
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
        if (k == KeyEvent.VK_D) {
            right = true;
            left = false;
            dStillPressed = true;
        }
        if (k == KeyEvent.VK_S)
            down = true;
        if (k == KeyEvent.VK_A){
            left = true;
            right = false;
            aStillPressed = true;}
        if (k == KeyEvent.VK_W && canJump)
            up = true;
    }
    public static void keyReleased(int k) {
        if (k == KeyEvent.VK_D){
            right = false;
            dStillPressed = false;}
        if (k == KeyEvent.VK_A){
            left = false;
            aStillPressed = false;}

    }
    }
