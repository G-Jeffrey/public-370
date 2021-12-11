package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuggyClassTestBC2 {
    BuggyClass bug;
    @Before
    public void setUp() throws Exception {
        bug = new BuggyClass();
    }
    @After
    public void tearDown() throws Exception {
        bug = null;
    }
    // 75% branch coverage, 100% statement coverage
    @Test
    public void buggyMethod_bc1(){
        assertEquals(-0.566,bug.buggyMethod2(3,7,3),0.001);
    }
    @Test
    public void buggyMethod_bc2(){
        assertEquals(2.528,bug.buggyMethod2(-3,6,4),0.001);
    }
    @Test(expected = ArithmeticException.class)
    public void buggyMethod2_bc3(){ // b^2 - 4ac results in negative
        bug.buggyMethod2(0, 7, 3);
    }
}