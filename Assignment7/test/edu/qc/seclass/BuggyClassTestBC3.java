
package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuggyClassTestBC3 {
    BuggyClass bug;
    @Before
    public void setUp() throws Exception {
        bug = new BuggyClass();
    }
    @After
    public void tearDown() throws Exception {
        bug = null;
    }
    // 100% branch coverage
    @Test
    public void buggyMethod_bc1(){
        assertEquals(2, bug.buggyMethod3(3,1));
    }
    @Test
    public void buggyMethod_bc2(){
        assertEquals(8, bug.buggyMethod3(4,1));
    }
}