package cf.nebur.util;

import static cf.nebur.util.Math.*;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Ruben O. Chiavone
 */
public class MathTest extends TestCase {

    @Test
    public void testFactorial() {
        assertEquals(0, factorial(0));
        assertEquals(0, factorial(-1));
        assertEquals(0, factorial(-10));
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(3628800, factorial(10));
    }

    @Test
    public void testFibonacci() {
        assertEquals(0, fibonacci(0));
        assertEquals(0, fibonacci(-1));
        assertEquals(0, fibonacci(-10));
        assertEquals(1, fibonacci(1));
        assertEquals(1, fibonacci(2));
        assertEquals(2, fibonacci(3));
        assertEquals(3, fibonacci(4));
        assertEquals(89, fibonacci(11));
        assertEquals(6765, fibonacci(20));
    }
}
