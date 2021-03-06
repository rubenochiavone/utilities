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

    private static final int DEFAULT_INITIAL_CAPACITY = 14;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
    }

    private class Bucket<K, V> {
        int hash;
        Entry<K, V> entry;
    }

    private Bucket<K, V>[] buckets;
    private int size;
    private float loadFactor;

    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(float loadFactor) {
        this(DEFAULT_INITIAL_CAPACITY, loadFactor);
    }

    public HashTable(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0) {
            initialCapacity = DEFAULT_INITIAL_CAPACITY;
        }
        if (loadFactor <= 0) {
            loadFactor = DEFAULT_LOAD_FACTOR;
        }
        buckets = new Bucket[initialCapacity];
        size = 0;
        this.loadFactor = loadFactor;
    }

    /**
     * Calculates hash value for a specified {@code key}
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        return java.lang.Math.abs(key.hashCode());
    }

    /**
     * Calculates an index in {@code buckets} where the value
     * for hash's key is going to be stored
     *
     * @param hash
     * @return
     */
    private int index(int hash) {
        return hash % buckets.length;
    }

    /**
     * Calculates actual load factor
     *
     * @return actual load factor
     */
    private float measureLoadFactor() {
        return (float) size / buckets.length;
    }

    /**
     * Increases the capacity of and internally reorganizes this
     * hash table, in order to accommodate and access its entries more
     * efficiently.
     */
    private void rehash() {
        Bucket<K, V>[] oldBuckets = buckets;

        Long newCapacity = new Long((buckets.length << 1) + 1);
        Bucket<K, V>[] newBuckets;

        if (newCapacity > MAX_ARRAY_SIZE) {
            newBuckets = new Bucket[MAX_ARRAY_SIZE];
        } else {
            newBuckets = new Bucket[newCapacity.intValue()];
        }

        buckets = newBuckets;

        for (Bucket<K, V> oldBucket : oldBuckets) {
            if (oldBucket == null) {
                continue;
            }
            Entry<K, V> oldEntry = oldBucket.entry;

            while (oldEntry != null) {
                Entry<K, V> entry = new Entry<>();
                entry.key = oldEntry.key;
                entry.value = oldEntry.value;
                entry.next = null;

                int hash = hash(entry.key);
                int index = index(hash);

                if (buckets[index] == null) {
                    Bucket<K, V> bucket = new Bucket<>();
                    bucket.hash = hash;
                    bucket.entry = entry;
                    buckets[index] = bucket;
                } else {
                    Bucket<K, V> bucket = buckets[index];
                    Entry<K, V> previousEntry = bucket.entry;
                    if (previousEntry != null) {
                        while (previousEntry.next != null) {
                            previousEntry = previousEntry.next;
                        }
                        previousEntry.next = entry;
                    } else {
                        bucket.entry = entry;
                    }
                }

                oldEntry = oldEntry.next;
            }
        }
    }

    /**
     * Returns {@code true} if this hash table contains
     * the specified key.
     *
     * @param key
     * @return {@code true} if this hash table contains
     * the specified and {@code false} otherwise
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Returns {@code true} if this hash table has one or more
     * keys to the specified value.
     *
     * @param value
     * @return {@code true} if this hash table has one or more
     * keys to the specified value and {@code false} otherwise
     */
    public boolean containsValue(V value) {
        for (Bucket<K, V> bucket : buckets) {
            if (bucket == null) {
                continue;
            }

            Entry<K, V> entry = bucket.entry;

            while (entry != null) {
                if (entry.value.equals(value)) {
                    return true;
                }

                entry = entry.next;
            }
        }

        return false;
    }

    /**
     * Adds a new (key, value) pair to the hash table
     *
     * <ul>
     *     <li>Time complexity: O(1) *</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * <p>* This assumes that the none of the buckets has a
     * large number of items in it. More accurately O(B),
     * where B is the size of the bucket assigned to by
     * the hash function.</p>
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }

        if (size == Integer.MAX_VALUE) {
            throw new IllegalStateException("No more room");
        }

        Entry<K, V> entry = new Entry<>();
        entry.key = key;
        entry.value = value;
        entry.next = null;

        int hash = hash(key);
        int index = index(hash);

        if (buckets[index] == null) {
            Bucket<K, V> bucket = new Bucket<>();
            bucket.hash = hash;
            bucket.entry = entry;
            buckets[index] = bucket;
        } else {
            Bucket<K, V> bucket = buckets[index];
            Entry<K, V> previousEntry = bucket.entry;
            if (previousEntry != null) {
                while (previousEntry.next != null) {
                    previousEntry = previousEntry.next;
                }
                previousEntry.next = entry;
            } else {
                bucket.entry = entry;
            }
        }

        size++;
        float actualLoadFactor = measureLoadFactor();

        if (buckets.length != MAX_ARRAY_SIZE && actualLoadFactor > loadFactor) {
            // rehash whole table
            rehash();
        }
    }

    /**
     * Removes (key) from the hash table
     *
     * <ul>
     *     <li>Time complexity: O(1) *</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * <p>* This assumes that the none of the buckets has a
     * large number of items in it. More accurately O(B),
     * where B is the size of the bucket assigned to by
     * the hash function.</p>
     *
     * @param key
     */
    public boolean delete(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        if (size == 0) {
            return false;
        }

        int hash = hash(key);
        int index = index(hash);

        Bucket<K, V> bucket = buckets[index];

        if (bucket != null) {
            Entry<K, V> previous = null;
            Entry<K, V> entry = bucket.entry;
            while (entry != null && !entry.key.equals(key)) {
                previous = entry;
                entry = entry.next;
            }
            if (entry != null) {
                if (previous != null) {
                    previous.next = entry.next;
                } else {
                    bucket.entry = null;
                }
                size--;
            }
            return true;
        }

        return false;
    }

    /**
     * Lookup whether key is in hash table
     *
     * <ul>
     *     <li>Time complexity: O(1) *</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * <p>* This assumes that the none of the buckets has a
     * large number of items in it. More accurately O(B),
     * where B is the size of the bucket assigned to by
     * the hash function.</p>
     *
     * @param key
     * @return
     */
    public V get(K key) {
        int hash = hash(key);
        int index = index(hash);

        Bucket<K, V> bucket = buckets[index];

        if (bucket != null) {
            Entry<K, V> entry = bucket.entry;
            while (entry != null && !entry.key.equals(key)) {
                entry = entry.next;
            }
            if (entry != null) {
                return entry.value;
            }
        }

        return null;
    }

    /**
     * Amount of entries on this hash table
     *
     * @return amount of entries on this hash table
     */
    public int size() {
        return size;
    }
}
