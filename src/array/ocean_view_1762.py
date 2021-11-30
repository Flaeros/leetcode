class Solution(object):
    def findBuildings(self, heights):

        max = 0
        result = []

        for i in range(len(heights) - 1, -1, -1):
            b = heights[i]
            if b > max:
                result.append(i)
                max = b

        return result[::-1]


print(Solution().findBuildings([4, 2, 3, 1]))
print(Solution().findBuildings([4, 3, 2, 1]))
print(Solution().findBuildings([1, 3, 2, 4]))
print(Solution().findBuildings([2, 2, 2, 2]))
