package com.adventofcode.model;

import com.adventofcode.utils.AdventOfCodeTestUtils;

import java.util.List;

import static com.adventofcode.utils.AdventOfCodeUtils.println;

public abstract class AbstractAdventOfCodeTests {

    protected int year;
    protected String packageName;

    protected AbstractAdventOfCodeTests() {
        this.packageName = this.getClass().getPackageName();
        this.year = Integer.parseInt(packageName.replaceAll(".*year(\\d{4}).*", "$1"));
    }

    public void start() throws Exception {

        println("Starting TEST AdventOfCode " + year);

        final List<? extends AbstractDayTest<?, ?>> allDaysClasses = AdventOfCodeTestUtils.getAllDayTestClasses(packageName + ".days");

        for (AbstractDayTest<?, ?> dayClass : allDaysClasses) {
            dayClass.test();
        }
    }
}
