package cf.nebur.util;

/**
 * @author Ruben O. Chiavone
 */
public class SortableFactory {

    private SortableFactory() {}

    public static <T extends Number & Comparable> Sortable<T> create(
            Class<T> clazz,
            SortingAlgorithm algorithm) {
        Sortable<T> sortable = null;
        switch (algorithm) {
            case MERGE_SORT:
            case MERGE_SORT_ASC:
                sortable = new MergeSort(clazz);
                break;
            case MERGE_SORT_DESC:
                sortable = new MergeSort(clazz, MergeSort.Direction.DESC);
                break;
            case INSERTION_SORT:
            case BUBBLE_SORT:
            default:
                break;
        }

        return sortable;
    }
}
