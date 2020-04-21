package array;

import java.util.List;

import static java.util.Arrays.asList;

public class BinaryMatrix {
    int[][] matrix;

    public BinaryMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int get(int x, int y) {
        System.out.println(x + "," + y);
        return matrix[x][y];
    }

    public List<Integer> dimensions() {
        return asList(matrix.length, matrix[0].length);
    }
}
