package array;

public class IslandPerimeter_463 {

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter_463().islandPerimeter(new int[][]{{1}}));

        System.out.println(new IslandPerimeter_463().islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}}));
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                if (i == 0) {
                    perimeter++;
                }

                if (i == grid.length - 1) {
                    perimeter++;
                }

                if (i > 0 && grid[i - 1][j] == 0)
                    perimeter++;
                if (i < grid.length - 1 && grid[i + 1][j] == 0)
                    perimeter++;

                if (j == 0) {
                    perimeter++;
                }
                if (j == grid[0].length - 1) {
                    perimeter++;
                }

                if (j > 0 && grid[i][j - 1] == 0)
                    perimeter++;
                if (j < grid[0].length - 1 && grid[i][j + 1] == 0)
                    perimeter++;
            }
        }
        return perimeter;
    }
}
