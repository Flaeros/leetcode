package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares_279 {

    public static void main(String[] args) {
        System.out.println(new PerfectSquares_279().numSquares(12));
        System.out.println(new PerfectSquares_279().numSquares(13));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public int numSquares2(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n == i * i)
                return 1;
            squares.add(i * i);
        }

        int[] dp = new int[n+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int sq : squares) {
            for (int j = 1; j <= n; j++) {
                if (sq == j) {
                    dp[j] = 1;
                } else if (j >= sq) {
                    dp[j] = Math.min(dp[j],  dp[j - sq] + 1);
                }
            }
        }

        return dp[n];
    }
}
