package cf.nebur.util;

/**
 * @param <T>
 * @author Ruben O. Chiavone
 */
public interface Sortable<T extends Number & Comparable> {

    /**
     * Sort {@code array}
     *
     * @param array
     *      {@code array} to be sorted
     * @return sorted {@code array}
     */
    T[] sort(T[] array);
}
