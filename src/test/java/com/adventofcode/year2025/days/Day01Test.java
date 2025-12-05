package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDayTest;

import java.util.Scanner;

import static com.adventofcode.utils.AdventOfCodeUtils.debug;
import static com.adventofcode.utils.AdventOfCodeUtils.errln;

public class Day01Test extends AbstractDayTest<Day01, Integer> {

    public Day01Test() {
        super(new Day01());
    }

    public static void main(String[] args) {
        new Day01Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 1052;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 6295;
    }

    @Override
    protected boolean otherTests() {
        return logicAnswer2();
    }

    private boolean logicAnswer2() {
        String input = """
            R50
            L1
            R2
            L301
            R100    
        """;

        final Integer answer = day.logicAnswer2(new Scanner(input));
        debug(answer);

        int expected = 7;

        if (answer != expected) {
            errln(className + " logicAnswer2 KO | expected " + expected + " got " + answer);
        }
        return answer == expected;
    }
}
