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
public abstract class LinkedList<T> extends Collection<T> {

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
}
