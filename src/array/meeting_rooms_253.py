# sort intervals by start
# use min heap with interval end
# if next interval start > previous end, pop
# push next interval end
# return length of the heap

import heapq


class Solution(object):
    def minMeetingRooms(self, intervals):
        intervals.sort(key=lambda x: x[0])

        heap = []

        heapq.heappush(heap, intervals[0][1])

        for i in intervals[1:]:
            if heap[0] <= i[0]:
                heapq.heappop(heap)

            heapq.heappush(heap, i[1])

        return len(heap)


print(2, Solution().minMeetingRooms([[1, 5], [8, 9], [8, 9]]))
print(1, Solution().minMeetingRooms([[13, 15], [1, 13]]))
print(2, Solution().minMeetingRooms([[0, 30], [5, 10], [15, 20]]))
print(1, Solution().minMeetingRooms([[7, 10], [2, 4]]))
