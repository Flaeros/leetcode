def cyclic_sort(nums):
    i = 0
    while i < len(nums):
        index_to_be = nums[i] - 1
        if nums[index_to_be] != nums[i]:
            nums[index_to_be], nums[i] = nums[i], nums[index_to_be]
        else:
            i += 1

    return nums


print(cyclic_sort([1, 5, 6, 4, 3, 2]))
print(cyclic_sort([3, 1, 5, 4, 2]))
print(cyclic_sort([2, 6, 4, 3, 1, 5]))
