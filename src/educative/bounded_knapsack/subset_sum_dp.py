def can_partition(num, sum):
    if sum == 0:
        return True

    if sum < 0:
        return False

    n = len(num)

    dp = [[False for x in range(sum + 1)] for y in range(n)]

    for i in range(0, n):
        dp[i][0] = True

    for j in range(1, sum + 1):
        dp[0][j] = num[0] == j

    for i in range(1, n):
        for j in range(1, sum + 1):
            if dp[i - 1][sum]:
                dp[i][j] = dp[i - 1][sum]
            elif j >= num[i]:
                dp[i][j] = dp[i - 1][j - num[i]]

    return dp[n - 1][sum]


def main():
    print(can_partition([1, 2, 3, 7], 6))
    print(can_partition([1, 2, 7, 1, 5], 10))
    print(can_partition([1, 3, 4, 8], 6))


if __name__ == '__main__':
    main()
