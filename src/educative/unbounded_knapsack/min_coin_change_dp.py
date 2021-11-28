import math


def count_change(denominations, total):
    n = len(denominations)

    if n == 0 or total == 0:
        return 0

    dp = [[math.inf for x in range(total + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = 0

    for i in range(n):
        for j in range(1, total + 1):
            exclusive, inclusive = math.inf, math.inf

            if denominations[i] <= j:
                inclusive = 1 + dp[i][j - denominations[i]]

            if i > 0:
                exclusive = dp[i - 1][j]

            dp[i][j] = min(inclusive, exclusive)

    return -1 if dp[n - 1][total] == math.inf else dp[n - 1][total]


def main():
    print(count_change([1, 2, 3], 5))
    print(count_change([1, 2, 3], 11))
    print(count_change([1, 2, 3], 7))
    print(count_change([3, 5], 7))


if __name__ == '__main__':
    main()
