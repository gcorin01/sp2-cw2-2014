/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Gabriel
 *
 */
public class FractionCalculatorTest {

    @Test
    public void testFractionCalulator() {
        @SuppressWarnings("unused")
        FractionCalculator calculator = new FractionCalculator("0", null);
    }

    @Test
    public void testFractionCalulatorInitializationCurrentValue() {
        String currentValue = "0";

        @SuppressWarnings("unused")
        FractionCalculator calculator = new FractionCalculator(currentValue,
                null);
    }

    @Test
    public void testFractionCalulatorInitializationInputString() {
        String currentValue = "0";
        String userInput = "";

        @SuppressWarnings("unused")
        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
    }
    
//    @Test
//    public void testFractionCalulatorInitializationCurrentOperation() {
//        String currentValue = "0";
//        String currentOperation = "";
//        String userInput = "";
//
//        @SuppressWarnings("unused")
//        FractionCalculator calculator = new FractionCalculator(currentValue,
//                userInput);
//    }

    @Test
    public void testSringTokenizer() {
        String currentValue = "0";
        String userInput = "";
        String delimiter = " ";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        calculator.inputTokenizer(userInput, delimiter);
    }

    @Test
    public void testInputTokenizerUserInput() {
        String currentValue = "0";
        String userInput = "3/4 + 1/-3";
        String delimiter = " ";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        @SuppressWarnings("unused")
        String[] userInputTokenized = calculator.inputTokenizer(userInput, delimiter);
    }

    @Test
    public void testMethodInputTokenizerThreeTokens() {
        String currentValue = "0";
        String userInput = "3/4 + 1/-3";
        String[] expectedResult = { "3/4", "+", "1/-3" };
        String delimiter = " ";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        String[] userInputTokenized = calculator.inputTokenizer(userInput, delimiter);

        assertArrayEquals(
                "testMethodInputTokenizerThreeTokens() - unexpected value",
                expectedResult, userInputTokenized);

    }

    @Test
    public void testMethodInputTokenizerFourTokens() {
        String currentValue = "0";
        String userInput = "3/4 + 1/-3 * 7 / 5";
        String[] expectedResult = { "3/4", "+", "1/-3", "*", "7", "/", "5" };
        String delimiter = " ";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        String[] userInputTokenized = calculator.inputTokenizer(userInput, delimiter);

        assertArrayEquals(
                "testMethodInputTokenizerThreeTokens() - unexpected value",
                expectedResult, userInputTokenized);

    }

    @Test
    public void testMethodInputTokenizerThreeTokensWithMultipleSpacesAsDelimeter() {
        String currentValue = "0";
        String userInput = "3/4 +       1/-3";
        String[] expectedResult = { "3/4", "+", "1/-3" };
        String delimiter = " ";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        String[] userInputTokenized = calculator.inputTokenizer(userInput, delimiter);

        assertArrayEquals(
                "testMethodInputTokenizerThreeTokens() - unexpected value",
                expectedResult, userInputTokenized);

    }

    @Test
    public void testMethodInputTokenizerThreeTokensWithEmptyString() {
        String currentValue = "0";
        String userInput = "";
        String[] expectedResult = { };
        String delimiter = " ";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        String[] userInputTokenized = calculator.inputTokenizer(userInput, delimiter);

        assertArrayEquals(
                "testMethodInputTokenizerThreeTokens() - unexpected value",
                expectedResult, userInputTokenized);

    }

    @Test
    public void testMethodInputTokenizerThreeTokensWithOnlySpaces() {
        String currentValue = "0";
        String userInput = "           ";
        String[] expectedResult = { };
        String delimiter = " ";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        String[] userInputTokenized = calculator.inputTokenizer(userInput, delimiter);

        assertArrayEquals(
                "testMethodInputTokenizerThreeTokens() - unexpected value",
                expectedResult, userInputTokenized);
    }
    
    @Test
    public void testMethodEvaluate() {
        String currentValue = "0";
        String userInput = "3/4";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        calculator.evaluate(frac, userInput);
    }
    
    @Test
    public void testMethodEvaluateAddition() {
        String currentValue = "0";
        String userInput = "3/4 + 1/4";
        String expectedResult = "1";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateAddition()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckTwoConsecutiveFractions() {
        String currentValue = "0";
        String userInput = "3/4 1/4";
        String expectedResult = "Two consecutive fraction are not accepted; separate each fraction with an operator";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckTwoConsecutiveFractions()", expectedResult, actualResult);
    }
        
    @Test
    public void testMethodEvaluateCheckTwoConsecutiveFractionsAfterValidOperation() {
        String currentValue = "0";
        String userInput = "3/4 + 1/4 1/4";
        String expectedResult = "Two consecutive fraction are not accepted; separate each fraction with an operator";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckTwoConsecutiveFractionsAfterValidOperation()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckTwoConsecutiveFractionsBeforeValidOperation() {
        String currentValue = "0";
        String userInput = "3/4 1/4 + 1/4";
        String expectedResult = "Two consecutive fraction are not accepted; separate each fraction with an operator";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckTwoConsecutiveFractionsBeforeValidOperation()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckThreeConsecutiveFractions() {
        String currentValue = "0";
        String userInput = "3/4 1/4  1/4";
        String expectedResult = "Two consecutive fraction are not accepted; separate each fraction with an operator";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckThreeConsecutiveFractions()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckFourConsecutiveFractions() {
        String currentValue = "0";
        String userInput = "3/4 1/4  1/4 3/4";
        String expectedResult = "Two consecutive fraction are not accepted; separate each fraction with an operator";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckFourConsecutiveFractions()", expectedResult, actualResult);
    }

    @Test
    public void testMethodEvaluateCheckAdditionIntegerInputInsteadOfFraction() {
        String currentValue = "0";
        String userInput = "1/2 + 3";
        String expectedResult = "7/2";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckAdditionIntegerInputInsteadOfFraction()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckConsecutiveOperatorsBeforeFraction() {
        String currentValue = "0";
        String userInput = "- + 3";
        String expectedResult = "Invalid input; check that each fraction is followed by an operator and vice versa";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckConsecutiveOperatorsBeforeFraction()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckConsecutiveOperatorsAfterFraction() {
        String currentValue = "0";
        String userInput = "3 + -";
        String expectedResult = "Invalid input; check that each fraction is followed by an operator and vice versa";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckConsecutiveOperatorsAfterFraction()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckOnlyOperators() {
        String currentValue = "0";
        String userInput = "a + -";
        String expectedResult = "Invalid input; check that each fraction is followed by an operator and vice versa";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckConsecutiveOperatorsAfterFraction()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateCheckMixedIntegerAndOperatorInOneToken() {
        String currentValue = "0";
        String userInput = "3+ + 1";
        String expectedResult = "Invalid input; check that each fraction is followed by an operator and vice versa";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateCheckMixedIntegerAndOperatorInOneToken()", expectedResult, actualResult);
    }
    
    @SuppressWarnings("unused")
    @Test(expected = NumberFormatException.class)
    public void testMethodEvaluateCheckMixedFractionAndOperatorInOneToken() {
        String currentValue = "0";
        String userInput = "3/4+ + 1";
        String expectedResult = "Invalid input; check that each fraction is followed by an operator and vice versa";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
    }
    
    @Test
    public void testMethodEvaluateMultiplication() {
        String currentValue = "0";
        String userInput = "1/4 * 1/4";
        String expectedResult = "1/16";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateMultiplication()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateDivision() {
        String currentValue = "0";
        String userInput = "1/2 / 1/4";
        String expectedResult = "2";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateDivision()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateSubtraction() {
        String currentValue = "0";
        String userInput = "1/2 - 1/4";
        String expectedResult = "1/4";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateAddition()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateAbsValue() {
        String currentValue = "0";
        String userInput = "-1/4 a";
        String expectedResult = "1/4";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateAbsValue()", expectedResult, actualResult);
    }
    
    @Test
    public void testMethodEvaluateNegate() {
        String currentValue = "0";
        String userInput = "1/4 n";
        String expectedResult = "1/-4";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateAbsValue()", expectedResult, actualResult);
    }
    
    //TODO Test strings with more than 2 fractions

}
