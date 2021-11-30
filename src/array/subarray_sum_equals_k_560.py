# sum += nums[i]
# while sum > k, subtract start from sum, increment start
# if sum == k, increment result, subtract start from sum, increment start

class Solution(object):
    def subarraySum2(self, nums, k):
        result = 0

        for i, num in enumerate(nums):
            sum = 0
            for j in range(i, len(nums)):
                sum += nums[j]
                if sum == k:
                    result += 1

        return result

    def subarraySum(self, nums, k):
        result = 0
        dict = {0: 1}
        sum = 0

        for num in nums:
            sum += num

            if sum - k in dict:
                result += dict[sum - k]

            dict[sum] = dict.get(sum, 0) + 1

        return result


print(Solution().subarraySum([-1, -1, 1], 1))
print(Solution().subarraySum([1, 1, 1], 2))
print(Solution().subarraySum([1, 2, 3], 3))
