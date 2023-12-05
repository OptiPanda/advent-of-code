package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final String ONE = "one";
    private static final String TWO = "two";
    private static final String THREE = "three";
    private static final String FOUR = "four";
    private static final String FIVE = "five";
    private static final String SIX = "six";
    private static final String SEVEN = "seven";
    private static final String EIGHT = "eight";
    private static final String NINE = "nine";

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int total = 0;

        while (sc.hasNextLine()) {
            final String line = sc.nextLine();

            Matcher matcherFirst = Pattern.compile("^\\D*(?<first>\\d)").matcher(line);
            Matcher matcherLast = Pattern.compile("(?<last>\\d)\\D*$").matcher(line);

            matcherFirst.find();
            String i = matcherFirst.group("first");

            matcherLast.find();
            String j = matcherLast.group("last");

            total += Integer.parseInt(i + j);

        }

        return total;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int total = 0;

        while (sc.hasNextLine()) {
            final String line = sc.nextLine();

            Matcher matcherFirst = Pattern.compile("^.*?(?<first>\\d|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)).*").matcher(line);
            Matcher matcherLast = Pattern.compile(".*(?<last>\\d|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)).*$").matcher(line);

            matcherFirst.find();
            String i = convert(matcherFirst.group("first"));

            matcherLast.find();
            String j = convert(matcherLast.group("last"));

            total += Integer.parseInt(i + j);

        }

        return total;
    }

    private static String convert(String entry) {
        return switch (entry) {
            case ONE -> "1";
            case TWO -> "2";
            case THREE -> "3";
            case FOUR -> "4";
            case FIVE -> "5";
            case SIX -> "6";
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
            default -> entry;
        };
    }
}
