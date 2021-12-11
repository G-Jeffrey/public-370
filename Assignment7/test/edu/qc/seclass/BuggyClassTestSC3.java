
package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuggyClassTestSC3 {
    BuggyClass bug;
    @Before
    public void setUp() throws Exception {
        bug = new BuggyClass();
    }
    @After
    public void tearDown() throws Exception {
        bug = null;
    }
    // 100% statement coverage and reveals fault
    @Test(expected = ArithmeticException.class)
    public void buggyMethod_sc1(){
        assertEquals(2, bug.buggyMethod3(3,0));
    }
}