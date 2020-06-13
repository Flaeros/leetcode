package dp;

public class BestBuyStock_138 {

    public static void main(String[] args) {
        System.out.println(new BestBuyStock_138().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestBuyStock_138().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
