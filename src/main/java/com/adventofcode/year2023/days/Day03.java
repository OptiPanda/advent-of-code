package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day03 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    private static final Pattern PATTERN_DIGITS = Pattern.compile("\\d{1,3}");
    private static final Pattern PATTERN_NOT_DIGITS_NOT_DOT = Pattern.compile("[^\\d\\.]");

    private static final Pattern PATTERN_GEAR = Pattern.compile("\\*");

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        int total = 0;

        for (int i = 0; i < lines.size(); i++) {
            final String line = lines.get(i);

            Matcher matcher = PATTERN_DIGITS.matcher(line);

            while (matcher.find()) {
                int start = matcher.start();
                start = start > 0 ? start - 1 : start;
                int end = matcher.end();
                end = end < line.length() ? end +1 : end;

                final String find = matcher.group();

                if (i > 0) {
                    final String previousLine = lines.get(i-1);

                    if (PATTERN_NOT_DIGITS_NOT_DOT.matcher(previousLine.substring(start, end)).find()) {
                        total += Integer.parseInt(find);
                        continue;
                    }
                }

                if (i < lines.size() - 1) {
                    final String nextLine = lines.get(i+1);

                    if (PATTERN_NOT_DIGITS_NOT_DOT.matcher(nextLine.substring(start, end)).find()) {
                        total += Integer.parseInt(find);
                        continue;
                    }
                }

                if (PATTERN_NOT_DIGITS_NOT_DOT.matcher(line.substring(start, end)).find()) {
                    total += Integer.parseInt(find);
                }
            }
        }

        return total;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        int total = 0;

        for (int i = 0; i < lines.size(); i++) {
            final String line = lines.get(i);

            Matcher matcher = PATTERN_GEAR.matcher(line);

            while (matcher.find()) {
                int start = matcher.start();
                start = start - 3 >= 0 ? start - 3 : start;
                int end = matcher.end();
                end = end + 3 < line.length() ? end + 3 : end;

                Integer previous = null;
                if (i > 0) {
                    final String previousLine = lines.get(i-1);

                    final Matcher digitMatcher = PATTERN_DIGITS.matcher(previousLine.substring(start, end));
                    if (digitMatcher.find()) {
                        previous = Integer.parseInt(digitMatcher.group());
                    }
                }

                Integer next = null;
                if (i < lines.size() - 1) {
                    final String nextLine = lines.get(i+1);

                    final Matcher digitMatcher = PATTERN_DIGITS.matcher(nextLine.substring(start, end));
                    if (digitMatcher.find()) {
                        next = Integer.parseInt(digitMatcher.group());
                    }
                }

                Integer before = null;
                final Matcher digitMatcherBefore = PATTERN_DIGITS.matcher(line.substring(start, matcher.end()));

                if (digitMatcherBefore.find()) {
                    before = Integer.parseInt(digitMatcherBefore.group());
                }

                Integer after = null;
                final Matcher digitMatcherAfter = PATTERN_DIGITS.matcher(line.substring(matcher.start(), end));

                if (digitMatcherAfter.find()) {
                    after = Integer.parseInt(digitMatcherAfter.group());
                }

                final List<Integer> collect = Stream.of(previous, next, before, after).filter(Objects::nonNull).collect(Collectors.toList());

                if (collect.size() == 2) {
                    System.err.println(lines.get(i-1).substring(start, end));
                    System.err.println(lines.get(i).substring(start, end));
                    System.err.println(lines.get(i+1).substring(start, end));

                    System.err.println(previous + " " + next + " " + before + " " + after);

                    System.err.println();

                    total += collect.stream().reduce(Integer::sum).orElse(0);
                }
            }
        }

        return total;
    }
}
