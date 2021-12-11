package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuggyClassTestSC1b{
    BuggyClass bug;
    @Before
    public void setUp() {
        bug = new BuggyClass();
    }

    @After
    public void tearDown() {
        bug = null;
    }
    // under 50% statement coverage
    @Test(expected = ArithmeticException.class)
    public void buggyMethod1_divisor0() { // denominator is 0
        bug.buggyMethod1(0, 7, 3);
    }
    //      Could be used to check if the b^2 - 4ac is negative so that there are no imaginary numbers
//    @Test(expected = ArithmeticException.class)
//    public void buggyMethod1_negative(){ // b^2 - 4ac results in negative
//        bug.buggyMethod1(2,2, 3);
//    }
}