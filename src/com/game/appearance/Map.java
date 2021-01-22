package com.game.appearance;

import java.awt.*;

import com.game.panels.GamePanel;

import static com.game.appearance.MapBuilding.*;

public class Map {

    public static int blockSize= 32;

    public static int bg_x = -100;
    public static int bg_y = -70;


    public static void platform(Graphics g) {
        nextLvl();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case 0:
                        g.setColor(Color.blue);
                        g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        break;
                    case 1:
                        g.setColor(Color.red);
                        g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        break;
                    case 2:
                        g.drawImage(GamePanel.images[18], j * blockSize,i * blockSize, blockSize, blockSize, null);
                        break;
                }
            }
        }
    }

    public static void backGround(Graphics g){
        g.drawImage(GamePanel.images[1], bg_x,bg_y, 2000, 1000, null);
    }

    public static void draw(Graphics g) {
        //backGround(g);
        platform(g);
    }
}