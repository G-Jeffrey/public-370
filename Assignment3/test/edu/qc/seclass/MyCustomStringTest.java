package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("123 1234!@#% 51$%52 -#$% 6#@%7@#$+)1"); // Only Integers + Special Characters
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test(expected = NullPointerException.class)
    public void testCountNumbers3() {
        mycustomstring.setString(null); // Empty String
        mycustomstring.countNumbers();
    }

    @Test
    public void testCountNumbers4() {
        mycustomstring.setString(""); // Empty String
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("My numbers are 11 and 96");
        assertEquals(2, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("1-2-5-6-5t234");
        assertEquals(6, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected = IllegalArgumentException.class) // Less than or equal to 0
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);
    }

    @Test // n is larger than input length
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        String input = "Hello World";
        mycustomstring.setString(input);
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(input.length()+1, true));
    }

    @Test(expected = NullPointerException.class)  // Input is Null
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(100, true);
    }

    @Test(expected = IllegalArgumentException.class)  // Input is Null but n is not greater than 0
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, true);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() { // n = 1, return every letter
        String input = "Hello World";
        mycustomstring.setString(input);
        assertEquals("Hello World", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        String input = "Hello World!";
        mycustomstring.setString(input);
        assertEquals("el ol!", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() { // Should the same output at the last testcase
        String input = "!dlroW olleH";
        mycustomstring.setString(input);
        assertEquals(new StringBuilder("el ol!").reverse().toString(), mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test // Testcase for whitespace
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        String input = "          "; // 10 whitespaces
        mycustomstring.setString(input);
        assertEquals("     ",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2,false));
    }

    @Test // Check for length = str.length(), taking the last letter of the string
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        String input = "Hello World!";
        mycustomstring.setString(input);
        assertEquals("!", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(input.length(), false));
    }

    @Test // Same case as the previous case but starting from the end of the String.
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        String input = "Hello World!";
        mycustomstring.setString(input);
        assertEquals("H", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(input.length(), true));
    }

    @Test // Every 2nd of a reversed test case, since the length/2 is odd we can start from 0 instead of the last string
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        mycustomstring.setString(input);
        assertEquals("Lrmismdlrstae,cnettraiicn lt", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));

    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        mycustomstring.setString(input);
        assertEquals("mulieot igt", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));

    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class) // start > end
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(40, 23);
    }
    // The next two cases preassumes that start < end position due to the IllegalArgument coverage
    @Test(expected = MyIndexOutOfBoundsException.class) //Start position is less than 1
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(0, 10);
    }

    @Test(expected = MyIndexOutOfBoundsException.class) //End Position is greater than string's length
    public void testConvertDigitsToNamesInSubstring4() {
        String input = "I'd b3tt3r put s0me d161ts in this 5tr1n6, right?";
        mycustomstring.setString(input);
        mycustomstring.convertDigitsToNamesInSubstring(1,input.length()+1);
    }

    @Test(expected = NullPointerException.class) // Null input
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,4);
    }

    @Test(expected = IllegalArgumentException.class) // Null input but start > end
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,-4);
    }

    @Test(expected = MyIndexOutOfBoundsException.class) // Null input but invalid start/end
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(-1,4);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("1234567890");
        mycustomstring.convertDigitsToNamesInSubstring(1,5);
        assertEquals("OneTwoThreeFourFive67890",mycustomstring.getString());
    }

}
