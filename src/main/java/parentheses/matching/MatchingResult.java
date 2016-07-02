package parentheses.matching;

public class MatchingResult {
    private final int numberOfParenthesisPairs;
    private final int numberOfUnmatchedRightParentheses;
    private final int numberOfUnmatchedLeftParentheses;

    public MatchingResult(int numberOfParenthesisPairs,
                          int numberOfUnmatchedLeftParentheses,
                          int numberOfUnmatchedRightParentheses) {
        this.numberOfParenthesisPairs = numberOfParenthesisPairs;
        this.numberOfUnmatchedLeftParentheses = numberOfUnmatchedLeftParentheses;
        this.numberOfUnmatchedRightParentheses = numberOfUnmatchedRightParentheses;
    }

    public int numberOfParenthesisPairs() {
        return numberOfParenthesisPairs;
    }

    public int numberOfUnmatchedRightParentheses() {
        return numberOfUnmatchedRightParentheses;
    }

    public int numberOfUnmatchedLeftParentheses() {
        return numberOfUnmatchedLeftParentheses;
    }

    public boolean isValid() {
        return numberOfUnmatchedLeftParentheses == 0 && numberOfUnmatchedRightParentheses == 0;
    }
}
