package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

public class ArrayTest extends TestCase {

    @Test
    public void testIntegerArraySize() {
        Array<Integer> integerArray = new Array<>();

        assertEquals(0, integerArray.size());
    }

    @Test
    public void testIntegerArrayAppend() {
        Array<Integer> integerArray = new Array<>();

        assertEquals(0, integerArray.size());

        integerArray.append(0);

        assertEquals(1, integerArray.size());

        integerArray.append(0);

        assertEquals(2, integerArray.size());
    }

    @Test
    public void testIntegerArrayAppendInLoop() {
        Array<Integer> integerArray = new Array<>();

        int n = new Random().nextInt(100000);

        for (int i = 0; i < n; i++) {
            integerArray.append(i);
        }

        assertEquals(n, integerArray.size());
    }

    @Test
    public void testIntegerArrayDelete() {
        Array<Integer> integerArray = new Array<>();

        assertEquals(0, integerArray.size());

        integerArray.append(0);
        integerArray.append(1);
        integerArray.append(2);

        assertEquals(3, integerArray.size());

        integerArray.delete(0);

        assertEquals(2, integerArray.size());

        integerArray.delete(0);

        assertEquals(1, integerArray.size());

        integerArray.delete(0);

        assertEquals(0, integerArray.size());
    }

    @Test
    public void testIntegerArrayDeleteInLoop() {
        Array<Integer> integerArray = new Array<>();

        int n = new Random().nextInt(100000);

        for (int i = 0; i < n; i++) {
            integerArray.append(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            integerArray.delete(i);
        }

        assertEquals(0, integerArray.size());
    }

    @Test
    public void testIntegerArrayDeleteOutOfBounds() {
        Array<Integer> integerArray = new Array<>();

        try {
            assertEquals(0, integerArray.size());
            integerArray.delete(0);
            fail("Should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
        }

        integerArray.append(0);
        integerArray.append(1);
        integerArray.append(2);

        assertEquals(3, integerArray.size());

        integerArray.delete(0);
        integerArray.delete(0);
        integerArray.delete(0);

        try {
            assertEquals(0, integerArray.size());
            integerArray.delete(0);
            fail("Should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
        }
    }

    @Test
    public void testIntegerArrayGet() {
        Array<Integer> integerArray = new Array<>();

        assertEquals(0, integerArray.size());

        integerArray.append(0);

        assertEquals(0, integerArray.get(0).intValue());

        integerArray.append(1);

        assertEquals(1, integerArray.get(1).intValue());
    }

    @Test
    public void testIntegerArrayGetInLoop() {
        Array<Integer> integerArray = new Array<>();

        assertEquals(0, integerArray.size());

        int n = new Random().nextInt(100000);

        for (int i = 0; i < n; i++) {
            integerArray.append(i);
        }

        assertEquals(n, integerArray.size());

        for (int i = 0; i < n; i++) {
            assertEquals(i, integerArray.get(i).intValue());
        }
    }
}
