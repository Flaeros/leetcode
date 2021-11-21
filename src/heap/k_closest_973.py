import heapq


# calculate distance of the point
# put element into heap
# remove farthest elements until k is left

# return k elements

class Solution(object):
    def kClosest(self, points, k):

        heap = []

        for (x, y) in points:
            distance = -(x * x + y * y)

            heapq.heappush(heap, (distance, x, y))

            while len(heap) > k:
                heapq.heappop(heap)

        return [[x, y] for (dist, x, y) in heap]


print(Solution().kClosest([[3, 3], [5, -1], [-2, 4]], 2))
print(Solution().kClosest([[1, 3], [3, 4], [2, -1]], 2))
