package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Day02 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int sumOfIds = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            final String[] game = line.split(": ");

            final int id = Integer.parseInt(game[0].split(" ")[1]);

            final String[] sets = game[1].split("; ");

            boolean possible = true;

            for (String set : sets) {
                int red = 0;
                int green = 0;
                int blue = 0;

                final String[] rolls = set.split(", ");
                for (String roll : rolls) {
                    final String[] values = roll.split(" ");

                    int qte = Integer.parseInt(values[0]);
                    switch (values[1]) {
                        case "red" -> red += qte;
                        case "blue" -> blue += qte;
                        case "green" -> green += qte;
                    }
                }

                if (red > 12 || green > 13 || blue > 14) {
                    possible = false;
                }
            }

            if (possible) {
                sumOfIds += id;
            }
        }

        return sumOfIds;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int sumOfPower = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            final String[] game = line.split(": ");

            final String[] sets = game[1].split("; ");

            int minRed = 0;
            int minGreen = 0;
            int minBlue = 0;

            for (String set : sets) {

                final String[] rolls = set.split(", ");
                for (String roll : rolls) {
                    final String[] values = roll.split(" ");

                    int qte = Integer.parseInt(values[0]);
                    switch (values[1]) {
                        case "red" -> minRed = Math.max(qte, minRed);
                        case "blue" -> minBlue = Math.max(qte, minBlue);
                        case "green" -> minGreen = Math.max(qte, minGreen);
                    }
                }
            }

            sumOfPower += (minRed * minGreen * minBlue);
        }

        return sumOfPower;
    }
}
