package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDay;

import java.util.Scanner;

public class Day04 extends AbstractDay<Integer> {

    @Override
    public Integer answer1() {

        Scanner sc = getScanner();

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

    @Override
    public Integer answer2() {

        Scanner sc = getScanner();

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

            if (s1From >= s2From && s1From <= s2To || s2From >= s1From && s2From <= s1To) {
                score++;
            }

        }

        return score;
    }
}
