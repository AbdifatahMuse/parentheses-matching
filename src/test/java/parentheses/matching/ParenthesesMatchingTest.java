package parentheses.matching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParenthesesMatchingTest {

    private ParenthesesMatcher matcher = new ParenthesesMatcher();

    @Test
    public void returnsZeroesWhenInputIsEmpty() {
        MatchingResult result = matcher.match("");

        assertEquals(0, result.numberOfParenthesisPairs());
        assertEquals(0, result.numberOfUnmatchedLeftParentheses());
        assertEquals(0, result.numberOfUnmatchedRightParentheses());
    }

    @Test
    public void returnZeroesWhenNoParenthesisInInput() {
        MatchingResult result = matcher.match("something");

        assertEquals(0, result.numberOfParenthesisPairs());
        assertEquals(0, result.numberOfUnmatchedLeftParentheses());
        assertEquals(0, result.numberOfUnmatchedRightParentheses());
    }

    @Test
    public void returnsOneForInputWithOnlyOneRightParenthesis() {
        MatchingResult result = matcher.match(")");

        assertEquals(0, result.numberOfParenthesisPairs());
        assertEquals(0, result.numberOfUnmatchedLeftParentheses());
        assertEquals(1, result.numberOfUnmatchedRightParentheses());
    }

    @Test
    public void returnsOneForInputWithOnlyOneLeftParenthesis() {
        MatchingResult result = matcher.match("(");

        assertEquals(0, result.numberOfParenthesisPairs());
        assertEquals(1, result.numberOfUnmatchedLeftParentheses());
        assertEquals(0, result.numberOfUnmatchedRightParentheses());
    }

    @Test
    public void returnsBothLeftAndRightUnmatchedParentheses() {
        MatchingResult result = matcher.match(")())()aaa (bbb(sss))ss))((");

        assertEquals(4, result.numberOfParenthesisPairs());
        assertEquals(2, result.numberOfUnmatchedLeftParentheses());
        assertEquals(4, result.numberOfUnmatchedRightParentheses());
    }

    @Test
    public void returnsUnmatchedRightParentheses() {
        MatchingResult result = matcher.match("()aaa (bbb(sss))ss))");

        assertEquals(3, result.numberOfParenthesisPairs());
        assertEquals(0, result.numberOfUnmatchedLeftParentheses());
        assertEquals(2, result.numberOfUnmatchedRightParentheses());
    }

    @Test
    public void matchesParenthesesWhenTheyAreCorrectlyPaired() {
        MatchingResult result = matcher.match("x= fes(int) (print xxxxx)");

        assertEquals(2, result.numberOfParenthesisPairs());
        assertEquals(0, result.numberOfUnmatchedLeftParentheses());
        assertEquals(0, result.numberOfUnmatchedRightParentheses());
    }

}
