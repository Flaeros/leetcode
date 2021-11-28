def find_LAS_length(nums):
    n = len(nums)

    dp = [[0 for _ in range(2)] for _ in range(n)]

    max_length = 1

    for i in range(n):
        dp[i][0] = dp[i][1] = 1
        for j in range(i):
            if nums[i] > nums[j]:
                dp[i][0] = max(dp[i][0], dp[j][1] + 1)
                max_length = max(max_length, dp[i][0])
            elif nums[i] != nums[j]:
                dp[i][1] = max(dp[i][1], dp[j][0] + 1)
                max_length = max(max_length, dp[i][1])

    return max_length


def main():
    print(find_LAS_length([1, 2, 3, 4]))
    print(find_LAS_length([3, 2, 1, 4]))
    print(find_LAS_length([1, 3, 2, 4]))


if __name__ == '__main__':
    main()
