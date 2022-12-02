package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.List;
import java.util.Scanner;

public class Day2 {

    private static final String FILE_PATH = "C:\\Users\\AJ0BAB2L\\workspace\\adventofcode\\src\\main\\resources\\input-day2";

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

        int score = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            final String[] values = line.split(" ");
            String enemy = values[0];
            String me = values[1];
            if ("X".equals(me)) {
                me = ROCK;
            } else if ("Y".equals(me)) {
                me = PAPER;
            } else if ("Z".equals(me)) {
                me = SCISSOR;
            }

            int roundScore = getRoundScore(me, enemy);

            score += roundScore;
        }

        return score;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int score = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            final String[] values = line.split(" ");
            String enemy = values[0];
            String resultWanted = values[1];

            int roundScore = 0;

            switch (resultWanted) {
                case LOOSE:
                    roundScore += getRoundScore(getLoose(enemy), enemy);
                    break;

                case DRAW:
                    roundScore += getRoundScore(enemy, enemy);
                    break;

                case WIN:
                    roundScore += getRoundScore(getWin(enemy), enemy);
                    break;
                default:
                    break;
            }

            score += roundScore;
        }

        return score;
    }

    private static int getRoundScore(String me, String enemy) {
        int roundScore = 0;

        switch (me) {
            case ROCK:
                roundScore += SCORE_ROCK;

                if (ROCK.equals(enemy)) {
                    roundScore += SCORE_DRAW;
                } else if (SCISSOR.equals(enemy)) {
                    roundScore += SCORE_WIN;
                }
                break;

            case PAPER:
                roundScore += SCORE_PAPER;

                if (PAPER.equals(enemy)) {
                    roundScore += SCORE_DRAW;
                } else if (ROCK.equals(enemy)) {
                    roundScore += SCORE_WIN;
                }
                break;

            case SCISSOR:
                roundScore += SCORE_SCISSORS;

                if (SCISSOR.equals(enemy)) {
                    roundScore += SCORE_DRAW;
                } else if (PAPER.equals(enemy)) {
                    roundScore += SCORE_WIN;
                }
                break;

            default:
        }

        return roundScore;
    }

    private static String getWin(String from) {
        switch (from) {
            case ROCK:
                return PAPER;
            case PAPER:
                return SCISSOR;
            case SCISSOR:
                return ROCK;
            default:
                throw new RuntimeException(from + " is not handled");
        }
    }

    private static String getLoose(String from) {
        switch (from) {
            case ROCK:
                return SCISSOR;
            case PAPER:
                return ROCK;
            case SCISSOR:
                return PAPER;
            default:
                throw new RuntimeException(from + " is not handled");
        }
    }
}
