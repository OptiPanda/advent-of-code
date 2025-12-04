package com.adventofcode.model;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.List;

import static com.adventofcode.utils.AdventOfCodeUtils.log;

public abstract class AbstractAdventOfCodeStartup {

    protected abstract int year();
    protected abstract String packageName();

    public void main() throws Exception {
        log("Starting AdventOfCode2025");

        final List<? extends AbstractDay> allDaysClasses = AdventOfCodeUtils.getAllDayClasses(packageName() + ".days");

        for (AbstractDay dayClass : allDaysClasses) {

            log(year() + " Day " + dayClass.day() + " - answer 1 : " + dayClass.answer1());
            log(year() + " Day " + dayClass.day() + " - anwser 2 : " + dayClass.answer2());
        }
    }
}
