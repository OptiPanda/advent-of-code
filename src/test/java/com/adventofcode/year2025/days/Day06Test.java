package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

class Day06Test extends AbstractDayTest<Day06, Long> {

    public Day06Test() {
        super(new Day06());
    }

    public static void main(String[] args) {
        new Day06Test().test();
    }

    @Override
    protected Long getExpectedAnswer1() {
        return 4719804927602L;
    }

    @Override
    protected Long getExpectedAnswer2() {
        return 9608327000261L;
    }
}