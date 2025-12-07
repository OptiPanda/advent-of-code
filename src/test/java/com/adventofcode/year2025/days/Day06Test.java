package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day06Test extends AbstractDayTest<Day06, Integer> {

    public Day06Test() {
        super(new Day06());
    }

    public static void main(String[] args) {
        new Day06Test().test();
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