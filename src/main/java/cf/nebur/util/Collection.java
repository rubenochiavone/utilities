package cf.nebur.util;

import java.util.Iterator;

/**
 * Abstract collection class
 *
 * @param <T>
 * @author Ruben O. Chiavone
 */
public abstract class Collection<T> implements Iterable<T> {

    /**
     * Adds {@code item} to this collection
     *
     * @param item
     */
    public void append(T item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the item referenced by {@code index} of this collection
     *
     * @param index
     */
    public void delete(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes {@code item} to this collection
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
