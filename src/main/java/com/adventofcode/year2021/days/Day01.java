package com.adventofcode.year2021.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Day01 {

    private static final String FILE_PATH = "src/main/resources/year2021/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Integer previous = null;

        int count = 0;

        while (sc.hasNextInt()) {
            final int current = sc.nextInt();

            if (previous != null && previous < current) {
                System.err.println(previous + " < " + current);
                count++;
            }

            previous = current;
        }

        return count;
    }

    public static Integer answer2() {
        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Integer previous = null;

        int count = 0;

        while (sc.hasNextInt()) {
            final int current = sc.nextInt();

            if (previous != null && previous < current) {
                System.err.println(previous + " < " + current);
                count++;
            }

            previous = current;
        }

        return count;
    }
}
