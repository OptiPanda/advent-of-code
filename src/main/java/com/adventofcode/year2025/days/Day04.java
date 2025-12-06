package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;

import java.util.Scanner;

import static com.adventofcode.utils.AdventOfCodeUtils.print;

public class Day04 extends AbstractDay<Integer> {

    public static final String ROLL_OF_PAPER = "@";

    @Override
    public Integer answer1() {
        final Scanner sc = getScanner();

        String[][] grid = new String[135][135];
        int row = 0;
        while (sc.hasNextLine()) {
            grid[row++] = sc.nextLine().split("");
        }

        int rollWithLessThan4rollsAdjacent = 0;

        for (row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col].equals(ROLL_OF_PAPER)) {
                    int adjacents = 0;

                    if (row > 0) {
                        if (grid[row - 1][col].equals(ROLL_OF_PAPER)) {
                            adjacents++;
                        }
                        if (col > 0) {
                            if (grid[row - 1][col - 1].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }
                        }

                        if (col < grid[row].length - 1) {
                            if (grid[row - 1][col + 1].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }
                        }
                    }

                    if (row < grid.length - 1) {
                        if (grid[row + 1][col].equals(ROLL_OF_PAPER)) {
                            adjacents++;
                        }

                        if (col > 0) {
                            if (grid[row + 1][col - 1].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }
                        }

                        if (col < grid[row].length - 1) {
                            if (grid[row + 1][col + 1].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }
                        }
                    }

                    if (col > 0) {
                        if (grid[row][col - 1].equals(ROLL_OF_PAPER)) {
                            adjacents++;
                        }
                    }

                    if (col < grid[row].length - 1) {
                        if (grid[row][col + 1].equals(ROLL_OF_PAPER)) {
                            adjacents++;
                        }
                    }

                    if (adjacents < 4) {
                        rollWithLessThan4rollsAdjacent++;
                    }
                }
            }
        }

        return rollWithLessThan4rollsAdjacent;
    }

    @Override
    public Integer answer2() {
        final Scanner sc = getScanner();

        String[][] grid = new String[135][135];
        int row = 0;
        while (sc.hasNextLine()) {
            grid[row++] = sc.nextLine().split("");
        }

        int rollThatCanBeRemoved = 0;
        int trySum = 0;
        while (true) {
            for (row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col].equals(ROLL_OF_PAPER)) {
                        int adjacents = 0;

                        if (row > 0) {
                            if (grid[row - 1][col].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }
                            if (col > 0) {
                                if (grid[row - 1][col - 1].equals(ROLL_OF_PAPER)) {
                                    adjacents++;
                                }
                            }

                            if (col < grid[row].length - 1) {
                                if (grid[row - 1][col + 1].equals(ROLL_OF_PAPER)) {
                                    adjacents++;
                                }
                            }
                        }

                        if (row < grid.length - 1) {
                            if (grid[row + 1][col].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }

                            if (col > 0) {
                                if (grid[row + 1][col - 1].equals(ROLL_OF_PAPER)) {
                                    adjacents++;
                                }
                            }

                            if (col < grid[row].length - 1) {
                                if (grid[row + 1][col + 1].equals(ROLL_OF_PAPER)) {
                                    adjacents++;
                                }
                            }
                        }

                        if (col > 0) {
                            if (grid[row][col - 1].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }
                        }

                        if (col < grid[row].length - 1) {
                            if (grid[row][col + 1].equals(ROLL_OF_PAPER)) {
                                adjacents++;
                            }
                        }

                        if (adjacents < 4) {
                            trySum++;
                            grid[row][col] = "x";
                        }
                    }
                }
            }

            if (trySum == 0) {
                break;
            }

            rollThatCanBeRemoved += trySum;
            trySum = 0;
        }

        return rollThatCanBeRemoved;
    }
}
