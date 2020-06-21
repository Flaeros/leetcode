package strings;

import java.util.ArrayList;
import java.util.List;

import static array.MaximalSquare_221.printDim;

public class InsertInterval_57 {

    public static void main(String[] args) {
        System.out.println(printDim(new InsertInterval_57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(printDim(new InsertInterval_57().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        boolean merged = false;

        for (int i = 0; i < len; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            if (end < newStart) {
                res.add(interval);
            } else if (start > newEnd) {
                if (!merged) {
                    res.add(new int[]{newStart, newEnd});
                    merged = true;
                }
                res.add(interval);
            } else {
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
        }

        if (!merged) {
            res.add(new int[]{newStart, newEnd});
        }

        return res.toArray(new int[0][0]);
    }
}
