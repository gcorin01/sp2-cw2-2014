/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
        Fraction frac = new Fraction(0, 0);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        calculator.evaluate(frac, userInput);
    }
    
    @Test
    public void testMethodEvaluateAddition() {
        String currentValue = "0";
        String userInput = "3/4 + 1/4";
        String expectedResult = "1/1";
        Fraction frac = new Fraction(0, 1);

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
        
        String actualResult = calculator.evaluate(frac, userInput);
        
        assertEquals(
                "testMethodEvaluateAddition()", expectedResult, actualResult);
    }

    // TODO Input exceptions to be added: two consecutive operators, two
    // consecutive fractions/integers, unrecognised operator, entered only
    // operator, entered only number

//    @Test
//    public void testMethodCheckFractionTokenIsAFraction() {
//        String currentValue = "0";
//        String userInput = "3/4";
//        Boolean validInput = false;
//
//        FractionCalculator calculator = new FractionCalculator(currentValue,
//                userInput);
//
//        String[] userInputTokenized = calculator.inputTokenizer(userInput);
//
//        validInput = calculator.checkTokenValidity(userInputTokenized);
//
//        assertTrue("testMethodInputTokenizerThreeTokens() - unexpected value",
//                validInput);
//    }
    
    // @Test
    // public void testArrayOfValidOperatorInputs() {
    // int currentValue = "0";
    // String userInput = "+"; // - * /
    // Boolean validOperator = true;
    //
    // FractionCalculator calculator = new FractionCalculator(currentValue,
    // userInput);
    //
    // String[] userInputTokenized = calculator.inputTokenizer(userInput);
    //
    // assertArrayEquals("testMethodInputTokenizerThreeTokens() - unexpected value",
    // expectedResult, userInputTokenized);
    //
    // }

    // @Test
    // public void testArrayOfValidFractionInputs() {
    // int currentValue = "0";
    // String userInput = "";
    // String[] expectedResult = {"3/4", "+", "1/-3"};
    //
    // FractionCalculator calculator = new FractionCalculator(currentValue,
    // userInput);
    //
    // String[] userInputTokenized = calculator.inputTokenizer(userInput);
    //
    // assertArrayEquals("testMethodInputTokenizerThreeTokens() - unexpected value",
    // expectedResult, userInputTokenized);
    //
    // }

}
