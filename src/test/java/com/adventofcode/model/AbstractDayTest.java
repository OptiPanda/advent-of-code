package com.adventofcode.model;

import org.jetbrains.annotations.NotNull;

import static com.adventofcode.utils.AdventOfCodeUtils.errln;
import static com.adventofcode.utils.AdventOfCodeUtils.println;

public abstract class AbstractDayTest<T extends AbstractDay<U>, U> {

    protected static final Long LONG_DEFAULT = -1L;
    protected static final Integer INT_DEFAULT = -1;
    protected static final String STRING_DEFAULT = "NULL";

    protected T day;
    private final int year;
    private final String className;

    public AbstractDayTest(T day) {
        this.day = day;
        final var aClass = day.getClass();
        this.className = aClass.getSimpleName();
        year = Integer.parseInt(aClass.getPackageName().replaceAll(".*year(\\d{4}).*", "$1"));
    }

    protected abstract U getExpectedAnswer1();

    protected abstract U getExpectedAnswer2();

    protected boolean otherTests() {
        return true;
    }

    public void test() {
        println(classTestCode() + " : Start tests");
        println("---");

        boolean isOk = otherTests() & testAnswer1() & testAnswer2();

        println("---");

        if (isOk) {
            println(classTestCode() + " : All test OK");
        } else {
            errln(classTestCode() + " : All test KO");
        }
    }

    @NotNull
    protected String classTestCode() {
        return "[" + year + "/" + className + "]";
    }

    protected boolean testAnswer1() {
        final U answer = day.answer1();
        if (!answer.equals(getExpectedAnswer1())) {
            errln(classTestCode() + " answer 1 KO | given " + answer + " expected " + getExpectedAnswer1());
            return false;
        }
        println(classTestCode() + " answer 1 OK");
        return true;
    }

    protected boolean testAnswer2() {
        final U answer = day.answer2();
        if (!answer.equals(getExpectedAnswer2())) {
            errln(classTestCode() + " answer 2 KO | given " + answer + " expected " + getExpectedAnswer2());
            return false;
        }
        println(classTestCode() + " answer 2 OK");
        return true;
    }
}
