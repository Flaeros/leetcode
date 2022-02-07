def find_duplicate(nums):
    n = len(nums)

    i = 0
    while i < n:
        j = nums[i] - 1
        if nums[i] != nums[j]:
            nums[i], nums[j] = nums[j], nums[i]
        else:
            i += 1

    for i in range(n):
        if nums[i] != i + 1:
            return nums[i]

    return n


print(find_duplicate([1, 4, 4, 3, 2]))
print(find_duplicate([2, 1, 3, 3, 5, 4]))
print(find_duplicate([2, 4, 1, 4, 4]))
