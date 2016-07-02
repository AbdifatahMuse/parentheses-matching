package application;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTest {
    private ByteArrayOutputStream output;
    private static final String NEW_LINE = System.getProperty("line.separator");

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
    }

    @Test
    public void givenValidInput_ShouldReturnFormattedOutput() {
        String input = "x= fes(int) (print xxxxx)";
        App app = new App(new ByteArrayInputStream(input.getBytes()), new PrintStream(output));

        app.run();

        assertEquals("Input: " + input + NEW_LINE + "Output: 2" + NEW_LINE +
                "Explanation: the number of () is 2, the whole string are valid syntax", output.toString().trim());
    }

    @Test
    public void givenInvalidInput_ShouldReturnFormattedOutput() {
        String input = " ()aaa (bbb(sss))ss))";
        App app = new App(new ByteArrayInputStream(input.getBytes()), new PrintStream(output));

        app.run();

        assertEquals("Input: " + input + NEW_LINE + "Output: 3" + NEW_LINE +
                "Explanation: the number of () is 3, the syntax is invalid with 2 unmatched right parentheses", output.toString().trim());
    }
}
