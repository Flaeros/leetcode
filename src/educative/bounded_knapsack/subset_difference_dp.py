def can_partition(num):
    n = len(num)
    if n == 0:
        return 0

    num_sum = sum(num)

    s2 = int(num_sum / 2)

    dp = [[False for x in range(s2 + 1)] for y in range(n)]

    for i in range(0, n):
        dp[i][0] = False

    for j in range(1, s2 + 1):
        dp[0][j] = j == num[0]

    for i in range(1, n):
        for j in range(1, s2 + 1):
            if dp[i - 1][j]:
                dp[i][j] = dp[i - 1][j]
            elif num[i] <= j:
                dp[i][j] = dp[i - 1][j - num[i]]

    sum1 = 0

    for i in range(s2, -1, -1):
        if dp[n - 1][i]:
            sum1 = i
            break

    sum2 = num_sum - sum1

    return abs(sum1 - sum2)


def main():
    print("Can partition: " + str(can_partition([1, 2, 3, 9])))
    print("Can partition: " + str(can_partition([1, 2, 7, 1, 5])))
    print("Can partition: " + str(can_partition([1, 3, 100, 4])))


if __name__ == '__main__':
    main()
