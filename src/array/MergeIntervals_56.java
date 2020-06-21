package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static array.MaximalSquare_221.printDim;

public class MergeIntervals_56 {

    public static void main(String[] args) {
        System.out.println(printDim(new MergeIntervals_56().merge(
                new int[][]{{1, 4}, {2, 3}})));
        System.out.println(printDim(new MergeIntervals_56().merge(
                new int[][]{{1, 4}, {0, 4}})));
        System.out.println(printDim(new MergeIntervals_56().merge(
                new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(printDim(new MergeIntervals_56().merge(
                new int[][]{{1, 4}, {4, 5}})));
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1)
            return intervals;
        int[] starts = new int[len];
        int[] ends = new int[len];

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            starts[i] = interval[0];
            ends[i] = interval[1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int start = 0;
        int end = 0;

        List<int[]> res = new ArrayList<>();

        while (end < len) {
            if (end == len - 1 || starts[end + 1] > ends[end]) {
                res.add(new int[]{starts[start], ends[end]});
                start = end + 1;
            }
            end++;
        }

        return res.toArray(new int[0][0]);
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if (nextStart > end) {
                res.add(new int[]{start, end});
                start = nextStart;
            }
            end = Math.max(end, nextEnd);
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[0][0]);
    }
}
