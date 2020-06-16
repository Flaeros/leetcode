package array;

import static array.MaximalSquare_221.printDim;

public class RotateImage_48 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        new RotateImage_48().rotate(matrix);
        System.out.println(printDim(matrix));

    }

    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][c - j - 1];
                matrix[i][c - j - 1] = temp;
            }
        }
    }
}
