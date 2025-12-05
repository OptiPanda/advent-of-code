package com.adventofcode.model;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.List;

import static com.adventofcode.utils.AdventOfCodeUtils.println;

public abstract class AbstractAdventOfCodeStartup {

    protected int year;

    protected AbstractAdventOfCodeStartup() {
        this.year = Integer.parseInt(this.getClass().getPackageName().replaceAll(".*year(\\d{4}).*", "$1"));
    }

    protected abstract String packageName();

    public void main() throws Exception {
        println("Starting AdventOfCode " + year);

        final List<? extends AbstractDay> allDaysClasses = AdventOfCodeUtils.getAllDayClasses(packageName() + ".days");

        for (AbstractDay dayClass : allDaysClasses) {

            println(year + " Day " + dayClass.day() + " - answer 1 : " + dayClass.answer1());
            println(year + " Day " + dayClass.day() + " - anwser 2 : " + dayClass.answer2());
        }
    }
}
