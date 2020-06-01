public class BubbleSort implements ISorter {
    public BubbleSort() {

    }

    /**
     * Method that sorts the members of given array a using the bubble sort technique. Returns an
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
        while (!Check.isInOrder(a)) {
            for (int i = 0; i < a.length - 1; i++) {
                numComparisons++;
                //compares two adjacent values
                if (a[i] > a[i + 1]) {
                    numMoves++;
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }

        return new SortStats("Bubble Sort", a.length, numComparisons, numMoves, System.nanoTime() - startTime);
    }
}
