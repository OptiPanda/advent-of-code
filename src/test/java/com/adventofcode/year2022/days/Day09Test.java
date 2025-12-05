package com.adventofcode.year2022.days;

import com.adventofcode.model.AbstractDayTest;

import static com.adventofcode.utils.AdventOfCodeUtils.errln;
import static com.adventofcode.utils.AdventOfCodeUtils.println;

public class Day09Test extends AbstractDayTest<Day09, Integer> {
    
    public Day09Test() {
        super(new Day09());
    }

    public static void main(String[] args) {
        new Day09Test().test();
    }

    @Override
    protected Integer getExpectedAnswer1() {
        return 6256;
    }

    @Override
    protected Integer getExpectedAnswer2() {
        return 0;
    }

    @Override
    protected boolean otherTests() {
        return testTailFollowHead();
    }

    private boolean testTailFollowHead() {
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
    private boolean testUp() {
        int[] head = {0, 0};
        int[] tail = {-2, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testUp KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testUp OK");
        return true;
    }

    /**
     * ##T##    #####
     * #####    ##T##
     * ##H## -> ##H##
     * #####    #####
     * #####    #####
     */
    private boolean testDown() {
        int[] head = {0, 0};
        int[] tail = {2, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testDown KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testDown OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H#T -> ##HT#
     * #####    #####
     * #####    #####
     */
    private boolean testLeft() {
        int[] head = {0, 0};
        int[] tail = {0, 2};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {0, 1};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testLeft KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testLeft OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * T#H## -> #TH##
     * #####    #####
     * #####    #####
     */
    private boolean testRight() {
        int[] head = {0, 0};
        int[] tail = {0, -2};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {0, -1};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testRight KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testRight OK");
        return true;
    }

    /**
     * ###T#    #####
     * #####    ##T##
     * ##H## -> ##H##
     * #####    #####
     * #####    #####
     */
    private boolean testLeftDown() {
        int[] head = {0, 0};
        int[] tail = {2, 1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testLeftDown KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testLeftDown OK");
        return true;
    }

    /**
     * #T###    #####
     * #####    ##T##
     * ##H## -> ##H##
     * #####    #####
     * #####    #####
     */
    private boolean testRightDown() {
        int[] head = {0, 0};
        int[] tail = {2, -1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testRightDown KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testRightDown OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H## -> ##H##
     * #####    ##T##
     * ###T#    #####
     */
    private boolean testLeftUp() {
        int[] head = {0, 0};
        int[] tail = {-2, 1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testLeftUp KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testLeftUp OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H## -> ##H##
     * #####    ##T##
     * #T###    #####
     */
    private boolean testRightUp() {
        int[] head = {0, 0};
        int[] tail = {-2, -1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testRightUp KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testRightUp OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##H## -> #TH##
     * T####    #####
     * #####    #####
     */
    private boolean testRightUp2() {
        int[] head = {0, 0};
        int[] tail = {-2, -1};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {-1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testRightUp3 KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testRightUp3 OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * ##X## -> ##X##
     * #####    #####
     * #####    #####
     */
    private boolean testNoMove() {
        int[] head = {0, 0};
        int[] tail = {0, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {0, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testNoMove KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testNoMove OK");
        return true;
    }

    /**
     * #####    #####
     * #####    #####
     * #TH## -> #TH##
     * #####    #####
     * #####    #####
     */
    private boolean testNoMove2() {
        int[] head = {0, 0};
        int[] tail = {1, 0};

        Day09.tailFollowHead(head, tail);

        int[] expectedAnswer = {1, 0};
        if (tail[0] != expectedAnswer[0] || tail[1] != expectedAnswer[1]) {
            errln(classTestCode() + " testNoMove2 KO | given [" + tail[0] + "," + tail[1] + "] expected [" + expectedAnswer[0] + "," + expectedAnswer[1] + "]");
            return false;
        }
        println(classTestCode() + " testNoMove2 OK");
        return true;
    }
}