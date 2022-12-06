package com.adventofcode.year2021.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Day02 {

    private static final String FILE_PATH = "src/main/resources/year2021/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";


    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int x = 0; // horizontal
        int y = 0; // vertical

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            final String[] order = line.split(" ");

            switch (order[0]) {
                case FORWARD -> x += Integer.parseInt(order[1]);
                case DOWN -> y += Integer.parseInt(order[1]);
                case UP -> y -= Integer.parseInt(order[1]);
                default -> throw new RuntimeException(order[0] + " is not handled");
            }
        }

        return x * y;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int x = 0; // horizontal
        int y = 0; // vertical
        int aim = 0; // aim

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            final String[] order = line.split(" ");

            switch (order[0]) {
                case FORWARD -> {
                    final int i = Integer.parseInt(order[1]);
                    x += i;
                    y += (i * aim);
                }
                case DOWN -> aim += Integer.parseInt(order[1]);
                case UP -> aim -= Integer.parseInt(order[1]);
                default -> throw new RuntimeException(order[0] + " is not handled");
            }
        }

        return x * y;
    }
}
