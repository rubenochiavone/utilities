package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

public class HashTableTest extends TestCase {

    @Test
    public void testStringIntegerCtor() {
        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>();
        assertEquals(0, stringIntegerHashTable.size());
    }

    @Test
    public void testStringIntegerPut() {
        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>();
        stringIntegerHashTable.put("John Smith", 5211234);
        stringIntegerHashTable.put("Lisa Smith", 5218976);
        stringIntegerHashTable.put("Sam Doe", 5215030);
        stringIntegerHashTable.put("Sandra Dee", 5219655);
        stringIntegerHashTable.put("Ted Baker", 4184165);

        assertEquals(5, stringIntegerHashTable.size());
    }

    @Test
    public void testBigStringIntegerPut() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>();

        int i;

        for (i = 0; i < length; i++) {
            String key = words[i];
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);

        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testStringIntegerGet() {
        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>();
        stringIntegerHashTable.put("John Smith", 5211234);
        stringIntegerHashTable.put("Lisa Smith", 5218976);
        stringIntegerHashTable.put("Sam Doe", 5215030);
        stringIntegerHashTable.put("Sandra Dee", 5219655);
        stringIntegerHashTable.put("Ted Baker", 4184165);

        assertEquals(5, stringIntegerHashTable.size());

        assertEquals(4184165, stringIntegerHashTable.get("Ted Baker").intValue());
        assertEquals(5218976, stringIntegerHashTable.get("Lisa Smith").intValue());
        assertEquals(5215030, stringIntegerHashTable.get("Sam Doe").intValue());
        assertEquals(5211234, stringIntegerHashTable.get("John Smith").intValue());
        assertEquals(5219655, stringIntegerHashTable.get("Sandra Dee").intValue());

        assertNull(stringIntegerHashTable.get("Simon Doe"));
        assertNull(stringIntegerHashTable.get("Simon Baker"));
        assertNull(stringIntegerHashTable.get("Simon Smith"));
    }

    @Test
    public void testStringIntegerDelete() {
        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>();
        stringIntegerHashTable.put("John Smith", 5211234);
        stringIntegerHashTable.put("Lisa Smith", 5218976);
        stringIntegerHashTable.put("Sam Doe", 5215030);
        stringIntegerHashTable.put("Sandra Dee", 5219655);
        stringIntegerHashTable.put("Ted Baker", 4184165);

        assertEquals(5, stringIntegerHashTable.size());

        assertEquals(4184165, stringIntegerHashTable.get("Ted Baker").intValue());
        assertEquals(5218976, stringIntegerHashTable.get("Lisa Smith").intValue());
        assertEquals(5215030, stringIntegerHashTable.get("Sam Doe").intValue());
        assertEquals(5211234, stringIntegerHashTable.get("John Smith").intValue());
        assertEquals(5219655, stringIntegerHashTable.get("Sandra Dee").intValue());

        assertNull(stringIntegerHashTable.get("Simon Doe"));
        assertNull(stringIntegerHashTable.get("Simon Baker"));
        assertNull(stringIntegerHashTable.get("Simon Smith"));

        stringIntegerHashTable.delete("Ted Baker");

        assertEquals(4, stringIntegerHashTable.size());
        assertNull(stringIntegerHashTable.get("Ted Baker"));

        stringIntegerHashTable.delete("John Smith");

        assertEquals(3, stringIntegerHashTable.size());
        assertNull(stringIntegerHashTable.get("John Smith"));

        stringIntegerHashTable.delete("Simon Smith");

        assertEquals(3, stringIntegerHashTable.size());
    }

    @Test
    public void testStringStringContains() {
        HashTable<String, String> stringStringHashTable =
                new HashTable<>();
        stringStringHashTable.put("Google", "United States");
        stringStringHashTable.put("Nokia", "Finland");
        stringStringHashTable.put("Sony", "Japan");

        // contains key
        assertTrue(stringStringHashTable.containsKey("Google"));
        assertTrue(stringStringHashTable.containsKey("Nokia"));
        assertFalse(stringStringHashTable.containsKey("Apple"));

        // contains value
        assertTrue(stringStringHashTable.containsValue("Japan"));
        assertTrue(stringStringHashTable.containsValue("Finland"));
        assertFalse(stringStringHashTable.containsValue("Brazil"));
    }

    @Test
    public void testStringStringPutNull() {
        HashTable<String, String> stringStringHashTable =
                new HashTable<>();
        stringStringHashTable.put("Google", "United States");
        stringStringHashTable.put("Nokia", "Finland");
        stringStringHashTable.put("Sony", "Japan");

        try {
            stringStringHashTable.put("Apple", null);
            fail("Should never reach here");
        } catch (NullPointerException e) {
            assertNotNull(e);
        }

        try {
            stringStringHashTable.put(null, "Brazil");
            fail("Should never reach here");
        } catch (NullPointerException e) {
            assertNotNull(e);
        }

        try {
            stringStringHashTable.put(null, null);
            fail("Should never reach here");
        } catch (NullPointerException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testStringStringDeleteNull() {
        HashTable<String, String> stringStringHashTable =
                new HashTable<>();
        stringStringHashTable.put("Google", "United States");
        stringStringHashTable.put("Nokia", "Finland");
        stringStringHashTable.put("Sony", "Japan");

        try {
            stringStringHashTable.delete(null);
            fail("Should never reach here");
        } catch (NullPointerException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testStringStringDeleteEmpty() {
        HashTable<String, String> stringStringHashTable =
                new HashTable<>();

        assertFalse(stringStringHashTable.delete("Google"));
        assertFalse(stringStringHashTable.delete("Facebook"));
    }
}
