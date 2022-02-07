from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        i, n = 0, len(nums)
        while i < n:
            j = nums[i]

            if nums[i] < n and nums[i] != nums[j]:
                nums[i], nums[j] = nums[j], nums[i]
            else:
                i += 1

        for i in range(n):
            if i != nums[i]:
                return i

        return n


print(Solution().missingNumber([4, 0, 3, 1]))
print(Solution().missingNumber([8, 3, 5, 2, 4, 6, 0, 1]))
