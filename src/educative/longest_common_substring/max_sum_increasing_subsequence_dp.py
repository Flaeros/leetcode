def find_MSIS(nums):
    n = len(nums)
    dp = [i for i in nums]
    max_sum = nums[0]

    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j] and dp[i] < dp[j] + nums[i]:
                dp[i] = dp[j] + nums[i]

        max_sum = max(max_sum, dp[i])

    return max_sum


def main():
    print(find_MSIS([4, 1, 2, 6, 10, 1, 12]))
    print(find_MSIS([-4, 10, 3, 7, 15]))


if __name__ == '__main__':
    main()
