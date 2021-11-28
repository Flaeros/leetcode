def can_partition(num):
    s = sum(num)
    if s % 2 != 0:
        return False

    s = int(s / 2)

    n = len(num)

    dp = [[False for x in range(s + 1)] for y in range(n)]

    for i in range(0, n):
        dp[i][0] = True

    for j in range(0, s + 1):
        dp[0][j] = j == num[0]

    for i in range(1, n):
        for j in range(1, s + 1):
            if dp[i - 1][j]:
                dp[i][j] = dp[i - 1][j]
            elif dp[i - 1][j - num[i]]:
                dp[i][j] = dp[i - 1][j - num[i]]

    return dp[n - 1][s]


def main():
    print(can_partition([1, 1, 3, 4, 7]))
    print(can_partition([2, 3, 4, 6]))


if __name__ == '__main__':
    main()
