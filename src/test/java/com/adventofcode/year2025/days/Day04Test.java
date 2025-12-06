package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day04Test extends AbstractDayTest<Day04, Integer> {

    public Day04Test() {
        super(new Day04());
    }

    public static void main(String[] args) {
        new Day04Test().test();
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