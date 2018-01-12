package cf.nebur.util;

import java.lang.reflect.ParameterizedType;

public class Array<T> extends Collection<T> {

    private T[] data;
    private int size;

    public Array() {
        data = (T[]) new Object[0];
        size = 0;
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

    @Override
    public int size() {
        return size;
    }
}
