package cf.nebur.util;

/**
 * Sorting algorithms enumeration
 *
 * @author Ruben O. Chiavone
 * @see https://brilliant.org/wiki/sorting-algorithms/
 */
public enum SortingAlgorithm {

    /**
     * Mergesort is a comparison-based algorithm
     * that focuses on how to merge together two
     * pre-sorted arrays such that the resulting
     * array is also sorted.
     *
     * <p>
     *     <h2>Complexity</h2>
     *     <ul>
     *         <li>Best-case: O(nlogn)</li>
     *         <li>Worst-case: O(nlogn)</li>
     *         <li>Average-case: O(nlogn)</li>
     *         <li>Space: O(n)</li>
     *     </ul>
     * </p>
     */
    MERGE_SORT,
    /**
     * Insertion sort is a comparison-based algorithm
     * that builds a final sorted array one element at
     * a time. It iterates through an input array and
     * removes one element per iteration, finds the
     * place the element belongs in the array, and then
     * places it there.
     *
     * <p>
     *     <h2>Complexity</h2>
     *     <ul>
     *         <li>Best-case: O(n)</li>
     *         <li>Worst-case: O(n^2)</li>
     *         <li>Average-case: O(n^2)</li>
     *         <li>Space: O(1)</li>
     *     </ul>
     * </p>
     */
    INSERTION_SORT,
    /**
     * Bubble sort is a comparison​-based algorithm that
     * compares each pair of elements in an array and
     * swaps them if they are out of order until the
     * entire array is sorted. For each element in the
     * list, the algorithm compares every pair of elements.
     *
     * <p>
     *     <h2>Complexity</h2>
     *     <ul>
     *         <li>Best-case: O(n)</li>
     *         <li>Worst-case: O(n^2)</li>
     *         <li>Average-case: O(n^2)</li>
     *         <li>Space: O(1)</li>
     *     </ul>
     * </p>
     */
    BUBBLE_SORT,
    /**
     * Quicksort is a comparison-based algorithm that
     * uses divide-and-conquer to sort an array. The
     * algorithm picks a pivot element, {@code A[q]},
     * and then rearranges the array into two subarrays
     * {@code A[p...q-1]}, such that all elements are
     * less than {@code A[q]}, and {@code A[q+1...r]},
     * such that all elements are greater than or equal to
     * {@code A[q]}.
     *
     * <p>
     *     <h2>Complexity</h2>
     *     <ul>
     *         <li>Best-case: O(nlogn)</li>
     *         <li>Worst-case: O(n^2)</li>
     *         <li>Average-case: O(nlogn)</li>
     *         <li>Space: O(logn) best, O(n) avg</li>
     *     </ul>
     * </p>
     */
    QUICK_SORT,
    /**
     * Heapsort is a comparison-based algorithm that
     * uses a binary heap data structure to sort elements.
     * It divides its input into a sorted and an unsorted
     * region, and it iteratively shrinks the unsorted
     * region by extracting the largest element and
     * moving that to the sorted region.
     *
     * <p>
     *     <h2>Complexity</h2>
     *     <ul>
     *         <li>Best-case: O(nlogn)</li>
     *         <li>Worst-case: O(nlogn)</li>
     *         <li>Average-case: O(nlogn)</li>
     *         <li>Space: O(1)</li>
     *     </ul>
     * </p>
     */
    HEAP_SORT,
    /**
     * Counting sort is an integer sorting algorithm that
     * assumes that each of the {@code n} input elements
     * in a list has a key value ranging from {@code 0}
     * to {@code k}, for some integer {@code k}. For each
     * element in the list, counting sort determines the
     * number of elements that are less than it. Counting
     * sort can use this information to place the element
     * directly into the correct slot of the output array.
     *
     * <p>
     *     <h2>Complexity</h2>
     *     <ul>
     *         <li>Best-case: O(k+n)</li>
     *         <li>Worst-case: O(k+n)</li>
     *         <li>Average-case: O(k+n)</li>
     *         <li>Space: O(k+n)</li>
     *     </ul>
     * </p>
     */
    COUNTING_SORT;

    /**
     * Sorting algorithm order
     */
    enum Order {

        /**
         * Ascending order
         */
        ASC,
        /**
         * Descending order
         */
        DESC
    }
}
