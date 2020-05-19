package tree;

import java.util.Stack;

/**
 * Write a class StockSpanner which collects daily price quotes for some stock,
 * and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days
 * (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
public class OnlineStockSpan_901 {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }

    private static void test2() {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(29));
        System.out.println(s.next(91));
        System.out.println(s.next(62));
        System.out.println(s.next(76));
        System.out.println(s.next(51));
    }
    private static void test1() {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));
    }

    static class StockSpanner {


        public StockSpanner() {

        }

        Stack<int[]> stack = new Stack<>();
        public int next(int price) {
            int res = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price)
                res += stack.pop()[1];
            stack.push(new int[]{price, res});
            return res;
        }

    }
}
