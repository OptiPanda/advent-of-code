package com.adventofcode.year2022.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day09 {

    private static final String FILE_PATH = "src/main/resources/year2022/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        final Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int[] head = {0, 0};
        int[] tail = {0, 0};

        Set<String> histTpos = new HashSet<>();
        histTpos.add(tail[0] + ";" + tail[1]);

        while (sc.hasNextLine()) {
            final String[] order = sc.nextLine().split(" ");


            for (int i = 0; i < Integer.parseInt(order[1]); i++) {

                switch (order[0]) {
                    case "L" -> head[0]--;
                    case "R" -> head[0]++;
                    case "U" -> head[1]++;
                    case "D" -> head[1]--;
                }

                tailFollowHead(head, tail);

                histTpos.add(tail[0] + ";" + tail[1]);
            }
        }

        return histTpos.size();
    }

    protected static void tailFollowHead(int[] head, int[] tail) {
        if (head[0] - tail[0] > 1) {
            tail[0]++;
            if (head[1] - tail[1] == 1) {
                tail[1]++;
            } else if (tail[1] - head[1] == 1) {
                tail[1]--;
            }
        } else if (tail[0] - head[0] > 1) {
            tail[0]--;
            if (head[1] - tail[1] == 1) {
                tail[1]++;
            } else if (tail[1] - head[1] == 1) {
                tail[1]--;
            }
        }

        if (head[1] - tail[1] > 1) {
            tail[1]++;
            if (head[0] - tail[0] == 1) {
                tail[0]++;
            } else if (tail[0] - head[0] == 1) {
                tail[0]--;
            }
        } else if (tail[1] - head[1] > 1) {
            tail[1]--;
            if (head[0] - tail[0] == 1) {
                tail[0]++;
            } else if (tail[0] - head[0] == 1) {
                tail[0]--;
            }
        }
    }

    protected static void print(int[] head, int[] tail) {
        System.out.println("H[" + head[0] + "," + head[1] + "] -> T[" + tail[0] + "," + tail[1] + "]");
        for (int i = 5; i > -5; i--) {
            for (int j = -5; j < 5; j++) {
                if (head[0] % 5 == i && head[1] % 5 == j) {
                    System.out.print("H");
                } else if (tail[0] % 5 == i && tail[1] % 5 == j) {
                    System.out.print("T");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Integer answer2() {

        final Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        return 0;
    }
}


