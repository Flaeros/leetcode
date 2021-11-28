def find_minimum_deletions(nums):
    memo = {}
    lis = find_minimum_deletions_rec(nums, memo, -1, 0, 0)
    return len(nums) - lis


def find_minimum_deletions_rec(nums, memo, prev, current, length):
    if current == len(nums):
        return length

    key = str(prev) + '-' + str(current) + '-' + str(length)
    if key in memo:
        return memo.get(key)

    inclusive = length
    if nums[current] > nums[prev] or prev == -1:
        inclusive = find_minimum_deletions_rec(nums, memo, current, current + 1, length + 1)

    exclusive = find_minimum_deletions_rec(nums, memo, prev, current + 1, length)

    memo[key] = max(inclusive, exclusive)
    return memo.get(key)


def main():
    print(find_minimum_deletions([4, 2, 3, 6, 10, 1, 12]))
    print(find_minimum_deletions([-4, 10, 3, 7, 15]))
    print(find_minimum_deletions([3, 2, 1, 0]))


if __name__ == '__main__':
    main()
