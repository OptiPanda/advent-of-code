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
                count++;
            }

            previous = current;
        }

        return count;
    }

    public static Integer answer2() {
        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Integer p1 = null;
        Integer p2 = null;
        Integer p3 = null;

        Integer previous = null;

        int count = 0;

        while (sc.hasNextInt()) {

            p1 = p2;
            p2 = p3;
            p3 = sc.nextInt();

            if (p1 == null) {
                continue;
            }

            int sum = p1 + p2 + p3;

            if (previous != null && previous < sum) {
                count++;
            }

            previous = sum;
        }

        return count;
    }
}
