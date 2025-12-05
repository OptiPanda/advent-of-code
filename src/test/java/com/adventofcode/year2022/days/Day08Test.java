package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDayTest;

import static com.adventofcode.utils.AdventOfCodeUtils.errln;
import static com.adventofcode.utils.AdventOfCodeUtils.println;

public class Day08Test extends AbstractDayTest<Day08, Integer> {

    public Day08Test() {
        super(new Day08());
    }

    public static void main(String[] args) {
        new Day08Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 1835;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 263670;
    }

    @Override
    protected boolean otherTests() {
        return testGetDirection();
    }

    private static final Integer[][] TEST_MAP = new Integer[][]{
            {3, 0, 3, 7, 3},
            {2, 5, 5, 1, 2},
            {6, 5, 3, 3, 2},
            {3, 3, 5, 4, 9},
            {3, 5, 3, 9, 0}
    };

    private boolean testGetDirection() {
        return testGetDirectionValue(Day08.getTop(TEST_MAP, 1, 2), 1, "Top 1")
                & testGetDirectionValue(Day08.getLeft(TEST_MAP, 1, 2), 1, "Left 1")
                & testGetDirectionValue(Day08.getRight(TEST_MAP, 1, 2), 2, "Right 1")
                & testGetDirectionValue(Day08.getBottom(TEST_MAP, 1, 2), 2, "Bottom 1")

                & testGetDirectionValue(Day08.getTop(TEST_MAP, 3, 2), 2, "Top 2")
                & testGetDirectionValue(Day08.getLeft(TEST_MAP, 3, 2), 2, "Left 2")
                & testGetDirectionValue(Day08.getRight(TEST_MAP, 3, 2), 2, "Right 2")
                & testGetDirectionValue(Day08.getBottom(TEST_MAP, 3, 2), 1, "Bottom 2");
    }

    private boolean testGetDirectionValue(int answer, int expectedAnswer, String direction) {
        if (answer != expectedAnswer) {
            errln(classTestCode() + " testGetDirection " + direction + " KO | answer " + answer + " expected " + expectedAnswer);
            return false;
        }
        println(classTestCode() + " testGetDirection " + direction + " OK");
        return true;
    }
}