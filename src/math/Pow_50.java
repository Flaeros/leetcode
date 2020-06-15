package math;

import java.text.DecimalFormat;

public class Pow_50 {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(new Pow_50().myPow(2.00000, 2)));
        System.out.println(df.format(new Pow_50().myPow(2.00000, 10)));
        System.out.println(df.format(new Pow_50().myPow(2.10000, 3)));
        System.out.println(df.format(new Pow_50().myPow(2.00000, -2)));
        System.out.println(df.format(new Pow_50().myPow(1.00000, 2147483647)));
        System.out.println(df.format(new Pow_50().myPow(1.00000, -2147483648)));
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0)
            return 1 / myPow(x, -1 * n);

        return n%2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
