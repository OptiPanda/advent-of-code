package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

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
        return -1L;
    }
}