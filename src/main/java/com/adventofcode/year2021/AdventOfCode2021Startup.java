package com.adventofcode.year2021;

import com.adventofcode.model.AbstractAdventOfCodeStartup;
import com.adventofcode.year2021.days.Day01;
import com.adventofcode.year2021.days.Day02;
import com.adventofcode.year2021.days.Day03;

import static com.adventofcode.utils.AdventOfCodeUtils.log;

public class AdventOfCode2021Startup extends AbstractAdventOfCodeStartup {

    @Override
    public void main() throws Exception {
        AdventOfCode2021Startup.main(null);
    }

    public static void main(String[] args) {

        log("Starting AdventOfCode2021");
        // Day 1
        System.out.println("2021 Day 1 - 1 : " + Day01.answer1());
        System.out.println("2021 Day 1 - 2 : " + Day01.answer2());

        // Day 2
        System.out.println("2021 Day 2 - 1 : " + Day02.answer1());
        System.out.println("2021 Day 2 - 2 : " + Day02.answer2());

        // Day 3
        System.out.println("2021 Day 3 - 1 : " + Day03.answer1());
        System.out.println("2021 Day 3 - 2 : " + Day03.answer2());
    }

    @Override
    protected int year() {
        return 2021;
    }

    @Override
    protected String packageName() {
        return AdventOfCode2021Startup.class.getPackageName();
    }
}
