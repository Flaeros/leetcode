# dp 2-dim, max_square

# dp[i][j] =  matrix[i][j] == 1 -> 1
#             matrix[i-1][j] == 1 && 
#             matrix[i][j-1] == 1 &&
#             matrix[i-1][j-1] == 1 
#          min() == 1     -> min + 1

# dp -> 0
# n,m  +1

class Solution(object):
    def maximalSquare(self, matrix):
        n = len(matrix)
        m = len(matrix[0])

        dp = [[0 for _ in range(m)] for _ in range(n)]

        max_square = 0

        for i in range(n):
            if matrix[i][0] == "1":
                dp[i][0] = 1
                max_square = max(1, max_square)

        for j in range(m):
            if matrix[0][j] == "1":
                dp[0][j] = 1
                max_square = max(1, max_square)

        for i in range(1, n):
            for j in range(1, m):
                if matrix[i][j] == "1":
                    dp[i][j] = 1
                    max_square = max(1, max_square)

                min_square = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
                if min_square > 0 and dp[i][j] == 1:
                    dp[i][j] = min_square + 1
                    max_square = max(dp[i][j], max_square)

        return max_square * max_square


# 16
print(Solution().maximalSquare(
    [["1", "1", "1", "1", "0"],
     ["1", "1", "1", "1", "0"],
     ["1", "1", "1", "1", "1"],
     ["1", "1", "1", "1", "1"],
     ["0", "0", "1", "1", "1"]]))
# 4
print(Solution().maximalSquare(
    [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]))
# 1
print(Solution().maximalSquare([["0", "1"], ["1", "0"]]))
# 0
print(Solution().maximalSquare([["0"]]))
# 1
print(Solution().maximalSquare([["1"]]))
