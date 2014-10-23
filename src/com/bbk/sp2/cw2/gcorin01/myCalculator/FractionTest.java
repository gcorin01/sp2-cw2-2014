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
        
        int numberator = 0;
        int denomiator = 1;

        Fraction fraction = new Fraction(numberator, denomiator);  
        
        int divisionResult = fraction.divide(fraction);
    }


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
    public void testMethodMultiply() {
        
        Fraction expectedOutcome = new Fraction(3, 10);
        
        Fraction fraction1 = new Fraction(1, 2);
        
        Fraction fraction2 = new Fraction(3, 5);
        
        Fraction multiplicationResult = new Fraction(0, 0);
        
        multiplicationResult = fraction1.multiply(fraction2);
        
        assert expectedOutcome.equals(multiplicationResult) : "testMethodMultiply() - Unexpected Fraction multiplication outcome";
    }
    
    
    @Test
    public void testMethodMultiply1() { 

        assert ((new Fraction(3, 10)).equals(new Fraction(1, 2).multiply(new Fraction(3, 5)))) : "testMethodMultiply1() - Fraction not equal after multiplication ";
    }
    
    
    
}

