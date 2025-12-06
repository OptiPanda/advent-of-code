package com.adventofcode.year2021.days;

import com.adventofcode.model.AbstractDay;

import java.util.Scanner;

public class Day01 extends AbstractDay<Integer> {

    @Override
    public Integer answer1() {

        Scanner sc = getScanner();

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

    @Override
    public Integer answer2() {
        Scanner sc = getScanner();

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
