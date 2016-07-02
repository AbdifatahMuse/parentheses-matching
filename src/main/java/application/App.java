package application;

import parentheses.matching.ParenthesesMatcher;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    private final InputStream inputStream;
    private final PrintStream outputStream;

    public App(InputStream inputStream, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void run() {
        ParenthesesMatcher matcher = new ParenthesesMatcher();
        MatchingFormatter formatter = new MatchingFormatter();

        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                outputStream.println("Input: " + input);
                outputStream.println(formatter.format(matcher.match(input)));
            }
        }
    }
}
