package com.adventofcode.model;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.Scanner;

public abstract class AbstractDay<T> {

    private final String filePath;

    protected AbstractDay() {
        int year = Integer.parseInt(this.getClass().getPackageName().replaceAll(".*year(\\d{4}).*", "$1"));
        this.filePath = "src/main/resources/year"+year+"/input-" + this.getClass().getSimpleName().toLowerCase();
    }

    public abstract T answer1();
    public abstract T answer2();

    protected Scanner getScanner() {
        return AdventOfCodeUtils.getScanner(this.filePath);
    }

    public int day() {
        return Integer.parseInt(this.getClass().getSimpleName().replace("[a-zA-Z]", ""));
    }

    protected static void errln(Object message) {
        AdventOfCodeUtils.errln(message);
    }

    protected static void println(Object message) {
        AdventOfCodeUtils.println(message);
    }

    protected static void debug(Object message) {
        AdventOfCodeUtils.debug(message);
    }
}
