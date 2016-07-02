package application;

import org.junit.Test;
import parentheses.matching.MatchingResult;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MatchingFormatterTest {
    private static final String NEW_LINE = System.getProperty("line.separator");

    private final Random random = new Random();
    private final MatchingFormatter formatter = new MatchingFormatter();

    @Test
    public void formatsValidMatchingResult() {
        int parenthesisPairs = someNonZeroInt();

        String output = formatter.format(new MatchingResult(parenthesisPairs, 0, 0));

        assertEquals(output, "Output: " + parenthesisPairs + NEW_LINE +
                "Explanation: the number of () is " + parenthesisPairs + ", the whole string are valid syntax");
    }

    @Test
    public void formatsMatchingResultWithUnmatchedLeftParentheses() {
        int parenthesisPairs = someNonZeroInt();
        int unmatchedLeftParentheses = someNonZeroInt();

        String output = formatter.format(new MatchingResult(parenthesisPairs, unmatchedLeftParentheses, 0));

        assertEquals(output, "Output: " + parenthesisPairs + NEW_LINE +
                "Explanation: the number of () is " + parenthesisPairs +
                ", the syntax is invalid with " + unmatchedLeftParentheses + " unmatched left parentheses");
    }

    @Test
    public void formatsMatchingResultWithUnmatchedRightParentheses() {
        int parenthesisPairs = someNonZeroInt();
        int unmatchedRightParentheses = someNonZeroInt();

        String output = formatter.format(new MatchingResult(parenthesisPairs, 0, unmatchedRightParentheses));

        assertEquals(output, "Output: " + parenthesisPairs + NEW_LINE +
                "Explanation: the number of () is " + parenthesisPairs +
                ", the syntax is invalid with " + unmatchedRightParentheses + " unmatched right parentheses");
    }

    @Test
    public void formatsMatchingResultWithBothUnmatchedLeftAndRightParentheses() {
        int parenthesisPairs = someNonZeroInt();
        int unmatchedLeftParentheses = someNonZeroInt();
        int unmatchedRightParentheses = someNonZeroInt();

        String output = formatter.format(new MatchingResult(parenthesisPairs, unmatchedLeftParentheses, unmatchedRightParentheses));

        assertEquals(output, "Output: " + parenthesisPairs + NEW_LINE +
                "Explanation: the number of () is " + parenthesisPairs +
                ", the syntax is invalid with " + unmatchedLeftParentheses + " unmatched left parentheses" +
                " and " + unmatchedRightParentheses + " unmatched right parentheses");
    }

    private int someNonZeroInt() {
        return random.nextInt(10) + 1;
    }
}