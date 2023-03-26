package com.adventofcode.year2022.days;

import com.adventofcode.DayTest;

public class Day09Test extends DayTest {

    public static final String CLASSNAME = Day09Test.class.getSimpleName();

    public static void test() {
        System.out.println(CLASSNAME + " : Start tests");
        System.out.println("---");

        boolean isOk = testTailFollowHead()
                && testAnswer1()
                && testAnswer2()
                ;

        System.out.println("---");

        System.out.println(CLASSNAME + " : All test " + (isOk ? "OK" : "KO"));
    }

    private static boolean testAnswer1() {
        final Integer answer = Day09.answer1();
        int expectedAnswer = 6256;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 1 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 1 OK");
        return true;
    }

    private static boolean testAnswer2() {
        final Integer answer = Day09.answer2();
        int expectedAnswer = 0;
        if (answer != expectedAnswer) {
            System.err.println(CLASSNAME + " answer 2 KO | given " + answer + " expected " + expectedAnswer);
            return false;
        }
        System.out.println(CLASSNAME + " answer 2 OK");
        return true;
    }

    private static boolean testTailFollowHead() {
        return testUp()
            && testRight()
            && testLeft()
            && testDown()
            && testLeftDown()
            && testRightDown()
            && testLeftUp()
            && testRightUp()
            && testRightUp2()
            && testNoMove()
            && testNoMove2()
        ;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H## -> ##H##
     * #####    ##T##
     * ##T##    #####
     */
    private static boolean testUp() {
        int[] head = {0, 0};
        int[] tail = {-2, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testUp KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testUp OK");
        return true;
    }

    /**
     * ##T##    #####
     * #####    ##T##
     * ##H## -> ##H##
     * #####    #####
     * #####    #####
     */
    private static boolean testDown() {
        int[] head = {0, 0};
        int[] tail = {2, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testDown KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testDown OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H#T -> ##HT#
     * #####    #####
     * #####    #####
     */
    private static boolean testLeft() {
        int[] head = {0, 0};
        int[] tail = {0, 2};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {0, 1};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testLeft KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testLeft OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * T#H## -> #TH##
     * #####    #####
     * #####    #####
     */
    private static boolean testRight() {
        int[] head = {0, 0};
        int[] tail = {0, -2};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {0, -1};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testRight KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testRight OK");
        return true;
    }

    /**
     * ###T#    #####
     * #####    ##T##
     * ##H## -> ##H##
     * #####    #####
     * #####    #####
     */
    private static boolean testLeftDown() {
        int[] head = {0, 0};
        int[] tail = {2, 1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testLeftDown KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testLeftDown OK");
        return true;
    }

    /**
     * #T###    #####
     * #####    ##T##
     * ##H## -> ##H##
     * #####    #####
     * #####    #####
     */
    private static boolean testRightDown() {
        int[] head = {0, 0};
        int[] tail = {2, -1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testRightDown KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testRightDown OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H## -> ##H##
     * #####    ##T##
     * ###T#    #####
     */
    private static boolean testLeftUp() {
        int[] head = {0, 0};
        int[] tail = {-2, 1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testLeftUp KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testLeftUp OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H## -> ##H##
     * #####    ##T##
     * #T###    #####
     */
    private static boolean testRightUp() {
        int[] head = {0, 0};
        int[] tail = {-2, -1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testRightUp KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testRightUp OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H## -> #TH##
     * T####    #####
     * #####    #####
     */
    private static boolean testRightUp2() {
        int[] head = {0, 0};
        int[] tail = {-2, -1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testRightUp3 KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testRightUp3 OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##X## -> ##X##
     * #####    #####
     * #####    #####
     */
    private static boolean testNoMove() {
        int[] head = {0, 0};
        int[] tail = {0, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {0, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testNoMove KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testNoMove OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * #TH## -> #TH##
     * #####    #####
     * #####    #####
     */
    private static boolean testNoMove2() {
        int[] head = {0, 0};
        int[] tail = {1, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            System.err.println(CLASSNAME + " testNoMove2 KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        System.out.println(CLASSNAME + " testNoMove2 OK");
        return true;
    }
}