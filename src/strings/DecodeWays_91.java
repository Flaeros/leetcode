package strings;

public class DecodeWays_91 {
    public static void main(String[] args) {
        System.out.println(new DecodeWays_91().numDecodings("110"));
        System.out.println(new DecodeWays_91().numDecodings("26"));
        System.out.println(new DecodeWays_91().numDecodings("27"));
        System.out.println(new DecodeWays_91().numDecodings("10"));
        System.out.println(new DecodeWays_91().numDecodings("100"));
        System.out.println(new DecodeWays_91().numDecodings("12"));
        System.out.println(new DecodeWays_91().numDecodings("226"));
        System.out.println(new DecodeWays_91().numDecodings("9"));
        System.out.println(new DecodeWays_91().numDecodings("99"));
        System.out.println(new DecodeWays_91().numDecodings("0"));
        System.out.println(new DecodeWays_91().numDecodings("22699"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int curr = s.charAt(i - 1) - '0';
            int prev = (s.charAt(i - 2) - '0') * 10 + curr;

            if (curr >= 1 && curr <= 9) {
                dp[i] = dp[i - 1];
            }

            if (prev >= 10 && prev <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
