package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day02Test extends AbstractDayTest<Day02, Integer> {

    public Day02Test() {
        super(new Day02());
    }

    public static void main(String[] args) {
        new Day02Test().test();
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