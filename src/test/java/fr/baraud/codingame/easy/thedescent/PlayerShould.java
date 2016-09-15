package fr.baraud.codingame.easy.thedescent;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerShould {

    @Test
    public void print_index_1_on_shot_HighestMountain_1_4_2_3_4_0_1(){
        ByteArrayInputStream input = new ByteArrayInputStream(String.format("1%n4%n2%n3%n4%n0%n1%n0%n").getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Player player = new Player(output);
        player.shotBiggestMountain(Mountains.fromStream(input));
        assertThat(output.toString(), is(String.format("1%n")));
    }

    @Test
    public void print_index_2_on_shot_HighestMountain_1_4_10_3_4_0_1(){
        ByteArrayInputStream input = new ByteArrayInputStream(String.format("1%n4%n10%n3%n4%n0%n1%n0%n").getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Player player = new Player(output);
        player.shotBiggestMountain(Mountains.fromStream(input));
        assertThat(output.toString(), is(String.format("2%n")));
    }


}
