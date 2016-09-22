package fr.baraud.codingame.easy.powerofthor1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

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

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
        Player thor = Player.atPosition(initialTX, initialTY);
        Light light = Light.atPosition(lightX, lightY);
        while (remainingTurns > 0) {
            String direction = thor.directionTo(light);
            System.out.println(direction);
            thor = thor.afterMove(direction);
        }
    }

}
