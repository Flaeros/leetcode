def count_subsets(num, sum1):
    dp = [[-1 for x in range(sum1 + 1)] for y in range(len(num))]
    return count_subsets_rec(dp, num, sum1, 0)


def count_subsets_rec(dp, num, target_sum, index):
    if target_sum == 0:
        return 1

    n = len(num)
    if n == 0 or index >= n:
        return 0

    if dp[index][target_sum] != -1:
        sum1 = 0
        if num[index] <= target_sum:
            sum1 = count_subsets_rec(dp, num, target_sum - num[index], index + 1)

        sum2 = count_subsets_rec(dp, num, target_sum, index + 1)
        dp[index][target_sum] = sum1 + sum2

    return dp[index][target_sum]


def main():
    print(count_subsets([1, 1, 2, 3], 4))
    print(count_subsets([1, 2, 7, 1, 5], 9))


if __name__ == '__main__':
    main()
