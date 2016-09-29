package fr.baraud.codingame.easy.marslander1;

import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SolutionShould {

    private static final String EXAMPLE_1_INPUT = "fr/baraud/codingame/easy/marslander1/example_1_input.txt";
    private static final String EXAMPLE_1_OUTPUT = "fr/baraud/codingame/easy/marslander1/example_1_output.txt";

    private void assert_solving_input_resource_produces_output_resource(String inputResource, String outputResource) throws IOException, URISyntaxException {
        InputStream in = new FileInputStream(getClass().getClassLoader().getResource(inputResource).getFile());
        OutputStream out = new ByteArrayOutputStream();
        Solution.solve(in, out);
        String expected = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(outputResource).toURI())));
        assertThat(out.toString(), is(equalTo(expected)));
    }

    @Test
    public void solve_example() throws IOException, URISyntaxException {
        assert_solving_input_resource_produces_output_resource(EXAMPLE_1_INPUT, EXAMPLE_1_OUTPUT);
    }
}
