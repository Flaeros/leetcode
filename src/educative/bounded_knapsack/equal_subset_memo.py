def can_partition(num):
    s = sum(num)
    if s % 2 == 0:
        return False

    dp = [[-1 for x in range(int(s / 2) + 1)] for y in range(len(num))]

    result = can_partition_rec(num, dp, 0, int(s / 2))
    return True if result == 1 else False


def can_partition_rec(num, dp, index, sum):
    # print(f'left: {left} right: {right}')
    if sum == 0:
        return 1

    n = len(num)
    if n == 0 or index >= n:
        return 0

    if dp[index][sum] == -1:
        if num[index] <= sum:
            if can_partition_rec(num, dp, index + 1, sum - num[index]) == 1:
                dp[index][sum] = 1
                return 1

    dp[index][sum] = can_partition_rec(num, dp, index + 1, sum)

    return dp[index][sum]


def main():
    print(can_partition([1, 1, 3, 4, 7]))
    print(can_partition([2, 3, 4, 6]))


if __name__ == '__main__':
    main()
