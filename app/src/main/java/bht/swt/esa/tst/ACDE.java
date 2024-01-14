package bht.swt.esa.tst;

import java.util.Map;

/**
 * A class that does everything.
 * 
 */
public class ACDE {

    private static final Map<Character, Integer> ROMAN = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

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
    public float div(float a, float b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return a / b;
    }

    /**
     * 
     * calculates a score from 0 to 100 for a given name, only accepts names with
     * length > 0 and not
     * containing numbers or special characters other than spaces and dashes. (Sorry
     * Elon Musk)
     * 
     * @param name the name to be scored
     */
    public int scoreName(String name) throws WeirdNameException, NoNameException {
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
    public class WeirdNameException extends RuntimeException {
        public WeirdNameException(String errorMessage) {
            super(errorMessage);
        }
    }

    /**
     * A custom exception for empty names.
     */
    public class NoNameException extends RuntimeException {
        public NoNameException(String errorMessage) {
            super(errorMessage);
        }
    }

    /**
     * A custom exception for empty names.
     */
    public static Integer romanNumeralsToNumbers(String string) throws IllegalArgumentException {
        for (char c : string.toCharArray()) {
            if (!ROMAN.containsKey(c)) {
                throw new IllegalArgumentException("Invalid Roman numeral: " + c);
            }
        }

        // check for illegal numeral combinations
        if (string.contains("VV") || string.contains("LL") || string.contains("DD") || string.contains("IIII")
                || string.contains("XXXX") || string.contains("CCCC") || string.contains("MMMM")
                || string.contains("IVI")) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + string);
        }

        int result = 0;

        for (int i = 0; i < string.length(); i++) {
            int current = ROMAN.get(string.charAt(i));
            int next = i + 1 < string.length() ? ROMAN.get(string.charAt(i + 1)) : 0;
            if (current >= next) {
                result += current;
            } else {
                result -= current;
            }
        }

        return result;

    }
}
