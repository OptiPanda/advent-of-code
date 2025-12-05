package com.adventofcode.year2023.days;

import com.adventofcode.model.AbstractDayTest;

public class Day03Test extends AbstractDayTest<Day03, Integer> {

    public Day03Test() {
        super(new Day03());
    }

    public static void main(String[] args) {
        new Day03Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 538046;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 0;
    }
}