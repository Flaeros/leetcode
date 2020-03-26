package array;

import java.util.Arrays;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * <p>
 * Return the answer in an array.
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class CountSmallerNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountSmallerNumbers().smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(new CountSmallerNumbers().smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
        System.out.println(Arrays.toString(new CountSmallerNumbers().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(new CountSmallerNumbers().smallerNumbersThanCurrent(new int[]{5,0,10,0,10,6})));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else  {
                res[i] = count[nums[i]-1];
            }
        }

        return res;
    }

}
