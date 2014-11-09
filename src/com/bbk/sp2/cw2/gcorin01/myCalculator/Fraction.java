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
            throw e;
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
        this.numerator = Math.toIntExact(numerator);
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

    public Fraction divide(Fraction frac) {

        try {
            int tempNum = Math.multiplyExact(this.numerator, frac.denominator);
            int tempDenom = Math
                    .multiplyExact(this.denominator, frac.numerator);

            return new Fraction(tempNum, tempDenom);
        } catch (ArithmeticException e) {
            System.out
                    .println("The Division result is either too big or too small to be calculated accuraterly");
            throw e;
        }
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

        try {
            int num = Math.multiplyExact(this.numerator, frac.numerator);
            int denom = Math.multiplyExact(this.denominator, frac.denominator);

            return new Fraction(num, denom);
        } catch (ArithmeticException e) {
            System.out
                    .println("The Multiplication result is either too big or too small to be calculated accuraterly");
            throw e;
        }
    }

    public int getGcd(int num1, int num2) {

        while (num2 != 0) {
            int tempGcd = num2;
            num2 = num1 % num2;
            num1 = tempGcd;
        }

        return num1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String s;

        if (getDenominator() == 1) {
            s = getNumerator() + "";
        } else {
            s = getNumerator() + "/" + getDenominator();
        }

        return s;
    }

    public int getLcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int lcm = (a * b) / getGcd(a, b);

        return lcm;
    }

    public Fraction add(Fraction frac) {

        try {
            int lcm = getLcm(this.denominator, frac.denominator);
            int tempNum = Math.addExact(Math.multiplyExact(
                    (lcm / frac.denominator), frac.numerator), Math
                    .multiplyExact((lcm / this.denominator), this.numerator));

            return new Fraction(tempNum, lcm);
        } catch (ArithmeticException e) {
            System.out
                    .println("The Addition result is either too small or too big to be calculated correctly");
            throw e;
        }
    }

    public Fraction subtract(Fraction frac) {

        try {
            int lcm = getLcm(this.denominator, frac.denominator);
            int tempThisNum = Math.multiplyExact((lcm / this.denominator),
                    this.numerator);
            int tempFracNum = Math.multiplyExact((lcm / frac.denominator),
                    frac.numerator);
            int num = Math.subtractExact(tempThisNum, tempFracNum);

            return new Fraction(num, lcm);
        } catch (ArithmeticException e) {
            System.out
                    .println("The Subtraction result is either too small or too big to be calculated correctly");
            throw e;
        }
    }

    public Fraction absValue(Fraction frac) {
        int num = frac.numerator;
        int denum = frac.denominator;

        if (num < 0) {
            num = num * -1;
        }

        if (denum < 0) {
            denum = denum * -1;
        }

        return new Fraction(num, denum);
    }

    public Fraction negate(Fraction frac) {
        int num = frac.numerator;
        int denom = frac.denominator;

        if (num >= 0 && denom >= 1) { // e.g. 1/1
            num = frac.numerator * -1;
            denom = frac.denominator;
        } else if (num >= 0 && denom < 0) { // e.g. 1/-1
            num = frac.numerator;
            denom = frac.denominator * -1;
        } else if (num < 0 && denom >= 1) { // e.g. -1/1
            num = frac.numerator * -1;
            denom = frac.denominator;
        }

        return new Fraction(num, denom);
    }
}