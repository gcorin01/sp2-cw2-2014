/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Gabriel
 *
 */
public class FractionCalculator {
    private String currentValue;
    private String userInput;

    public FractionCalculator(String currentValue, String userInput) {
        setCurrentValue(currentValue);
        setUserInput(userInput);
    }

    /**
     * @return the currentValue
     */
    public String getCurrentValue () {
        return currentValue;
    }

    /**
     * @param currentValue
     *            the currentValue to set
     */
    public void setCurrentValue (String currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * @return the userInput
     */
    public String getUserInput () {
        return userInput;
    }

    /**
     * @param userInput
     *            the userInput to set
     */
    public void setUserInput (String userInput) {
        this.userInput = userInput;
    }

    public String[] inputTokenizer (String userInput, String delimiter) {
        StringTokenizer userInputTokenized = new StringTokenizer(userInput,
                delimiter);

        int length = userInputTokenized.countTokens();
        int i = 0;

        String[] input = new String[length];

        while (userInputTokenized.hasMoreTokens()) {
            String token = userInputTokenized.nextToken();
            input[i] = token;
            i++;
            System.out.println(token);
        }

        return input;
    }

    public String evaluate (Fraction frac, String userInput) {
        // 3/4 + 1/4
        int operationCount = 0;
        int fractionCount = 0;
        String currentOperation = "";
        ArrayList<String> operators = new ArrayList<String>(Arrays.asList("+",
                "-", "*", "/", "a", "A", "abs", "n", "N", "neg", "c", "C",
                "clear", "q", "Q", "quit"));

        String tokenDelimeter = " ";
        String[] tokens = inputTokenizer(userInput, tokenDelimeter);
        Fraction fracInput = frac;

        for (int i = 0; i < tokens.length; i++) {
            String[] token;

            if (tokens[i].contains("/") && fractionCount == 0) {
                tokenDelimeter = "/";
                token = inputTokenizer(tokens[i], tokenDelimeter);

                try {
                    if (token.length == 2) {
                    }
                } catch (ArithmeticException e) {
                    System.out
                            .println("Invalid input; a fraction needs to have a numerator and a denominator separated by a \"/\" with no spaces in the middle.");
                    throw e;
                }

                fracInput = new Fraction(Integer.parseInt(token[0]),
                        Integer.parseInt(token[1]));
                currentValue = fracInput.toString();
                fractionCount = 1;

            } else if (tokens[i].matches("-?\\d+") && fractionCount == 0) {
                fracInput = new Fraction(Integer.parseInt(tokens[i]), 1);
                currentValue = fracInput.toString();
                fractionCount = 1;

            } else if (operators.contains(tokens[i]) && operationCount == 0) {
                currentOperation = tokens[i];

                switch (currentOperation) {

                case "+":
                    fracInput = fracInput.add(fracInput);
                    break;

                case "-":
                    fracInput = fracInput.subtract(fracInput);
                    break;

                case "/":
                    fracInput = fracInput.divide(fracInput);
                    break;

                case ("*"):
                    fracInput = fracInput.multiply(fracInput);
                    break;

                default:
                    System.out.println("Not a valid operator");

                }

                // TODO Review code so that only one operation at the time is
                // allowed and after the first fraction the operation needs to
                // be done recursion may be necessary
                fractionCount = 1;
                operationCount = 1;
            }
        }
        return currentValue;
    }

    /**
     * @param args
     */
    public static void main (String[] args) {
        // TODO Auto-generated method stub

    }
}