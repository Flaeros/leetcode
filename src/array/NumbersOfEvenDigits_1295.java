package array;

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 */
public class NumbersOfEvenDigits_1295 {

    /**
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     */
    public static void main(String[] args) {
        System.out.println(new NumbersOfEvenDigits_1295().findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(new NumbersOfEvenDigits_1295().findNumbers(new int[]{555,901,482,1771}));
    }

    public int findNumbers(int[] nums) {
        int count = 0 ;
        for (int num : nums) {
            if ((num >= 10 && num < 100 ) || (num >=1000 && num < 10000) || num == 100000)
                count++;
        }
        return count;
    }

    public int findNumbers2(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int d = 0;
            while (num >=10) {
                d++;
                num = num / 10;
            }
            if (d%2 != 0) {
                count++;
            }
        }

        return count;
    }
}
