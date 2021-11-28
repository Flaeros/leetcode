def find_LIS_length(nums):
    n = len(nums)
    dp = [1 for _ in range(n)]

    max_length = 1
    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j] and dp[i] <= dp[j]:
                dp[i] = dp[j] + 1
                max_length = max(max_length, dp[i])

    return max_length


def main():
    print(find_LIS_length([4, 2, 3, 6, 10, 1, 12]))
    print(find_LIS_length([-4, 10, 3, 7, 15]))


if __name__ == '__main__':
    main()
