package cf.nebur.util;

/**
 * Hash table data structure is used to store an unordered collection
 * of (key, value) pairs, where the key has to be unique.
 *
 * <p>
 *     Item lookup by key, inserting a new item, or deleting
 *     an item are all fast operations (approximately O(1)).
 * </p>
 *
 * <p>
 *     <h2>Strengths</h2>
 *     <ul>
 *         <li>Hash tables have extremely fast lookup by key (O(1)).</li>
 *         <li>Insertion and deletion of data is also quick (O(1)).</li>
 *         <li>In a hash table, you can use the keys as the data, and use
 *         that to check if we've seen an element before. A hash table used
 *         this way is usually called a set.</li>
 *     </ul>
 *
 *     <h2>Weaknesses</h2>
 *     <ul>
 *         <li>Hash tables have no notion of order.</li>
 *         <li>Hash tables cannot match "nearby" keys, or keys that share
 *         the same prefix. So a hash table wouldn't be a good choice
 *         for checking for words that began with a certain prefix
 *         (a trie would be a better choice in that case).</li>
 *         <li>Lookup by value (instead of by key) is O(n).</li>
 *         <li>A hash table loses its strengths when the amount of
 *         data in a single bucket becomes large. Lookup becomes O(B),
 *         where B is the number of things in the bucket.</li>
 *     </ul>
 * </p>
 *
 * @param <K>
 *     Hash table key type
 * @param <V>
 *     Hash table value type
 * @author Ruben O. Chiavone
 * @see https://codefights.com/interview-practice/topics/hash-tables/tutorial
 */
public class HashTable<K, V> {

    public class Entry {
        K key;
        V value;
    }

    private class Key {
        K key;
        int index;
    }

    private int hash(K key) {
        return key.hashCode();
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean containsValue(V value) {
        // TODO:
        return false;
    }

    public void put(K key, V value) {
        // TODO:
    }

    public boolean delete(K key) {
        // TODO:
        return false;
    }

    public V get(K key) {
        // TODO:
        return null;
    }

    /**
     * Amount of items on this hash table
     *
     * @return amount of items on this hash table
     */
    public int size() {
        // TODO:
        return -1;
    }
}
