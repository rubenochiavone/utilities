package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

public class SortingAlgorithmTest extends TestCase {

    @Test
    public void testIntegerMergeSort() {
        Sortable<Integer> integerSortable =
                SortableFactory.create(Integer.class, SortingAlgorithm.MERGE_SORT);

        assertNotNull(integerSortable);

        Integer[] array = new Integer[8];
        array[0] = 5;
        array[1] = 3;
        array[2] = 1;
        array[3] = 6;
        array[4] = 7;
        array[5] = 2;
        array[6] = 8;
        array[7] = 4;

        Integer[] sortedArray = integerSortable.sort(array);

        for (int i = 1; i <= 8; i++) {
            assertEquals(i, sortedArray[i - 1].intValue());
        }

        integerSortable =
                SortableFactory.create(Integer.class, SortingAlgorithm.MERGE_SORT_DESC);

        assertNotNull(integerSortable);

        sortedArray = integerSortable.sort(array);

        for (int i = 8; i > 0; i--) {
            assertEquals(i, sortedArray[8 - i].intValue());
        }

        // TODO: improve testing
    }

    @Test
    public void testIntegerInsertionSort() {
        Sortable<Integer> integerSortable =
                SortableFactory.create(Integer.class, SortingAlgorithm.INSERTION_SORT);

        assertNotNull(integerSortable);

        Integer[] array = new Integer[8];
        array[0] = 5;
        array[1] = 3;
        array[2] = 1;
        array[3] = 6;
        array[4] = 7;
        array[5] = 2;
        array[6] = 8;
        array[7] = 4;

        Integer[] sortedArray = integerSortable.sort(array);

        for (int i = 1; i <= 8; i++) {
            assertEquals(i, sortedArray[i - 1].intValue());
        }
    }

    @Test
    public void testIntegerBubbleSort() {
        Sortable<Integer> integerSortable =
                SortableFactory.create(Integer.class, SortingAlgorithm.BUBBLE_SORT);

        assertNotNull(integerSortable);

        Integer[] array = new Integer[8];
        array[0] = 5;
        array[1] = 3;
        array[2] = 1;
        array[3] = 6;
        array[4] = 7;
        array[5] = 2;
        array[6] = 8;
        array[7] = 4;

        Integer[] sortedArray = integerSortable.sort(array);

        for (int i = 1; i <= 8; i++) {
            assertEquals(i, sortedArray[i - 1].intValue());
        }
    }
}
