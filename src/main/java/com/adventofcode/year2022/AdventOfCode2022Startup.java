package com.adventofcode.year2022;

import com.adventofcode.model.AbstractAdventOfCodeStartup;
import com.adventofcode.year2022.days.*;

import static com.adventofcode.utils.AdventOfCodeUtils.log;

public class AdventOfCode2022Startup extends AbstractAdventOfCodeStartup {

    @Override
    public void main() throws Exception {
        AdventOfCode2022Startup.main(null);
    }

    public static void main(String[] args) {
        log("Starting AdventOfCode2022");

        System.out.println("2022 Day 1 - 1 : " + Day01.answer1());
        System.out.println("2022 Day 1 - 2 : " + Day01.answer2());

        System.out.println("2022 Day 2 - 1 : " + Day02.answer1());
        System.out.println("2022 Day 2 - 2 : " + Day02.answer2());

        System.out.println("2022 Day 3 - 1 : " + Day03.answer1());
        System.out.println("2022 Day 3 - 2 : " + Day03.answer2());

        System.out.println("2022 Day 4 - 1 : " + Day04.answer1());
        System.out.println("2022 Day 4 - 2 : " + Day04.answer2());

        System.out.println("2022 Day 5 - 1 : " + Day05.answer1());
        System.out.println("2022 Day 5 - 2 : " + Day05.answer2());

        System.out.println("2022 Day 6 - 1 : " + Day06.answer1());
        System.out.println("2022 Day 6 - 2 : " + Day06.answer2());

        System.out.println("2022 Day 7 - 1 : " + Day07.answer1());
        System.out.println("2022 Day 7 - 2 : " + Day07.answer2());

        System.out.println("2022 Day 8 - 1 : " + Day08.answer1());
        System.out.println("2022 Day 8 - 2 : " + Day08.answer2());

        System.out.println("2022 Day 9 - 1 : " + Day09.answer1());
        System.out.println("2022 Day 9 - 2 : " + Day09.answer2());
    }

    @Override
    protected int year() {
        return 2022;
    }

    @Override
    protected String packageName() {
        return AdventOfCode2022Startup.class.getPackageName();
    }
}
