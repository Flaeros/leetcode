package array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals_435 {

    public static void main(String[] args) {
        System.out.println(new NonOverlappingIntervals_435().eraseOverlapIntervals(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        }));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(e -> e[1]));

        int prev = 0;
        int countMax = 1;
        int n = intervals.length;

        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            int prevEnd = intervals[prev][1];
            if (currStart >= prevEnd) {
                prev = i;
                countMax++;
            }
        }

        return n - countMax;
    }
}
