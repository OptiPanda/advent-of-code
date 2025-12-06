package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day06 extends AbstractDay<Integer> {

    private static Integer answer(int messageSize, String[] strings) {

        for (int i = messageSize - 1; i < strings.length; i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j < messageSize; j++) {
                set.add(strings[i - j]);
            }

            if (set.size() == messageSize) {
                return i + 1;
            }
        }

        return 0;
    }

    @Override
    public Integer answer1() {

        Scanner sc = getScanner();

        final String[] strings = sc.nextLine().split("");

        return answer(4, strings);
    }

    @Override
    public Integer answer2() {

        Scanner sc = getScanner();

        final String[] strings = sc.nextLine().split("");

        return answer(14, strings);
    }
}
