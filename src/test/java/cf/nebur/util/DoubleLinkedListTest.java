package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

public class DoubleLinkedListTest extends TestCase {

    @Test
    public void testIntegerDoubleLinkedListCtor() {
        DoubleLinkedList<Integer> integerDoubleLinkedList =
                new DoubleLinkedList<>();

        assertEquals(0, integerDoubleLinkedList.size());
        assertEquals(-1, integerDoubleLinkedList.find(0));
    }

    @Test
    public void testIntegerDoubleLinkedListAppend() {
        DoubleLinkedList<Integer> integerDoubleLinkedList =
                new DoubleLinkedList<>();

        integerDoubleLinkedList.append(10);
        integerDoubleLinkedList.append(20);
        integerDoubleLinkedList.append(30);

        assertEquals(3, integerDoubleLinkedList.size());
        assertEquals(0, integerDoubleLinkedList.find(10));
        assertEquals(1, integerDoubleLinkedList.find(20));
        assertEquals(2, integerDoubleLinkedList.find(30));
    }

    @Test
    public void testFloatDoubleLinkedListDelete() {
        DoubleLinkedList<Float> floatDoubleLinkedList =
                new DoubleLinkedList<>();

        floatDoubleLinkedList.append(10.0f);
        floatDoubleLinkedList.append(20.0f);
        floatDoubleLinkedList.append(30.0f);

        floatDoubleLinkedList.delete(10.0f);

        assertEquals(2, floatDoubleLinkedList.size());
        assertEquals(0, floatDoubleLinkedList.find(20.0f));
        assertEquals(1, floatDoubleLinkedList.find(30.0f));

        floatDoubleLinkedList.delete(30.0f);

        assertEquals(1, floatDoubleLinkedList.size());
        assertEquals(0, floatDoubleLinkedList.find(20.0f));

        floatDoubleLinkedList.delete(20.0f);

        assertEquals(0, floatDoubleLinkedList.size());

        floatDoubleLinkedList.delete(20.0f);

        assertEquals(0, floatDoubleLinkedList.size());
    }

    @Test
    public void testEmptyDoubleLinkedListIterator() {
        DoubleLinkedList<Integer> integerDoubleLinkedList
                = new DoubleLinkedList<>();

        for (Integer i : integerDoubleLinkedList) {
            fail("Should never reach here");
        }
    }

    @Test
    public void testStringDoubleLinkedListIterator() {
        DoubleLinkedList<Integer> integerDoubleLinkedList
                = new DoubleLinkedList<>();

        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        DoubleLinkedList<String> stringDoubleLinkedList =
                new DoubleLinkedList<>();

        int i;

        for (i = 0; i < length; i++) {
            stringDoubleLinkedList.append(words[i]);
        }

        i = 0;
        for (String word : stringDoubleLinkedList) {
            assertEquals(words[i], word);
            i++;
        }
    }

    @Test
    public void testStringDoubleLinkedListReverseIterator() {
        DoubleLinkedList<Integer> integerDoubleLinkedList
                = new DoubleLinkedList<>();

        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        DoubleLinkedList<String> stringDoubleLinkedList =
                new DoubleLinkedList<>();

        int i;

        for (i = 0; i < length; i++) {
            stringDoubleLinkedList.append(words[i]);
        }

        i = length - 1;
        Iterator<String> iterator = stringDoubleLinkedList.reverseIterator();
        while (iterator.hasNext()) {
            assertEquals(words[i], iterator.next());
            i--;
        }
    }
}
