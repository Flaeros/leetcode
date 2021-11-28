def find_MSIS(nums):
    memo = {}
    return find_MSIS_rec(nums, memo, 0, 0, 0)


def find_MSIS_rec(nums, memo, prev, current, sum):
    if current >= len(nums):
        return sum

    key = str(current) + "-" + str(prev) + "-" + str(sum)

    if key in memo:
        return memo.get(key)

    exclusive = find_MSIS_rec(nums, memo, prev, current + 1, sum)

    inclusive = 0
    if nums[current] > nums[prev] or current == 0:
        inclusive = find_MSIS_rec(nums, memo, current, current + 1, nums[current] + sum)

    memo[key] = max(exclusive, inclusive, sum)

    return memo.get(key)


def main():
    print(find_MSIS([4, 1, 2, 6, 10, 1, 12]))
    print(find_MSIS([-4, 10, 3, 7, 15]))


if __name__ == '__main__':
    main()
