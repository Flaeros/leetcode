package array;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands_200 {

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands_200().numIslands(new char[][]{
                {'1'},
                {'1'}

        }));
        System.out.println(new NumberOfIslands_200().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}

        }));
        System.out.println(new NumberOfIslands_200().numIslands(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}

        }));

    }

    int height;
    int breadth;

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        height = grid.length;
        breadth = grid[0].length;

        int count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < breadth; j++) {
                if (grid[i][j] == '1') {
                    markAdjecent(grid, i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private void markAdjecent(char[][] grid, int i, int j) {
        //invalid index
        if (i < 0 || i >= height || j < 0 || j >= breadth || grid[i][j] != '1')
            return;

        //visited
        grid[i][j] = '0';

        markAdjecent(grid, i + 1, j);
        markAdjecent(grid, i - 1, j);
        markAdjecent(grid, i, j + 1);
        markAdjecent(grid, i, j - 1);
    }
}
