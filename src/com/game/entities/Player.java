package com.game.entities;

import com.game.appearance.MapBuilding;
import com.game.panels.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.game.appearance.MapBuilding.*;
import static com.game.entities.Collisions.*;


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

    private static final int CHARACTERSIZE = 32;
    private static final int CHARACTERMOVINGSPEED = 6;

    public static int lvlCounter = 1;
    public static boolean newLvl = true;

    private static int left_animation;
    private static int right_animation;
    private static int lFramecounter;
    private static int rFramecounter;

    public static void playerActions() {
        goToTheNextLevel();
        collisionWithTrapBlock();
        canJump();
        rightBlockIsSolid();
        leftBlockIsSolid();
        upperBlockIsSolid();
        downBlockIsAir();

        if(up || down) {
            if(dStillPressed && !(MapBuilding.map[((y) / 32)][((x + 32) / 32)] == 1
                    || ((y % 32) > 5 && MapBuilding.map[((y) / 32) + 2][((x + 32) / 32)] == 1)))
                right = true;
            if(aStillPressed && !(MapBuilding.map[((y) / 32)][((x - 6) / 32)] == 1
                    || ((y % 32) > 5 && MapBuilding.map[((y) / 32 + 2)][((x - 4) / 32)] == 1)))
                left = true;
        }

        if(right){
            x += CHARACTERMOVINGSPEED;
        }

        if(left){
            x -= CHARACTERMOVINGSPEED;
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

    public static void setRight(boolean right) {
        Player.right = right;
    }

    public static void setLeft(boolean left) {
        Player.left = left;
    }

    public static boolean isUp() {
        return up;
    }

    public static void setUp(boolean up) {
        Player.up = up;
    }

    public static void setDown(boolean down) {
        Player.down = down;
    }

    public static void setCanJump(boolean canJump) {
        Player.canJump = canJump;
    }

    public static double getJumpSpeed() {
        return jumpSpeed;
    }

    public static void setCurrentJumpSpeed(double currentJumpSpeed) {
        Player.currentJumpSpeed = currentJumpSpeed;
    }

    public static int getCHARACTERSIZE() {
        return CHARACTERSIZE;
    }

    public static void animation (Graphics g) {

        g.setColor(Color.blue);
        g.drawRect(x,y ,32, 32);

 /*       if(up || down) {
            if(left)
                g.drawImage(GamePanel.images[16],  x, y , null);
            if(right)
                g.drawImage(GamePanel.images[15],  x, y , null);
            if (!right && !left){
                if (left_animation > right_animation)
                    g.drawImage(GamePanel.images[16],  x, y , null);
                else
                    g.drawImage(GamePanel.images[15],  x, y , null);
            }

        }


        if (!right && !left && !up && !down){
            if (left_animation > right_animation)
                g.drawImage(GamePanel.images[9],  x, y , null);
            else
                g.drawImage(GamePanel.images[11],  x, y , null);
        }


        if (left && !up && !down) {
            right_animation = 0;
            left_animation = 1;
            switch (lFramecounter) {
                case 0, 2, 4, 6, 8 -> {
                    g.drawImage(GamePanel.images[5], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 10, 12, 14, 16 -> {
                    g.drawImage(GamePanel.images[6], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 18, 20, 22, 24 -> {
                    g.drawImage(GamePanel.images[7], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 26, 28, 30 -> {
                    g.drawImage(GamePanel.images[8], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 32 -> {
                    g.drawImage(GamePanel.images[8], x, y, null);
                    lFramecounter = 0;
                }
            }
        }
        else if (right && !up && !down) {
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
                case 26, 28, 30, 32-> {
                    g.drawImage(GamePanel.images[4], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 34-> {
                    g.drawImage(GamePanel.images[4], x, y, null);
                    rFramecounter = 0;
                }

            }
        }*/
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
        if (k == KeyEvent.VK_S) {
            currentJumpSpeed = jumpSpeed;
            up = false;
            down = true;
            canJump = false;
        }
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
