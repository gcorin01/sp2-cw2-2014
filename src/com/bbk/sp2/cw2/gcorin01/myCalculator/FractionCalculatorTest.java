/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

import org.junit.Test;

/**
 * @author Gabriel
 *
 */
public class FractionCalculatorTest {
    
    @Test
    public void testFractionCalulator() {
        FractionCalculator calculator = new FractionCalculator(0, null);
    }
    
    @Test
    public void testFractionCalulatorInitializationCurrentValue() {
        int currentValue = 0;
        
        FractionCalculator calculator = new FractionCalculator(currentValue, null);
    }
    
    @Test
    public void testFractionCalulatorInitializationInputString() {
        int currentValue = 0;
        String userInput = "";
        
        FractionCalculator calculator = new FractionCalculator(currentValue, userInput);
    }
    
    // Input numbers 
    
    // Input operators
    
    // Input exception: two consecutive operators
    
    // Input exception: unrecognised operator
}
