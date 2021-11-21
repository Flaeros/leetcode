
class Solution(object):
    def coinChange(self, coins, amount):
        n = len(coins)
        MAX = float('inf')
        dp = [[MAX for _ in range(amount + 1)] for _ in range(n)]

        for i in range(n):
            dp[i][0] = 0

        for i in range(n):
            for j in range(1, amount + 1):
                if i > 0:
                    dp[i][j] = dp[i - 1][j]
                if coins[i] <= j:
                    if dp[i][j - coins[i]] != MAX:
                        dp[i][j] = min(1 + dp[i][j - coins[i]], dp[i][j])

        return dp[n - 1][amount] if dp[n - 1][amount] != MAX else -1


print(Solution().coinChange([1, 2, 5], 11))
print(Solution().coinChange([2], 3))
print(Solution().coinChange([1], 0))
print(Solution().coinChange([1], 1))
print(Solution().coinChange([1], 2))
