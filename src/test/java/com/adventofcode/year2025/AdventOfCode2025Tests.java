package com.adventofcode.year2025;

import com.adventofcode.model.AbstractDayTest;
import com.adventofcode.utils.AdventOfCodeTestUtils;

import java.util.List;

public class AdventOfCode2025Tests {

    public static void main(String[] args) throws Exception {

        System.out.println("Starting TEST AdventOfCode2025");

        final List<? extends AbstractDayTest<?>> allDaysClasses = AdventOfCodeTestUtils.getAllDayTestClasses(AdventOfCode2025Tests.class.getPackageName() + ".days");

        for (AbstractDayTest<?> dayClass : allDaysClasses) {
            dayClass.test();
        }
    }
}
