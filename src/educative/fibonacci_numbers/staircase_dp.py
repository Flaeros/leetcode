def count_ways(n):
    dp = [0 for _ in range(n + 1)]
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2

    for i in range(3, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

    return dp[n]


def main():
    print(count_ways(3))
    print(count_ways(4))
    print(count_ways(5))


if __name__ == '__main__':
    main()
