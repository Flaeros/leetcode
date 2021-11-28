def count_ways(n):
    dp = [0 for _ in range(n + 1)]

    dp[0] = 1
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2

    for i in range(4, n + 1):
        dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4]

    return dp[n]


def main():
    print(count_ways(4))
    print(count_ways(5))
    print(count_ways(6))


if __name__ == '__main__':
    main()
