# [] - > 0
# [1] -> 0
# [1, 2] -> dp[i] -> prices[i]
#           dp[i] -> min(dp[i-1], dp[i])
#           result = max(0, prices[i]-dp[i-1])

# почему будет работать dp

class Solution(object):
    def bestTimeToBuy(self, prices):
        n = len(prices)

        MAX = float('inf')
        dp = [0] * n
        result = 0

        for i in range(n):
            dp[i] = prices[i]
            if i > 0:
                dp[i] = min(dp[i], dp[i - 1])

            if i > 0 and prices[i] > dp[i - 1]:
                result = max(result, prices[i] - dp[i - 1])

        print(dp)
        return result


print(Solution().bestTimeToBuy([7, 1, 5, 3, 6, 4]))
print(Solution().bestTimeToBuy([7, 6, 4, 3, 1]))
print(Solution().bestTimeToBuy([5, 3, 5, 2, 6]))

# {7, 1, 5, 3, 6, 4}), -> 5
# {7, 6, 4, 3, 1}), -> 0
# {5, 3, 5, 2, 6}), -> 4
