package cf.nebur.util;

/**
 * Insertion sort algorithm implementation.
 *
 * @param <T>
 * @author Ruben O. Chiavone
 * @see https://brilliant.org/wiki/insertion/
 */
class InsertionSort<T extends Number & Comparable> implements Sortable<T> {

    private interface OrderBasedComparable<T> {
        /**
         * Returns {@code true} if the comparison succeed
         * based on its order and {@code false} otherwise
         *
         * @param left
         * @param right
         * @return {@code true} if the comparison succeed
         * based on its order and {@code false} otherwise
         */
        boolean compare(T left, T right);
    }

    private Class<T> clazz;
    private OrderBasedComparable<T> orderBasedComparable;

    InsertionSort(Class<T> clazz) {
        this(clazz, SortingAlgorithm.Order.ASC);
    }

    InsertionSort(Class<T> clazz, SortingAlgorithm.Order order) {
        this.clazz = clazz;
        switch (order) {
            case ASC:
                orderBasedComparable = new OrderBasedComparable<T>() {
                    @Override
                    public boolean compare(T left, T right) {
                        return left.compareTo(right) > 0;
                    }
                };
                break;
            case DESC:
                orderBasedComparable = new OrderBasedComparable<T>() {
                    @Override
                    public boolean compare(T left, T right) {
                        return left.compareTo(right) < 0;
                    }
                };
                break;
        }
    }

    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        } else if (array.length == 1) {
            return array;
        }

        int n = array.length;
        T[] result = (T[]) java.lang.reflect.Array.newInstance(clazz, n);

        // copy data
        System.arraycopy(array, 0, result, 0, n);

        T value;
        int i, j;
        for (i = 1; i < n; i++) {
            value = result[i];
            j = i - 1;
            while (j > -1 && orderBasedComparable.compare(result[j], value)) {
                result[j + 1] = result[j];
                j--;
            }
            result[j + 1] = value;
        }

        return result;
    }
}
