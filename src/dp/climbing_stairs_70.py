# dp
# dp[i] =  dp[i-2] + dp[i-1]


class Solution(object):
    def climbStairs(self, n):
        if n < 2:
            return 1

        dp = [1 for _ in range(n + 1)]

        for i in range(2, n + 1):
            dp[i] = dp[i - 2] + dp[i - 1]

        return dp[n]


print(Solution().climbStairs(1))
print(Solution().climbStairs(2))
print(Solution().climbStairs(3))
print(Solution().climbStairs(5))
