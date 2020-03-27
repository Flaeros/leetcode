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

        int temp = n;
        int product = 1;
        int sum = 0;

        while(temp >= 10) {
            int digit = temp % 10;
            product = product * digit;
            sum = sum + digit;
            temp = temp / 10;
        }
        product = product * temp;
        sum = sum + temp;

        return product - sum;
    }
}
