package array;

import java.util.Arrays;

import static array.MaximalSquare_221.printDim;

public class CoinChange2_518 {

    public static void main(String[] args) {
        System.out.println(new CoinChange2_518().change(5, new int[]{1, 2, 5}));
        System.out.println(new CoinChange2_518().change(3, new int[]{2}));
        System.out.println(new CoinChange2_518().change(10, new int[]{10}));
    }

    public int change2(int amount, int[] coins) {
        Arrays.sort(coins);
        reverse(coins);

        int[][] dp = new int[amount + 1][coins.length];
        return change2(amount, coins, 0, dp);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public int change3(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int coinIndex = 1; coinIndex <= coins.length; coinIndex++) {
            dp[coinIndex][0] = 1;
            for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
                dp[coinIndex][currentAmount] = dp[coinIndex-1][currentAmount] + (currentAmount >= coins[coinIndex-1] ? dp[coinIndex][currentAmount-coins[coinIndex-1]] : 0);
            }
        }

        System.out.println(printDim(dp));
        return dp[coins.length][amount];
    }

    public int change2(int amount, int[] coins, int index, int[][] dp) {
        if (dp[amount][index] > 0)
            return dp[amount][index];

        if (index >= coins.length - 1)
            return 1;

        int coin = coins[index];

        int ways = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            ways += change2(remaining, coins, index + 1, dp);
        }
        dp[amount][index] = ways;
        return ways;
    }

    public void reverse(int[] coins) {
        int len = coins.length;
        for (int k = 0; k < len / 2; k++) {
            int temp = coins[k];
            coins[k] = coins[len - (1 + k)];
            coins[len - (1 + k)] = temp;
        }
    }
}
