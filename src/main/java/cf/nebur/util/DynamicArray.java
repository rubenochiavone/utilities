package cf.nebur.util;

import java.util.Iterator;

/**
 * A random-access, variable sized list data structure that allows
 * elements to be added or removed.
 *
 * <p>
 *     Like a regular array, but with reserved space for additional elements.
 * </p>
 *
 * <p>
 *     <h2>Strengths</h2>
 *     <ul>
 *         <li>On average, inserting elements to the end of the dynamic array is quick.</li>
 *         <li>Item lookup by index is O(1).</li>
 *     </ul>
 *
 *     <h2>Weaknesses</h2>
 *     <ul>
 *         <li>Dynamic arrays must be implemented in contiguous memory.</li>
 *         <li>Dynamic arrays have inconsistent run times for adding to the array,
 *         so they're not good for real-time systems.</li>
 *         <li>Dynamic arrays do not allow for the quick rearrangement of elements.</li>
 *     </ul>
 * </p>
 *
 * @param <T>
 * @author Ruben O. Chiavone
 * @see https://codefights.com/interview-practice/topics/arrays/tutorial
 */
public class DynamicArray<T> implements Iterable<T> {

    private static final int MINIMUM_EXTRA_SPACE = 5;

    private T[] data;
    private int physicalSize = -1;
    private int logicalSize;

    public DynamicArray() {
        this(0);
    }

    public DynamicArray(int size) {
        if (size < 0) {
            size = 0;
        }
        allocateAdditionalSpace(size);
        logicalSize = size;
    }

    /**
     * Allocate additional space for {@code data} if needed
     *
     * @param newSize
     */
    private void allocateAdditionalSpace(int newSize) {
        if (physicalSize == -1) {
            // during ctor
            if (newSize / 10 < MINIMUM_EXTRA_SPACE) {
                physicalSize = newSize + MINIMUM_EXTRA_SPACE;
            } else {
                physicalSize = newSize + newSize / 10;
            }
            data = (T[]) new Object[physicalSize];
        } else if (newSize == physicalSize) {
            if (newSize / 10 < MINIMUM_EXTRA_SPACE) {
                physicalSize = newSize + MINIMUM_EXTRA_SPACE;
            } else {
                physicalSize = newSize + newSize / 10;
            }
            T[] tmp = (T[]) new Object[physicalSize];
            System.arraycopy(data, 0, tmp, 0, logicalSize);
            data = null;
            data = tmp;
        }
    }

    /**
     * Adds item to the end of the array
     *
     * <ul>
     *     <li>Time complexity: O(1) (amortized)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param item
     */
    public void append(T item) {
        allocateAdditionalSpace(logicalSize + 1);
        data[logicalSize] = item;
        logicalSize++;
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
        if (index > logicalSize - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + logicalSize);
        }
        T[] tmp = (T[]) new Object[logicalSize - 1];
        for (int i = 0; i < logicalSize - 1; i++) {
            if (i != index) {
                tmp[i] = data[i];
            }
        }
        logicalSize--;
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
        if (index > logicalSize - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + logicalSize);
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
        if (index > logicalSize - 1) {
            throw new IndexOutOfBoundsException("index " + index + " but size is " + logicalSize);
        }
        data[index] = item;
    }

    public int size() {
        return logicalSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < logicalSize;
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
