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
public class Array<T> extends Collection<T> {

    private T[] data;
    private int size;

    public Array() {
        this(0);
    }

    public Array(int size) {
        if (size < 0) {
            size = 0;
        }
        data = (T[]) new Object[size];
        this.size = size;
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
    @Override
    public void append(T item) {
        T[] tmp = (T[]) new Object[size + 1];
        System.arraycopy(data, 0, tmp, 0, size);
        size++;
        data = null;
        data = tmp;
        data[size - 1] = item;
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
    @Override
    public void delete(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + size);
        }
        T[] tmp = (T[]) new Object[size - 1];
        for (int i = 0; i < size - 1; i++) {
            if (i != index) {
                tmp[i] = data[i];
            }
        }
        size--;
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
    @Override
    public T get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + size);
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
    @Override
    public void set(T item, int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + size);
        }
        data[index] = item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
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
