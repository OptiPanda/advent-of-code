package com.adventofcode.days;

public class Day2Test {

    public static final String CLASSNAME = Day2Test.class.getSimpleName();

    public static void main(String[] args) {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testAnswer1() & testAnswer2();

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    private static boolean testAnswer1() {
        final Integer answer = Day2.answer1();
        if (answer != 15337) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected 15337");
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    private static boolean testAnswer2() {
        final Integer answer = Day2.answer2();
        if (answer != 11696) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected 11696");
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }
}