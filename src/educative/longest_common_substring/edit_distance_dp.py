def find_min_operations(s1, s2):
    n1 = len(s1)
    n2 = len(s2)
    dp = [[-1 for _ in range(n2 + 1)] for _ in range(n1 + 1)]

    for i in range(n1 + 1):
        dp[i][0] = i

    for j in range(n2 + 1):
        dp[0][j] = j

    for i in range(1, n1 + 1):
        for j in range(1, n2 + 1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = dp[i - 1][j - 1]
            else:
                dp[i][j] = 1 + min(dp[i - 1][j - 1],
                                   dp[i - 1][j],
                                   dp[i][j - 1])
    return dp[n1][n2]


def main():
    print(find_min_operations("bat", "but"))
    print(find_min_operations("abdca", "cbda"))
    print(find_min_operations("passpot", "ppsspqrt"))


main()
