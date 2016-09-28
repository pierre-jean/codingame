package fr.baraud.codingame.easy.defibrillators;

import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SolutionShould {
    private static final String TEST_1_INPUT = "fr.baraud.codingame.easy.defibrillators/test_1_input.txt";
    private static final String TEST_1_OUTPUT = "fr.baraud.codingame.easy.defibrillators/test_1_output.txt";
    private static final String TEST_EXAMPLE_INPUT = "fr.baraud.codingame.easy.defibrillators/input_example.txt";
    private static final String TEST_EXAMPLE_OUTPUT = "fr.baraud.codingame.easy.defibrillators/output_example.txt";
    private static final String TEST_2_INPUT = "fr.baraud.codingame.easy.defibrillators/test_2_input.txt";
    private static final String TEST_2_OUTPUT = "fr.baraud.codingame.easy.defibrillators/test_2_output.txt";
    private static final String TEST_3_INPUT = "fr.baraud.codingame.easy.defibrillators/test_3_input.txt";
    private static final String TEST_3_OUTPUT = "fr.baraud.codingame.easy.defibrillators/test_3_output.txt";
    private static final String TEST_4_INPUT = "fr.baraud.codingame.easy.defibrillators/test_4_input.txt";
    private static final String TEST_4_OUTPUT = "fr.baraud.codingame.easy.defibrillators/test_4_output.txt";

    private void assertInputResourceGiveOutputResource(String inputResource, String outputResource) throws IOException, URISyntaxException {
        InputStream in = new FileInputStream(getClass().getClassLoader().getResource(inputResource).getFile());
        OutputStream out = new ByteArrayOutputStream();
        Solution.solve(in, out);
        String expected = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(outputResource).toURI())));
        assertThat(out.toString(), is(equalTo(expected)));
    }

    @Test
    public void solve_example() throws IOException, URISyntaxException {
        assertInputResourceGiveOutputResource(TEST_EXAMPLE_INPUT,TEST_EXAMPLE_OUTPUT);
    }

    @Test
    public void solve_test_1() throws IOException, URISyntaxException {
        assertInputResourceGiveOutputResource(TEST_1_INPUT,TEST_1_OUTPUT);
    }

    @Test
    public void solve_test_2() throws IOException, URISyntaxException {
        assertInputResourceGiveOutputResource(TEST_2_INPUT,TEST_2_OUTPUT);
    }

    @Test
    public void solve_test_3() throws IOException, URISyntaxException {
        assertInputResourceGiveOutputResource(TEST_3_INPUT,TEST_3_OUTPUT);
    }

    @Test
    public void solve_test_4() throws IOException, URISyntaxException {
        assertInputResourceGiveOutputResource(TEST_4_INPUT,TEST_4_OUTPUT);
    }
}
