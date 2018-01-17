package cf.nebur.util;

/**
 * @author Ruben O. Chiavone
 */
public class SortableFactory {

    private SortableFactory() {}

    /**
     * Creates a new sortable instance
     *
     * @param clazz
     * @param algorithm
     * @param <T>
     * @return a new sortable instance or {code null}
     * if no suitable implementation is found
     */
    public static <T extends Number & Comparable> Sortable<T> create(
            Class<T> clazz,
            SortingAlgorithm algorithm) {
        return create(clazz, algorithm, SortingAlgorithm.Order.ASC);
    }

    /**
     * Creates a new sortable instance
     *
     * @param clazz
     * @param algorithm
     * @param order
     * @param <T>
     * @return a new sortable instance or {code null}
     * if no suitable implementation is found
     */
    public static <T extends Number & Comparable> Sortable<T> create(
            Class<T> clazz,
            SortingAlgorithm algorithm,
            SortingAlgorithm.Order order) {
        Sortable<T> sortable = null;
        switch (algorithm) {
            case MERGE_SORT:
                sortable = new MergeSort(clazz, order);
                break;
            case INSERTION_SORT:
                sortable = new InsertionSort(clazz, order);
                break;
            case BUBBLE_SORT:
                sortable = new BubbleSort(clazz, order);
                break;
            case QUICK_SORT:
            case HEAP_SORT:
            case COUNTING_SORT:
            default:
                break;
        }

        return sortable;
    }
}
