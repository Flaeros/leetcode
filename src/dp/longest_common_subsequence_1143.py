# dp 2-dim
# dp[i][j] - lcs
# dp[i][j] = i==j -> 1 + dp[i-1][j-1]
#            i!=j -> max(dp[i-1][j], dp[i][j-1])

# init: 0, index + 1


class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        n1 = len(text1)
        n2 = len(text2)

        dp = [[0 for _ in range(n2 + 1)] for _ in range(n1 + 1)]

        for i in range(1, n1 + 1):
            for j in range(1, n2 + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return dp[n1][n2]


print(Solution().longestCommonSubsequence("abcde", "ace"))
print(Solution().longestCommonSubsequence("abc", "abc"))
print(Solution().longestCommonSubsequence("abc", "def"))
