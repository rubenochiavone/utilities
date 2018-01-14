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
}
