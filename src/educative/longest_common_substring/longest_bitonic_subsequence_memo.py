def find_LBS_length(nums):
    maxLength = 0
    n = len(nums)
    memo = [[-1 for _ in range(n + 1)] for _ in range(n)]
    memoR = [[-1 for _ in range(n + 1)] for _ in range(n)]

    for i in range(n):
        fwd = find_LDS_length(nums, memo, i, -1)
        bwd = find_LDS_length_rev(nums, memoR, i, -1)
        maxLength = max(maxLength, fwd + bwd - 1)
    return maxLength


def find_LDS_length(nums, memo, currentIndex, previousIndex):
    if currentIndex == len(nums):
        return 0

    if memo[currentIndex][previousIndex + 1] == -1:

        c1 = 0
        if previousIndex == -1 or nums[currentIndex] < nums[previousIndex]:
            c1 = 1 + find_LDS_length(nums, memo, currentIndex + 1, currentIndex)

        c2 = find_LDS_length(nums, memo, currentIndex + 1, previousIndex)
        memo[currentIndex][previousIndex + 1] = max(c1, c2)

    return memo[currentIndex][previousIndex + 1]


def find_LDS_length_rev(nums, memo, currentIndex, previousIndex):
    if currentIndex < 0:
        return 0

    if memo[currentIndex][previousIndex + 1] == -1:
        c1 = 0
        if previousIndex == -1 or nums[currentIndex] < nums[previousIndex]:
            c1 = 1 + find_LDS_length_rev(nums, memo, currentIndex - 1, currentIndex)

        c2 = find_LDS_length_rev(nums, memo, currentIndex - 1, previousIndex)
        memo[currentIndex][previousIndex + 1] = max(c1, c2)

    return memo[currentIndex][previousIndex + 1]


def main():
    print(find_LBS_length([4, 2, 3, 6, 10, 1, 12]))
    print(find_LBS_length([4, 2, 5, 9, 7, 6, 10, 3, 1]))


if __name__ == '__main__':
    main()
