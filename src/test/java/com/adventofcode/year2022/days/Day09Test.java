package com.adventofcode.year2022.days;

import com.adventofcode.DayTest;

public class Day09Test extends DayTest {

    public static final String CLASSNAME = Day09Test.class.getSimpleName();

    public static void test() {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testAnswer1() & testAnswer2();

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    private static boolean testAnswer1() {
        final Integer answer = Day09.answer1();
        int expectedAnswer = 0;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    private static boolean testAnswer2() {
        final Integer answer = Day09.answer2();
        int expectedAnswer = 0;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }
}