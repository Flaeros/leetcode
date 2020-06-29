package array;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {


    public static void main(String[] args) {
        System.out.println(new ShortestBridge_934().shortestBridge(new int[][]{
                {0, 1},
                {1, 0}
        }));
        System.out.println(new ShortestBridge_934().shortestBridge(new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        }));
        System.out.println(new ShortestBridge_934().shortestBridge(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        }));
    }


    public int shortestBridge(int[][] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (A[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    paint(A, i, j, q);
                    return bfs(A, q);
                }
            }
        }

        return -1;
    }

    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int bfs(int[][] A, Queue<int[]> q) {

        int len = A.length;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int i = poll[0];
            int j = poll[1];

            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (isSafe(nextI, nextJ, len)) {
                    if (A[nextI][nextJ] == 1) {
                        return A[i][j] - 2;
                    } else if (A[nextI][nextJ] == 0) {
                        A[nextI][nextJ] = A[i][j] + 1;
                        q.add(new int[]{nextI, nextJ});
                    }
                }
            }
        }

        return -1;
    }

    private void paint(int[][] A, int i, int j, Queue<int[]> q) {
        if (i < 0 || j < 0 || i > A.length - 1 || j > A.length - 1)
            return;

        if (A[i][j] == 0) {
            A[i][j] = 3;
            q.add(new int[]{i, j});
        }

        if (A[i][j] != 1) {
            return;
        }

        A[i][j] = 2;

        paint(A, i - 1, j, q);
        paint(A, i, j + 1, q);
        paint(A, i + 1, j, q);
        paint(A, i, j - 1, q);
    }

    boolean isSafe(int i, int j, int len) {
        return i >= 0 && j >= 0 && i < len && j < len;
    }
}
