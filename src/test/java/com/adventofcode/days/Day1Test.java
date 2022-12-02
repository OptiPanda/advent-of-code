package com.adventofcode.days;

public class Day1Test {

    public static void main(String[] args) {
        boolean isOk = true;
        isOk &= testAnswer1();
        isOk &= testAnswer2();
        System.out.println(Day1Test.class.getSimpleName() + " : All test " + (isOk ? "OK" : "KO"));
    }

    static boolean testAnswer1() {
        final Integer answer = Day1.answer1();
        if (answer != 69501) {
            System.err.println("Day1 answer 1 incorrect | given " + answer + " expected 69501");
            return false;
        }
        return true;
    }

    static boolean testAnswer2() {
        final Integer answer = Day1.answer2();
        if (answer != 202346) {
            System.err.println("Day1 answer 2 incorrect | given " + answer + " expected 202346");
            return false;
        }
        return true;
    }

}