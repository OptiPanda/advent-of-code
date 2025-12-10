package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day07 extends AbstractDay<Long> {


    @Override
    public Long answer1() {

        final Scanner sc = getScanner();
        final Map<Integer, String> lines = new HashMap<>();
        int i = 0;
        while (sc.hasNextLine()) {
            lines.put(i++, sc.nextLine());
        }

        long count = 0;
        for (Map.Entry<Integer, String> entry : lines.entrySet()) {
            if (entry.getKey() == 0) {
                continue;
            }

            final String[] upperLineSplitted = lines.get(entry.getKey() - 1).split("");
            final String[] lineSplitted = entry.getValue().split("");

            for (int idx = 0; idx < upperLineSplitted.length; idx++) {
                if (upperLineSplitted[idx].equals("S")) {
                    lineSplitted[idx] = "|";
                } else if (upperLineSplitted[idx].equals("|")) {
                    if (lineSplitted[idx].equals("^")) {
                        lineSplitted[idx - 1] = "|";
                        lineSplitted[idx + 1] = "|";
                        count++;
                    } else {
                        lineSplitted[idx] = "|";
                    }
                }
            }

            lines.put(entry.getKey(), String.join("", lineSplitted));
        }

        return count;
    }

    @Override
    public Long answer2() {
//        final Scanner sc = getScanner();
//        final Map<Integer, String> lines = new HashMap<>();
//        int i = 0;
//        while (sc.hasNextLine()) {
//            lines.put(i++, sc.nextLine());
//        }
//
//        double count = 1;
//        for (Map.Entry<Integer, String> entry : lines.entrySet()) {
//            if (entry.getKey() == 0) {
//                continue;
//            }
//
//            println(count);
//
//            final String[] upperLineSplitted = lines.get(entry.getKey() - 1).split("");
//            final String[] lineSplitted = entry.getValue().split("");
//
//            for (int idx = 0; idx < upperLineSplitted.length; idx++) {
//                if ("S".equals(upperLineSplitted[idx])) {
//                    lineSplitted[idx] = "|";
//                } else if ("|".equals(upperLineSplitted[idx])) {
//                    if ("^".equals(lineSplitted[idx])) {
//                        count *= "|".equals(lineSplitted[idx - 1]) ? 1 : 2;
//                        lineSplitted[idx - 1] = "|";
//                        lineSplitted[idx + 1] = "|";
//                    } else {
//                        lineSplitted[idx] = "|";
//                    }
//                }
//            }
//
//            final String join = String.join("", lineSplitted);
//            lines.put(entry.getKey(), join);
//        }

        return 0L;
    }

//    private long take(int lineNb, long count, Map<Integer, String> lines) {
//
//        println(count);
//        if (lineNb >= lines.size()) {
//            return count;
//        }
//
//        final String[] upperLineSplitted = lines.get(lineNb - 1).split("");
//        final String[] lineSplitted = lines.get(lineNb).split("");
//
//        for (int idx = 0; idx < upperLineSplitted.length; idx++) {
//            if (upperLineSplitted[idx].equals("S")) {
//                lineSplitted[idx] = "|";
//                lines.put(lineNb, String.join("", lineSplitted));
//                return take(lineNb + 1, count, new HashMap<>(lines));
//            } else if (upperLineSplitted[idx].equals("|")) {
//                if (lineSplitted[idx].equals("^")) {
//                    Map<Integer, String> left = new HashMap<>(lines);
//                    Map<Integer, String> right = new HashMap<>(lines);
//
//                    final String[] leftLineSplitted = left.get(lineNb).split("");
//                    leftLineSplitted[idx - 1] = "|";
//                    left.put(lineNb, String.join("", leftLineSplitted));
//                    long leftSum = take(lineNb + 1, count + 1, left);
//
//                    final String[] rightLineSplitted = right.get(lineNb).split("");
//                    rightLineSplitted[idx + 1] = "|";
//                    right.put(lineNb, String.join("", rightLineSplitted));
//                    long rightSum = take(lineNb + 1, count + 1, right);
//                    return count + leftSum + rightSum;
//                } else {
//                    final HashMap<Integer, String> newLine = new HashMap<>(lines);
//                    final String[] newLineSplitted = newLine.get(lineNb).split("");
//                    newLineSplitted[idx] = "|";
//                    newLine.put(lineNb, String.join("", newLineSplitted));
//                    return take(lineNb + 1, count, newLine);
//                }
//            }
//        }
//
//        return count;
//    }
}
