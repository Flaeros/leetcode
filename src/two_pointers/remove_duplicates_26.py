class Solution(object):
    def removeDuplicates(self, nums):
        next_non_duplicate = 0

        for i in range(1, len(nums)):
            if nums[next_non_duplicate] != nums[i]:
                next_non_duplicate += 1
                nums[next_non_duplicate] = nums[i]

        return next_non_duplicate + 1


print(Solution().removeDuplicates([2, 3, 3, 3, 6, 9, 9]))
print(Solution().removeDuplicates([2, 2, 2, 11]))
