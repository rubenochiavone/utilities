package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Ruben O. Chiavone
 */
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

        for (String key : words) {
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);
        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testBigStringIntegerPutWithInitialCapacity() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>(91);

        for (String key : words) {
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);
        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testBigStringIntegerPutWithLoadFactor() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>(1.0f);

        for (String key : words) {
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);
        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testBigStringIntegerPutWithInitialCapacityLoadFactor() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>(91,1.0f);

        for (String key : words) {
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);
        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testBiggerStringIntegerPut() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>();

        for (String key : words) {
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);
        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testBiggerStringIntegerPutWithInitialCapacity() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>(91);

        for (String key : words) {
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);
        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testBiggerStringIntegerPutWithLoadFactor() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>(1.0f);

        for (String key : words) {
            int value = 0;

            for (char c : key.toCharArray()) {
                value += c;
            }

            stringIntegerHashTable.put(key, value);
        }

        assertEquals(length, stringIntegerHashTable.size());
    }

    @Test
    public void testBiggerStringIntegerPutWithInitialCapacityLoadFactor() {
        String aVeryLongString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
        String[] words = aVeryLongString.split(" ");
        int length = words.length;

        HashTable<String, Integer> stringIntegerHashTable =
                new HashTable<>(91,1.0f);

        for (String key : words) {
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
