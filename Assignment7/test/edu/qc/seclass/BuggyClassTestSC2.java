package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC2 {
    BuggyClass bug;
    @Before
    public void setUp() throws Exception {
        bug = new BuggyClass();
    }
    @After
    public void tearDown() throws Exception {
        bug = null;
    }
    // 100% statement coverage
    @Test
    public void buggyMethod2(){
        assertEquals(2.135,bug.buggyMethod2(-3,5, 3),0.001);
    }
}