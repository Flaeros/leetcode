package math;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 */
public class ValidPerfectSquare_367 {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(4));
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(81));
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(121));
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(122));
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(120));
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(14));
        System.out.println(new ValidPerfectSquare_367().isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        long e = num;
        while (e * e > num) {
            e >>= 1;
        }

        while (e * e < num) {
            e++;
        }

        if (e * e == num) {
            return true;
        }

        return false;
    }
}
