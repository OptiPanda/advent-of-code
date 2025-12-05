package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

import java.util.List;

import static com.adventofcode.utils.AdventOfCodeUtils.*;

class Day02Test extends AbstractDayTest<Day02, Long> {

    public Day02Test() {
        super(new Day02());
    }

    public static void main(String[] args) {
        new Day02Test().test();
    }

    @Override
    protected Long getExpectedAnswer1() {
        return 17077011375L;
    }

    @Override
    protected Long getExpectedAnswer2() {
        return 36037497037L;
    }

    @Override
    protected boolean otherTests() {
        return countMatches();
    }

    List<Long> testValues = List.of(
            11L,
            22L,
            99L,
            111L,
            999L,
            1010L,
            1188511885L,
            222222L,
            446446L,
            38593859L,
            565656L
    );

    private boolean countMatches() {

        int expected = 7;

        boolean answer = true;
        for (Long testValue : testValues) {
            answer &= day.hasDuplicateSequences(testValue);
        }

        if (answer != true) {
            errln(classTestCode() + " countMatches KO | expected " + expected + " got " + answer);
            return false;
        }
        println(classTestCode() + " countMatches OK");
        return true;
    }
}