package cf.nebur.util;

/**
 * Merge sort algorithm implementation.
 *
 * @param <T>
 * @author Ruben O. Chiavone
 */
class MergeSort<T extends Number & Comparable> implements Sortable<T> {

    enum Direction {
        ASC, DESC
    }

    private interface DirectionComparable<T> {
        /**
         * Returns {@code true} if the comparison succeed
         * based on its direction and {@code false} otherwise
         *
         * @param left
         * @param right
         * @return {@code true} if the comparison succeed
         * based on its direction and {@code false} otherwise
         */
        boolean compare(T left, T right);
    }

    private Class<T> clazz;
    private DirectionComparable<T> directionComparable;

    MergeSort(Class<T> clazz) {
        this(clazz, Direction.ASC);
    }

    MergeSort(Class<T> clazz, Direction direction) {
        this.clazz = clazz;
        switch (direction) {
            case ASC:
                directionComparable = new DirectionComparable<T>() {
                    @Override
                    public boolean compare(T left, T right) {
                        return left.compareTo(right) <= 0;
                    }
                };
                break;
            case DESC:
                directionComparable = new DirectionComparable<T>() {
                    @Override
                    public boolean compare(T left, T right) {
                        return left.compareTo(right) > 0;
                    }
                };
                break;
        }
    }

    private T[] merge(T[] left, T[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        T[] res = (T[]) java.lang.reflect.Array.newInstance(clazz, leftLength + rightLength);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (directionComparable.compare(left[i], right[j])) {
                res[k] = left[i];
                i++;
                k++;
            } else {
                res[k] = right[j];
                k++;
                j++;
            }
        }

        for (int ii = i; ii < leftLength; ii++) {
            res[k] = left[ii];
            k++;
        }

        for (int jj = j; jj < rightLength; jj++) {
            res[k] = right[jj];
            k++;
        }

        return res;
    }


    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        } else if (array.length == 1) {
            // base case
            return array;
        }

        int n = array.length;

        // divide
        int nFirstHalf, nSecondHalf;

        if (n % 2 == 0) {
            nFirstHalf = n / 2;
        } else {
            nFirstHalf = n / 2 + 1;
        }
        nSecondHalf = n / 2;

        T[] firstHalf = (T[]) java.lang.reflect.Array.newInstance(clazz, nFirstHalf);
        T[] secondHalf = (T[]) java.lang.reflect.Array.newInstance(clazz, nSecondHalf);

        // copy data
        System.arraycopy(array, 0, firstHalf, 0, nFirstHalf);
        System.arraycopy(array, nFirstHalf, secondHalf, 0, nSecondHalf);

        // conquer
        firstHalf = sort(firstHalf);
        secondHalf = sort(secondHalf);

        // merge
        return merge(firstHalf, secondHalf);
    }
}
