package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day05Test extends AbstractDayTest<Day05, Integer> {

    public Day05Test() {
        super(new Day05());
    }

    public static void main(String[] args) {
        new Day05Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return -1;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return -1;
    }
}