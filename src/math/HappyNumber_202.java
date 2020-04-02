package math;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber_202 {

    public static void main(String[] args) {
        System.out.println(new HappyNumber_202().isHappy(19));
        System.out.println(new HappyNumber_202().isHappy(20));
        System.out.println(new HappyNumber_202().isHappy(10));
        System.out.println(new HappyNumber_202().isHappy(20192621));
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while (true) {
            slow = sum(slow);
            fast = sum(sum(fast));
            if (fast == 1)
                return true;
            if (slow == fast)
                return false;
        }
    }

    public int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum = sum + rem * rem;
            n = n / 10;
        }
        return sum;
    }
}
