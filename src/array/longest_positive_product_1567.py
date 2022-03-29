class Solution:

    # if positive, positive ++
    # if negative, swap positive and negative, ++
    # if 0, reset

    def getMaxLen(self, nums):

        n = len(nums)

        positive = 0
        negative = 0
        result = 0
        for i in range(n):
            if nums[i] == 0:
                positive = 0
                negative = 0
            elif nums[i] > 0:
                positive += 1
                if negative > 0:
                    negative += 1
            else:
                positive, negative = 0 if negative == 0 else negative + 1, positive + 1
            result = max(result, positive)

        return result


print(Solution().getMaxLen([1, -2, -3, 4]))  # 4
print(Solution().getMaxLen([0, 1, -2, -3, -4]))  # 3
print(Solution().getMaxLen([-1, -2, -3, 0, 1]))  # 2
