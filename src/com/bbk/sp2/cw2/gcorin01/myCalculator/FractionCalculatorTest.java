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
        FractionCalculator calculator = new FractionCalculator(0, null);
    }

    @Test
    public void testFractionCalulatorInitializationCurrentValue() {
        int currentValue = 0;

        @SuppressWarnings("unused")
        FractionCalculator calculator = new FractionCalculator(currentValue,
                null);
    }

    @Test
    public void testFractionCalulatorInitializationInputString() {
        int currentValue = 0;
        String userInput = "";

        @SuppressWarnings("unused")
        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);
    }

    @Test
    public void testSringTokenizer() {
        int currentValue = 0;
        String userInput = "";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        calculator.inputTokenizer(userInput);
    }

    @Test
    public void testInputTokenizerUserInput() {
        int currentValue = 0;
        String userInput = "3/4 + 1/-3";

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        @SuppressWarnings("unused")
        String[] userInputTokenized = calculator.inputTokenizer(userInput);
    }

    @Test
    public void testMethodinputTokenizerThreeTokens() {
        int currentValue = 0;
        String userInput = "3/4 + 1/-3";
        String[] expectedResult = {"3/4", "+", "1/-3"};

        FractionCalculator calculator = new FractionCalculator(currentValue,
                userInput);

        String[] userInputTokenized = calculator.inputTokenizer(userInput);

        assertArrayEquals("testMethodinputTokenizerThreeTokens() - unexpected value", expectedResult, userInputTokenized);

    }

    // Input exception: two consecutive operators

    // Input exception: unrecognised operator
}
