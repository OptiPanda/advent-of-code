package com.adventofcode.utils;

import com.adventofcode.model.AbstractDayTest;

import java.util.List;

public class AdventOfCodeTestUtils {

    public static List<? extends AbstractDayTest<?, ?>> getAllDayTestClasses(String packageName) throws Exception {
        List<Class<?>> classes = AdventOfCodeUtils.getClasses(packageName);

        return classes.stream()
                .filter(cls -> AbstractDayTest.class.isAssignableFrom(cls) && cls != AbstractDayTest.class)
                .map(cls -> {
                    try {
                        return (AbstractDayTest<?, ?>) cls.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
    }
}
