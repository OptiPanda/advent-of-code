package com.adventofcode.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.*;

public class Day05 {

    private static final String FILE_PATH = "src/main/resources/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static String answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Map<Integer, List<String>> stock = new HashMap<>();

        stock.put(1, new ArrayList<>(List.of("L","N","W","T","D")));
        stock.put(2, new ArrayList<>(List.of("C","P","H")));
        stock.put(3, new ArrayList<>(List.of("W","P","H","N","D","G","M","J")));
        stock.put(4, new ArrayList<>(List.of("C","W","S","N","T","Q","L")));
        stock.put(5, new ArrayList<>(List.of("P","H","C","N")));
        stock.put(6, new ArrayList<>(List.of("T","H","N","D","M","W","Q","B")));
        stock.put(7, new ArrayList<>(List.of("M","B","R","J","G","S","L")));
        stock.put(8, new ArrayList<>(List.of("Z","N","W","G","V","B","R","T")));
        stock.put(9, new ArrayList<>(List.of("W","G","D","N","P","L")));

        int initRowsCount = 10;

        while (initRowsCount-- > 0) {
            sc.nextLine();
        }

        while (sc.hasNextLine()) {
            Order order = getOrder(sc.nextLine());

            for (int i = 0; i < order.move; i++) {

                stock.get(order.to).add(stock.get(order.from).remove(stock.get(order.from).size() - 1));

            }
        }

        StringBuilder answer = new StringBuilder();

        stock.values().forEach(list -> answer.append(list.get(list.size()-1)));

        return answer.toString();
    }

    public static String answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Map<Integer, List<String>> stock = new HashMap<>();

        stock.put(1, new ArrayList<>(List.of("L","N","W","T","D")));
        stock.put(2, new ArrayList<>(List.of("C","P","H")));
        stock.put(3, new ArrayList<>(List.of("W","P","H","N","D","G","M","J")));
        stock.put(4, new ArrayList<>(List.of("C","W","S","N","T","Q","L")));
        stock.put(5, new ArrayList<>(List.of("P","H","C","N")));
        stock.put(6, new ArrayList<>(List.of("T","H","N","D","M","W","Q","B")));
        stock.put(7, new ArrayList<>(List.of("M","B","R","J","G","S","L")));
        stock.put(8, new ArrayList<>(List.of("Z","N","W","G","V","B","R","T")));
        stock.put(9, new ArrayList<>(List.of("W","G","D","N","P","L")));

        int initRowsCount = 10;

        while (initRowsCount-- > 0) {
            sc.nextLine();
        }

        while (sc.hasNextLine()) {
            Order order = getOrder(sc.nextLine());

            List<String> tmpList = new ArrayList<>();

            for (int i = 0; i < order.move; i++) {
                tmpList.add(stock.get(order.from).remove(stock.get(order.from).size() - 1));
            }
            for (int i = 0; i < order.move; i++) {
                stock.get(order.to).add(tmpList.remove(tmpList.size() - 1));
            }
        }

        StringBuilder answer = new StringBuilder();

        stock.values().forEach(list -> answer.append(list.get(list.size()-1)));

        return answer.toString();
    }

    public static Order getOrder(String line) {
        line = line.replace("move ", "");
        line = line.replace(" from ",";");
        line = line.replace(" to ",";");

        final String[] ordSplit = line.split(";");

        return new Order(Integer.parseInt(ordSplit[0]),Integer.parseInt(ordSplit[1]),Integer.parseInt(ordSplit[2]));
    }

    protected static class Order {
        Integer move;
        Integer from;
        Integer to;

        public Order(Integer move, Integer from, Integer to) {
            this.move = move;
            this.from = from;
            this.to = to;
        }
    }
}


