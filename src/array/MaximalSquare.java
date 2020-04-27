package array;

import java.util.Arrays;

public class MaximalSquare {

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        }));

        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'0'}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1'}}));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1)
            return 0;

        int height = matrix.length;
        int breadth = matrix[0].length;
        int[][] mx = new int[height + 1][breadth + 1];

        for (int i = 1; i < height + 1; i++) {
            for (int j = 1; j < breadth + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    if (mx[i - 1][j - 1] > 0 && mx[i - 1][j] > 0 && mx[i][j - 1] > 0) {
                        int min = Math.min(mx[i - 1][j - 1], mx[i - 1][j]);
                        min = Math.min(mx[i][j - 1], min);
                        mx[i][j] = min + 1;
                    } else {
                        mx[i][j] = 1;
                    }
                }
            }
        }

        System.out.println(printDim(mx));
        int max = 0;
        for (int i = 0; i < height + 1; i++) {
            for (int j = 0; j < breadth + 1; j++) {
                max = Math.max(max, mx[i][j]);
            }
        }

        return max * max;
    }

    public static String printDim(int[][] mx) {
        StringBuilder builder = new StringBuilder();
        for (int[] ints : mx) {
            builder.append(Arrays.toString(ints));
            builder.append("\n");
        }
        return builder.toString();
    }
}
