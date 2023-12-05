package com.adventofcode.year2021.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.Collectors;

public class Day03 {

    private static final String FILE_PATH = "src/main/resources/year2021/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();


    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Map<Integer, Integer[]> datas = new HashMap<>();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("");


            for (int index = 0; index < line.length; index++) {
                int val = Integer.parseInt(line[index]);

                Integer[] data = datas.get(index);

                if (data == null) {
                    data = new Integer[2];
                    data[0] = 0;
                    data[1] = 0;
                }

                data[val]++;

                datas.put(index, data);
            }
        }

        return getGamma(datas) * getEpsilon(datas);
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Map<Integer, Integer[]> datas = new HashMap<>();

        int idx = 0;

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("");

            Integer[] iLine = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList()).toArray(new Integer[0]);

            datas.put(idx++, iLine);
        }

        return getOxygenGeneratorRating(datas) * getCO2ScrubberRating(datas);
    }

    public static int getOxygenGeneratorRating(Map<Integer, Integer[]> datas) {

        Map<Integer, Integer[]> tmp = new HashMap<>(datas);

        for (int round = 0; round < datas.get(0).length; round++) {

            Map<Integer, List<Integer>> index = new HashMap<>();
            index.put(0, new ArrayList<>());
            index.put(1, new ArrayList<>());

            for (Map.Entry<Integer, Integer[]> entry : tmp.entrySet()) {
                final Integer val = entry.getValue()[round];
                index.get(val).add(entry.getKey());
            }

            if (index.get(0).size() > index.get(1).size()) {
                index.get(1).forEach(tmp::remove);
            } else {
                index.get(0).forEach(tmp::remove);
            }
        }

        final Integer[] answer = tmp.values().stream().findAny().orElseThrow(() -> new RuntimeException("Smelly"));

        final String answerBinary = Arrays.stream(answer).map(String::valueOf).collect(Collectors.joining());

        return Integer.parseInt(answerBinary, 2);
    }

    public static int getCO2ScrubberRating(Map<Integer, Integer[]> datas) {

        Map<Integer, Integer[]> tmp = new HashMap<>(datas);

        for (int round = 0; round < datas.get(0).length && tmp.size() > 1; round++) {

            Map<Integer, List<Integer>> index = new HashMap<>();
            index.put(0, new ArrayList<>());
            index.put(1, new ArrayList<>());

            for (Map.Entry<Integer, Integer[]> entry : tmp.entrySet()) {
                final Integer val = entry.getValue()[round];
                index.get(val).add(entry.getKey());
            }

            if (index.get(0).size() <= index.get(1).size()) {
                index.get(1).forEach(tmp::remove);
            } else {
                index.get(0).forEach(tmp::remove);
            }
        }

        final Integer[] answer = tmp.values().stream().findAny().orElseThrow(() -> new RuntimeException("Smelly"));

        final String answerBinary = Arrays.stream(answer).map(String::valueOf).collect(Collectors.joining());

        return Integer.parseInt(answerBinary, 2);
    }

    public static int getGamma(Map<Integer, Integer[]> datas) {

        StringBuilder b = new StringBuilder();
        datas.values()
                .forEach(v -> b.append(v[0] > v[1] ? "0" : "1"));

        return Integer.parseInt(b.toString(), 2);
    }

    public static int getEpsilon(Map<Integer, Integer[]> datas) {

        StringBuilder b = new StringBuilder();
        datas.values()
                .forEach(v -> b.append(v[0] > v[1] ? "1" : "0"));

        return Integer.parseInt(b.toString(), 2);
    }
}
