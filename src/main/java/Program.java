import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ISorter[] sorters = {new MergeSort(), new BubbleSort(), new InsertionSort(), new SelectionSort()};
        Random random = new Random();

        // Random Order testing
        for (int i = 1; i <= 4096; i *= 2) {
            int[] b = new int[i];
            for (int j = 0; j < b.length; j++) {
                b[j] = b.length - j;
            }
            for (int k = 0; k < b.length; k++) {
                int randomIndexToSwap = random.nextInt(b.length);
                int temp = b[randomIndexToSwap];
                b[randomIndexToSwap] = b[k];
                b[k] = temp;
            }
            for (ISorter sorter : sorters) {
                int[] a = new int[i];
                for (int k = 0; k < a.length; k++) {
                    a[k] = b[k];
                }
                ISortStats stats = sorter.sort(a);
                System.out.println(Check.isInOrder(a));
                System.out.println(stats.toString());
            }
        }
        for (ISorter sorter : sorters) {
            // setting up reverse order array
            int[] c = new int[4096];
            for (int i = 4096; i > 0; i--) {
                c[4096 - i] = i;
            }
            // sorting in reverse order
            ISortStats stats = sorter.sort(c);
            System.out.println(Check.isInOrder(c));
            System.out.println(stats.toString());

            //sorting in forwards order
            stats = sorter.sort(c);
            System.out.println(Check.isInOrder(c));
            System.out.println(stats.toString());
        }

    }
}
