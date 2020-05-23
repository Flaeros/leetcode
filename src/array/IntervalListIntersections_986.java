package array;

import java.util.ArrayList;
import java.util.List;

import static array.MaximalSquare_221.printDim;

public class IntervalListIntersections_986 {

    public static void main(String[] args) {
        System.out.println(printDim(new IntervalListIntersections_986().intervalIntersection(
                new int[][]{{0, 2}, {5, 10}}, new int[][]{{3, 4}}
        )));
        System.out.println();
        System.out.println(printDim(new IntervalListIntersections_986().intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}
        )));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0)
            return new int[0][0];

        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        int x1, x2;

        while (i < A.length && j < B.length) {
             x1 = Math.max(A[i][0], B[j][0]);
             x2 = Math.min(A[i][1], B[j][1]);
            if (x2 >= x1)
                result.add(new int[]{x1, x2});

            if (x2 == A[i][1])
                i++;
            if (x2 == B[j][1])
                j++;
        }

        return result.toArray(new int[0][0]);
    }

}
