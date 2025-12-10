package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day08Test extends AbstractDayTest<Day08, Integer> {

    public Day08Test() {
        super(new Day08());
    }

    public static void main(String[] args) {
        new  Day08Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return INT_DEFAULT;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return INT_DEFAULT;
    }
}