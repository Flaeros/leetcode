def count_change(den, total):
    n = len(den)

    dp = [[0 for x in range(total + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = 1

    for i in range(n):
        for j in range(1, total + 1):
            inclusive = 0
            if den[i] <= j:
                inclusive = dp[i][j - den[i]]

            exclusive = 0
            if i > 0:
                exclusive = dp[i - 1][j]

            dp[i][j] = inclusive + exclusive

    return dp[n - 1][total]


def main():
    print(count_change([1, 2, 3], 5))


if __name__ == '__main__':
    main()
