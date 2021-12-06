# find pair of two adjacent digits, left and right where left < right, swap them
# sort digits to the right of them in ascending order
# if there are no such left/right digits, meaning all digits are in descending order, sort all of them.

class Solution(object):
    def nextPermutation(self, nums):
        n = len(nums)
        if n < 2:
            return

        index = n - 2
        while index >= 0:
            if nums[index] < nums[index + 1]:
                break
            index -= 1

        if index >= n - 1:
            return

        index_to_swap = 0
        if index >= 0:
            for i in range(n - 1, index, -1):
                if nums[i] > nums[index]:
                    index_to_swap = i
                    break

            nums[index], nums[index_to_swap] = nums[index_to_swap], nums[index]

        left, right = index + 1, n - 1

        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1


s = Solution()

current = [3, 2, 1]
s.nextPermutation(current)
print(current)

current = [1, 3, 2]
s.nextPermutation(current)
print(current)

current = [1, 2, 3]
s.nextPermutation(current)
print(current)

current = [1, 1, 5]
s.nextPermutation(current)
print(current)

current = [1]
s.nextPermutation(current)
print(current)

current = [1, 2, 3, 2, 1]
s.nextPermutation(current)
print(current)

current = [1, 2, 3, 1, 2]
s.nextPermutation(current)
print(current)
