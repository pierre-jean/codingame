package fr.baraud.codingame.easy.marslander1;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
    public void build_correct_landscape_from_scanner(){
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
    public void build_correct_lander_from_scanner(){
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
}
