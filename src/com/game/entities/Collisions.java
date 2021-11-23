package com.game.entities;

import com.game.appearance.MapBuilding;

import static com.game.appearance.MapBuilding.x;
import static com.game.appearance.MapBuilding.y;
import static com.game.entities.Player.*;


public class Collisions {

    public static void leftBlockIsSolid(){
        if(MapBuilding.map[((y) / getCHARACTERSIZE())][((x - 6) / getCHARACTERSIZE())] == 1
                || ((y % getCHARACTERSIZE()) > 5
                && MapBuilding.map[((y) / getCHARACTERSIZE())][((x - 6) / getCHARACTERSIZE())] == 1))

            setLeft(false);
    }

    public static void rightBlockIsSolid(){
        if(MapBuilding.map[((y) / getCHARACTERSIZE())][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 1
                || ((y % getCHARACTERSIZE()) > 5
                && MapBuilding.map[((y) / getCHARACTERSIZE())][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 1)) {

            setRight(false);
        }
    }

    public static void canJump(){
        if(MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 1
                || ((x % getCHARACTERSIZE()) > 5
                && MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 1)
                || MapBuilding.map[((y + 130) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 1) {

            setCanJump(true);
        }
    }

    public static void upperBlockIsSolid(){
        if(MapBuilding.map[((y - 3) / getCHARACTERSIZE())][(x / getCHARACTERSIZE())] == 1
                || ((x % getCHARACTERSIZE()) > 5
                && MapBuilding.map[((y - 3) / getCHARACTERSIZE())][(x / getCHARACTERSIZE()) + 1] == 1)) {

            Player.setUp(false);
            setCurrentJumpSpeed(getJumpSpeed());
            setDown(true);
        }
    }

    public static void downBlockIsAir(){
        if(MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 1
                || ((x % getCHARACTERSIZE()) > 5
                && MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE()) + 1] == 1)) {
            setDown(false);
            y -= (y % getCHARACTERSIZE());
        }
        else {
            if (!isUp()) {
                setDown(true);
            }
        }
    }

    public static void goToTheNextLevel() {
        if(MapBuilding.map[((y) / getCHARACTERSIZE())][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 2
                || ((y % getCHARACTERSIZE()) > 5
                && MapBuilding.map[((y) / getCHARACTERSIZE()) + 2][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 2)) {
            lvlCounter += 1;
            newLvl = true;
        }
    }

    public static void collisionWithTrapBlock() {
        if(MapBuilding.map[((y) / getCHARACTERSIZE())][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 3
                || MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 3
                || MapBuilding.map[((y) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 3
                || MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 3
                || MapBuilding.map[((y) / getCHARACTERSIZE())][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 33
                || MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x + getCHARACTERSIZE()) / getCHARACTERSIZE())] == 33
                || MapBuilding.map[((y) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 33
                || MapBuilding.map[((y + getCHARACTERSIZE()) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 33
                || MapBuilding.map[((y) / getCHARACTERSIZE())][((x) / getCHARACTERSIZE())] == 4) {
            newLvl = true;
        }
    }
}
