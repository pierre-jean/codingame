package fr.baraud.codingame.easy.powerofthor1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    @Test
    public void moveEastWhenLightIsEast(){
        Player player = new Player(5,10);
        Light light = new Light(5, 15);
        assertThat(player.directionTo(light), is(equalTo(Direction.EAST)));
    }

    @Test
    public void moveWestLightIsWest(){
        Player player = new Player(5,15);
        Light light = new Light(5, 10);
        assertThat(player.directionTo(light), is(equalTo(Direction.WEST)));
    }

    @Test
    public void moveSouthLightIsSouth(){
        Player player = new Player(5,15);
        Light light = new Light(10, 15);
        assertThat(player.directionTo(light), is(equalTo(Direction.SOUTH)));
    }

    @Test
    public void moveNorthLightIsNorth(){
        Player player = new Player(10,15);
        Light light = new Light(5, 15);
        assertThat(player.directionTo(light), is(equalTo(Direction.NORTH)));
    }

    @Test
    public void moveNorthEastLightIsNorthEast(){
        Player player = new Player(10,10);
        Light light = new Light(5, 15);
        assertThat(player.directionTo(light), is(equalTo(Direction.NORTH_EAST)));
    }

    @Test
    public void moveNorthWestLightIsNorthWest(){
        Player player = new Player(10,10);
        Light light = new Light(0, 0);
        assertThat(player.directionTo(light), is(equalTo(Direction.NORTH_WEST)));
    }

    @Test
    public void moveSouthWestLightIsSouthWest(){
        Player player = new Player(0,10);
        Light light = new Light(10, 0);
        assertThat(player.directionTo(light), is(equalTo(Direction.SOUTH_WEST)));
    }

    @Test
    public void moveSouthEastLightIsSouthEast(){
        Player player = new Player(0,0);
        Light light = new Light(10, 10);
        assertThat(player.directionTo(light), is(equalTo(Direction.SOUTH_EAST)));
    }

    @Test
    public void beOneCaseLowerFromThePreviousPosition(){
        Player player = new Player(0,0);
        Player playerAfterMove = player.afterMove(Direction.SOUTH);
    }

}
