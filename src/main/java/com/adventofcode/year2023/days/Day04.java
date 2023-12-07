package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day04 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        int points = 0;

        while (sc.hasNextLine()) {
            final String card = sc.nextLine().split(": ")[1];

            int cardPoints = 0;

            final String[] numbers = card.split(" \\| ");

            List<Integer> winningNumbers = Arrays.stream(numbers[0].split(" ")).filter(n -> !"".equals(n)).map(Integer::parseInt).toList();

            List<Integer> playedNumbers = Arrays.stream(numbers[1].split(" ")).filter(n -> !"".equals(n)).map(Integer::parseInt).toList();

            for (Integer n : playedNumbers) {
                if (winningNumbers.contains(n)) {
                    cardPoints++;
                }
            }

            if (cardPoints > 0) {
                points += Math.pow(2, cardPoints - 1);
            }
        }

        return points;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        List<String> cards = new ArrayList<>();

        while (sc.hasNextLine()) {
            cards.add(sc.nextLine().split(": ")[1]);
        }

        int[] factors = new int[cards.size()];

        for (int i = 0; i < cards.size(); i++) {
            factors[i]++;
            final String card = cards.get(i);

            int cardPoints = 0;

            final String[] numbers = card.split(" \\| ");

            List<Integer> winningNumbers = Arrays.stream(numbers[0].split(" ")).filter(n -> !"".equals(n)).map(Integer::parseInt).toList();
            List<Integer> playedNumbers = Arrays.stream(numbers[1].split(" ")).filter(n -> !"".equals(n)).map(Integer::parseInt).toList();

            for (Integer n : playedNumbers) {
                if (winningNumbers.contains(n)) {
                    cardPoints++;
                }
            }

            if (cardPoints > 0) {
                int result = (int) Math.pow(2, cardPoints-1) - 1;

                for (int it = 0; it < result; it++) {
                    if (i+it+1 < factors.length) {
                        factors[i+it+1] += factors[i];
                    }
                }
            }
        }

        return Arrays.stream(factors).reduce(Integer::sum).orElse(0);
    }
}
