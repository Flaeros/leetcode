class Solution(object):
    def minSubArrayLen(self, target, nums):
        window_start = 0
        window_sum = 0
        result = float('inf')

        for window_end in range(len(nums)):
            window_sum += nums[window_end]

            while window_sum >= target:
                result = min(result, window_end - window_start + 1)
                window_sum -= nums[window_start]
                window_start += 1

        return 0 if result == float('inf') else result


print(Solution().minSubArrayLen(7, [2, 1, 5, 2, 8]))
