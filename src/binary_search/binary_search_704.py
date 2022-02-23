class Solution(object):
    def search(self, nums, target):
        start, end = 0, len(nums) - 1
        while start <= end:
            middle = start + (end-start) // 2
            if nums[middle] < target:
                start = middle + 1
            elif nums[middle] > target:
                end = middle - 1
            else:
                return middle
        return -1


print(Solution().search(nums=[5], target=5))
print(Solution().search(nums=[2, 3], target=3))
print(Solution().search(nums=[-1, 0, 3, 5, 9, 12], target=9))
print(Solution().search(nums=[-1, 0, 3, 9, 12], target=9))
print(Solution().search(nums=[-1, 0, 3, 5, 9, 12], target=2))
