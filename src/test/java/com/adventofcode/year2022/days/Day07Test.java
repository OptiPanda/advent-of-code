package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDayTest;

public class Day07Test extends AbstractDayTest<Day07, Integer> {

    public Day07Test() {
        super(new Day07());
    }

    public static void main(String[] args) {
        new Day07Test().test();
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 1390824;
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 7490863;
    }
}