package com.adventofcode.year2022.days;

public class Day05Test {

    public static final String CLASSNAME = Day05Test.class.getSimpleName();

    public static void main(String[] args) {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testGetOrder() & testAnswer1() & testAnswer2();

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    private static boolean testAnswer1() {
        final String answer = Day05.answer1();
        String expectedAnswer = "TWSGQHNHL";
        if (!answer.equals(expectedAnswer)) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    private static boolean testAnswer2() {
        final String answer = Day05.answer2();
        String expectedAnswer = "JNRSCDWPP";
        if (!answer.equals(expectedAnswer)) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }

    private static boolean testGetOrder() {
        final Day05.Order answer = Day05.getOrder("move 4 from 5 to 6");
        if (answer.move != 4) {
            System.err.println(CLASSNAME + " testGetOrder KO | given 4 expected 4 got" + answer.move);
            return false;
        }
        if (answer.from != 5) {
            System.err.println(CLASSNAME + " testGetOrder KO | given 5 expected 5 got" + answer.from);
            return false;
        }
        if (answer.to != 6) {
            System.err.println(CLASSNAME + " testGetOrder KO | given 6 expected 6 got" + answer.to);
            return false;
        }
        System.out.println(CLASSNAME + " testGetOrder OK");
        return true;
    }
}