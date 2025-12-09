package com.adventofcode.year2025.days;

import com.adventofcode.model.AbstractDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day06 extends AbstractDay<Long> {

    private static final String PLUS = "+";
    private static final String MULT =  "*";

    @Override
    public Long answer1() {
        final Scanner sc = getScanner();

        List<Integer[]> list = new ArrayList<>();
        long sum = 0;

        for (int i = 0; i < 4; i++) {
            final String line = sc.nextLine();
            final Integer[] array = Arrays.stream(line.replaceAll("\s+", " ").split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            list.add(array);
        }

        final String[] line = sc.nextLine().replaceAll("\s+", " ").split(" ");
        for (int i = 0; i < line.length; i++) {
            long operation = line[i].equals(PLUS) ? 0 : 1;
            for (Integer[] integers : list) {
                if (line[i].equals(PLUS)) {
                    operation += integers[i];
                } else {
                    operation *= integers[i];
                }
            }
            sum += operation;
        }

        return sum;
    }

    @Override
    public Long answer2() {
        final Scanner sc = getScanner();

        List<String> lines = new ArrayList<>();
        long sum = 0;

        for (int i = 0; i < 4; i++) {
            lines.add(sc.nextLine());
        }

        final String operationLine = sc.nextLine();

        int idxStart = operationLine.length()-1;
        int countSpaces = 0;
        for (int opIdx = operationLine.length()-1; opIdx >= 0; opIdx--) {
            char c = operationLine.charAt(opIdx);

            if (c == ' ') {
                countSpaces++;
            } else if (c == '+' || c == '*') {
                long operation = c == '+' ? 0 : 1;
                for (int len = 1; len <= countSpaces; len++) {
                    String val = "";
                    for (String strings : lines) {
                        if (strings.charAt(idxStart-len) != ' ') {
                            val += strings.charAt(idxStart-len);
                        }
                    }
                    if (c == '+') {
                        operation += Integer.parseInt(val);
                    } else {
                        operation *= Integer.parseInt(val);
                    }
                }
                sum += operation;

                countSpaces = 0;
                idxStart = opIdx-1;
            }
        }

        return sum;
    }
}
