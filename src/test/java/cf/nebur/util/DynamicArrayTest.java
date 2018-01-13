package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

/**
 * @author Ruben O. Chiavone
 */
public class DynamicArrayTest extends TestCase {

    @Test
    public void testIntegerDynamicArraySize() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();

        assertEquals(0, integerDynamicArray.size());

        integerDynamicArray = new DynamicArray<>(10);

        assertEquals(10, integerDynamicArray.size());

        integerDynamicArray = new DynamicArray<>(100);

        assertEquals(100, integerDynamicArray.size());

        integerDynamicArray = new DynamicArray<>(-1);

        assertEquals(0, integerDynamicArray.size());
    }

    @Test
    public void testIntegerDynamicArrayAppend() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();

        assertEquals(0, integerDynamicArray.size());

        integerDynamicArray.append(0);

        assertEquals(1, integerDynamicArray.size());

        integerDynamicArray.append(0);

        assertEquals(2, integerDynamicArray.size());
    }

    @Test
    public void testIntegerDynamicArrayAppendInLoop() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();

        int n = new Random().nextInt(100000);

        for (int i = 0; i < n; i++) {
            integerDynamicArray.append(i);
        }

        assertEquals(n, integerDynamicArray.size());
    }

    @Test
    public void testIntegerDynamicArrayDelete() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();

        assertEquals(0, integerDynamicArray.size());

        integerDynamicArray.append(0);
        integerDynamicArray.append(1);
        integerDynamicArray.append(2);

        assertEquals(3, integerDynamicArray.size());

        integerDynamicArray.delete(0);

        assertEquals(2, integerDynamicArray.size());

        integerDynamicArray.delete(0);

        assertEquals(1, integerDynamicArray.size());

        integerDynamicArray.delete(0);

        assertEquals(0, integerDynamicArray.size());
    }

    @Test
    public void testIntegerDynamicArrayDeleteInLoop() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();

        int n = new Random().nextInt(100000);

        for (int i = 0; i < n; i++) {
            integerDynamicArray.append(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            integerDynamicArray.delete(i);
        }

        assertEquals(0, integerDynamicArray.size());
    }

    @Test
    public void testIntegerDynamicArrayDeleteOutOfBounds() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();

        try {
            assertEquals(0, integerDynamicArray.size());
            integerDynamicArray.delete(0);
            fail("Should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
        }

        integerDynamicArray.append(0);
        integerDynamicArray.append(1);
        integerDynamicArray.append(2);

        assertEquals(3, integerDynamicArray.size());

        integerDynamicArray.delete(0);
        integerDynamicArray.delete(0);
        integerDynamicArray.delete(0);

        try {
            assertEquals(0, integerDynamicArray.size());
            integerDynamicArray.delete(0);
            fail("Should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
        }
    }

    @Test
    public void testIntegerDynamicArrayGet() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>(10);

        for (int i = 0; i < integerDynamicArray.size(); i++) {
            assertNull(integerDynamicArray.get(0));
        }

        for (int i = 0; i < integerDynamicArray.size(); i++) {
            integerDynamicArray.set(i, i);
        }

        for (int i = 0; i < integerDynamicArray.size(); i++) {
            assertEquals(i, integerDynamicArray.get(i).intValue());
        }

        integerDynamicArray = new DynamicArray<>();

        assertEquals(0, integerDynamicArray.size());

        integerDynamicArray.append(0);

        assertEquals(0, integerDynamicArray.get(0).intValue());

        integerDynamicArray.append(1);

        assertEquals(1, integerDynamicArray.get(1).intValue());
    }

    @Test
    public void testIntegerDynamicArrayGetInLoop() {
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();

        assertEquals(0, integerDynamicArray.size());

        int n = new Random().nextInt(100000);

        for (int i = 0; i < n; i++) {
            integerDynamicArray.append(i);
        }

        assertEquals(n, integerDynamicArray.size());

        for (int i = 0; i < n; i++) {
            assertEquals(i, integerDynamicArray.get(i).intValue());
        }
    }

    @Test
    public void testStringDynamicArraySet() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        DynamicArray<String> stringDynamicArray = new DynamicArray<>(length);

        assertEquals(length, stringDynamicArray.size());

        for (int i = 0; i < length; i++) {
            try {
                stringDynamicArray.set(words[i], i);
            } catch (IndexOutOfBoundsException e) {
                fail(e.getMessage());
            }
        }

        for (int i = 0; i < length; i++) {
            try {
                assertEquals(words[i], stringDynamicArray.get(i));
            } catch (IndexOutOfBoundsException e) {
                fail(e.getMessage());
            }
        }
    }

    @Test
    public void testStringDynamicArraySetOutOfBounds() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        DynamicArray<String> stringDynamicArray = new DynamicArray<>(length);

        assertEquals(length, stringDynamicArray.size());

        for (int i = 0; i < length; i++) {
            try {
                stringDynamicArray.set(words[i], i);
            } catch (IndexOutOfBoundsException e) {
                fail(e.getMessage());
            }
        }

        try {
            stringDynamicArray.set(words[0], length);
            fail("Should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
        }
    }
}
