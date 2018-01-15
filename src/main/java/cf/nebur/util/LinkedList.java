package cf.nebur.util;

/**
 * A linked list is a sequential-access data structure used for storing ordered elements.
 *
 * <p>
 *     They prioritize quick and easy data insertion and deletion over item lookup.
 *     All linked lists are collections of node data structures that are connected
 *     by pointers - that's where the "link" in "linked list" comes from.
 * </p>
 *
 * <p>
 *     <h2>Strengths</h2>
 *     <ul>
 *         <li>Linked lists store ordered lists of data in nodes.</li>
 *         <li>Linked lists allow for quick (O(1)) addition and removal
 *         of elements (advantage over an array).</li>
 *         <li>Linked lists can be resized dynamically.</li>
 *         <li>The size of a linked list is only limited by the amount
 *         of available memory.</li>
 *     </ul>
 *
 *     <h2>Weaknesses</h2>
 *     <ul>
 *         <li>Linked lists can require more space in memory than arrays do.</li>
 *         <li>Linked lists are sequential-access instead of random-access, meaning
 *         that accessing the ith element can be slow because you must iterate over
 *         {@code i} elements to get there.</li>
 *     </ul>
 * </p>
 *
 * @param <T>
 * @author Ruben O. Chiavone
 * @see https://codefights.com/interview-practice/topics/linked-lists/tutorial
 */
public abstract class LinkedList<T> implements Iterable<T> {

    /**
     * Adds {@code item} to the beginning of this collection
     *
     * <ul>
     *     <li>Time complexity: O(1)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param item
     */
    public void prepend(T item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds {@code item} to the end of this collection
     *
     * @param item
     */
    public void append(T item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes {@code item} from this collection
     *
     * @param item
     */
    public void delete(T item) {
        throw new UnsupportedOperationException();
    }


    /**
     * Get the item referenced by {@code index}
     *
     * @param index
     * @return item referenced by {@code index} or {@code null}
     */
    public T get(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Set {@code item} to this collection on specified {@code index}
     *
     * @param item
     * @param index
     */
    public void set(T item, int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Check if exists an item with the value of {@code item} on this collection
     *
     * @param item
     * @return {@code true} if exists and {@code false} otherwise
     */
    public final boolean contains(T item) {
        return indexOf(item) != -1;
    }

    /**
     * Return the index of the item with the value of {@code item} otherwise
     * return {@code -1}
     *
     * @param item
     * @return the index of the item with the value of {@code item} otherwise
     * return {@code -1}
     */
    public final int indexOf(T item) {
        return find(item);
    }

    /**
     * Return the index of the item with the value of {@code item} otherwise
     * return {@code -1}
     *
     * @param item
     * @return the index of the item with the value of {@code item} otherwise
     * return {@code -1}
     */
    public int find(T item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Amount of items on this collection
     *
     * @return amount of items on this collection
     */
    public int size() {
        throw new UnsupportedOperationException();
    }
}
