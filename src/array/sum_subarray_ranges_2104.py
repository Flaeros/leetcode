class Solution:
    # n^2
    def subArrayRanges(self, nums):
        result = 0
        n = len(nums)
        for i in range(n):
            l, r = nums[i], nums[i]
            for j in range(i, n):
                l = min(nums[j], l)
                r = max(nums[j], r)
                result += r - l

        return result


print(Solution().subArrayRanges([1, 2, 3]))  # 4
print(Solution().subArrayRanges([1, 3, 3]))  # 4
print(Solution().subArrayRanges([4, -2, -3, 4, 1]))  # 59