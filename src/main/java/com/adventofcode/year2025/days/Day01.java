package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 extends AbstractDay<Integer> {

    private static final String FILE_PATH = "src/main/resources/year2025/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final String REGEX = "([LR])(\\d+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private static final int MAX = 99;

    @Override
    public Integer answer1() {
        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int countZeros = 0;
        int current = 50;

        while (sc.hasNextLine()) {
            int step = getStep(sc.nextLine());

            current += step;

            while (current < 0) {
                current += (MAX + 1);
            }

            while (current > MAX) {
                current -= (MAX + 1);
            }

            if (current == 0) {
                countZeros++;
            }
        }

        return countZeros;
    }

    @Override
    public Integer answer2() {
        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        return logicAnswer2(sc);
    }

    public Integer logicAnswer2(Scanner sc) {
        int countZeros = 0;
        int current = 50;

        debug("(" + countZeros + ") " + current);

        while (sc.hasNextLine()) {
            String out = "[(" + current;
            int step = getStep(sc.nextLine());
            out += " + " + step + ")]";

            if (step % (MAX + 1) == 0) {
                while (step % (MAX + 1) == 0 && step != 0) {
                    if (step < 0) {
                        step += MAX + 1;
                    } else {
                        step -= MAX + 1;
                    }
                    countZeros++;
                    out += "(+1%)";
                }
                if (current !=  0) {
                    countZeros++;
                    out += "(+1!0)";
                }
            }

            if (step > 0) {
                while (step > (MAX + 1)) {
                    step -= (MAX + 1);
                    countZeros++;
                    out += "(+1>M)";
                }
            } else {
                while (step < -(MAX + 1)) {
                    step += (MAX + 1);
                    countZeros++;
                    out += "(+1<M)";
                }
            }
            boolean wasZero = current==0;
            current += step;
            if (current == (MAX + 1)) {
                current = 0;
            }
            if (current > (MAX + 1)) {
                current -= (MAX + 1);
                countZeros++;
                out += "(+1>)";
            } else if (current <  0) {
                current += (MAX + 1);
                if (!wasZero) {
                    countZeros++;
                    out += "(+1<)";
                }
            } else if (!wasZero && current ==  0) {
                countZeros++;
                out += "(+1~)";
            }

//            current += step;
//
//            out += " = " + current + "]";
//
//            if (current % (MAX+1) == 0) {
//                final int zeros = Math.abs(current / (MAX + 1));
//                countZeros+= zeros + (current - step != 0 ? 1 : 0);
//                current = 0;
//                out += "(+"+zeros+")";
//            }
//
//            while (current < 0) {
//                current += (MAX+1);
//                out += " -> " + current;
//                if ((current - step) != 0) {
//                    countZeros++;
//                    out += "(+1)";
//                }
//            }
//
//            while (current > MAX) {
//                current -= (MAX+1);
//                out += " -> " + current;
//                if ((current - step) != 0) {
//                    countZeros++;
//                    out += "(+1)";
//                }
//            }

            out += "\t\t===> " + current;
            debug("(" + countZeros + ") " + out);
        }

        return countZeros;
    }

    public static void main(String[] args) {
        String test = """
                L68
                L30
                R48
                L5
                R60
                L55
                L1
                L99
                R14
                L82
                """;

        Scanner sc = new Scanner(test);
        debug(new Day01().logicAnswer2(sc));
    }

    private static int getStep(String line) {
        Matcher matcher = PATTERN.matcher(line);
        matcher.find();
        return switch (matcher.group(1)) {
            case LEFT -> -Integer.parseInt(matcher.group(2));
            case RIGHT -> Integer.parseInt(matcher.group(2));
            default -> throw new IllegalArgumentException("Invalid input");
        };
    }
}
