class Solution:
    def permute(self, nums):
        perms = []
        self.permute_rec(nums, perms, [])
        return perms

    def permute_rec(self, nums, perms, perm):
        if len(perm) == len(nums):
            perms.append(list(perm))

        for i in range(len(nums)):

            if nums[i] in perm:
                continue

            perm.append(nums[i])
            self.permute_rec(nums, perms, perm)
            perm.pop()


def main():
    print("Here is the list of permutations: " + str(Solution().permute([1, 2, 3])))
    print("Here is the list of permutations: " + str(Solution().permute([0, 1])))
    print("Here is the list of permutations: " + str(Solution().permute([1])))


main()
