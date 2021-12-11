package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC1a {
    BuggyClass bug;
    @Before
    public void setUp() {
        bug = new BuggyClass();
    }

    @After
    public void tearDown() {
        bug = null;
    }
    // 100% statement coverage
    @Test
    public void buggyMethod1_fullCoverage(){
        assertEquals(-1.0, bug.buggyMethod1(2,4,2), 0.001);
    }
}