package array;

public class BuyAndSell_122 {
    public static void main(String[] args) {
        System.out.println(new BuyAndSell_122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BuyAndSell_122().maxProfit(new int[]{7, 1, 5, 6, 5, 8}));
        System.out.println(new BuyAndSell_122().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BuyAndSell_122().maxProfit(new int[]{1, 2, 4, 5, 6}));
        System.out.println(new BuyAndSell_122().maxProfit(new int[]{7, 6, 4, 3, 1}));

    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i])
                sum += prices[i+1] - prices[i];
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;

        int sum = 0;

        int buyPointer = 0;
        int sellPointer = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] >= prices[sellPointer]) {
                sellPointer = i;
            } else {
                if (buyPointer != sellPointer)
                    sum += prices[sellPointer] - prices[buyPointer];
                buyPointer = sellPointer = i;
            }
        }

        if (prices[sellPointer] > prices[buyPointer])
            sum += prices[sellPointer] - prices[buyPointer];

        return sum;
    }
}
