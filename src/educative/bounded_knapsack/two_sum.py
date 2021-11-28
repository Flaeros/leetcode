# This is a sample Python script.

# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.
from typing import List


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press ⌘F8 to toggle the breakpoint.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map = {num: i for i, num in enumerate(nums)}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in nums_map and nums_map[diff] != i:
                return [i, nums_map[diff]]




if __name__ == '__main__':
    print(Solution().twoSum([2,7,11,15], 9))
    print(Solution().twoSum([3,2,4], 6))
    print(Solution().twoSum([3,3], 6))