package dp;

public class UniquePaths_62 {

    public static void main(String[] args) {
        System.out.println(new UniquePaths_62().uniquePaths(3, 2));
        System.out.println(new UniquePaths_62().uniquePaths(7, 3));
    }

    public int uniquePaths(int r, int c) {
        if (r == 0 || c == 0)
            return 0;
        if (r > c)
            return uniquePaths(c, r);

        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < c; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[r-1][c-1];
    }
}
