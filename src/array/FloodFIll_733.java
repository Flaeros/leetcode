package array;

import java.util.Arrays;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 */
public class FloodFIll_733 {

    /**
     * The length of image and image[0] will be in the range [1, 50].
     * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
     * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
     */
    public static void main(String[] args) {
        int[][] screen = {
                {1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };

        System.out.println(printDim(new FloodFIll_733().floodFill(screen, 1, 2, 2)));

    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        floodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int newColor, int prevColor) {
        if (sr < 0 || sr > image.length - 1)
            return;
        if (sc < 0 || sc > image[0].length - 1)
            return;
        if (image[sr][sc] == newColor || image[sr][sc] != prevColor)
            return;

        image[sr][sc] = newColor;

        floodFill(image, sr + 1, sc, newColor, prevColor);
        floodFill(image, sr, sc + 1, newColor, prevColor);
        floodFill(image, sr - 1, sc, newColor, prevColor);
        floodFill(image, sr, sc - 1, newColor, prevColor);

    }

    public static String printDim(int[][] rotateMatrix) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rotateMatrix.length; i++) {
            builder.append(Arrays.toString(rotateMatrix[i]));
            builder.append("\n");
        }
        return builder.toString();
    }
}
