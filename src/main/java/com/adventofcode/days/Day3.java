package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.Scanner;

public class Day3 {

    private static final String FILE_PATH = "src/main/resources/input-day3";

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String firstCompartment = line.substring(0, line.length()/2);
            String secondCompartment = line.substring(line.length()/2);

            String lineChar = "";

            for (String c : firstCompartment.split("")) {
                if (secondCompartment.contains(c)) {
                    lineChar = c;
                    break;
                }
            }

            int val = 0;

            if (Character.isUpperCase(lineChar.charAt(0))) {
                val = lineChar.charAt(0) - 64;
            } else {
                val = lineChar.charAt(0) - 70;
            }

            score += val;
        }

        return score;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 1;

        return score;
    }
}
