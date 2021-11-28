def count_subsets(num, sum1):
    n = len(num)

    dp = [[-1 for x in range(sum1 + 1)] for y in range(n)]

    for i in range(n):
        dp[i][0] = 1

    for j in range(1, sum1 + 1):
        dp[0][j] = 1 if num[0] == j else 0

    for i in range(1, n):
        for j in range(1, sum1 + 1):
            dp[i][j] = dp[i - 1][j]

            if sum1 >= num[i]:
                dp[i][j] += dp[i - 1][j - num[i]]

    return dp[n - 1][sum1]


def main():
    print(count_subsets([1, 1, 2, 3], 4))
    print(count_subsets([1, 2, 7, 1, 5], 9))


if __name__ == '__main__':
    main()
