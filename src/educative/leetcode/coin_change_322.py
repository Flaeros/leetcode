# dp
# i - numbers of coins
# j - current total
# dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-1])

class Solution(object):
    def coinChange(self, coins, amount):
        MAX = float('inf')

        n = len(coins)
        dp = [[MAX for _ in range(amount + 1)] for _ in range(n)]

        for i in range(n):
            dp[i][0] = 0

        for i in range(n):
            for j in range(amount + 1):
                # exclude
                if i > 0:
                    dp[i][j] = dp[i - 1][j]

                # exclude or include
                if coins[i] <= j and dp[i][j - coins[i]] != MAX:
                    dp[i][j] = min(dp[i][j], 1 + dp[i][j - coins[i]])

        return dp[n - 1][amount] if dp[n - 1][amount] != MAX else -1


print(Solution().coinChange([1, 2, 5], 11))
print(Solution().coinChange([2], 11))
print(Solution().coinChange([1], 0))
print(Solution().coinChange([1], 1))
print(Solution().coinChange([1], 2))
