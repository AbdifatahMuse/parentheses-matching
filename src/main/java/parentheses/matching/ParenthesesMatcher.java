package parentheses.matching;

import java.util.Deque;
import java.util.LinkedList;

public class ParenthesesMatcher {

    public MatchingResult match(String input) {
        Deque<Character> parenthesisStack = new LinkedList<>();

        int numberOfUnmatchedRightParentheses = 0;
        int numberOfParenthesisPairs = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '(')
                parenthesisStack.push(ch);
            else if (ch == ')') {
                if (parenthesisStack.isEmpty()) {
                    numberOfUnmatchedRightParentheses++;
                } else {
                    parenthesisStack.pop();
                    numberOfParenthesisPairs++;
                }
            }
        }

        return new MatchingResult(numberOfParenthesisPairs, parenthesisStack.size(), numberOfUnmatchedRightParentheses);
    }
}
