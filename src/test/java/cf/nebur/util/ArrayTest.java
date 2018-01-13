package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

public class ArrayTest extends TestCase {

    @Test
    public void testIntegerArraySize() {
        Array<Integer> integerArray = new Array<>();

        assertEquals(0, integerArray.size());

        integerArray = new Array<>(10);

        assertEquals(10, integerArray.size());

        integerArray = new Array<>(100);

        assertEquals(100, integerArray.size());

        integerArray = new Array<>(-1);

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
        Array<Integer> integerArray = new Array<>(10);

        for (int i = 0; i < integerArray.size(); i++) {
            assertNull(integerArray.get(0));
        }

        for (int i = 0; i < integerArray.size(); i++) {
            integerArray.set(i, i);
        }

        for (int i = 0; i < integerArray.size(); i++) {
            assertEquals(i, integerArray.get(i).intValue());
        }

        integerArray = new Array<>();

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

    @Test
    public void testStringArraySet() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        Array<String> stringArray = new Array<>(length);

        assertEquals(length, stringArray.size());

        for (int i = 0; i < length; i++) {
            try {
                stringArray.set(words[i], i);
            } catch (IndexOutOfBoundsException e) {
                fail(e.getMessage());
            }
        }

        for (int i = 0; i < length; i++) {
            try {
                assertEquals(words[i], stringArray.get(i));
            } catch (IndexOutOfBoundsException e) {
                fail(e.getMessage());
            }
        }
    }

    @Test
    public void testStringArraySetOutOfBounds() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        Array<String> stringArray = new Array<>(length);

        assertEquals(length, stringArray.size());

        for (int i = 0; i < length; i++) {
            try {
                stringArray.set(words[i], i);
            } catch (IndexOutOfBoundsException e) {
                fail(e.getMessage());
            }
        }

        try {
            stringArray.set(words[0], length);
            fail("Should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
        }
    }

    @Test
    public void testStringArrayIterator() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        Array<String> stringArray = new Array<>(length);

        assertEquals(length, stringArray.size());

        int i;

        for (i = 0; i < length; i++) {
            stringArray.set(words[i], i);
        }

        i = 0;
        for (String word : stringArray) {
            assertEquals(words[i], word);
            i++;
        }
    }
}
