package math;

/**
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 */
public class SubtractAnInteger_1281 {
    /**
     * 1 <= n <= 10^5
     */
    public static void main(String[] args) {
        System.out.println(new SubtractAnInteger_1281().subtractProductAndSum(14));
        System.out.println(new SubtractAnInteger_1281().subtractProductAndSum(234));
        System.out.println(new SubtractAnInteger_1281().subtractProductAndSum(4421));
        System.out.println(new SubtractAnInteger_1281().subtractProductAndSum(10225));
    }

    public int subtractProductAndSum(int n) {
        if (n < 10)
            return 0;

        int product = 1;
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            product = product * digit;
            sum = sum + digit;
            n /= 10;
        }

        return product - sum;
    }
}
