package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();


    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int total = 0;

        while (sc.hasNextLine()) {
            final String line = sc.nextLine();

            Matcher matcherFirst = Pattern.compile("^\\D*(?<first>\\d)").matcher(line);
            Matcher matcherLast = Pattern.compile("(?<first>\\d)\\D*$").matcher(line);

            matcherFirst.find();
            String i = matcherFirst.group("first");

            matcherLast.find();
            String j = matcherLast.group("first");

            total += Integer.parseInt(i+j);

        }

        return total;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        return 0;
    }
}
