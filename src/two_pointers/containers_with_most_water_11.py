# two pointers
# sliding window
# dp
# n^2
#


class Solution(object):
    def maxArea(self, height):
        left, right = 0, len(height) - 1
        max_volume = 0

        while left < right:
            volume = (right - left) * min(height[left], height[right])
            max_volume = max(volume, max_volume)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return max_volume


print(Solution().maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))
print(Solution().maxArea([1, 1]))
print(Solution().maxArea([4, 3, 2, 1, 4]))
