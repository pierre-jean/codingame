package fr.baraud.codingame.easy.defibrillators;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DefibrillatorShould {

    @Test
    public void buildFromScanner(){
        InputStream in = new ByteArrayInputStream(
                String.format("4;Centre municipal Garosud;34000 Montpellier;04 67 34 74 62;3,85859221929501;43,5725732056683%n")
                .getBytes());
        Scanner scanner = new Scanner(in);
        Defibrillator defibrillator = new Defibrillator.BuildNew().fromScanner(scanner).build();
        Defibrillator clonedDefibrillator = new Defibrillator.BuildNew()
                .withLatitude(43.5725732056683d)
                .withLongitude(3.85859221929501d)
                .withPhone("04 67 34 74 62")
                .withAddress("34000 Montpellier")
                .withName("Centre municipal Garosud")
                .withId(4)
                .build();
        assertThat(defibrillator, is(equalTo(clonedDefibrillator)));
    }

    @Test
    public void compute_the_right_longitude_distance(){
        User user = new User.BuildNew()
                .withLatitude(0)
                .withLongitude(0)
                .build();
        Defibrillator defibrillator = new Defibrillator.BuildNew()
                .withLongitude(90d)
                .withLatitude(0d)
                .build();
        assertThat(defibrillator.distanceTo(user), is(equalTo(90d*6371)));
    }

    @Test
    public void compute_the_right_latitude_distance(){
        User user = new User.BuildNew()
                .withLatitude(0)
                .withLongitude(0)
                .build();
        Defibrillator defibrillator = new Defibrillator.BuildNew()
                .withLongitude(0d)
                .withLatitude(90d)
                .build();
        assertThat(defibrillator.distanceTo(user), is(equalTo(90d*6371)));
    }
}
