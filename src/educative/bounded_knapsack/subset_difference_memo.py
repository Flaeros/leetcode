def can_partition(num):
    n = len(num)
    if n == 0:
        return 0
    num_sum = sum(num)
    dp = [[-1 for x in range(num_sum + 1)] for y in range(n)]

    return can_partition_rec(num, num_sum, dp, 0, 0)


def can_partition_rec(num, sum, dp, index, s):
    # print(f'index={index} s={s}')
    if index >= len(num):
        return abs(s - (sum - s))

    if dp[index][s] != -1:
        return dp[index][s]

    include = can_partition_rec(num, sum, dp, index + 1, s + num[index])
    exclude = can_partition_rec(num, sum, dp, index + 1, s)

    dp[index][s] = min(include, exclude)

    return dp[index][s]


def main():
    print("Can partition: " + str(can_partition([1, 2, 3, 9])))
    print("Can partition: " + str(can_partition([1, 2, 7, 1, 5])))
    print("Can partition: " + str(can_partition([1, 3, 100, 4])))


if __name__ == '__main__':
    main()
