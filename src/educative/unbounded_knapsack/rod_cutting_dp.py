def solve_rod_cutting(lengths, prices, n):
    lenCount = len(lengths)
    if n <= 0 or lenCount == 0 or lenCount != len(prices):
        return -1

    dp = [[0 for x in range(n + 1)] for y in range(lenCount)]

    for i in range(lenCount):
        for length in range(1, n + 1):
            s1, s2 = 0, 0

            if lengths[i] <= length:
                s1 = prices[i] + dp[i][length - lengths[i]]

            if i > 0:
                s2 = dp[i - 1][length]

            dp[i][length] = max(s1, s2)

    return dp[lenCount - 1][n]


def main():
    print(solve_rod_cutting([1, 2, 3, 4, 5], [2, 6, 7, 10, 13], 5))


if __name__ == '__main__':
    main()
