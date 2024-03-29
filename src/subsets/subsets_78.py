from typing import List


#discuss all subset/perm/comb examples
#https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets = []
        self.find_subsets_rec(nums, subsets, [], 0)
        return subsets

    def find_subsets_rec(self, nums, subsets, subset, index):
        subsets.append(subset.copy())

        for i in range(index, len(nums)):
            subset.append(nums[i])
            self.find_subsets_rec(nums, subsets, subset, i + 1)
            subset.pop()


def main():
    print("Here is the list of subsets: " + str(Solution().subsets([1, 3])))
    print("Here is the list of subsets: " + str(Solution().subsets([1, 5, 3])))


main()
