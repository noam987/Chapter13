public class InsertionSort implements ISorter {
    public InsertionSort() {
    }

    /**
     * Method that sorts the members of given array a using the insertion sort technique. Returns an
     * object of type ISortStats that contains the statistics relevant to the
     * sorting.
     *
     * @param a
     * @return ISortStats
     * @author Noam Arie
     */
    @Override
    public ISortStats sort(int[] a) {
        long startTime = System.nanoTime();
        int numComparisons = 0;
        int numMoves = 0;

        for (int i = 0; i < a.length; i++) {
            boolean foundSpot = false;
            int j = 0;
            while (!foundSpot) {
                numComparisons++;
                if (a[i] <= a[j]) {
                    foundSpot = true;
                    int temp = a[i];
                    for (int k = i - 1; k >= j; k--) {
                        numMoves++;
                        a[k + 1] = a[k];
                    }
                    numMoves++;
                    a[j] = temp;
                }
                j++;
            }
        }


        return new SortStats("Insertion Sort", a.length, numComparisons, numMoves, System.nanoTime() - startTime);
    }
}
