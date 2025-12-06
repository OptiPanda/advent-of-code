package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day03 extends AbstractDay<Long> {

    @Override
    public Long answer1() {

        long sum = 0;

        for (String bank : getBanks()) {
//            debug(bank);
            long highestBatteries = findHighestBatteries(bank, 2);
            sum += highestBatteries;
//            debug(highestBatteries + " -> " + sum);
        }

        return sum;
    }

    @Override
    public Long answer2() {
        long sum = 0;

        for (String bank : getBanks()) {
//            debug(bank);
            long highestBatteries = findHighestBatteries(bank, 12);
            sum += highestBatteries;
//            debug(highestBatteries + " -> " + sum);
        }

        return sum;
    }

    private List<String> getBanks() {
        final Scanner scanner = getScanner();
        final ArrayList<String> banks = new ArrayList<>();
        while (scanner.hasNextLine()) {
            banks.add(scanner.nextLine());
        }
        return banks;
    }

    public long findHighestBatteries(String bank, int size) {
        int index = -1;
        int[] highests = new int[size];

        for (int s = size; s > 0; s--) {
            highests[size-s] = 0;
            for (int i = index+1; i < bank.length()-(s-1); i++) {
                int value = bank.charAt(i) - '0';
                if (value > highests[size-s]) {
                    highests[size-s] = value;
                    index = i;
                    if (value == 9) {
                        break;
                    }
                }
            }
//            println(Arrays.stream(highests).mapToObj(n -> ""+n).collect(Collectors.joining(",")));
        }

        return Long.parseLong(Arrays.stream(highests).mapToObj(n -> ""+n).collect(Collectors.joining("")));
    }
}
