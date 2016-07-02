package main;

import application.App;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter a string to count the number of matched parenthesis pair:");
        new App(System.in, System.out).run();
    }
}
