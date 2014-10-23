/**
 * 
 */
package com.bbk.sp2.cw2.gcorin01.myCalculator;

/**
 * @author Gabriel
 * 
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denum) {
            this.numerator = num;
            this.denominator = denum;
    }


    public int divide(Fraction fraction) {
        int divisionResult = 0;
        try {
            divisionResult = this.numerator / this.denominator;
        } catch (ArithmeticException e) {
            System.out.println("Invalid fraction with denominator 0");
        }
        return divisionResult;
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + denominator;
        result = prime * result + numerator;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        Fraction other = (Fraction) obj;
        
        if (denominator != other.denominator) return false;
        if (numerator != other.numerator) return false;
        return true;
    }


    public Fraction multiply(Fraction frac) {
        int num = this.numerator * frac.numerator;
        int denom = this.denominator * frac.denominator;
        
        return new Fraction(num, denom);
    }
}
