package array;

public class ArrangingCoins_441 {

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins_441().arrangeCoins(1));
        System.out.println(new ArrangingCoins_441().arrangeCoins(5));
        System.out.println(new ArrangingCoins_441().arrangeCoins(2147483647));
        System.out.println(new ArrangingCoins_441().arrangeCoins(6));
        System.out.println(new ArrangingCoins_441().arrangeCoins(8));
    }

    public int arrangeCoins(int n) {
        if (n == 0)
            return 0;

        int k = 0;

        while (n > 0) {
            n -= k;
            if (n < 0)
                return k -1;
            k++;
        }

        return k - 1;
    }
}
