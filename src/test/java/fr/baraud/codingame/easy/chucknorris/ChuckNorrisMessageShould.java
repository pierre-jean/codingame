package fr.baraud.codingame.easy.chucknorris;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ChuckNorrisMessageShould {

    @Test
    public void display_0_0_00_0000_0_00_for_C() {
        ChuckNorrisMessage chuckNorrisMessage = new ChuckNorrisMessage("C");
        assertThat(chuckNorrisMessage.toString(), is(equalTo("0 0 00 0000 0 00")));
    }

    @Test
    public void display_0_0_00_0000_0_000_00_0000_0_00_for_CC() {
        ChuckNorrisMessage chuckNorrisMessage = new ChuckNorrisMessage("CC");
        assertThat(chuckNorrisMessage.toString(), is(equalTo("0 0 00 0000 0 000 00 0000 0 00")));
    }


}
