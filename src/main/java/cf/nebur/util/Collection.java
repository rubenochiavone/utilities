package cf.nebur.util;

/**
 * Abstract collection class
 *
 * @param <T>
 * @author Ruben O. Chiavone
 */
public abstract class Collection<T> {

    /**
     * Adds {@code item} to this collection
     *
     * @param item
     */
    public void append(T item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds {@code item} to this collection on specified index
     *
     * @param item
     */
    public void append(T item, int index) {
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
     * Check if exists an item with the value of {@code item}
     *
     * @param item
     * @return {@code true} if exists and {@code false} otherwise
     */
    public boolean contains(T item) {
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
