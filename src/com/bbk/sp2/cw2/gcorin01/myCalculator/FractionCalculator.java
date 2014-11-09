/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

import java.util.StringTokenizer;

/**
 * @author Gabriel
 *
 */
public class FractionCalculator {

    public FractionCalculator(int currentValue, String userInput) {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String[] inputTokenizer(String userInput) {
        String delimiter = " ";
        StringTokenizer userInputTokenized = new StringTokenizer(userInput,
                delimiter);

        int length = userInputTokenized.countTokens();
        int i = 0;

        String[] input = new String[length];

        while (userInputTokenized.hasMoreTokens()) {
            String token = userInputTokenized.nextToken();
            input[i] = token;
            i++;
        }

        return input;
    }
}