/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Before;
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
        Fraction expectedResult = new Fraction(9, 10);
        Fraction fraction = new Fraction(3, 5);
        Fraction divisionResult = fraction.divide(new Fraction(2, 3));

        assertEquals("testMethodDivide() - Unexpected division result",
                expectedResult, divisionResult);
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodDivideOverflow() {
        int a = Integer.MAX_VALUE + 1;
        int b = Integer.MAX_VALUE * 3;
        int c = Integer.MAX_VALUE + 1;
        int d = Integer.MAX_VALUE * 3;

        Fraction frac = new Fraction(a, b).divide(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodDivideUnderflow() {
        int a = Integer.MIN_VALUE - 1;
        int b = Integer.MIN_VALUE / 3;
        int c = Integer.MIN_VALUE - 1;
        int d = Integer.MIN_VALUE / 3;

        Fraction frac = new Fraction(a, b).divide(new Fraction(c, d));
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
    public void testMethodMultiply1() {

        Fraction expectedOutcome = new Fraction(3, 10);

        Fraction fraction1 = new Fraction(1, 2);

        Fraction fraction2 = new Fraction(3, 5);

        Fraction multiplicationResult;

        multiplicationResult = fraction1.multiply(fraction2);

        assert expectedOutcome.equals(multiplicationResult) : "testMethodMultiply() - Unexpected Fraction multiplication outcome";
    }

    @Test
    public void testMethodMultiply() {

        assert ((new Fraction(3, 10)).equals(new Fraction(1, 2)
                .multiply(new Fraction(3, 5)))) : "testMethodMultiply1() - Fraction not equal after multiplication ";
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodMultiplyOverflow() {
        int a = Integer.MAX_VALUE + 1;
        int b = Integer.MAX_VALUE * 3;
        int c = Integer.MAX_VALUE * 3;
        int d = Integer.MAX_VALUE + 1;

        Fraction frac = new Fraction(a, b).multiply(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodMultiplyUnderflow() {
        int a = Integer.MIN_VALUE + 1;
        int b = Integer.MIN_VALUE * 3;
        int c = Integer.MIN_VALUE * 3;
        int d = Integer.MIN_VALUE + 1;

        Fraction frac = new Fraction(a, b).multiply(new Fraction(c, d));
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
    public void testMethodToStringDenIsOne() {
        Fraction frac = new Fraction(879, 1);
        String expectedOutcome = "879";
        fraction = frac;
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

        assertEquals(
                "testMethodLeastCommonMultiplier() - Unexpected lcm outcome",
                expectedOutcome, lcm);
    }

    @Test
    public void testMethodLeastCommonMultiplierWithNegNumb() {
        int expectedOutcome = -15;
        int a = -3;
        int b = -15;
        int lcm = new Fraction(64, 1024).getLcm(a, b);

        assertEquals(
                "testMethodLeastCommonMultiplier() - Unexpected lcm outcome",
                expectedOutcome, lcm);
    }

    @Test
    public void testMethodLeastCommonMultiplierWithOneNegNumb() {
        int expectedOutcome = 15;
        int a = -3;
        int b = 15;
        int lcm = fraction.getLcm(a, b);

        assertEquals(
                "testMethodLeastCommonMultiplier() - Unexpected lcm outcome",
                expectedOutcome, lcm);
    }

    @Test
    public void testMethodLeastCommonMultiplierWithZero() {
        int expectedOutcome = 0;
        int a = 0;
        int b = -15;
        int lcm = fraction.getLcm(a, b);

        assertEquals(
                "testMethodLeastCommonMultiplier() - Unexpected lcm outcome",
                expectedOutcome, lcm);
    }

    @Test
    public void testMethodLeastCommonMultiplierWithEqualNumbs() {
        int expectedOutcome = 10000;
        int a = 10000;
        int b = 10000;
        int lcm = fraction.getLcm(a, b);

        assertEquals(
                "testMethodLeastCommonMultiplier() - Unexpected lcm outcome",
                expectedOutcome, lcm);
    }

    @SuppressWarnings("unused")
    @Test
    public void testMethodLeastCommonMultiplierWithBigNumbs() {
        int expectedOutcome = 10000;
        int a = 214748364;
        int b = 214748364;
        int lcm = fraction.getLcm(a, b);
    }

    @Test
    public void testMethodAdd() {
        Fraction expectedOutcome = new Fraction(8, 15);

        assertEquals(expectedOutcome,
                new Fraction(1, 3).add(new Fraction(1, 5)));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodAddNumeratorOverflow() {
        int a = Integer.MAX_VALUE + 1;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;

        Fraction frac = new Fraction(a, b).add(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodAddDenominatorOverflow() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE + 1;
        int c = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;

        Fraction frac = new Fraction(a, b).add(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodAddNumeratorUnderflow() {
        int a = Integer.MIN_VALUE - 1;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;

        Fraction frac = new Fraction(a, b).add(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodAdddenominatorUnderflow() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE - 1;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;

        Fraction frac = new Fraction(a, b).add(new Fraction(c, d));
    }

    @Test
    public void testMethodSubtractThisFractionGreater() {
        Fraction expectedOutcome = new Fraction(1, 4);

        assertEquals(expectedOutcome,
                new Fraction(1, 2).subtract(new Fraction(1, 4)));
    }

    @Test
    public void testMethodSubtractThisFractionSmaller() {
        Fraction expectedOutcome = new Fraction(1, -4);

        assertEquals(expectedOutcome,
                new Fraction(1, 4).subtract(new Fraction(1, 2)));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodSubtractNumeratorOverflow() {
        int a = Integer.MAX_VALUE + 1; // 10
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE + 2;
        int d = Integer.MAX_VALUE;

        Fraction frac = new Fraction(a, b).subtract(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodSubtractNumeratorUnderflow() {
        int a = Integer.MIN_VALUE + 1;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;

        Fraction frac = new Fraction(a, b).subtract(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodSubtractDenominatorOverflow() {
        int a = Integer.MAX_VALUE; // 10
        int b = Integer.MAX_VALUE + 2;
        int c = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE + 1;

        Fraction frac = new Fraction(a, b).subtract(new Fraction(c, d));
    }

    @SuppressWarnings("unused")
    @Test(expected = ArithmeticException.class)
    public void testMethodSubtractDenominatorUnderflow() {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE + 1;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;

        Fraction frac = new Fraction(a, b).subtract(new Fraction(c, d));
    }

    @Test
    public void testMethodAbsValueNumDenumNegative() {
        Fraction inputFrac = new Fraction(-7, -3);
        Fraction expectedOutcome = new Fraction(7, 3);

        assertEquals(expectedOutcome, fraction.absValue(inputFrac));
    }

    @Test
    public void testMethodAbsValueNumDenumPositive() {
        Fraction inputFrac = new Fraction(7, 3);
        Fraction expectedOutcome = new Fraction(7, 3);

        assertEquals(expectedOutcome, fraction.absValue(inputFrac));
    }

    @Test
    public void testMethodAbsValueNumNegative() {
        Fraction inputFrac = new Fraction(-7, 3);
        Fraction expectedOutcome = new Fraction(7, 3);

        assertEquals(expectedOutcome, fraction.absValue(inputFrac));
    }

    @Test
    public void testMethodAbsValueDenumNegative() {
        Fraction inputFrac = new Fraction(7, -3);
        Fraction expectedOutcome = new Fraction(7, 3);

        assertEquals(expectedOutcome, fraction.absValue(inputFrac));
    }

    @Test
    public void testMethodNegateWithPositiveInput() {
        Fraction inputFrac = new Fraction(7, 3);
        Fraction expectedOutcome = new Fraction(-7, 3);

        assertEquals(expectedOutcome, fraction.negate(inputFrac));
    }

    @Test
    public void testMethodNegateWithPosotiveInputNegativeNumAndDenom() {
        Fraction inputFrac = new Fraction(-7, -3);
        Fraction expectedOutcome = new Fraction(-7, 3);

        assertEquals(expectedOutcome, fraction.negate(inputFrac));
    }

    @Test
    public void testMethodNegateWithNegativeInput() {
        Fraction inputFrac = new Fraction(7, -3);
        Fraction expectedOutcome = new Fraction(7, 3);

        assertEquals(expectedOutcome, fraction.negate(inputFrac));
    }

    @Test
    public void testMethodNegateWithNegativeInput2() {
        Fraction inputFrac = new Fraction(-7, 3);
        Fraction expectedOutcome = new Fraction(7, 3);

        assertEquals(expectedOutcome, fraction.negate(inputFrac));
    }

}
