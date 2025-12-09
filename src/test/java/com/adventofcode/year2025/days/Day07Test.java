package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day07Test extends AbstractDayTest<Day07, Long> {

    public Day07Test() {
        super(new Day07());
    }

    public static void main(String[] args) {
        new Day07Test().test();
    }

    @Override
    protected Long getExpectedAnswer1() {
        return 1687L;
    }

    @Override
    protected Long getExpectedAnswer2() {
        return LONG_DEFAULT;
    }
}