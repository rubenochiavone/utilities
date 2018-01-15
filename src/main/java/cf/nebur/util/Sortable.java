package cf.nebur.util;

/**
 * @param <T>
 * @author Ruben O. Chiavone
 */
public interface Sortable<T extends Number & Comparable> {

    T[] sort(T[] array);
}
