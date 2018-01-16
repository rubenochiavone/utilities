package cf.nebur.util;

/**
 * Handful of useful mathematical methods
 *
 * @author Ruben O. Chiavone
 */
public class Math {

    private Math() {}

    /**
     * Factorial method
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Fibonacci series method
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // TODO: add permutation and combination methods
}
