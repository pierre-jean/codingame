package fr.baraud.codingame.easy.thebridge1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    @Test
    public void accelerate_when_not_enough_speed_to_jump() {
        Player player = new Player.BuildNew().drivingAtSpeed(0).fromPosition(0).build();
        Bridge bridge = new Bridge.BuildNew().atPosition(10).withLength(100).build();
        assertThat(player.actionToJump(bridge), is(Action.SPEED_UP));
    }

    @Test
    public void slowdown_when_not_enough_length_on_the_platform() {
        Player player = new Player.BuildNew().drivingAtSpeed(100).fromPosition(0).build();
        Bridge bridge = new Bridge.BuildNew().atPosition(200).withLength(10).build();
        assertThat(player.actionToJump(bridge), is(Action.SLOW_DOWN));
    }
    
}
