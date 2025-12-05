package com.adventofcode.year2023.days;

import com.adventofcode.model.AbstractDayTest;

public class Day01Test extends AbstractDayTest<Day01, Integer> {

    public Day01Test() {
        super(new Day01());
    }

    public static void main(String[] args) {
        new Day01Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 53921;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 54676;
    }
}