package array;

import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{-3, 4, 3, 90}, 0)));
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{0, 4, 3, 0}, 0)));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (sums.containsKey(key)) {
                return new int[] {sums.get(key), i};
            }
            sums.put(nums[i], i);
        }
        return new int[0];
    }
}
