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
public class FractionTest {

    @Test
    public void testCreationOfFraction() {
        
        int numberator = 1;
        int denomiator = 0;
        
        Fraction fraction = new Fraction(numberator, denomiator);      
    }


    @Test
    public void testMethodDivide() {
        
        int numberator = 1;
        int denomiator = 2;

        Fraction fraction = new Fraction(numberator, denomiator);  
        
        int divisionResult = fraction.divide(fraction);
    }


    @Test
    public void testMethodMultiply() {
        equals(new Fraction(1, 2));
        multiply(new Fraction(3, 5);
    }


    private void multiply(Fraction fraction) {
        // TODO Auto-generated method stub
        
    }
}
