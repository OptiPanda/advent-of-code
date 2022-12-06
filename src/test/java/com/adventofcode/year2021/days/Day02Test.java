package com.adventofcode.year2021.days;

public class Day02Test {

    public static final String CLASSNAME = Day02Test.class.getSimpleName();

    public static void main(String[] args) {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testAnswer1() & testAnswer2();

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    private static boolean testAnswer1() {
        final Integer answer = Day02.answer1();
        int expectedAnswer = 1488669;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    private static boolean testAnswer2() {
        final Integer answer = Day02.answer2();
        int expectedAnswer = 1176514794;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }

}