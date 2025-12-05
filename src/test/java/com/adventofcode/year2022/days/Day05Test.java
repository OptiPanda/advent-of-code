package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDayTest;

import static com.adventofcode.utils.AdventOfCodeUtils.errln;
import static com.adventofcode.utils.AdventOfCodeUtils.println;

public class Day05Test extends AbstractDayTest<Day05, String> {

    public Day05Test() {
        super(new Day05());
    }

    public static void main(String[] args) {
        new Day05Test().test();
    }

    @Override
    protected String getExpectedAnswer1() {
        return "TWSGQHNHL";
    }

    @Override
    protected String getExpectedAnswer2() {
        return "JNRSCDWPP";
    }

    @Override
    protected boolean otherTests() {
        return testGetOrder();
    }

    private boolean testGetOrder() {
        final Day05.Order answer = Day05.getOrder("move 4 from 5 to 6");
        if (answer.move != 4) {
            errln(className + " testGetOrder KO | given 4 expected 4 got" + answer.move);
            return false;
        }
        if (answer.from != 5) {
            errln(className + " testGetOrder KO | given 5 expected 5 got" + answer.from);
            return false;
        }
        if (answer.to != 6) {
            errln(className + " testGetOrder KO | given 6 expected 6 got" + answer.to);
            return false;
        }
        println(className + " testGetOrder OK");
        return true;
    }
}