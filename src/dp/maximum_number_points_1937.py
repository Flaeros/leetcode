from typing import List


class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        m = len(points[0])

        dp = [[0 for _ in range(m)] for _ in range(n)]

        for j in range(m):
            dp[0][j] = points[0][j]

        def left(row):
            lft = [0] * m
            lft[0] = row[0]

            for j in range(1, m):
                lft[j] = max(lft[j - 1] - 1, row[j])

            return lft

        def right(row):
            rgt = [0] * m
            rgt[-1] = row[-1]

            for j in range(m-2, -1, -1):
                rgt[j] = max(rgt[j+1] - 1, row[j])

            return rgt

        for i in range(1, n):
            lft, rgt = left(dp[i - 1]), right(dp[i - 1])
            for j in range(m):
                dp[i][j] = max(lft[j], rgt[j]) + points[i][j]


        result = 0
        for j in range(m):
            result = max(result, dp[-1][j])

        return result


print(Solution().maxPoints([[1, 2, 3], [1, 5, 1], [3, 1, 1]]))
