package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Day08 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final Map<String, String[]> MAP = new HashMap<>();

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        final String instructions = sc.nextLine();

        sc.nextLine();

        while (sc.hasNextLine()) {
            final String[] line = sc.nextLine().split(" = ");

            MAP.put(line[0], line[1].replace("(", "").replace(")", "").replace(" ", "").split(","));
        }

        return (int) getNumSteps("AAA", instructions, s -> !s.equals("ZZZ"));
    }

    public static Long answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        final String instructions = sc.nextLine();

        sc.nextLine();

        while (sc.hasNextLine()) {
            final String[] line = sc.nextLine().split(" = ");

            MAP.put(line[0], line[1].replace("(", "").replace(")", "").replace(" ", "").split(","));
        }

        return MAP.keySet().stream()
                .filter(k -> k.endsWith("A"))
                .map(k -> getNumSteps(k, instructions, s -> !s.endsWith("Z")))
                .reduce(1L, (a, b) -> (a * b) / gcd(a, b));
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long getNumSteps(String current, String instructions, Predicate<String> condition) {
        int i = 0;
        while (condition.test(current)) {
            final String dir = instructions.charAt(i++ % instructions.length()) + "";
            int lr = "L".equals(dir) ? 0 : 1;

            current = MAP.get(current)[lr];
        }

        return i;
    }
}
