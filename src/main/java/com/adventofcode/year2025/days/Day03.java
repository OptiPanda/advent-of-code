package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;
import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day03 extends AbstractDay<Integer> {

    private static final String FILE_PATH = "src/main/resources/year2025/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    @Override
    public Integer answer1() {

        int sum = 0;

        for (String bank : getBanks()) {
            debug(bank);
            int highestBatteries = findHighestBatteries(bank);
            sum += highestBatteries;
            debug(highestBatteries + " -> " + sum);
        }

        return sum;
    }

    @Override
    public Integer answer2() {
        return 0;
    }

    private List<String> getBanks() {
        final Scanner scanner = AdventOfCodeUtils.getScanner(FILE_PATH);
        final ArrayList<String> banks = new ArrayList<>();
        while (scanner.hasNextLine()) {
            banks.add(scanner.nextLine());
        }
        return banks;
    }

    public int findHighestBatteries(String bank) {
        int firstHighest = 0;
        int index = 0;
        for (int i = 0; i < bank.length()-1; i++) {
            int value = bank.charAt(i) - '0';
            if (value > firstHighest) {
                firstHighest = value;
                index = i;
                if (value == 9) {
                    break;
                }
            }
        }
        int secondHighest = 0;
        for (int i = index + 1; i < bank.length(); i++) {
            int value = bank.charAt(i) - '0';
            if (value > secondHighest) {
                secondHighest = value;
                if (value == 9) {
                    break;
                }
            }
        }

        return Integer.parseInt(firstHighest + "" + secondHighest);
    }
}
