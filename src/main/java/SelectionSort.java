public class SelectionSort implements ISorter {

    public SelectionSort() {
    }


    /**
     * Method that sorts the members of given array a using the selection sort technique. Returns an
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
        int numComparisons = 0;
        int numMoves = 0;
        int i = 0;
        while (i < a.length - 1) {
            int minIndex = i;
            //finds the lowest remaining value
            for (int j = i + 1; j < a.length; j++) {
                numComparisons++;
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //places the lowest remaining value at the front
            int min = a[minIndex];
            if (min != a[i]) {
                a[minIndex] = a[i];
                a[i] = min;
                numMoves++;
            }
            i++;

        }

        return new SortStats("SelectionSort", a.length, numComparisons, numMoves, System.nanoTime() - startTime);
    }
}
