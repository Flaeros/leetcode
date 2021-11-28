def find_LBS_length(nums):
    n = len(nums)

    lds = [1 for _ in range(n)]
    lds_rev = [1 for _ in range(n)]

    for i in range(n):
        for j in range(i - 1, -1, -1):
            if nums[j] < nums[i]:
                lds[i] = max(lds[i], lds[j] + 1)

    for i in range(n - 1, -1, -1):
        for j in range(i + 1, n):
            if nums[j] < nums[i]:
                lds_rev[i] = max(lds_rev[i], lds_rev[j] + 1)

    max_len = 0
    for i in range(n):
        max_len = max(max_len, lds[i] + lds_rev[i] - 1)

    return max_len


def main():
    print(find_LBS_length([4, 2, 3, 6, 10, 1, 12]))
    print(find_LBS_length([4, 2, 5, 9, 7, 6, 10, 3, 1]))


if __name__ == '__main__':
    main()
