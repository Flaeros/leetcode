from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        squares = []
    
        left = 0
        zero_closest = nums[0]
    
        for i, num in enumerate(nums):
            if abs(zero_closest) > abs(num):
                zero_closest = abs(num)
                left = i
    
        right = left + 1
    
        while left >= 0 or right < len(nums):
    
            if right >= len(nums):
                next_square = nums[left]
                left -= 1
            elif left < 0:
                next_square = nums[right]
                right += 1
            else:
                if abs(nums[left]) > abs(nums[right]):
                    next_square = nums[right]
                    right += 1
                else:
                    next_square = nums[left]
                    left -= 1
    
            squares.append(next_square ** 2)
    
        return squares


print(Solution().sortedSquares([-2, -1, 0, 2, 3]))
print(Solution().sortedSquares([-3, -1, 0, 1, 2]))
print(Solution().sortedSquares([-2, -1, 0]))
print(Solution().sortedSquares([0, 1, 2]))
