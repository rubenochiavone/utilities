package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

public class SortingAlgorithmTest extends TestCase {

    @Test
    public void testIntegerMergeSort() {
        testIntegerGenericSort(SortingAlgorithm.MERGE_SORT);
    }

    @Test
    public void testIntegerInsertionSort() {
        testIntegerGenericSort(SortingAlgorithm.INSERTION_SORT);
    }

    @Test
    public void testIntegerBubbleSort() {
        testIntegerGenericSort(SortingAlgorithm.BUBBLE_SORT);
    }

    public void testIntegerGenericSort(SortingAlgorithm algorithm) {
        Sortable<Integer> integerSortable =
                SortableFactory.create(Integer.class, algorithm);

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
                SortableFactory.create(Integer.class,
                        algorithm,
                        SortingAlgorithm.Order.DESC);

        assertNotNull(integerSortable);

        sortedArray = integerSortable.sort(array);

        for (int i = 8; i > 0; i--) {
            assertEquals(i, sortedArray[8 - i].intValue());
        }

        integerSortable =
                SortableFactory.create(Integer.class, algorithm);

        assertNotNull(integerSortable);

        array = new Integer[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 1;
        array[3] = 4;
        array[4] = 5;

        sortedArray = integerSortable.sort(array);

        for (int i = 1; i <= 5; i++) {
            assertEquals(i, sortedArray[i - 1].intValue());
        }

        integerSortable =
                SortableFactory.create(Integer.class, algorithm);

        assertNotNull(integerSortable);

        array = new Integer[6];
        array[0] = 8;
        array[1] = 2;
        array[2] = 4;
        array[3] = 9;
        array[4] = 3;
        array[5] = 6;

        sortedArray = integerSortable.sort(array);

        assertEquals(2, sortedArray[0].intValue());
        assertEquals(3, sortedArray[1].intValue());
        assertEquals(4, sortedArray[2].intValue());
        assertEquals(6, sortedArray[3].intValue());
        assertEquals(8, sortedArray[4].intValue());
        assertEquals(9, sortedArray[5].intValue());

        integerSortable =
                SortableFactory.create(Integer.class,
                        algorithm,
                        SortingAlgorithm.Order.DESC);

        assertNotNull(integerSortable);

        array = new Integer[6];
        array[0] = 8;
        array[1] = 2;
        array[2] = 4;
        array[3] = 9;
        array[4] = 3;
        array[5] = 6;

        sortedArray = integerSortable.sort(array);

        assertEquals(9, sortedArray[0].intValue());
        assertEquals(8, sortedArray[1].intValue());
        assertEquals(6, sortedArray[2].intValue());
        assertEquals(4, sortedArray[3].intValue());
        assertEquals(3, sortedArray[4].intValue());
        assertEquals(2, sortedArray[5].intValue());

        // TODO: improve testing
    }
}
