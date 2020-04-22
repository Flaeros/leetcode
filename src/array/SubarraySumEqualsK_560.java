package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubarraySumEqualsK_560 {

    /**
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */
    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK_560().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new SubarraySumEqualsK_560().subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;

            if (cache.containsKey(sum - k))
                res += cache.get(sum - k);
            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
