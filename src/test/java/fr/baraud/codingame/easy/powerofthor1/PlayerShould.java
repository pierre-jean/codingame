package fr.baraud.codingame.easy.powerofthor1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class PlayerShould {

    @Test
    public void moveEastWhenLightIsEast(){
        Player player = Player.fromCoordinates(5,10);
        OutputStream outputStream = new ByteArrayOutputStream();
        Light light = Light.fromCoordinates(8, 10);
        player.printInto(outputStream).directionTo(light);
    }
}
