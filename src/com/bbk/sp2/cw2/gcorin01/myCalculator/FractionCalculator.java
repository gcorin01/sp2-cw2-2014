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
    public String getCurrentValue() {
        return currentValue;
    }

    /**
     * @param currentValue
     *            the currentValue to set
     */
    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * @return the userInput
     */
    public String getUserInput() {
        return userInput;
    }

    /**
     * @param userInput
     *            the userInput to set
     */
    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String[] inputTokenizer(String userInput, String delimiter) {
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

    public String evaluate(Fraction frac, String userInput) {
        // 3/4 + 1/4
        String currentOperation = "";
        ArrayList<String> operators = new ArrayList<String>(Arrays.asList("+",
                "-", "*", "/", "a", "A", "abs", "n", "N", "neg", "c", "C",
                "clear", "q", "Q", "quit"));

        String[] input = inputTokenizer(userInput, " ");
        Fraction fracInput = new Fraction(0, 1);

        for (int i = 0; i < input.length; i++) {

            if (input[i].contains("/")) {
                String[] token = inputTokenizer(input[i], "/");

                for (int j = 0; j < token.length; j++) { // Check if there is >1
                                                         // "/" in the token

                    try {
                        if (token[j].contains("/")) {
                        }
                    } catch (ArithmeticException e) {
                        System.out.println("Invalid input");
                        throw e;
                    }
                }

                fracInput = new Fraction(Integer.parseInt(token[0]),
                        Integer.parseInt(token[1]));
                currentValue = fracInput.toString();

            } else if (input[i].matches("-?\\d+")) {
                fracInput = new Fraction(Integer.parseInt(input[i]), 1);
                currentValue = fracInput.toString();

            } else if (operators.contains(input[i])) {

                currentOperation = input[i];

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
                    
                default: System.out.println("Not a valid operator");
                }

            }

        }
        return currentValue;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}