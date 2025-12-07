package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day05Test extends AbstractDayTest<Day05, Long> {

    public Day05Test() {
        super(new Day05());
    }

    public static void main(String[] args) {
        new Day05Test().test();
    }

    @Override
    protected Long getExpectedAnswer1() {
        return 643L;
    }

    @Override
    protected Long getExpectedAnswer2() {
        return -1L;
    }
}