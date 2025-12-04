package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

public class Day01Test extends AbstractDayTest<Day01> {

    public Day01Test() {
        super(new Day01());
    }

    public static void main(String[] args) {
        new Day01Test().test();
    }

    @Override
    protected int getExpectedAnswer1() {
        return 1052;
    }

    @Override
    protected int getExpectedAnswer2() {
        return 0;
    }
}
