def find_min_fee(fee):
    n = len(fee)

    dp = [0 for _ in range(n + 1)]

    dp[0] = 0
    dp[1] = fee[0]
    dp[2] = fee[0]

    for i in range(2, n):
        dp[i + 1] = min(dp[i] + fee[i],
                        dp[i - 1] + fee[i - 1],
                        dp[i - 2] + fee[i - 2])

    return dp[n]


def main():
    print(find_min_fee([1, 2, 5, 2, 1, 2]))
    print(find_min_fee([2, 3, 4, 5]))


if __name__ == '__main__':
    main()
