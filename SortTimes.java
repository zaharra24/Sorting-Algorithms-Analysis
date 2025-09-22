/**
 * Author: Zaharra Chami
 * Assignment: Sort Times Programming Assignment #1
 */
import java.util.*;

public class SortTimes {
    public static void main(String[] args) {
        // created new Scanner
        Scanner input = new Scanner(System.in);

        // Read n and m
        System.out.print("Enter n (list size): ");
        int n = input.nextInt();
        System.out.print("Enter m (number of trials): ");
        int m = input.nextInt();

        Random rand = new Random();

        // Results storage
        String[] names = {"Insertion","Selection","Bubble","Quick","Merge","Shell"};
        long[][] times = new long[m][6];   // store elapsed times in ns
        Object[] copy = new Object[n];

        // m trials
        for (int t = 0; t < m; t++) {
            // base for trial t
            Object[] base = new Object[n];
            for (int i = 0; i < n; i++) base[i] = rand.nextInt();

            long start, end;

            // Insertion
            System.arraycopy(base, 0, copy, 0, n);
            start = System.nanoTime();
            sorter.isort(copy, n);
            end = System.nanoTime();
            times[t][0] = end - start;

            // Selection
            System.arraycopy(base, 0, copy, 0, n);
            start = System.nanoTime();
            sorter.ssort(copy, n);
            end = System.nanoTime();
            times[t][1] = end - start;

            // Bubble
            System.arraycopy(base, 0, copy, 0, n);
            start = System.nanoTime();
            sorter.bsort(copy, n);
            end = System.nanoTime();
            times[t][2] = end - start;

            // Quick
            System.arraycopy(base, 0, copy, 0, n);
            start = System.nanoTime();
            sorter.qsort(copy, 0, n - 1);
            end = System.nanoTime();
            times[t][3] = end - start;

            // Merge
            System.arraycopy(base, 0, copy, 0, n);
            start = System.nanoTime();
            sorter.msort(copy, 0, n - 1);
            end = System.nanoTime();
            times[t][4] = end - start;

            // Shell
            System.arraycopy(base, 0, copy, 0, n);
            start = System.nanoTime();
            sorter.shsort(copy, n);
            end = System.nanoTime();
            times[t][5] = end - start;
        }
         
        //column with
        int w = 11; 

        // Header
        System.out.println("Insertion  Selection  Bubble  Quick  Merge  Shell");

        // One row per trial
        for (int t = 0; t < m; t++) {
            System.out.printf("%d. ", (t + 1));
            for (int a = 0; a < 6; a++) {
                System.out.printf("%" + w + "d", times[t][a]);
            }
            System.out.println();
        }
        System.out.println();

        // Best
        System.out.print("Best time:");
        for (int a = 0; a < 6; a++) {
            long best = Long.MAX_VALUE;
            for (int t = 0; t < m; t++) best = Math.min(best, times[t][a]);
            System.out.printf("%" + w + "d", best);
        }
        System.out.println();

        // Avg
        System.out.print("Avg time:");
        for (int a = 0; a < 6; a++) {
            long sum = 0;
            for (int t = 0; t < m; t++) sum += times[t][a];
            long avg = Math.round(sum / (double) m);
            System.out.printf("%" + w + "d", avg);
        }
        System.out.println();

        // Worst
        System.out.print("Worst time:");
        for (int a = 0; a < 6; a++) {
            long worst = Long.MIN_VALUE;
            for (int t = 0; t < m; t++) worst = Math.max(worst, times[t][a]);
            System.out.printf("%" + w + "d", worst);
        }
        System.out.println();
    }
}
/*
 * Enter n (list size): 15
Enter m (number of trials): 3
Insertion  Selection  Bubble  Quick  Merge  Shell
1.     1047549      16028      17557      14786      21735      11349
2.        7385      11309      12446       9678      15595       8721
3.        7600      11484      12374       8533      23614       7901

Best time:       7385      11309      12374       8533      15595       7901
Avg time:     354178      12940      14126      10999      20315       9324
Worst time:    1047549      16028      17557      14786      23614      11349

 */
