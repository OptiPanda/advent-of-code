package com.adventofcode.year2023.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07 {

    private static final String FILE_PATH = "src/main/resources/year2023/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    // REGEX 5 of a kind : (.)\1{4}

    private static final Pattern FIVE_OF_A_KIND = Pattern.compile("(.)\\1{4}");
    private static final Pattern FOUR_OF_A_KIND = Pattern.compile(".*(?<A>.)\\1{3}");
    private static final Pattern FULL_HOUSE = Pattern.compile("((?<A>.)\\2\\2(?<C>.)\\3)|((?<D>.)\\5(?<B>.)\\6\\6)");
    private static final Pattern THREE_OF_A_KIND = Pattern.compile(".*(?<A>.)\\1\\1.*");
    private static final Pattern TWO_PAIR = Pattern.compile(".*(?<A>.)\\1.*(?<B>.)\\2.*");
    private static final Pattern ONE_PAIR = Pattern.compile(".*(?<A>.)\\1.*");

    private static final String ORDER = "23456789TJQKA";
    private static final String ORDER_RULE_2 = "J23456789TQKA";

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        List<Play> plays = new ArrayList<>();

        while (sc.hasNextLine()) {
            final String[] val = sc.nextLine().split(" ");

            Play play = new Play();
            play.hand = val[0].chars().mapToObj(c -> (char)c).sorted(Comparator.comparingInt(ORDER::indexOf)).sorted(Comparator.reverseOrder()).map(c -> ""+c).reduce(String::concat).orElse("");
            play.bid = Integer.parseInt(val[1]);
            play.scoreRank = ORDER.indexOf(val[0].charAt(0)) * 100000000
                    + ORDER.indexOf(val[0].charAt(1)) * 1000000
                    + ORDER.indexOf(val[0].charAt(2)) * 10000
                    + ORDER.indexOf(val[0].charAt(3)) * 100
                    + ORDER.indexOf(val[0].charAt(4));

            final Matcher matcher5 = FIVE_OF_A_KIND.matcher(play.hand);
            if(matcher5.find()) {
                play.scoreType = 6;

                plays.add(play);
                continue;
            }

            final Matcher matcher4 = FOUR_OF_A_KIND.matcher(play.hand);
            if(matcher4.find()) {
                play.scoreType = 5;
                plays.add(play);
                continue;
            }

            final Matcher matcherFull = FULL_HOUSE.matcher(play.hand);
            if(matcherFull.find()) {
                play.scoreType = 4;
                plays.add(play);
                continue;
            }

            final Matcher matcher3 = THREE_OF_A_KIND.matcher(play.hand);
            if(matcher3.find()) {
                play.scoreType = 3;
                plays.add(play);
                continue;
            }

            final Matcher matcher2Pair = TWO_PAIR.matcher(play.hand);
            if(matcher2Pair.find()) {
                play.scoreType = 2;
                plays.add(play);
                continue;
            }

            final Matcher matcher1Pair = ONE_PAIR.matcher(play.hand);
            if(matcher1Pair.find()) {
                play.scoreType = 1;
                plays.add(play);
                continue;
            }

            play.scoreType = 0;
            plays.add(play);

        }

        plays.sort(Comparator.comparingInt(Play::getScoreType).thenComparing(Play::getScoreRank));

        int total = 0;

        for (int i = plays.size() - 1; i >= 0; i--) {
            final Play play = plays.get(i);
            System.err.println("[" + play.scoreType + "]" + (i+1) + " - " + play.hand + " for " + play.bid + " ["+(play.bid * (i+1))+"]");
            total += (play.bid * (i+1));
        }

        return total;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        List<Play> plays = new ArrayList<>();

        while (sc.hasNextLine()) {
            final String[] val = sc.nextLine().split(" ");

            Play play = new Play();
            play.hand = val[0].chars().mapToObj(c -> (char)c).sorted(Comparator.comparingInt(ORDER_RULE_2::indexOf)).sorted(Comparator.reverseOrder()).map(c -> ""+c).reduce(String::concat).orElse("");
            play.bid = Integer.parseInt(val[1]);
            play.scoreRank = ORDER_RULE_2.indexOf(val[0].charAt(0)) * 100000000
                    + ORDER_RULE_2.indexOf(val[0].charAt(1)) * 1000000
                    + ORDER_RULE_2.indexOf(val[0].charAt(2)) * 10000
                    + ORDER_RULE_2.indexOf(val[0].charAt(3)) * 100
                    + ORDER_RULE_2.indexOf(val[0].charAt(4));

            final Matcher matcher5 = FIVE_OF_A_KIND.matcher(play.hand);
            if(matcher5.find()) {
                play.scoreType = 6;

                plays.add(play);
                continue;
            }

            final Matcher matcher4 = FOUR_OF_A_KIND.matcher(play.hand);
            if(matcher4.find()) {
                if (play.hand.contains("J")) {
                    play.scoreType = 6;
                } else {
                    play.scoreType = 5;
                }
                plays.add(play);
                continue;
            }

            final Matcher matcherFull = FULL_HOUSE.matcher(play.hand);
            if(matcherFull.find()) {
                if (play.hand.contains("J")) {
                    play.scoreType = 6;
                } else {
                    play.scoreType = 4;
                }
                plays.add(play);
                continue;
            }

            final Matcher matcher3 = THREE_OF_A_KIND.matcher(play.hand);
            if(matcher3.find()) {
                if (play.hand.contains("J")) {
                    play.scoreType = 5;
                } else {
                    play.scoreType = 3;
                }
                plays.add(play);
                continue;
            }

            final Matcher matcher2Pair = TWO_PAIR.matcher(play.hand);
            if(matcher2Pair.find()) {
                if (play.hand.contains("JJ")) {
                    play.scoreType = 5;
                } else if (play.hand.contains("J")) {
                    play.scoreType = 4;
                } else {
                    play.scoreType = 2;
                }
                plays.add(play);
                continue;
            }

            final Matcher matcher1Pair = ONE_PAIR.matcher(play.hand);
            if(matcher1Pair.find()) {
                if (play.hand.contains("J")) {
                    play.scoreType = 3;
                } else {
                    play.scoreType = 1;
                }
                plays.add(play);
                continue;
            }

            if (play.hand.contains("J")) {
                play.scoreType = 1;
            } else {
                play.scoreType = 0;
            }
            plays.add(play);

        }

        plays.sort(Comparator.comparingInt(Play::getScoreType).thenComparing(Play::getScoreRank));

        int total = 0;

        for (int i = plays.size() - 1; i >= 0; i--) {
            final Play play = plays.get(i);
            System.err.println("[" + play.scoreType + "]" + (i+1) + " - " + play.hand + " for " + play.bid + " ["+(play.bid * (i+1))+"]");
            total += (play.bid * (i+1));
        }

        return total;
    }

    private static class Play {
        public String hand;
        public Integer bid;

        public int scoreType; // 0 - 1 - 2 - 3 - 4 - 5 - 6
        public int scoreRank; // 2 3 4 5 6 7 8 9 T J Q K A

        public int getScoreType() {
            return scoreType;
        }

        public int getScoreRank() {
            return scoreRank;
        }
    }
}
