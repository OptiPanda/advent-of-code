package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 extends AbstractDay {

    private static final String FILE_PATH = "src/main/resources/year2025/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final int MAX = 99;
    private static final String LEFT = "L";
    private static final String RIGHT = "R";

    @Override
    public int day() {
        return 1;
    }

    @Override
    public Integer answer1() {
        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int countZeros = 0;
        int current = 50;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile("([RL])(\\d+)");
            Matcher matcher = pattern.matcher(line);
            matcher.find();

            int step = switch (matcher.group(1)) {
                case LEFT -> -Integer.parseInt(matcher.group(2));
                case RIGHT -> Integer.parseInt(matcher.group(2));
                default -> throw new IllegalArgumentException("Invalid input");
            };

            current += step;

            while (current < 0) {
                current += (MAX+1);
            }

            current %= (MAX+1);

            if (current == 0) {
                countZeros++;
            }
        }

        return countZeros;
    }

    @Override
    public Integer answer2() {
        return 2;
    }
}
