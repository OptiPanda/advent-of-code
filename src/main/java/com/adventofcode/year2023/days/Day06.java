package com.adventofcode.year2023.days;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day06 extends AbstractDay<Integer> {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    @Override
    public Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        final List<String> times = Arrays.stream(sc.nextLine().split(":")[1].split(" ")).filter(o -> !"".equals(o)).toList();

        final List<String> distances = Arrays.stream(sc.nextLine().split(":")[1].split(" ")).filter(o -> !"".equals(o)).toList();

        int total = 1;

        for (int race = 0; race < times.size(); race++) {

            int recordBeaten = 0;

            int raceTime = Integer.parseInt(times.get(race));
            int raceDistance = Integer.parseInt(distances.get(race));

            for (int i = 1; i < raceTime-1; i++) {

                final int dist = i * (raceTime - i);
                if (dist > raceDistance) {
                    recordBeaten++;
                }
            }

            total *= recordBeaten;
        }

        return total;
    }

    @Override
    public Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int time = Integer.parseInt(sc.nextLine().split(":")[1].replace(" ", ""));

        double distance = Double.parseDouble(sc.nextLine().split(":")[1].replace(" ", ""));

        int total = 0;

        for (int i = 1; i < time-1; i++) {

            final double dist = i * (double)(time - i);
            if (dist > distance) {
                total++;
            }
        }

        return total;
    }
}
