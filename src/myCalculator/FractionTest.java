/**
 * 
 */
package myCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Gabriel
 *
 */
public class FractionTest {

    @Test
    public void test() {
        Fraction addObj = new Fraction();
        
        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
    }

}
