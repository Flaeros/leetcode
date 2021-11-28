# dp
# 0 - cost[0], 1 - cost[1]
# dp[i] = min(dp[i-1], dp[i-2])
# dp[-1]

class Solution(object):
    def minCostClimbingStairs(self, cost):
        n = len(cost)
        if n == 0:
            return cost[0]

        dp = [0] * (n + 1)
        dp[0] = 0
        dp[1] = cost[0]

        for i in range(2, n + 1):
            dp[i] = cost[i - 1] + min(dp[i - 1], dp[i - 2])

        return min(dp[-1], dp[-2])



print(Solution().minCostClimbingStairs([10, 15]))
print(Solution().minCostClimbingStairs([10, 15, 20]))
print(Solution().minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1]))
