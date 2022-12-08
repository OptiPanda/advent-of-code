package com.adventofcode.year2022.days;

import com.adventofcode.DayTest;

public class Day08Test extends DayTest {

    public static final String CLASSNAME = Day08Test.class.getSimpleName();

    private static final Integer[][] TEST_MAP = new Integer[][]{
            {3, 0, 3, 7, 3},
            {2, 5, 5, 1, 2},
            {6, 5, 3, 3, 2},
            {3, 3, 5, 4, 9},
            {3, 5, 3, 9, 0}
    };

    public static void test() {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testAnswer1() & testGetDirection() & testAnswer2();

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    private static boolean testAnswer1() {
        final Integer answer = Day08.answer1();
        int expectedAnswer = 1835;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    private static boolean testAnswer2() {
        final Integer answer = Day08.answer2();
        int expectedAnswer = 263670;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }

    private static boolean testGetDirection() {

        return testGetDirectionValue(Day08.getTop(TEST_MAP, 1, 2), 1, "Top 1")
                & testGetDirectionValue(Day08.getLeft(TEST_MAP, 1, 2), 1, "Left 1")
                & testGetDirectionValue(Day08.getRight(TEST_MAP, 1, 2), 2, "Right 1")
                & testGetDirectionValue(Day08.getBottom(TEST_MAP, 1, 2), 2, "Bottom 1")

                & testGetDirectionValue(Day08.getTop(TEST_MAP, 3, 2), 2, "Top 2")
                & testGetDirectionValue(Day08.getLeft(TEST_MAP, 3, 2), 2, "Left 2")
                & testGetDirectionValue(Day08.getRight(TEST_MAP, 3, 2), 2, "Right 2")
                & testGetDirectionValue(Day08.getBottom(TEST_MAP, 3, 2), 1, "Bottom 2");
    }

    private static boolean testGetDirectionValue(int answer, int expectedAnswer, String direction) {
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " testGetDirection " + direction + " KO | answer " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " testGetDirection " + direction + " OK");
        return true;
    }
}