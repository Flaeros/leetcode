def find_minimum_deletions(nums):
    n = len(nums)
    dp = [1 for _ in range(n)]

    lis = 1
    for i in range(n):
        for j in range(i):
            if nums[i] > nums[j] and dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1
                lis = max(lis, dp[i])

    return len(nums) - lis


def main():
    print(find_minimum_deletions([4, 2, 3, 6, 10, 1, 12]))
    print(find_minimum_deletions([-4, 10, 3, 7, 15]))
    print(find_minimum_deletions([3, 2, 1, 0]))


if __name__ == '__main__':
    main()
