package fr.baraud.codingame.easy.defibrillators;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DefibrillatorDirectoryShould {

    @Test
    public void return_the_closest_dashboard(){
        Defibrillator closestDefibrillator = new Defibrillator.BuildNew()
                .withLatitude(10d)
                .withLongitude(10d)
                .build();
        Defibrillator farthestDefibrillator = new Defibrillator.BuildNew()
                .withLatitude(15d)
                .withLongitude(15d)
                .build();
        DefibrillatorDirectory directory = new DefibrillatorDirectory.BuildNew()
                .addDefibrillator(closestDefibrillator)
                .addDefibrillator(farthestDefibrillator)
                .build();
        User user = new User.BuildNew()
                .withLongitude(0)
                .withLatitude(0)
                .build();
        assertThat(directory.getClosestTo(user), is(equalTo(closestDefibrillator)));
    }

    @Test
    public void return_defibrillator_at_exact_position_if_available(){
        Defibrillator closestDefibrillator = new Defibrillator.BuildNew()
                .withName("Centre municipal Garosud")
                .withLatitude(43.5725732056683d)
                .withLongitude(3.85859221929501d)
                .build();
        Defibrillator farthestDefibrillator = new Defibrillator.BuildNew()
                .withName("Cimetiere Saint-Etienne")
                .withLatitude(3.88995587137398d)
                .withLongitude(43.6260090150577d)
                .build();
        DefibrillatorDirectory directory = new DefibrillatorDirectory.BuildNew()
                .addDefibrillator(closestDefibrillator)
                .addDefibrillator(farthestDefibrillator)
                .build();
        User user = new User.BuildNew()
                .withLongitude(3.88995587137398d)
                .withLatitude(43.6260090150577d)
                .build();
        assertThat(directory.getClosestTo(user), is(equalTo(closestDefibrillator)));
    }
}
