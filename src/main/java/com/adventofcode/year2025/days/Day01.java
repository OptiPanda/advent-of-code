package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 extends AbstractDay {

    private static final String FILE_PATH = "src/main/resources/year2025/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final String REGEX = "([LR])(\\d+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private static final int MAX = 99;

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
            int step = getStep(sc.nextLine());

            current += step;

            while (current < 0) {
                current += (MAX+1);
            }

            while (current > MAX) {
                current -= (MAX+1);
            }

            if (current == 0) {
                countZeros++;
            }
        }

        return countZeros;
    }

    @Override
    public Integer answer2() {
        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        return logicAnswer2(sc);
    }

    private static int logicAnswer2(Scanner sc) {
        int countZeros = 0;
        int current = 50;

        debug("("  + countZeros + ") " + current);

        while (sc.hasNextLine()) {
            String out = "[(" + current;
            int step = getStep(sc.nextLine());

            out += " + " + step + ")";

            current += step;

            out += " = " + current + "]";

            if (current == 0) {
                countZeros++;
                out += "(+1)";
            }

            while (current < 0) {
                current += (MAX+1);
                out += " -> " + current;
                if ((current - step) % (MAX+1) != 0) {
                    countZeros++;
                    out += "(+1)";
                }
            }

            while (current > MAX) {
                current -= (MAX+1);
                out += " -> " + current;
                if ((current - step) % (MAX+1) != 0) {
                    countZeros++;
                    out += "(+1)";
                }
            }

            out += "\t\t===> " + current;
            debug("("  + countZeros + ") " + out);
        }

        return countZeros;
    }

    public static void main(String[] args) {
        String test = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
        """;

        Scanner sc = new Scanner(test);
        final int i = logicAnswer2(sc);
        debug(i);
    }

    private static int getStep(String line) {
        Matcher matcher = PATTERN.matcher(line);
        matcher.find();
        return switch (matcher.group(1)) {
            case LEFT -> -Integer.parseInt(matcher.group(2));
            case RIGHT -> Integer.parseInt(matcher.group(2));
            default -> throw new IllegalArgumentException("Invalid input");
        };
    }
}
