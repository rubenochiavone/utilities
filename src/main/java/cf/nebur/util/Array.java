package cf.nebur.util;

import java.util.Iterator;

/**
 * A random-access data structure that is of fixed size.
 *
 * <p>
 *     "Adding" or "deleting" an element from an array
 *     requires creating an appropriately sized contiguous
 *     chunk of memory, and copying the elements that you
 *     want to keep into the new array.
 * </p>
 *
 * <p>
 *     <h2>Strengths</h2>
 *     <ul>
 *         <li>The item lookup by index for arrays is very quick - O(1).</li>
 *         <li>Arrays are a simple data structure with a very low memory footprint.</li>
 *     </ul>
 *
 *     <h2>Weaknesses</h2>
 *     <ul>
 *         <li>Arrays have to be implemented in contiguous memory.</li>
 *         <li>Adding or deleting elements to the array is O(n), where
 *         n is the number of elements in the array.</li>
 *         <li>Arrays do not allow for the quick rearrangement of elements.</li>
 *         <li>Searching in the array for an entry with particular attributes is O(n).</li>
 *     </ul>
 * </p>
 *
 * @param <T>
 * @author Ruben O. Chiavone
 * @see https://codefights.com/interview-practice/topics/arrays/tutorial
 */
public class Array<T> implements Iterable<T> {

    private T[] data;

    public Array() {
        this(0);
    }

    public Array(int size) {
        if (size < 0) {
            size = 0;
        }
        data = (T[]) new Object[size];
    }

    /**
     * Adds item to the end of the array
     *
     * <ul>
     *     <li>Time complexity: O(n)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param item
     */
    public void append(T item) {
        T[] tmp = (T[]) new Object[data.length + 1];
        System.arraycopy(data, 0, tmp, 0, data.length);
        data = null;
        data = tmp;
        data[data.length - 1] = item;
    }

    /**
     * Removes item from array
     *
     * <ul>
     *     <li>Time complexity: O(n)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param index
     */
    public void delete(int index) {
        if (index > data.length - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + data.length);
        }
        T[] tmp = (T[]) new Object[data.length - 1];
        for (int i = 0; i < data.length - 1; i++) {
            if (i != index) {
                tmp[i] = data[i];
            }
        }
        data = null;
        data = tmp;
    }

    /**
     * Retrieves element at index
     *
     * <ul>
     *     <li>Time complexity: O(1)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index > data.length - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + data.length);
        }
        return data[index];
    }

    /**
     * Set an element at index
     *
     * <ul>
     *     <li>Time complexity: O(1)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @param item
     */
    public void set(T item, int index) {
        if (index > data.length - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + data.length);
        }
        data[index] = item;
    }

    public int size() {
        return data.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.length;
            }

            @Override
            public T next() {
                try {
                    return data[index];
                } finally {
                    index++;
                }
            }
        };
    }
}
