package com.adventofcode.year2022.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Day08 {

    private static final String FILE_PATH = "src/main/resources/year2022/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        final Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);
        
        Integer[][] map = new Integer[99][99];

        for (int i = 0; i < 99; i++) {
            final String[] split = sc.nextLine().split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int visible = 0;

        for (int l = 0; l < map.length; l++) { // line

            for (int c = 0; c < map[l].length; c++) { // column

                int height = map[l][c];

                int x = l;
                int y = c;

                boolean isVisibleLeft = true;

                while (--y >= 0 && isVisibleLeft) {
                    if (map[x][y] >= height) {
                        isVisibleLeft = false;
                    }
                }

                y = c;

                boolean isVisibleRight = true;

                while (++y < 99 && isVisibleRight) {
                    if (map[x][y] >= height) {
                        isVisibleRight = false;
                    }
                }

                y = c;

                boolean isVisibleTop = true;

                while (--x >= 0 && isVisibleTop) {
                    if (map[x][y] >= height) {
                        isVisibleTop = false;
                    }
                }

                x = l;

                boolean isVisibleBottom = true;

                while (++x < 99 && isVisibleBottom) {
                    if (map[x][y] >= height) {
                        isVisibleBottom = false;
                    }
                }

                if(isVisibleLeft || isVisibleRight || isVisibleTop || isVisibleBottom) {
                    visible++;
                }

            }
        }

        return visible;
    }

    public static Integer answer2() {

        final Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        return 0;
    }
}


