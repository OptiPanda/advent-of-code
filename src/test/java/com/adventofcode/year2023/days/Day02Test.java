package com.adventofcode.year2023.days;

import com.adventofcode.model.AbstractDayTest;

public class Day02Test extends AbstractDayTest<Day02, Integer> {

    public Day02Test() {
        super(new Day02());
    }

    public static void main(String[] args) {
        new Day02Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 2771;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 70924;
    }
}