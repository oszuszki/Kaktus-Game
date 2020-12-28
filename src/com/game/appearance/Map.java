package com.game.appearance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {

    private String path;
    private String line;
    private int width, height;



    public void Map(String mapPath) {
        path = mapPath;
    }

    public static void loadMap() {
        for( int i = 0; i < MapBuilding.map1.length; i++ )
        {
            for( int j = 0; j < MapBuilding.map1[i].length; j++ )
            {
                System.out.println(MapBuilding.map1[i][j]);
            }
        }
    }

}