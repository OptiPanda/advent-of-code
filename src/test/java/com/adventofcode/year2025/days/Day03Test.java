package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

public class Day03Test extends AbstractDayTest<Day03, Long> {

    public Day03Test() {
        super(new Day03());
    }

    public static void main(String[] args) {
        new Day03Test().test();
    }

    @Override
    protected Long getExpectedAnswer1() {
        return 17359L;
    }

    @Override
    protected Long getExpectedAnswer2() {
        return 172787336861064L;
    }
}
