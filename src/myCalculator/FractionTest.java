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

        int expectedOutput = 9;

        Fraction addObj = new Fraction(1, 0);

        // test divide by zero - should print an error and exit
        int actualOutput = addObj.divide(0);

        fail("Not yet implemented");

    }
        // test multiply

}
