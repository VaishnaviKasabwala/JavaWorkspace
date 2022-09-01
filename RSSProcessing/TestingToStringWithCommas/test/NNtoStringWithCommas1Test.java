import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NNtoStringWithCommas1Test {

    /**
     *  * Calls the method under test.  *  * @param n  *            the number
     * to pass to the method under test  * @return the {@code String} returned
     * by the method under test  * @ensures <pre>
      * redirectToMethodUnderTest = [String returned by the method under test]
      * </pre>  
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas1.toStringWithCommas(n);
    }

    /**
     * Test toStringWithCommas with input 0. boundary case as it tests at zero,
     * the smallest value allowed.
     */
    @Test
    public void testToStringWithCommas0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber expected = new NaturalNumber2(0);
        String actualOutput = redirectToMethodUnderTest(n);
        String expectedOutput = "0";

        assertEquals(expectedOutput, actualOutput);
        assertEquals(expected, n);
    }

    /**
     * Test toStringWithCommas with input 1. routine
     */
    @Test
    public void testToStringWithCommas1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber expected = new NaturalNumber2(1);
        String actualOutput = redirectToMethodUnderTest(n);
        String expectedOutput = "1";

        assertEquals(expectedOutput, actualOutput);
        assertEquals(expected, n);
    }

    /**
     * Test toStringWithCommas with input 100. routine
     */
    @Test
    public void testToStringWithCommas100() {
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber expected = new NaturalNumber2(100);
        String actualOutput = redirectToMethodUnderTest(n);
        String expectedOutput = "100";

        assertEquals(expectedOutput, actualOutput);
        assertEquals(expected, n);
    }

    /**
     * Test toStringWithCommas with input 1000. boundary, first number to have a
     * comma
     */
    @Test
    public void testToStringWithCommas1000() {
        NaturalNumber n = new NaturalNumber2(1000);
        NaturalNumber expected = new NaturalNumber2(1000);
        String actualOutput = redirectToMethodUnderTest(n);
        String expectedOutput = "1,000";

        assertEquals(expectedOutput, actualOutput);
        assertEquals(expected, n);
    }

    /**
     * Test toStringWithCommas with input 1234567. routine
     */
    @Test
    public void testToStringWithCommas1234567() {
        NaturalNumber n = new NaturalNumber2(1234567);
        NaturalNumber expected = new NaturalNumber2(1234567);
        String actualOutput = redirectToMethodUnderTest(n);
        String expectedOutput = "1,234,567";

        assertEquals(expectedOutput, actualOutput);
        assertEquals(expected, n);

    }

}
