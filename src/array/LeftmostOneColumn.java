package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A binary matrix means that all elements are 0 or 1.
 * For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed)
 * with at least a 1 in it. If such index doesn't exist, return -1.
 */
public class LeftmostOneColumn {

    public static void main(String[] args) {
        BinaryMatrix matrix = new BinaryMatrix(new int[][]{
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}});
        System.out.println(new LeftmostOneColumn().leftMostColumnWithOne(matrix));
        matrix = new BinaryMatrix(new int[][]{
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}});
        System.out.println(new LeftmostOneColumn().leftMostColumnWithOne(matrix));
        matrix = new BinaryMatrix(new int[][]{
                {0, 0},
                {1, 1}});
        System.out.println(new LeftmostOneColumn().leftMostColumnWithOne(matrix));
    }


    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);

        int m = 0;
        int n = col - 1;

        while (m < row && n >= 0) {
            if (binaryMatrix.get(m,n) == 1) {
                n--;
            } else {
                m++;
            }
        }
        return n != col - 1 ? n + 1 : -1;
    }
}

