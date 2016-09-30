package fr.baraud.codingame.easy.marslander1;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class BuilderShould {
    private static final String MARS_LANDSCAPE_INPUT = String.format(
            "6%n" +
                    "0 200%n" +
                    "100 100%n" +
                    "3000 100%n" +
                    "6999 1000%n"
    );
    private static final String MARS_LANDER_INPUT = String.format(
            "15 200 0 -5 100 3 2%n"
    );

    @Test
    public void build_same_landscape_from_scanner_or_from_parameter(){
        Landscape landscapeFromParameters = Builder.buildLandscape()
                .addEdge(0, 200)
                .addEdge(100, 100)
                .addEdge(3000, 100)
                .addEdge(6999, 1000)
                .build();
        Landscape landscapeFromScanner = Builder.buildLandscape()
                .fromScanner(new Scanner(
                        new ByteArrayInputStream(MARS_LANDSCAPE_INPUT.getBytes()))
                )
                .build();
        assertThat(landscapeFromScanner, is(equalTo(landscapeFromParameters)));
    }

    @Test
    public void build_same_lander_from_scanner_or_from_parameter(){
        Lander landerFromParameters = Builder.buildLander()
                .atXCoord(15)
                .atYCoord(200)
                .atHorizontalSpeed(0)
                .atVerticalSpeed(-5)
                .withFuelAmount(100)
                .withRotation(3)
                .withPower(2)
                .build();
        Lander landerFromScanner = Builder.buildLander()
                .fromScanner(new Scanner(
                        new ByteArrayInputStream(MARS_LANDER_INPUT.getBytes()))
                )
                .build();
        assertThat(landerFromScanner, is (equalTo(landerFromParameters)));
    }

    @Test
    public void not_build_lander_equal_to_lander_with_different_x_pos(){
        Lander lander1 = Builder.buildLander()
                .atXCoord(15)
                .build();
        Lander lander2 = Builder.buildLander()
                .atXCoord(0)
                .build();
        assertThat(lander1, is(not(equalTo(lander2))));
    }

    @Test
    public void not_build_lander_equal_to_lander_with_different_y_pos(){
        Lander lander1 = Builder.buildLander()
                .atYCoord(15)
                .build();
        Lander lander2 = Builder.buildLander()
                .atYCoord(0)
                .build();
        assertThat(lander1, is(not(equalTo(lander2))));
    }

    @Test
    public void not_build_lander_equal_to_lander_with_different_horizontal_speed(){
        Lander lander1 = Builder.buildLander()
                .atHorizontalSpeed(5)
                .build();
        Lander lander2 = Builder.buildLander()
                .atHorizontalSpeed(0)
                .build();
        assertThat(lander1, is(not(equalTo(lander2))));
    }

    @Test
    public void not_build_lander_equal_to_lander_with_different_vertical_speed(){
        Lander lander1 = Builder.buildLander()
                .atVerticalSpeed(5)
                .build();
        Lander lander2 = Builder.buildLander()
                .atVerticalSpeed(0)
                .build();
        assertThat(lander1, is(not(equalTo(lander2))));
    }

    @Test
    public void not_build_lander_equal_to_lander_with_different_fuel_amount(){
        Lander lander1 = Builder.buildLander()
                .withFuelAmount(5)
                .build();
        Lander lander2 = Builder.buildLander()
                .withFuelAmount(0)
                .build();
        assertThat(lander1, is(not(equalTo(lander2))));
    }

    @Test
    public void not_build_lander_equal_to_lander_with_different_rotation(){
        Lander lander1 = Builder.buildLander()
                .withRotation(5)
                .build();
        Lander lander2 = Builder.buildLander()
                .withRotation(0)
                .build();
        assertThat(lander1, is(not(equalTo(lander2))));
    }

    @Test
    public void not_build_lander_equal_to_lander_with_different_power(){
        Lander lander1 = Builder.buildLander()
                .withPower(4)
                .build();
        Lander lander2 = Builder.buildLander()
                .withPower(0)
                .build();
        assertThat(lander1, is(not(equalTo(lander2))));
    }
}
