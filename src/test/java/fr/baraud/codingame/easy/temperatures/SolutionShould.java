package fr.baraud.codingame.easy.temperatures;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SolutionShould {

    @Test
    public void display_1_for_temperatures_plus5_min2_plus1_plus4(){
        InputStream in = new ByteArrayInputStream(String.format("4%n5 -2 1 4").getBytes());
        int closestTemperatureToZero = Temperatures.fromStream(in).closestToZero();
        assertThat(closestTemperatureToZero, is(equalTo(1)));
    }

    @Test
    public void display_2_for_temperatures_plus5_plus2_min7_min10(){
        InputStream in = new ByteArrayInputStream(String.format("4%n5 2 -7 -10").getBytes());
        int closestTemperatureToZero = Temperatures.fromStream(in).closestToZero();
        assertThat(closestTemperatureToZero, is(equalTo(2)));
    }

    @Test
    public void display_0_when_0_measures_is_given(){
        InputStream in = new ByteArrayInputStream(String.format("0%n%n").getBytes());
        int closestTemperatureToZero = Temperatures.fromStream(in).closestToZero();
        assertThat(closestTemperatureToZero, is(equalTo(0)));
    }

    @Test
    public void display_5_for_temperatures_min5_plus5_min5(){
        InputStream in = new ByteArrayInputStream(String.format("3%n-5 5 -5%n").getBytes());
        int closestTemperatureToZero = Temperatures.fromStream(in).closestToZero();
        assertThat(closestTemperatureToZero, is(equalTo(5)));
    }
}
