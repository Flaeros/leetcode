from typing import List


# from end

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:

        next_empty = len(nums1) - 1
        i = m - 1
        j = n - 1

        while j >= 0:
            if i < 0 or nums1[i] <= nums2[j]:
                nums1[next_empty] = nums2[j]
                j -= 1
            else:
                nums1[next_empty] = nums1[i]
                i -= 1

            next_empty -= 1

nums_ = nums1 = [1, 2, 3, 0, 0, 0]
Solution().merge(nums_, m=3, nums2=[2, 5, 6], n=3)
print(nums_)

nums_ = [2, 0]
Solution().merge(nums_, m=1, nums2=[1], n=1)
print(nums_)

nums_ = [4, 0, 0, 0, 0, 0]
Solution().merge(nums_, m=1, nums2=[1, 2, 3, 5, 6], n=5)
print(nums_)
