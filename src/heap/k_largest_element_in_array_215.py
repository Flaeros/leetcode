import heapq

# use heap
# store in heap k elements
# in the end return the last element in the heap
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for num in nums:
            heapq.heappush(heap, num)

            if len(heap) > k:
                heapq.heappop(heap)

        return heap[0]


print(Solution().findKthLargest(nums=[3, 2, 1, 5, 6, 4], k=2))  # 5
print(Solution().findKthLargest(nums=[3, 2, 3, 1, 2, 4, 5, 5, 6], k=4))  # 4
