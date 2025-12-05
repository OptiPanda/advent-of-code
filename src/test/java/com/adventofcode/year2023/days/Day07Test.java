package com.adventofcode.year2023.days;

import com.adventofcode.model.AbstractDayTest;

public class Day07Test extends AbstractDayTest<Day07, Integer> {
    public Day07Test() {
        super(new Day07());
    }

    public static void main(String[] args) {
        new Day07Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 245794640;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 247899149;
    }
}