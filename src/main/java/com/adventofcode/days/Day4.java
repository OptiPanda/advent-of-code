package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.Scanner;

public class Day4 {

    private static final String FILE_PATH = "src/main/resources/input-day4";

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 0;

        while (sc.hasNextLine()) {

            String line = sc.nextLine();

            final String[] sections = line.split(",");

            String section1 = sections[0];
            String section2 = sections[1];

            final String[] s1Split = section1.split("-");
            final String[] s2Split = section2.split("-");

            int s1From = Integer.parseInt(s1Split[0]);
            int s1To = Integer.parseInt(s1Split[1]);

            int s2From = Integer.parseInt(s2Split[0]);
            int s2To = Integer.parseInt(s2Split[1]);

            if ((s1From <= s2From && s1To >= s2To) || (s2From <= s1From && s2To >= s1To)) {
                score++;
            }

        }

        return score;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 0;

        return score;
    }
}
