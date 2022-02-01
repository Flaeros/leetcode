# sort nlogn -> start
# i   -> start1, end1
# i+1 -> start2 > end1 --> new interval, reset vars
#      -> start2 < end1 -> max(end1,end2) continue
# last_end, next_start
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) < 2:
            return intervals

        merged = []

        intervals = sorted(intervals, key=lambda x: x[0])

        last_start = intervals[0][0]
        last_end = intervals[0][1]

        for i in range(1, len(intervals)):
            next_start = intervals[i][0]
            next_end = intervals[i][1]

            if next_start > last_end:
                merged.append([last_start, last_end])
                last_start = next_start
                last_end = next_end
            else:
                last_end = max(last_end, next_end)

        merged.append([last_start, last_end])

        return merged


def main():
    print(Solution().merge([[1, 4], [2, 5], [7, 9]]))
    print()

    print(Solution().merge([[6, 7], [2, 4], [5, 9]]))
    print()

    print(Solution().merge([[1, 4], [2, 6], [3, 5]]))
    print()

    print(Solution().merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
    print()

    print(Solution().merge([[1,4],[4,5]]))
    print()


main()
