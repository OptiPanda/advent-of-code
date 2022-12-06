package com.adventofcode.year2021.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

        return 0;
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
