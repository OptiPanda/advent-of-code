package com.adventofcode.model;

public abstract class AbstractDayTest<T extends AbstractDay> {

    protected T day;
    protected String className;

    public AbstractDayTest(T day) {
        this.day = day;
        this.className = day.getClass().getSimpleName();
    }

    protected abstract int getExpectedAnswer1();

    protected abstract int getExpectedAnswer2();

    public void test() {
        System.out.println(className + " : Start tests");
        System.out.println("---");

        boolean isOk = testAnswer1() & testAnswer2();

        System.out.println("---");

        System.out.println(className + " : All test " + (isOk ? "OK" : "KO"));
    }

    protected boolean testAnswer1() {
        final Integer answer = day.answer1();
        if (answer != getExpectedAnswer1()) {
            System.err.println(className + " answer 1 KO | given " + answer + " expected " + getExpectedAnswer1());
            return false;
        }
        System.out.println(className + " answer 1 OK");
        return true;
    }

    protected boolean testAnswer2() {
        final Integer answer = day.answer2();
        if (answer != getExpectedAnswer2()) {
            System.err.println(className + " answer 2 KO | given " + answer + " expected " + getExpectedAnswer2());
            return false;
        }
        System.out.println(className + " answer 2 OK");
        return true;
    }
}
