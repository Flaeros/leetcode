package array;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {

    public static void main(String[] args) {
        System.out.println(new RottingOranges_994().orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
        System.out.println(new RottingOranges_994().orangesRotting(new int[][]{
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        }));
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    countFresh++;
            }
        }

        if (countFresh == 0)
            return 0;

        int count = 0;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            count++;

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 ||  grid[x][y] == 2)
                        continue;

                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    countFresh--;
                }
            }
        }

        return countFresh == 0 ? count -1 : -1;
    }

}
