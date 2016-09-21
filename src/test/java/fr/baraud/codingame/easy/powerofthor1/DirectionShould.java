package fr.baraud.codingame.easy.powerofthor1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DirectionShould {

    @Test
    public void return_south_when_target_is_south(){
        assertThat(Direction.from(new Position(2,3)).to(new Position(4,3)), is(equalTo(Direction.SOUTH)));
    }

    @Test
    public void return_north_when_target_is_north(){
        assertThat(Direction.from(new Position(2,3)).to(new Position(0,3)), is(equalTo(Direction.NORTH)));
    }

    @Test
    public void return_east_when_target_is_east(){
        assertThat(Direction.from(new Position(0,3)).to(new Position(0,5)), is(equalTo(Direction.EAST)));
    }

    @Test
    public void return_west_when_target_is_west(){
        assertThat(Direction.from(new Position(0,3)).to(new Position(0,0)), is(equalTo(Direction.WEST)));
    }

    @Test
    public void return_southwest_when_target_is_southwest(){
        assertThat(Direction.from(new Position(0,3)).to(new Position(3,0)), is(equalTo(Direction.SOUTH_WEST)));
    }

    @Test
    public void return_southeast_when_target_is_southeast(){
        assertThat(Direction.from(new Position(0,3)).to(new Position(4,5)), is(equalTo(Direction.SOUTH_EAST)));
    }

    @Test
    public void return_northeast_when_target_is_northeast(){
        assertThat(Direction.from(new Position(3,3)).to(new Position(0,5)), is(equalTo(Direction.NORTH_EAST)));
    }

    @Test
    public void return_northwest_when_target_is_northwest(){
        assertThat(Direction.from(new Position(3,3)).to(new Position(1,0)), is(equalTo(Direction.NORTH_WEST)));
    }
}
