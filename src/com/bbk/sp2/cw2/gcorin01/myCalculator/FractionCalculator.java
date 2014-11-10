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
        int basicOperationCount = 0;
        int advancedOperationCount = 0;
        int fractionCount = 0;
        String currentOperation = "";

        ArrayList<String> basicOperators = new ArrayList<String>(Arrays.asList(
                "+", "-", "*", "/"));
        ArrayList<String> advancedOperators = new ArrayList<String>(
                Arrays.asList("a", "A", "abs", "n", "N", "neg", "c", "C",
                        "clear", "q", "Q", "quit"));
        ArrayList<String> clearOperators = new ArrayList<String>(Arrays.asList(
                "c", "C", "clear"));
        ArrayList<String> quitOperators = new ArrayList<String>(Arrays.asList(
                "q", "Q", "quit"));

        String tokenDelimeter = " ";
        String[] tokens = inputTokenizer(userInput, tokenDelimeter);
        Fraction currentValue = frac;
        Fraction tempFrac = frac;

        for (int i = 0; i < tokens.length; i++) {
            String[] token;

            if (tokens[i].contains("/")) {
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
                
                fractionCount += 1;
                tempFrac = new Fraction(Integer.parseInt(token[0]),
                        Integer.parseInt(token[1]));
                
                this.currentValue = tempFrac.toString();

            } else if (tokens[i].matches("-?\\d+")) {
                fractionCount += 1;
                tempFrac = new Fraction(Integer.parseInt(tokens[i]), 1);
                
                this.currentValue = tempFrac.toString();

            } else if (basicOperators.contains(tokens[i])
                    && basicOperationCount == 0 && advancedOperationCount == 0) {
                currentOperation = tokens[i];
                basicOperationCount = 1;

            } else if (advancedOperators.contains(tokens[i])
                    && basicOperationCount == 0 && advancedOperationCount == 0) {
                currentOperation = tokens[i];
                advancedOperationCount = 1;

            } else if (clearOperators.contains(tokens[i])) {
                currentOperation = "";
                basicOperationCount = 0;
                advancedOperationCount = 0;
                currentValue = new Fraction(0, 1);
                this.currentValue = "0";

                return this.currentValue;

            } else if (quitOperators.contains(tokens[i])) {
                currentOperation = "";
                basicOperationCount = 0;
                advancedOperationCount = 0;
                currentValue = new Fraction(0, 1);
                this.currentValue = "Thank you and good bye";

                return this.currentValue;

            } else {
                this.currentValue = "Invalid input";

                return this.currentValue;
            }

            if (basicOperationCount == 1 && fractionCount == 2) {

                switch (currentOperation) {

                case "+":
                    currentValue = currentValue.add(tempFrac);
                    break;

                case "-":
                    currentValue = currentValue.add(tempFrac);
                    break;

                case "/":
                    currentValue = currentValue.add(tempFrac);
                    break;

                case ("*"):
                    currentValue = currentValue.add(tempFrac);
                    break;

                default:
                    System.out.println("Not a valid operator");

                }
                basicOperationCount = 0;
                fractionCount = 0;
            }
            
            if (fractionCount == 1) {
                currentValue = tempFrac;
            }

            this.currentValue = currentValue.toString();
            // TODO Review code so that only one operation at the time is
            // allowed and after the first fraction the operation needs to
            // be done recursion may be necessary

        }

        return this.currentValue;
    }

    /**
     * @param args
     */
    public static void main (String[] args) {
        // TODO Auto-generated method stub

    }
}