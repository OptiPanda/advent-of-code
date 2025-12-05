package com.adventofcode.year2023.days;

import com.adventofcode.model.AbstractDayTest;

public class Day08Test extends AbstractDayTest<Day08, Long> {
    public Day08Test() {
        super(new Day08());
    }

    public static void main(String[] args) {
        new Day08Test().test();
    }

    @Override
    protected Long getExpectedAnswer1() {
        return 20221L;
    }

    @Override
    protected Long getExpectedAnswer2() {
        return 14616363770447L;
    }
}