package dp;

import static array.MaximalSquare_221.printDim;

public class TwoCityScheduling_1029 {

    public static void main(String[] args) {
        System.out.println(new TwoCityScheduling_1029().twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }


    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        System.out.println(printDim(dp));

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
                System.out.println(printDim(dp));

            }
        }
        return dp[N][N];
    }

    public int twoCitySchedCost2(int[][] costs) {
        int N = costs.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
            dp[0][i] = dp[0][i -1 ] + costs[i - 1][1];
        }

        System.out.println(printDim(dp));
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j- 1][0], dp[i][j - 1] + costs[i +j- 1][1]);
                System.out.println(printDim(dp));
            }
        }

        return dp[N][N];
    }
}
