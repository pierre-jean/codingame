package fr.baraud.codingame.easy.powerofthor1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    @Test
    public void moveEastWhenLightIsEast(){
        Player player = Player.atPosition(10, 5);
        Light light = Light.atPosition(15, 5);
        assertThat(player.directionTo(light), is(equalTo(Direction.EAST)));
    }

    @Test
    public void moveWestLightIsWest(){
        Player player = Player.atPosition(15, 5);
        Light light = Light.atPosition(10, 5);
        assertThat(player.directionTo(light), is(equalTo(Direction.WEST)));
    }

    @Test
    public void moveSouthLightIsSouth(){
        Player player = Player.atPosition(15, 5);
        Light light = Light.atPosition(15, 10);
        assertThat(player.directionTo(light), is(equalTo(Direction.SOUTH)));
    }

    @Test
    public void moveNorthLightIsNorth(){
        Player player = Player.atPosition(15, 10);
        Light light = Light.atPosition(15, 5);
        assertThat(player.directionTo(light), is(equalTo(Direction.NORTH)));
    }

    @Test
    public void moveNorthEastLightIsNorthEast(){
        Player player = Player.atPosition(10,10);
        Light light = Light.atPosition(15, 5);
        assertThat(player.directionTo(light), is(equalTo(Direction.NORTH_EAST)));
    }

    @Test
    public void moveNorthWestLightIsNorthWest(){
        Player player = Player.atPosition(10,10);
        Light light = Light.atPosition(0, 0);
        assertThat(player.directionTo(light), is(equalTo(Direction.NORTH_WEST)));
    }

    @Test
    public void moveSouthWestLightIsSouthWest(){
        Player player = Player.atPosition(10, 0);
        Light light = Light.atPosition(0, 10);
        assertThat(player.directionTo(light), is(equalTo(Direction.SOUTH_WEST)));
    }

    @Test
    public void moveSouthEastLightIsSouthEast(){
        Player player = Player.atPosition(0,0);
        Light light = Light.atPosition(10, 10);
        assertThat(player.directionTo(light), is(equalTo(Direction.SOUTH_EAST)));
    }

    @Test
    public void beOneCaseLowerFromThePreviousPosition(){
        Player player = Player.atPosition(0,0);
        Player playerAfterMove = player.afterMove(Direction.SOUTH);
        assertThat(playerAfterMove.position(), equalTo(new Position(0, 1)));
    }

}
