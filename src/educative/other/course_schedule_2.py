from collections import deque


class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        incoming = {i: 0 for i in range(numCourses)}
        adjacency = {i: [] for i in range(numCourses)}

        for edge in prerequisites:
            child, parent = edge[0], edge[1]
            incoming[child] += 1
            adjacency[parent].append(child)

        sources = deque()
        for key in incoming:
            if incoming[key] == 0:
                sources.append(key)

        if not sources:
            return []

        sorted_order = []
        while sources:
            parent = sources.popleft()
            sorted_order.append(parent)
            for child in adjacency[parent]:
                incoming[child] -= 1
                if incoming[child] == 0:
                    sources.append(child)

        return sorted_order if len(sorted_order) == numCourses else []


print(Solution().findOrder(2, []))
print(Solution().findOrder(2, [[1, 0]]))
print(Solution().findOrder(4, [[1, 0], [2, 0], [3, 1], [3, 2]]))
print(Solution().findOrder(1, []))
print(Solution().findOrder(3, [[1, 0]]))
print(Solution().findOrder(3, [[1, 0], [1, 2], [0, 1]]))
