/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Gabriel
 * 
 */
public class FractionTest {

    private static Fraction fraction;
    private static int      numerator;
    private static int      denominator;

    @Before
    public void setUpFraction() {
        numerator = 1;
        denominator = 3;

        fraction = new Fraction(numerator, denominator);
    }

    @Test
    public void testMethodGetNumerator() {
        int expectedNumerator = 1;

        assertEquals("testMethodGetNumerator() - Unexpected numerator value",
                fraction.getNumerator(), expectedNumerator);
    }

    @Test
    public void testMethodSetNumeratorExists() {
        Class<?> cls = fraction.getClass();

        Method[] methods = cls.getDeclaredMethods();

        String methodsList = Arrays.toString(methods);
        String methodNameToFind = ".Fraction.setNumerator(int)";

        assertTrue("testMethodSetNumeratorExists() - Method not found",
                methodsList.contains(methodNameToFind));
    }

    @Test
    public void testMethodSetNumerator() {
        int expectedNumerator = 1;

        assertEquals("testMethodSetNumerator() - Unexpected numerator value",
                fraction.getNumerator(), expectedNumerator);

    }

    @Test
    public void testMethodGetDenominator() {
        int wrongDenominator = 3;

        assertEquals(
                "testMethodGetDenominator() - Unexpected denominator value",
                fraction.getDenominator(), wrongDenominator);
    }

    @Test
    public void testMethodSetDenominatorExists() {
        Class<?> cls = fraction.getClass();

        Method[] methods = cls.getDeclaredMethods();

        String methodsList = Arrays.toString(methods);
        String methodNameToFind = ".Fraction.setDenominator(int)";

        assertTrue("testMethodSetDenominatorExists() - Method not found",
                methodsList.contains(methodNameToFind));
    }

    @Test
    public void testMethodSetDenominator() {
        int expectedDenominator = 3;

        assertEquals(
                "testMethodSetDenominator() - Unexpected denominator value",
                fraction.getDenominator(), expectedDenominator);

    }

    @Test
    public void testMethodDivide() {
        int divisionResult = fraction.divide(fraction);
    }
    
    
    // add more divide tests to assert result

    @Test
    public void testMethodEquals() {

        assert (new Fraction(1, 2).equals(new Fraction(1, 2))) : "testMethodEquals() - Fractions not equal";
    }

    @Test
    public void testMethodEquals1() {

        assert (new Fraction(3, 6).equals(new Fraction(3, 6))) : "testMethodEquals1() - Fractions not equal";
    }

    @Test
    public void testMethodEquals2() {

        assert (new Fraction(-1, 2).equals(new Fraction(-1, 2))) : "testMethodEquals2() - Fractions not equal";
    }

    @Test
    public void testMethodEquals3() {

        assert (new Fraction(1, -2).equals(new Fraction(1, -2))) : "testMethodEquals3() - Fractions not equal";
    }

    @Test
    public void testMethodMultiply() {

        Fraction expectedOutcome = new Fraction(3, 10);

        Fraction fraction1 = new Fraction(1, 2);

        Fraction fraction2 = new Fraction(3, 5);

        Fraction multiplicationResult = new Fraction(0, 0);

        multiplicationResult = fraction1.multiply(fraction2);

        assert expectedOutcome.equals(multiplicationResult) : "testMethodMultiply() - Unexpected Fraction multiplication outcome";
    }

    @Test
    public void testMethodMultiply1() {

        assert ((new Fraction(3, 10)).equals(new Fraction(1, 2)
                .multiply(new Fraction(3, 5)))) : "testMethodMultiply1() - Fraction not equal after multiplication ";
    }

    // @Test
    // public void testMethodGreatestCommonDivisor() {
    // int num1 = 8;
    // int num2 = 12;
    // int expectedOutcome = 4;
    //
    // Fraction fraction = new Fraction(num1, num2);
    //
    // assert ;

    // }

}
