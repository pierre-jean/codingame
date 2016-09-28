package fr.baraud.codingame.easy.defibrillators;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserShould {

    @Test
    public void haveCorrectLongitudeAndLatitude(){
        User user = new User.BuildNew()
                .withLatitude(0.05d)
                .withLongitude(0.32d)
                .build();
        assertThat(user.latitude(), is(equalTo(0.05d)));
        assertThat(user.longitude(), is(equalTo(0.32d)));
    }
}
