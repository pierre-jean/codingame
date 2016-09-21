package fr.baraud.codingame.easy.powerofthor1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Player {

    private final Position position;

    Player(Position position){
        this.position = position;
    }

    public static Player atPosition(int x, int y){
        return new Player(new Position(x, y));
    }

    public Position position(){
        return position;
    }

    public String directionTo(Light light) {
        return light.directionFrom(position);
    }


    public Player afterMove(String direction) {
        Position newPosition = position().moveTo(direction);
        return new Player(newPosition);
    }

}
