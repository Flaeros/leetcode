package dp;

public class PartitionEqualSubsetSum_416 {

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum_416().canPartition(new int[]{1, 1, 2}));
        System.out.println(new PartitionEqualSubsetSum_416().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new PartitionEqualSubsetSum_416().canPartition(new int[]{1, 2, 3, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        sum /= 2;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }
}
