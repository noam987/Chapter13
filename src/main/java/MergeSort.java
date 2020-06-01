import java.util.*;

public class MergeSort implements ISorter {
    private int numComparisons;
    private int numMoves;

    public MergeSort() {
    }

    /**
     * Method that sorts the members of given array a using the merge sort technique. Returns an
     * object of type ISortStats that contains the statistics relevant to the
     * sorting.
     *
     * @param a list to be sorted
     * @return ISortStats
     * @author Noam Arie
     */

    @Override
    public ISortStats sort(int[] a) {
        long startTime = System.nanoTime();
        numMoves = 0;
        numComparisons = 0;
        sorting(a);


        return new SortStats("mergeSort", a.length, numComparisons, numMoves, System.nanoTime() - startTime);

    }

    /**
     * The recursive implementation used by the sort method.
     *
     * @param a the array to be sorted
     * @author Noam Arie
     */
    private void sorting(int[] a) {
        if (a.length > 1) {
            numMoves += 2;
            int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

            sorting(left);
            sorting(right);

            merge(a, left, right);
        }

    }

    /**
     * Combines 2 sorted arrays into one sorted array.
     *
     * @param b     where to put the merged list
     * @param left  the first sorted list to  merge
     * @param right the second sorted list to merge
     */
    private void merge(int[] b, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        if (b.length > 1) {
            // loops through the length of b to place the lowest remaining value.
            for (int i = 0; i < b.length; i++) {
                if (leftIndex < left.length && rightIndex < right.length) {
                    if (left[leftIndex] < right[rightIndex]) {
                        b[i] = left[leftIndex];
                        leftIndex++;
                    } else {
                        b[i] = right[rightIndex];
                        rightIndex++;
                    }
                } else if (leftIndex == left.length && rightIndex == right.length) {
                    return;
                }
                //if there are no more remaining values in the left side, place from the right.
                else if (leftIndex == left.length) {
                    b[i] = right[rightIndex];
                    rightIndex++;
                }
                //if there are no more remaining values in the left side, place from the right.
                else if (rightIndex == right.length) {
                    b[i] = left[leftIndex];
                    leftIndex++;
                }
                numComparisons++;
                numMoves++;
            }
        }
    }


}
