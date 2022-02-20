class Solution:
    def permute_unique(self, nums):
        nums.sort()
        perms = []
        self.permute_unique_rec(nums, perms, [], [False for _ in range(len(nums))])
        return perms

    def permute_unique_rec(self, nums, perms, perm, used):
        if len(perm) == len(nums):
            perms.append(list(perm))

        for i in range(len(nums)):

            if used[i] or (i != 0 and nums[i] == nums[i - 1] and not used[i - 1]):
                continue

            perm.append(nums[i])
            used[i] = True
            self.permute_unique_rec(nums, perms, perm, used)
            perm.pop()
            used[i] = False


def main():
    print("Here is the list of permutations: " + str(Solution().permute_unique([1, 1, 2])))
    print("Here is the list of permutations: " + str(Solution().permute_unique([1, 2, 3])))


main()
