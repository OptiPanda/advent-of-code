package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day06 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

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

    public static Integer answer2() {

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
