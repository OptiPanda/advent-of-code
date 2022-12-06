package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.regex.Pattern;

public class Day06 {

    private static final String FILE_PATH = "src/main/resources/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        final String[] strings = sc.nextLine().split("");

        for (int i = 3; i < strings.length; i++) {
            Set<String> set =  new HashSet<>();
            set.add(strings[i - 3]);
            set.add(strings[i - 2]);
            set.add(strings[i - 1]);
            set.add(strings[i]);

            if (set.size() == 4) {
                return i+1;
            }
        }

        return 0;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 0;

        return score;
    }
}
