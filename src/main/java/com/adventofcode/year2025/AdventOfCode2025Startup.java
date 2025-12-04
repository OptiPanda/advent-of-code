package com.adventofcode.year2025;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.List;

public class AdventOfCode2025Startup {

    private static int YEAR = 2025;

    public static void main(String[] args) throws Exception {

        System.out.println("Starting AdventOfCode2025");

        final List<? extends AbstractDay> allDaysClasses = AdventOfCodeUtils.getAllDayClasses(AdventOfCode2025Startup.class.getPackageName()+".days");

        for (AbstractDay dayClass : allDaysClasses) {

            System.out.println(AdventOfCode2025Startup.YEAR + " Day " + dayClass.day() + " - answer 1 : " + dayClass.answer1());
            System.out.println(AdventOfCode2025Startup.YEAR + " Day " + dayClass.day() + " - anwser 2 : " + dayClass.answer2());
        }
    }
}
