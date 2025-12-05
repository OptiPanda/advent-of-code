package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDayTest;

import static com.adventofcode.utils.AdventOfCodeUtils.errln;
import static com.adventofcode.utils.AdventOfCodeUtils.println;

public class Day03Test extends AbstractDayTest<Day03, Integer> {

    public Day03Test() {
        super(new Day03());
    }

    public static void main(String[] args) {
        new Day03Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 8153;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 2342;
    }

    @Override
    protected boolean otherTests() {
        return testCalcCharScore();
    }

    private boolean testCalcCharScore() {
        boolean isOk = true;
        char letter = 'a';
        for (int i = 1; i < 27; i++, letter++) {
            final int answer = Day03.calcCharScore(letter);
            isOk &= answer == i;

            if (answer != i) {
                errln(className + " CalcCharScore KO | given '" + letter + "' expected " + i + " got " + answer);
            }
        }

        letter = 'A';
        for (int i = 27; i < 53; i++, letter++) {
            final int answer = Day03.calcCharScore(letter);
            isOk &= answer == i;

            if (answer != i) {
                errln(className + " CalcCharScore KO | given '" + letter + "' expected " + i + " got " + answer);
            }
        }

        println(className + " CalcCharScore OK");

        return isOk;
    }
}