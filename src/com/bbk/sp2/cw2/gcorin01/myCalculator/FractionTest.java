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
        numerator = 64;
        denominator = 1024;

        fraction = new Fraction(numerator, denominator);
    }

    @Test
    public void testMethodGetNumerator() {
        int expectedNumerator = 1;

        assertEquals("testMethodGetNumerator() - Unexpected numerator value",
                expectedNumerator, fraction.getNumerator());
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
                expectedNumerator, fraction.getNumerator());

    }

    @Test
    public void testMethodGetDenominator() {
        int expectedDenominator = 16;

        assertEquals(
                "testMethodGetDenominator() - Unexpected denominator value",
                expectedDenominator, fraction.getDenominator());
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
        int expectedDenominator = 16;

        assertEquals(
                "testMethodSetDenominator() - Unexpected denominator value",
                expectedDenominator, fraction.getDenominator());
    }

    @Test
    public void testMethodDivide() {
        int expectedResult = 0;
        int divisionResult = fraction.divide(fraction);

        assertEquals("testMethodDivide() - Unexpected division result",
                expectedResult, divisionResult);
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

        Fraction multiplicationResult;

        multiplicationResult = fraction1.multiply(fraction2);

        assert expectedOutcome.equals(multiplicationResult) : "testMethodMultiply() - Unexpected Fraction multiplication outcome";
    }

    @Test
    public void testMethodMultiply1() {

        assert ((new Fraction(3, 10)).equals(new Fraction(1, 2)
                .multiply(new Fraction(3, 5)))) : "testMethodMultiply1() - Fraction not equal after multiplication ";
    }

    @Test
    public void testMethodGreatestCommonDivisor() {
        int expectedGcd = 64;

        assertEquals(
                "testMethodGreatestCommonDivisor() - Unexpected gcd outcome",
                expectedGcd, fraction.getGcd(numerator, denominator));
    }

    @Test
    public void testMethodToString() {
        String expectedOutcome = fraction.getNumerator() + "/"
                + fraction.getDenominator();
        String actualOutcome = fraction.toString();

        assertEquals(
                "testMethodToString() - Unexpected Fraction to string outcome",
                expectedOutcome, actualOutcome);
    }

    @Test
    public void testMethodLeastCommonMultiplierWithPosNumb() {
        int expectedOutcome = 15;
        int a = 3;
        int b = 15;
        int lcm = fraction.getLcm(a, b);
        
        assertEquals("testMethodLeastCommonMultiplier() - Unexpected lcm outcome", expectedOutcome, lcm);
    }
    
    
    @Test
    public void testMethodLeastCommonMultiplierWithNegNumb() {
        int expectedOutcome = 15;
        int a = -3;
        int b = -15;
        int lcm = fraction.getLcm(a, b);
        
        assertEquals("testMethodLeastCommonMultiplier() - Unexpected lcm outcome", expectedOutcome, lcm);
    }
    
    @Test
    public void testMethodLeastCommonMultiplierWithOneNegNumb() {
        int expectedOutcome = 15;
        int a = -3;
        int b = 15;
        int lcm = fraction.getLcm(a, b);
        
        assertEquals("testMethodLeastCommonMultiplier() - Unexpected lcm outcome", expectedOutcome, lcm);
    }
    
    
    @Test
    public void testMethodLeastCommonMultiplierWithZero() {
        int expectedOutcome = 0;
        int a = 0;
        int b = -15;
        int lcm = fraction.getLcm(a, b);
        
        assertEquals("testMethodLeastCommonMultiplier() - Unexpected lcm outcome", expectedOutcome, lcm);
    }
    
    @Test
    public void testMethodLeastCommonMultiplierWithEqualNumbs() {
        int expectedOutcome = 10000;
        int a = 1000;
        int b = 10000;
        int lcm = fraction.getLcm(a, b);
        
        assertEquals("testMethodLeastCommonMultiplier() - Unexpected lcm outcome", expectedOutcome, lcm);
    }
    
    @Test
    public void testMethodLeastCommonMultiplierWithBigNumbs() {
        int expectedOutcome = 10000;
        int a = 214748364;
        int b = 214748364;
        int lcm = fraction.getLcm(a, b);
        
        assertEquals("testMethodLeastCommonMultiplier() - Unexpected lcm outcome", expectedOutcome, lcm);
    }
    
    
//    @Test
//    public void testMethodAdd() {
//        Fraction expectedOutcome = new Fraction(); 
//        Fraction frac1 = new Fraction(3, 4);
//        Fraction frac2 = new Fraction(2, 3);
//        
//        
//    }
}
