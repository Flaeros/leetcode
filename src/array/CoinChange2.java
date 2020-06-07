package array;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(5, new int[]{1, 2, 5}));
        System.out.println(new CoinChange2().change(3, new int[]{2}));
        System.out.println(new CoinChange2().change(10, new int[]{10}));
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        reverse(coins);
        return change(amount, coins, 0);
    }

    public int change(int amount, int[] coins, int index) {
        if (amount > coins[0])
        if (index >= coins.length - 1)
            return 1;

        int coin = coins[index];

        int ways = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            ways += change(remaining, coins, index + 1);
        }
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
