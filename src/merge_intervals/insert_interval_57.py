# 1. sorted - done
# 2. insert by start time O(N)
# 3. merge O(N)
from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], new_interval: List[int]) -> List[List[int]]:
        if len(intervals) == 0:
            return [new_interval]
        merged = []

        i, start, end = 0, 0, 1

        while i < len(intervals) and intervals[i][end] < new_interval[start]:
            merged.append(intervals[i])
            i += 1

        while i < len(intervals) and intervals[i][start] <= new_interval[end]:
            new_interval[start] = min(intervals[i][start], new_interval[start])
            new_interval[end] = max(intervals[i][end], new_interval[end])
            i += 1

        merged.append(new_interval)

        while i < len(intervals):
            merged.append(intervals[i])
            i += 1

        return merged


def main():
    print("Intervals after inserting the new interval: " + str(Solution().insert([[1, 5]], [2, 7])))
    print("Intervals after inserting the new interval: " + str(Solution().insert([[1, 3], [5, 7], [8, 12]], [4, 6])))
    print("Intervals after inserting the new interval: " + str(Solution().insert([[1, 3], [5, 7], [8, 12]], [4, 10])))
    print("Intervals after inserting the new interval: " + str(Solution().insert([[2, 3], [5, 7]], [1, 4])))
    print("Intervals after inserting the new interval: " + str(Solution().insert([], [1, 4])))


main()
