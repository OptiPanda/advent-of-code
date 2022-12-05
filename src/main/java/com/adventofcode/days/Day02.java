package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Day02 {

    private static final String FILE_PATH = "src/main/resources/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final String ROCK = "A";
    private static final String PAPER = "B";
    private static final String SCISSOR = "C";
    private static final String LOOSE = "X";
    private static final String DRAW = "Y";
    private static final String WIN = "Z";
    private static final int SCORE_ROCK = 1;
    private static final int SCORE_PAPER = 2;
    private static final int SCORE_SCISSORS = 3;
    private static final int SCORE_DRAW = 3;
    private static final int SCORE_WIN = 6;

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int gameScore = 0;

        while (sc.hasNextLine()) {
            final String[] values = sc.nextLine().split(" ");
            String enemy = values[0];
            String me = values[1];

            if ("X".equals(me)) {
                me = ROCK;
            } else if ("Y".equals(me)) {
                me = PAPER;
            } else if ("Z".equals(me)) {
                me = SCISSOR;
            }

            gameScore += getRoundScore(me, enemy);
        }

        return gameScore;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int gameScore = 0;

        while (sc.hasNextLine()) {
            final String[] values = sc.nextLine().split(" ");
            String enemy = values[0];
            String resultWanted = values[1];

            switch (resultWanted) {
                case LOOSE -> gameScore += getRoundScore(getLoose(enemy), enemy);
                case DRAW -> gameScore += getRoundScore(enemy, enemy);
                case WIN -> gameScore += getRoundScore(getWin(enemy), enemy);
                default -> throw new RuntimeException(resultWanted + " is not handled");
            }
        }

        return gameScore;
    }

    private static int getRoundScore(String me, String enemy) {
        int roundScore = 0;

        roundScore += getPlayScore(me);

        if (me.equals(getWin(enemy))) {
            roundScore += SCORE_WIN;
        } else if (me.equals(enemy)) {
            roundScore += SCORE_DRAW;
        } else if (me.equals(getLoose(enemy))) {
            //roundScore += 0;
        } else {
            throw new RuntimeException("not handled");
        }

        return roundScore;
    }

    private static String getWin(String from) {
        return switch (from) {
            case ROCK -> PAPER;
            case PAPER -> SCISSOR;
            case SCISSOR -> ROCK;
            default -> throw new RuntimeException(from + " is not handled");
        };
    }

    private static String getLoose(String from) {
        return switch (from) {
            case ROCK -> SCISSOR;
            case PAPER -> ROCK;
            case SCISSOR -> PAPER;
            default -> throw new RuntimeException(from + " is not handled");
        };
    }

    private static Integer getPlayScore(String play) {
        switch (play) {
            case ROCK -> {
                return SCORE_ROCK;
            }
            case PAPER -> {
                return SCORE_PAPER;
            }
            case SCISSOR -> {
                return SCORE_SCISSORS;
            }
            default -> throw new RuntimeException(play + " is not handled");
        }
    }
}
