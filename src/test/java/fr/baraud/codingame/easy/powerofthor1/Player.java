package fr.baraud.codingame.easy.powerofthor1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Player {

    private final int x;
    private final int y;
    private OutputStream output;

    private Player(int x, int y, OutputStream output){
        this.x = x;
        this.y = y;
        this.output = output;
    }

    public static Player fromCoordinates(int x, int y) {
        return new Player(x, y, new ByteArrayOutputStream());
    }

    public Player printInto(OutputStream output) {
        return new Player(x, y, output);
    }

    public String directionTo(Light light) {
        String direction = directionTo(light);
        print(direction);
        return direction;
    }

    private void print(String direction){
        try {
            tryPrint(direction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tryPrint(String direction) throws IOException {
        output.write(direction.getBytes());
    }
}
