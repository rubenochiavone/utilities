package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

public class SinglyLinkedListTest extends TestCase {

    @Test
    public void testIntegerCtor() {
        SinglyLinkedList<Integer> integerSinglyLinkedList =
                new SinglyLinkedList<>();

        assertEquals(0, integerSinglyLinkedList.size());
        assertEquals(-1, integerSinglyLinkedList.find(0));
    }

    @Test
    public void testIntegerAppend() {
        SinglyLinkedList<Integer> integerSinglyLinkedList =
                new SinglyLinkedList<>();

        integerSinglyLinkedList.append(10);
        integerSinglyLinkedList.append(20);
        integerSinglyLinkedList.append(30);

        assertEquals(3, integerSinglyLinkedList.size());
        assertEquals(0, integerSinglyLinkedList.find(10));
        assertEquals(1, integerSinglyLinkedList.find(20));
        assertEquals(2, integerSinglyLinkedList.find(30));
    }

    @Test
    public void testFloatDelete() {
        SinglyLinkedList<Float> floatSinglyLinkedList =
                new SinglyLinkedList<>();

        floatSinglyLinkedList.append(10.0f);
        floatSinglyLinkedList.append(20.0f);
        floatSinglyLinkedList.append(30.0f);

        floatSinglyLinkedList.delete(10.0f);

        assertEquals(2, floatSinglyLinkedList.size());
        assertEquals(0, floatSinglyLinkedList.find(20.0f));
        assertEquals(1, floatSinglyLinkedList.find(30.0f));

        floatSinglyLinkedList.delete(30.0f);

        assertEquals(1, floatSinglyLinkedList.size());
        assertEquals(0, floatSinglyLinkedList.find(20.0f));

        floatSinglyLinkedList.delete(20.0f);

        assertEquals(0, floatSinglyLinkedList.size());
    }
}
