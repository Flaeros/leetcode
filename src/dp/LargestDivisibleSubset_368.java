package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset_368().largestDivisibleSubset(new int[]{1}));
        System.out.println(new LargestDivisibleSubset_368().largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(new LargestDivisibleSubset_368().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(new LargestDivisibleSubset_368().largestDivisibleSubset(new int[]{1, 2, 4, 8, 3, 5}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int max = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }

        return res;
    }
}
