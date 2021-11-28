# elements that sum up to total/2
# dp
# exclude - dp[i][j] = dp[i-][j]
# if nums[i] < current_sum (j)
# include - dp[i][j] = dp[i-1][j-nums[i]] or dp[i-1][j]
# get close to sum/2

# edge cases
# if nums sum is odd - can't

# dp array
# j - sum, with 0 padding, T for 0
# i - nums, without padding
# T/F as dp

class Solution(object):
    def canPartition(self, nums):
        total = sum(nums)
        n = len(nums)
        if total % 2 != 0:
            return False

        target = int(total / 2)

        dp = [[False for _ in range(target + 1)] for _ in range(n)]

        for i in range(n):
            dp[i][0] = True

        for i in range(n):
            for j in range(1, target + 1):
                if i > 0:
                    dp[i][j] = dp[i - 1][j]

                if nums[i] <= j:
                    dp[i][j] = dp[i][j] or dp[i - 1][j - nums[i]]

        return dp[n - 1][target]


print(Solution().canPartition([1, 2, 5]))
print(Solution().canPartition([1, 5, 11, 5]))
print(Solution().canPartition([1, 2, 3, 5]))
