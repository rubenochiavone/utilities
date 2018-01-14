package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

public class SinglyLinkedListTest extends TestCase {

    @Test
    public void testIntegerSinglyLinkedListCtor() {
        SinglyLinkedList<Integer> integerSinglyLinkedList =
                new SinglyLinkedList<>();

        assertEquals(0, integerSinglyLinkedList.size());
        assertEquals(-1, integerSinglyLinkedList.find(0));
    }

    @Test
    public void testIntegerSinglyLinkedListAppend() {
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
    public void testFloatSinglyLinkedListDelete() {
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

    @Test
    public void testEmptySinglyLinkedListIterator() {
        SinglyLinkedList<Integer> integerSinglyLinkedList
                = new SinglyLinkedList<>();

        for (Integer i : integerSinglyLinkedList) {
            fail("Should never reach here");
        }
    }

    @Test
    public void testStringSinglyLinkedListIterator() {
        SinglyLinkedList<Integer> integerSinglyLinkedList
                = new SinglyLinkedList<>();

        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        SinglyLinkedList<String> stringSinglyLinkedList =
                new SinglyLinkedList<>();

        int i;

        for (i = 0; i < length; i++) {
            stringSinglyLinkedList.append(words[i]);
        }

        i = 0;
        for (String word : stringSinglyLinkedList) {
            assertEquals(words[i], word);
            i++;
        }
    }
}
