# start1 < end2 and start2 < end1
# [max(start1, start2), min(end1, end2]]
from typing import List


class Solution:
    def intervalIntersection(self, intervals_a: List[List[int]], intervals_b: List[List[int]]) -> List[List[int]]:

        result = []

        a, b = 0, 0
        start, end = 0, 1

        while a < len(intervals_a) and b < len(intervals_b):
            start_a, end_a = intervals_a[a][start], intervals_a[a][end]
            start_b, end_b = intervals_b[b][start], intervals_b[b][end]

            if start_a <= end_b and start_b <= end_a:
                result.append([max(start_a, start_b), min(end_a, end_b)])

            if end_a < end_b:
                a += 1
            else:
                b += 1

        return result


def main():
    print("Intervals Intersection: " + str(Solution().intervalIntersection([[1, 3], [5, 6], [7, 9]], [[2, 3], [5, 7]])))
    print("Intervals Intersection: " + str(Solution().intervalIntersection([[1, 3], [5, 7], [9, 12]], [[5, 10]])))
    print("Intervals Intersection: " + str(
        Solution().intervalIntersection(intervals_a=[[0, 2], [5, 10], [13, 23], [24, 25]],
                                        intervals_b=[[1, 5], [8, 12], [15, 24], [25, 26]])))


main()
