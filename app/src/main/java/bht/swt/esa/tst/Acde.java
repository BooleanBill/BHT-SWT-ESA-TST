package bht.swt.esa.tst;

/**
 * A class that does everything.
 * 
 */
public class Acde {

    /** a constructor that runs the methods */
    public Acde() {
        helloWorld();
    }

    /**
     * hello world method
     * s
     * 
     * @param args
     */
    public static void helloWorld() {
        System.out.println("Hello World!");
    }

    /**
     * a method that returns an empty string
     */
    public String getEmptyString() {
        return "";
    }

    /**
     * Adds two integers and returns the result.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the sum of the two integers
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the difference of the two integers
     */
    public int sub(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The product of the two integers.
     */
    public int mul(int a, int b) {
        return a * b;
    }

    /**
     * Divides two floats and returns the result.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of the division
     */
    public float div(float a, float b) {
        return a / b;
    }

}
