package com.adventofcode.model;

import com.adventofcode.utils.AdventOfCodeUtils;

public abstract class AbstractDay {

    public abstract int day();
    public abstract Integer answer1();
    public abstract Integer answer2();

    protected static void err(Object message) {
        AdventOfCodeUtils.err(message);
    }

    protected static void log(Object message) {
        AdventOfCodeUtils.log(message);
    }
}
