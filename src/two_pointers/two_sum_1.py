class Solution(object):
    def twoSum2(self, nums, target):
        nums = sorted(nums)
        left, right = 0, len(nums) - 1

        while left < right:
            if nums[left] + nums[right] == target:
                return [left, right]
            elif nums[left] + nums[right] > target:
                right -= 1
            else:
                left += 1

        return []

    def twoSum(self, nums, target):

        numsd = {}

        for i, num in enumerate(nums):
            if target - num in numsd:
                return [numsd[target - num], i]
            else:
                numsd[num] = i

        return []


print(Solution().twoSum([1, 2, 3, 4, 6], 6))
print(Solution().twoSum([1, 2, 3, 4, 6], 6))
print(Solution().twoSum([2, 5, 9, 11], 11))
