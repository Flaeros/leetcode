package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumPathSum_64 {

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum_64().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));

        System.out.println(new MinimumPathSum_64().minPathSum(new int[][]{
                {3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}}));

    }

    public int minPathSum(int[][] grid) {
        int height = grid.length;
        if (grid == null || height == 0) return 0;
        int breadth = grid[0].length;
        int[][] dp = new int[height][breadth];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[height - 1][breadth - 1];
    }

    int breadth;
    int height;


    Map<Coords, Integer> cache = new HashMap<>();

    public int minPathSumCached(int[][] grid) {

        breadth = grid[0].length;
        height = grid.length;
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int i, int j) {
        Coords coords = new Coords(i, j);
        Integer cached = cache.get(coords);
        if (cached != null)
            return cached;

        int result;
        if (i < height - 1 && j < breadth - 1) {
            result = grid[i][j] + Math.min(minPathSum(grid, i + 1, j), minPathSum(grid, i, j + 1));
        } else if (i < height - 1) {
            result = grid[i][j] + minPathSum(grid, i + 1, j);
        } else if (j < breadth - 1) {
            result = grid[i][j] + minPathSum(grid, i, j + 1);
        } else
            result = grid[i][j];

        cache.put(coords, result);
        return result;
    }


    static class Coords {
        int i;
        int j;

        public Coords(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coords coords = (Coords) o;
            return i == coords.i &&
                    j == coords.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
