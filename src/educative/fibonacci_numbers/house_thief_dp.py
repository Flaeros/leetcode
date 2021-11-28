def find_max_steal(wealth):
    n = len(wealth)

    dp = [0 for _ in range(n + 1)]
    dp[0] = 0
    dp[1] = wealth[0]

    for i in range(1, n):
        dp[i + 1] = max(wealth[i] + dp[i - 1], dp[i])

    return dp[n]


def main():
    print(find_max_steal([2, 5, 1, 3, 6, 2, 4]))
    print(find_max_steal([2, 10, 14, 8, 1]))


if __name__ == '__main__':
    main()
