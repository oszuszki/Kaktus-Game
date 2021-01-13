package com.game.appearance;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.game.appearance.Images;
import com.game.panels.GamePanel;

import javax.imageio.ImageIO;

public class Map {

    public static int blockSize= 32;

    public static int bg_x = -100;
    public static int bg_y = -70;

    public static void platform(Graphics g) {
        for (int i = 0; i < MapBuilding.map1.length; i++) {
            for (int j = 0; j < MapBuilding.map1[i].length; j++) {
                if (MapBuilding.map1[i][j] == 0){
                    //g.setColor(Color.blue);
                    //g.drawRect(i * blockSize,j * blockSize , blockSize, blockSize);
                }
                else if (MapBuilding.map1[i][j] == 1){
                    g.setColor(Color.red);
                    g.drawRect(i * blockSize,j * blockSize , blockSize, blockSize);
                    g.drawImage(GamePanel.images[0], i * blockSize,j * blockSize, blockSize, blockSize, null);

                }
            }
        }
    }

    public static void backGround(Graphics g){
        g.drawImage(GamePanel.images[1], bg_x,bg_y, 2000, 1000, null);
    }

    public static void draw(Graphics g) {
        backGround(g);
        platform(g);
    }
}