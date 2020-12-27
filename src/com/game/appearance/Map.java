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

    public void LoadMap() {
        InputStream is = this.getClass().getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

    }

}