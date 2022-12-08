package com.adventofcode.year2022.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Day08 {

    private static final String FILE_PATH = "src/main/resources/year2022/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Integer[][] map = generateMap(AdventOfCodeUtils.getScanner(FILE_PATH));

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

                if (isVisibleLeft || isVisibleRight || isVisibleTop || isVisibleBottom) {
                    visible++;
                }
            }
        }

        return visible;
    }

    private static Integer[][] generateMap(Scanner sc) {
        Integer[][] map = new Integer[99][99];

        for (int i = 0; i < 99; i++) {
            final String[] split = sc.nextLine().split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        return map;
    }

    public static Integer answer2() {

        Integer[][] map = generateMap(AdventOfCodeUtils.getScanner(FILE_PATH));

        int max = 0;

        for (int line = 0; line < map.length; line++) { // line

            for (int col = 0; col < map[line].length; col++) { // column

                int left = getLeft(map, line, col);
                int right = getRight(map, line, col);
                int top = getTop(map, line, col);
                int bottom = getBottom(map, line, col);

                int treeView = top * right * bottom * left;

//                System.err.print(treeView);
                if (treeView > max) {
//                    System.err.println(treeView + " new max [" + (line+1) + "," + (col+1) + "] w/ t:"+top+" r:"+right+" b:"+bottom+" l:"+left);
                    max = treeView;
                }
//                System.err.println();

            }
        }

        return max;
    }

    protected static int getBottom(Integer[][] map, int line, int col) {
        int currentTreeHeight = map[line][col];

        int cursor = line + 1;

        int bottom = 1;

        while (cursor < map.length - 1 && map[cursor++][col] < currentTreeHeight) {
            bottom++;
        }
        return bottom;
    }

    protected static int getTop(Integer[][] map, int line, int col) {
        int currentTreeHeight = map[line][col];

        int cursor = line - 1;

        int top = 1;

        while (cursor > 0 && map[cursor--][col] < currentTreeHeight) {
            top++;
        }
        return top;
    }

    protected static int getRight(Integer[][] map, int line, int col) {
        int currentTreeHeight = map[line][col];

        int cursor = col + 1;

        int right = 1;

        while (cursor < map[line].length -1 && map[line][cursor++] < currentTreeHeight) {
            right++;
        }
        return right;
    }

    protected static int getLeft(Integer[][] map, int line, int col) {
        int currentTreeHeight = map[line][col];

        int cursor = col - 1;

        int left = 1;

        while (cursor > 0 && map[line][cursor--] < currentTreeHeight) {
            left++;
        }
        return left;
    }
}


