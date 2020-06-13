package dp;

/**
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 */
public class MaximumSubarray_53 {

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray_53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaximumSubarray_53().maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int local = 0;
            for (int j = i; j < nums.length; j++) {
                local += nums[j];
                if (local > result)
                    result = local;
            }
        }
        return result;
    }

    public int maxSubArrayCopy(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArrayMax(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
