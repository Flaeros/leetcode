from typing import List

class Solution:
    def subsetsWithDup(self, nums):
        nums.sort()
        subsets = []
        self.subsetsWithDupRec(nums, subsets, [], 0)

        return subsets

    def subsetsWithDupRec(self, nums, subsets, subset, index):
        subsets.append(subset.copy())

        for i in range(index, len(nums)):
            if i != index and nums[i - 1] == nums[i]:
                continue

            subset.append(nums[i])
            self.subsetsWithDupRec(nums, subsets, subset, i + 1)
            subset.pop()


def main():
    print("Here is the list of subsets: " + str(Solution().subsetsWithDup([1, 2, 2])))
    print("Here is the list of subsets: " + str(Solution().subsetsWithDup([0])))


main()
