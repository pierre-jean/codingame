package fr.baraud.codingame.easy.powerofthor1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Player {

    private final int x;
    private final int y;

    Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String directionTo(Light light) {
        return light.directionFrom(x, y);
    }


    public Player afterMove(String direction) {
        return null;
    }
}
