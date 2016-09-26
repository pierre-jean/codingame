package fr.baraud.codingame.easy.thebridge1;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    @Test
    public void accelerate_when_not_enough_speed_to_jump() {
        Gap gap = new Gap.BuildNew()
                .atPosition(10)
                .withLength(3).build();
        Platform platform = new Platform.BuildNew().
                atPosition(13)
                .withLength(1000).build();
        Player player = new Player.BuildNew()
                .drivingAtSpeed(3)
                .fromPosition(0)
                .withGap(gap)
                .withPlatform(platform)
                .build();
        assertThat(player.bestAction(), is(Action.SPEED_UP));
    }

    @Test
    public void slowdown_when_not_enough_length_on_the_platform() {
        Gap gap = new Gap.BuildNew()
                .atPosition(200)
                .withLength(10).build();
        Platform platform = new Platform.BuildNew()
                .atPosition(210)
                .withLength(15).build();
        Player player = new Player.BuildNew()
                .drivingAtSpeed(100)
                .fromPosition(0)
                .withGap(gap)
                .withPlatform(platform).build();
        assertThat(player.bestAction(), is(Action.SLOW_DOWN));
    }

    @Test
    public void wait_if_successful_jump_and_successful_stop(){
        Gap gap = new Gap.BuildNew()
                .atPosition(31)
                .withLength(9).build();
        Platform platform = new Platform.BuildNew()
                .atPosition(40)
                .withLength(100).build();
        Player player = new Player.BuildNew()
                .drivingAtSpeed(10)
                .fromPosition(0)
                .withPlatform(platform)
                .withGap(gap).build();
        assertThat(player.bestAction(), is(Action.WAIT));
    }

    @Test
    public void slowdown_if_waiting_is_not_successful(){
        Gap gap = new Gap.BuildNew()
                .atPosition(4)
                .withLength(1).build();
        Platform platform = new Platform.BuildNew()
                .atPosition(5)
                .withLength(6).build();
        Player player = new Player.BuildNew()
                .drivingAtSpeed(2)
                .fromPosition(0)
                .withPlatform(platform)
                .withGap(gap).build();
        assertThat(player.bestAction(), is(Action.SLOW_DOWN));
    }
    
}
