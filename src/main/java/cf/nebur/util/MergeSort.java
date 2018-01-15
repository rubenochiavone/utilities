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

    private Class<T> clazz;
    private Direction direction;

    MergeSort(Class<T> clazz) {
        this(clazz, Direction.ASC);
    }

    MergeSort(Class<T> clazz, Direction direction) {
        this.clazz = clazz;
        this.direction = direction;
    }

    private T[] merge(T[] left, T[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        T[] res = (T[]) java.lang.reflect.Array.newInstance(clazz, leftLength + rightLength);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (
                    (direction == Direction.ASC && left[i].compareTo(right[j]) <= 0) || // asc
                    (direction == Direction.DESC && left[i].compareTo(right[j]) > 0)    // desc
                    ) {
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
            return array;
        }

        int n = array.length;
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

        firstHalf = sort(firstHalf);
        secondHalf = sort(secondHalf);

        return merge(firstHalf, secondHalf);
    }
}
