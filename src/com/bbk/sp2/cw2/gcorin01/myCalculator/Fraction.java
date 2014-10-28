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
        try {
            @SuppressWarnings("unused")
            int divisionResult = num / denum;
        } catch (ArithmeticException e) {
            System.out.println("Invalid fraction with denominator 0");
        }
        
        int gcd = getGcd(num, denum);
        
        setNumerator(num / gcd);
        setDenominator(denum / gcd);
    }

    /**
     * @param numerator
     *            the numerator to set
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * @return the numerator
     */
    public int getNumerator() {
        
        return numerator;
    }

    /**
     * @param denominator
     *            the denominator to set
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * @return the denominator
     */
    public int getDenominator() {

        return denominator;
    }

    public int divide(Fraction fraction) {
        int divisionResult = this.numerator / this.denominator;

        return divisionResult;
    }

    /*
     * (non-Javadoc)
     * 
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
        int num = 0;
        int denom = 0;
        
        try {
            num = this.numerator * frac.numerator;
            denom = this.denominator * frac.denominator;
        } catch (ArithmeticException e) {
            System.out.println("The Multiplication result is  ether too big or too small to be displayed accuraterly.");
        }

        return new Fraction(num, denom);
    }

    public int getGcd(int num1, int num2) {        
        
        while (num2 != 0) {
            int tempGcd = num2;
            num2 = num1 % num2;
            num1 = tempGcd;
        }
        
        return num1;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }

    public int getLcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int lcm = (a * b) / getGcd(a, b);
          
        return Math.abs(lcm);
    }
    
}