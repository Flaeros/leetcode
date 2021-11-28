def find_LAS_length(nums):
    n = len(nums)
    memo = [[[-1 for _ in range(2)] for _ in range(n)] for _ in range(n)]
    return max(find_LAS_length_rec(nums, memo, -1, 0, True),
               find_LAS_length_rec(nums, memo, -1, 0, False))


def find_LAS_length_rec(nums, memo, prev, current, is_asc):
    if current == len(nums):
        return 0

    asc_index = 1 if is_asc else 0
    if memo[prev + 1][current][asc_index] != -1:
        return memo[prev + 1][current][asc_index]

    s1 = 0
    if is_asc:
        if prev == -1 or nums[prev] < nums[current]:
            s1 = 1 + find_LAS_length_rec(nums, memo, current, current + 1, not is_asc)
    else:
        if prev == -1 or nums[prev] > nums[current]:
            s1 = 1 + find_LAS_length_rec(nums, memo, current, current + 1, not is_asc)

    s2 = find_LAS_length_rec(nums, memo, prev, current + 1, is_asc)

    memo[prev + 1][current][asc_index] = max(s1, s2)
    return memo[prev + 1][current][asc_index]


def main():
    print(find_LAS_length([1, 2, 3, 4]))
    print(find_LAS_length([3, 2, 1, 4]))
    print(find_LAS_length([1, 3, 2, 4]))


if __name__ == '__main__':
    main()
