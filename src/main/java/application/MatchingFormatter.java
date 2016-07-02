package application;

import parentheses.matching.MatchingResult;

public class MatchingFormatter {

    private String newLine = System.getProperty("line.separator");

    public String format(MatchingResult result) {
        return commentOnMatchedParentheses(result) + commentOnSyntax(result);
    }

    private String commentOnMatchedParentheses(MatchingResult result) {
        return "Output: " + Integer.toString(result.numberOfParenthesisPairs()) + newLine +
                "Explanation: the number of () is " + Integer.toString(result.numberOfParenthesisPairs());
    }

    private String commentOnSyntax(MatchingResult result) {
        if(result.isValid())
            return ", the whole string are valid syntax";
        else
            return ", the syntax is invalid with " + commentOnUnmatchedParentheses(result);
    }

    private String commentOnUnmatchedParentheses(MatchingResult result) {
        return commentOnUnmatchedLeftParentheses(result) + commonOnUnmatchedRightParentheses(result);
    }

    private String commonOnUnmatchedRightParentheses(MatchingResult result) {
        String output = "";

        if (result.numberOfUnmatchedRightParentheses() > 0) {
            if (result.numberOfUnmatchedLeftParentheses() > 0)
                output += " and ";
            output += result.numberOfUnmatchedRightParentheses() + " unmatched right parentheses";
        }

        return output;
    }

    private String commentOnUnmatchedLeftParentheses(MatchingResult result) {
        if (result.numberOfUnmatchedLeftParentheses() > 0)
            return result.numberOfUnmatchedLeftParentheses() + " unmatched left parentheses";
        return "";
    }
}
