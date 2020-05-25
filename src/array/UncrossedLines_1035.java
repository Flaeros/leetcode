package array;

public class UncrossedLines_1035 {

    public static void main(String[] args) {
  /*      System.out.println(new UncrossedLines_1035().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(new UncrossedLines_1035().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(new UncrossedLines_1035().maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
        System.out.println(new UncrossedLines_1035().maxUncrossedLines(new int[]{2, 1}, new int[]{1, 2, 1, 3, 3, 2}));
        System.out.println(new UncrossedLines_1035().maxUncrossedLines(new int[]{1, 2, 1, 3, 3, 2}, new int[]{2, 1}));*/
        System.out.println(new UncrossedLines_1035().maxUncrossedLines(new int[]{3, 3, 2}, new int[]{3, 3, 1, 2}));
    }


    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (n > m)
            return maxUncrossedLines(B, A);

        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i % 2][j] = 1 + dp[(i + 1) % 2][j - 1];
                } else {
                    dp[i % 2][j] = Math.max(dp[i % 2][j - 1], dp[(i + 1) % 2][j]);
                }
            }

        }

        return dp[m % 2][n];
    }

    public int maxUncrossedLinesNormal(int[] A, int[] B) {
        int alen = A.length;
        int blen = B.length;

        int[][] dp = new int[alen + 1][blen + 1];


        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (B[j - 1] == A[i - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[alen][blen];
    }
}
