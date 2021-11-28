def find_LIS_length(nums):
    n = len(nums)
    memo = [[-1 for _ in range(n)] for _ in range(n)]
    return find_LIS_length_rec(nums, memo, 0, -1)


def find_LIS_length_rec(nums, memo, current_index, previous_index):
    if current_index >= len(nums):
        return 0

    if memo[current_index][previous_index] != -1:
        return memo[current_index][ previous_index]

    inclusive, exclusive = 0, 0

    if previous_index == -1 or nums[current_index] > nums[previous_index]:
        inclusive = 1 + find_LIS_length_rec(nums, memo, current_index + 1, current_index)

    exclusive = find_LIS_length_rec(nums, memo, current_index + 1, previous_index)

    memo[current_index][previous_index] = max(inclusive, exclusive)
    return memo[current_index][previous_index]


def main():
    print(find_LIS_length([4, 2, 3, 6, 10, 1, 12]))
    print(find_LIS_length([-4, 10, 3, 7, 15]))


if __name__ == '__main__':
    main()
