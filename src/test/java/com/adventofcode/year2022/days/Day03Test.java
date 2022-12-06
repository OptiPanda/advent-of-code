package com.adventofcode.year2022.days;

public class Day03Test {

    public static final String CLASSNAME = Day03Test.class.getSimpleName();

    public static void main(String[] args) {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testCalcCharScore() & testAnswer1() & testAnswer2();

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    private static boolean testAnswer1() {
        final Integer answer = Day03.answer1();
        int expectedAnswer = 8153;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    private static boolean testAnswer2() {
        final Integer answer = Day03.answer2();
        int expectedAnswer = 2342;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }

    private static boolean testCalcCharScore() {
        boolean isOk = true;
        char letter = 'a';
        for (int i = 1; i < 27; i++, letter++) {
            final int answer = Day03.calcCharScore(letter);
            isOk &= answer == i;

            if (answer != i) {
                System.err.println(CLASSNAME + " CalcCharScore KO | given '" + letter + "' expected " + i + " got " + answer);
            }
        }

        letter = 'A';
        for (int i = 27; i < 53; i++, letter++) {
            final int answer = Day03.calcCharScore(letter);
            isOk &= answer == i;

            if (answer != i) {
                System.err.println(CLASSNAME + " CalcCharScore KO | given '" + letter + "' expected " + i + " got " + answer);
            }
        }

        System.out.println(CLASSNAME + " CalcCharScore OK");

        return isOk;
    }
}