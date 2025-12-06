package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day05 extends AbstractDay<Integer> {

    @Override
    public Integer answer1() {

        List<Range> freshranges = new ArrayList<>();
        int countFreshAvailable = 0;

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
                long from  = Long.parseLong(split[0]);
                long to = Long.parseLong(split[1]);

                freshranges.add(new Range(from, to));
            } else {
                final long id =  Long.parseLong(line);
                if (freshranges.stream().anyMatch(r -> id >= r.from && id <= r.to)) {
                    countFreshAvailable++;
                }
            }
        }

        return countFreshAvailable;
    }

    @Override
    public Integer answer2() {
        return 0;
    }

    private record Range(long from, long to) {}

}
