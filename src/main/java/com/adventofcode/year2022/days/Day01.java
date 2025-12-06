package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDay;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day01 extends AbstractDay<Integer> {

    @Override
    public Integer answer1() {
        return sumOf(1);
    }

    @Override
    public Integer answer2() {
        return sumOf(3);
    }

    private Integer sumOf(int limit) {

        Scanner sc = getScanner();

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
}
