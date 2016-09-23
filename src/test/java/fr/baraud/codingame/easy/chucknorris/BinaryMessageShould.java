package fr.baraud.codingame.easy.chucknorris;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BinaryMessageShould {

    @Test
    public void convert_ascii_C_to_binary_1000011(){
        assertThat(BinaryMessage.encodeToBinary("C"), is(equalTo("1000011")));
    }


    @Test
    public void return_000_for_extract_first_sequence_000101000() {
        assertThat(BinaryMessage.extractFirstSeq("000101000"), is(equalTo("000")));
    }

    @Test
    public void return_sequences_from_000101000(){
        BinaryMessage message = BinaryMessage.fromBinary("000101000");
        List<String> sequences = message.getSequencesOfZeroAndOnes();
        assertThat(sequences.size(), is(equalTo(5)));
        assertThat(sequences.get(0), is(equalTo("000")));
        assertThat(sequences.get(1), is(equalTo("1")));
        assertThat(sequences.get(2), is(equalTo("0")));
        assertThat(sequences.get(3), is(equalTo("1")));
        assertThat(sequences.get(4), is(equalTo("000")));
    }


}
