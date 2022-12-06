package com.adventofcode.year2022.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Day03 {

    private static final String FILE_PATH = "src/main/resources/year2022/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String firstCompartment = line.substring(0, line.length() / 2);
            String secondCompartment = line.substring(line.length() / 2);

            char lineChar = 0;

            for (char c : firstCompartment.toCharArray()) {
                if (secondCompartment.contains(c + "")) {
                    lineChar = c;
                    break;
                }
            }

            score += calcCharScore(lineChar);
        }

        return score;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 0;

        while (sc.hasNextLine()) {

            String firstLine = sc.nextLine();
            String secondLine = sc.nextLine();
            String thirdLine = sc.nextLine();

            char groupChar = 0;

            for (char c : firstLine.toCharArray()) {
                if (secondLine.contains(c + "") && thirdLine.contains(c + "")) {
                    groupChar = c;
                    break;
                }
            }

            score += calcCharScore(groupChar);
        }

        return score;
    }

    protected static int calcCharScore(char lineChar) {
        int val = 0;

        if (Character.isUpperCase(lineChar)) {
            val = lineChar - 38;
        } else {
            val = lineChar - 96;
        }

        return val;
    }
}
