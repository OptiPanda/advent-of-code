package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day06 {

    private static final String FILE_PATH = "src/main/resources/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

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

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        final String[] strings = sc.nextLine().split("");

        return answer(4, strings);
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        final String[] strings = sc.nextLine().split("");

        return answer(14, strings);
    }
}
