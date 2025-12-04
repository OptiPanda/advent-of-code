package com.adventofcode.model;

public abstract class AbstractDayTest<T extends AbstractDay> {

    protected T day;

    public AbstractDayTest(T day)
    {
        this.day = day;
    }

    public abstract void test();

    protected abstract boolean testAnswer1();
    protected abstract boolean testAnswer2();
}
