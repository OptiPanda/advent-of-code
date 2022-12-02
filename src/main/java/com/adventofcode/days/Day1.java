package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day1 {

    private static final String FILE_PATH = "src/main/resources/input-day1";

    private static Integer sumOf(int limit) {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int idx = 1;
        int sum = 0;

        Map<Integer, Integer> results = new HashMap<>();

        while (sc.hasNextInt()) {
            final int nInt = sc.nextInt();
            sum += nInt;

            if (sc.hasNext(";")) {
                results.put(idx++, sum);
                sum = 0;
                sc.next();
            }
        }

        return results.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getValue)
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("No sum"));
    }

    public static Integer answer1() {
        return sumOf(1);
    }

    public static Integer answer2() {
        return sumOf(3);
    }
}
