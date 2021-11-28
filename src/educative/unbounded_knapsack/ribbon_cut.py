import math


def count_ribbon_pieces(ribbonLengths, total):
    n = len(ribbonLengths)

    if n == 0 or total == 0:
        return 0

    dp = [[-math.inf for x in range(total + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = 0

    for i in range(n):
        for j in range(1, total + 1):

            if i > 0:
                dp[i][j] = dp[i - 1][j]

            if ribbonLengths[i] <= j and dp[i][j - ribbonLengths[i]] != -math.inf:
                dp[i][j] = max(dp[i][j], 1 + dp[i][j - ribbonLengths[i]])

    return -1 if dp[n - 1][total] == -math.inf else dp[n - 1][total]


def main():
    print(count_ribbon_pieces([2, 3, 5], 5))
    print(count_ribbon_pieces([2, 3], 7))
    print(count_ribbon_pieces([3, 5, 7], 13))
    print(count_ribbon_pieces([3, 5], 7))


if __name__ == '__main__':
    main()
