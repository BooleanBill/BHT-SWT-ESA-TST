package bht.swt.esa.tst;

/**
 * A class that does everything.
 * 
 */
public class ACDE {

    /** a constructor that runs the methods */
    public ACDE() {
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
     * Divides two floats.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of the division
     */
    public float div(float a, float b) {
        return a / b;
    }

    /**
     * calculates a score from 0 to 100 for a given name, only accepts names with
     * length > 0 and not
     * containing numbers or special characters other than spaces and dashes. (Sorry Elon Musk)
     * 
     * @param name the name to be scored
     */
    public int scoreName(String name) throws Exception {
        if (name.length() == 0) {
            throw new NoNameException("There is no name!");
        }
        if (!name.matches("[a-zA-Z\\-\\s]+")) {
            throw new WeirdNameException("Name must not contain numbers or special characters! Get out of here, Elon!");
        }
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            score += name.charAt(i);
        }
        return score % 101;
    }

    /**
     * A custom exception for weird names.
     */
    public class WeirdNameException extends Exception {
        public WeirdNameException(String errorMessage) {
            super(errorMessage);
        }
    }

    /**
     * A custom exception for empty names.
     */
    public class NoNameException extends Exception {
        public NoNameException(String errorMessage) {
            super(errorMessage);
        }
    }
}
