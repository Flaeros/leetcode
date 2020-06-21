package dp;

import static array.MaximalSquare_221.printDim;

public class DungeonGame_174 {

    public static void main(String[] args) {
        System.out.println(new DungeonGame_174().calculateMinimumHP(new int[][]{
                {0,0}
        }));
        System.out.println(new DungeonGame_174().calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] hp = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    hp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == n - 1) {
                    hp[i][j] = Math.max(1, hp[i][j + 1] - dungeon[i][j]);
                } else if (j == m - 1) {
                    hp[i][j] = Math.max(1, hp[i + 1][j] - dungeon[i][j]);
                } else {
                    hp[i][j] = Math.min(
                            Math.max(1, hp[i][j + 1] - dungeon[i][j]),
                            Math.max(1, hp[i + 1][j] - dungeon[i][j]));
                }
            }
        }

        System.out.println(printDim(hp));
        return hp[0][0];
    }
}
