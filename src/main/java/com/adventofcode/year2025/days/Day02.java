package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day02 extends AbstractDay<Long> {

    private static final String FILE_PATH = "src/main/resources/year2025/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    @Override
    public Long answer1() {
        final List<String> ids = getIds();

        long sum = 0;

        for (String id : ids) {
            final String[] splitedId = id.split("-");
            long from = Long.parseLong(splitedId[0]);
            long to = Long.parseLong(splitedId[1]);
            for (long current = from; current < to; current++) {
                if (isInvalidIdStep1(current)) {
                    sum += current;
                }
            }
        }

        return sum;
    }

    @Override
    public Long answer2() {
        final List<String> ids = getIds();

        long sum = 0;

        for (String id : ids) {
            final String[] splitedId = id.split("-");
            long from = Long.parseLong(splitedId[0]);
            long to = Long.parseLong(splitedId[1]);
            for (long current = from; current < to; current++) {
                if (isInvalidIdStep2(current)) {
                    sum += current;
                }
            }
        }

        return sum;
    }

    public List<String> getIds() {
        final Scanner scanner = AdventOfCodeUtils.getScanner(FILE_PATH);
        return Arrays.stream(scanner.nextLine().split(",")).toList();
    }

    public boolean isInvalidIdStep1(final long id) {
        return isSequenceOfNumers(id);
    }

    public boolean isInvalidIdStep2(final long id) {
        return hasDuplicateSequences(id);
    }

    public boolean isSequenceOfNumers(final long id) {
        String s = "" + id;
        int mid = s.length() / 2;

        String first = s.substring(0, mid);
        String second = s.substring(mid);
        return first.equals(second);
    }

    public boolean hasDuplicateSequences(final long id) {
        String s = "" + id;
        for (int size = 1; size <= s.length() / 2; size++) {
            for (int i = 0; i < s.length() - size; i++) {
                final int matches = countMatches(s, s.substring(i, i +size));
                if (matches > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int countMatches(String str, String findStr) {
        int len = str.replace(findStr, "").length();
        if  (len == 0) {
            return str.length()/findStr.length();
        }
        return 0;
    }
}
