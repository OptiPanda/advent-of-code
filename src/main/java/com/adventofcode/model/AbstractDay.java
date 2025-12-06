package com.adventofcode.model;

import com.adventofcode.utils.AdventOfCodeUtils;

public abstract class AbstractDay<T> {

    protected AbstractDay() {}

    public abstract T answer1();
    public abstract T answer2();

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
