import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Vaishnavi Kasabwala
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Test of isPrime1
     */
    @Test
    // boundary, 2 is the only even prime number
    public void testIsPrime1_2() {
        NaturalNumber n = new NaturalNumber2(2);

        boolean prime = true;

        assertEquals(prime, CryptoUtilities.isPrime1(n));
    }

    // routine
    @Test
    public void testIsPrime1_15() {
        NaturalNumber n = new NaturalNumber2(15);

        boolean prime = false;

        assertEquals(prime, CryptoUtilities.isPrime1(n));
    }

    // challenging, large number
    @Test
    public void testIsPrime1_3788923469() {
        NaturalNumber n = new NaturalNumber2("3788923469");

        boolean prime = true;

        assertEquals(prime, CryptoUtilities.isPrime1(n));
    }

    /*
     * Test of isPrime2
     */
    @Test
    // boundary, 2 is the only prime even number
    public void testIsPrime2_2() {

        NaturalNumber n = new NaturalNumber2(2);

        boolean prime = true;

        assertEquals(prime, CryptoUtilities.isPrime2(n));
    }

    @Test
    // routine
    public void testIsPrime2_27() {
        NaturalNumber n = new NaturalNumber2(27);

        boolean prime = false;

        assertEquals(prime, CryptoUtilities.isPrime2(n));
    }

    @Test
    // challenging, large natural number
    public void testIsPrime2_3788923469() {
        NaturalNumber n = new NaturalNumber2("3788923469");

        boolean prime = true;

        assertEquals(prime, CryptoUtilities.isPrime2(n));
    }

    /*
     * Test of isWitnessToCompositeness
     */
    @Test
    // boundary,  2 is the only prime even number
    public void testIsWitnessToCompositeness_2_30() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(30);
        assertEquals("2", w.toString());
        assertEquals("30", n.toString());
        boolean truth = true;
        assertEquals(truth, CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    // routine
    public void testIsWitnessToCompositeness_15_65() {
        NaturalNumber w = new NaturalNumber2(15);
        NaturalNumber n = new NaturalNumber2(65);
        assertEquals("15", w.toString());
        assertEquals("65", n.toString());
        boolean wrong = false;
        assertEquals(wrong, CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    // challenging, uses larger numbers
    public void testIsWitnessToCompositeness_30_990() {
        NaturalNumber w = new NaturalNumber2(30);
        NaturalNumber n = new NaturalNumber2(990);
        assertEquals("30", w.toString());
        assertEquals("990", n.toString());
        boolean truth = true;
        assertEquals(truth, CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    /*
     * Test of generateNextLikelyNumber
     */
    @Test
    // boundary, smallest prime numbers
    public void testGenerateNextLikelyPrime_2() {
        NaturalNumber n = new NaturalNumber2(2);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("3", n.toString());
    }

    // routine
    public void testGenerateNextLikelyPrime_20() {
        NaturalNumber n = new NaturalNumber2(20);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("23", n.toString());
    }

    // challenging, large number
    public void testGenerateNextLikelyPrime_3788923467() {
        NaturalNumber n = new NaturalNumber2("3788923467");
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("3788923469", n.toString());
    }

}