package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.util.*;

public class Day05 extends AbstractDay<Long> {

    @Override
    public Long answer1() {

        List<Range> freshranges = new ArrayList<>();
        long countFreshAvailable = 0;

        final Scanner scanner = getScanner();
        boolean firstPart = true;
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            if (line.isEmpty()) {
                firstPart = false;
                continue;
            }

            if (firstPart) {
                final String[] split = line.split("-");
                long from = Long.parseLong(split[0]);
                long to = Long.parseLong(split[1]);

                freshranges.add(new Range(from, to));
            } else {
                final long id = Long.parseLong(line);
                if (freshranges.stream().anyMatch(r -> id >= r.from && id <= r.to)) {
                    countFreshAvailable++;
                }
            }
        }

        return countFreshAvailable;
    }

    @Override
    public Long answer2() {
        List<Range> freshranges = new ArrayList<>();

        long countFreshAvailable = 0;

        final Scanner scanner = getScanner();
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            final String[] split = line.split("-");
            long from = Long.parseLong(split[0]);
            long to = Long.parseLong(split[1]);

            freshranges.add(new Range(from, to));
        }

        Set<Range> toRemove = new HashSet<>();

        println(freshranges.size());

        for (Range rangeReference : freshranges) {
            for (Range range : freshranges) {
                if (rangeReference == range || toRemove.contains(range)) {
                    continue;
                }

                if (rangeReference.contains(range)) {
                    toRemove.add(range);
                    continue;
                }

                if (rangeReference.from <= range.from && range.from <= rangeReference.to) {
                    rangeReference.to = Math.max(rangeReference.to, range.to);
                    toRemove.add(range);
                    continue;
                }

                if (rangeReference.from <= range.to && range.to <= rangeReference.to) {
                    rangeReference.from = Math.min(rangeReference.from, range.from);
                    toRemove.add(range);
                }
            }
        }

        freshranges.removeAll(toRemove);

        println(freshranges.size());
        freshranges.sort(Comparator.comparingLong(r -> r.from));
        for (Range range : freshranges) {
            println(range);
            countFreshAvailable += (range.sum());
        }


        return countFreshAvailable;
    }

    private class Range {

        public Range(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public long from;
        public long to;

        long sum() {
            return to - from;
        }

        boolean contains(long fromC, long toC) {
            return from <= fromC && toC <= to;
        }

        boolean contains(Range r) {
            return contains(r.from, r.to);
        }

        @Override
        public String toString() {
            return from + "-" + to;
        }
    }

}
