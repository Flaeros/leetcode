# exclude/include
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets = []
        self.find_subsets_rec(nums, subsets, [], 0)
        subsets.append([])
        return subsets

    def find_subsets_rec(self, nums, subsets, subset, index):
        if len(nums) <= index:
            return

        # exclude
        self.find_subsets_rec(nums, subsets, subset, index + 1)

        # include
        subset.append(nums[index])
        subsets.append(subset.copy())
        self.find_subsets_rec(nums, subsets, subset, index + 1)
        subset.pop()


def main():
    print("Here is the list of subsets: " + str(Solution().subsets([1, 3])))
    print("Here is the list of subsets: " + str(Solution().subsets([1, 5, 3])))


main()
