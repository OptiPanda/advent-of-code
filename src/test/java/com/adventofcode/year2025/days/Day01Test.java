package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

public class Day01Test extends AbstractDayTest<Day01> {

    public static final String CLASSNAME = Day01Test.class.getSimpleName();

    public Day01Test() {
        super(new Day01());
    }

    @Override
    public void test() {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testAnswer1() & testAnswer2();

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    @Override
    protected boolean testAnswer1() {
        final Integer answer = day.answer1();
        int expectedAnswer = 53921;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    @Override
    protected boolean testAnswer2() {
        final Integer answer = day.answer2();
        int expectedAnswer = 54676;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }
}
