from tree_tools import *
from collections import defaultdict, deque


class Solution:
    def verticalOrder(self, root):

        queue = deque([(root, 0)])
        columns = defaultdict(list)

        while queue:
            node, column = queue.popleft()

            if node:
                columns[column].append(node.val)

                queue.append((node.left, column - 1))
                queue.append((node.right, column + 1))

        keys = sorted(columns.keys())
        result = []

        for key in keys:
            result.append(columns[key])

        return result


root = tree_from_array([3, 9, 20, None, None, 15, 7])
print(Solution().verticalOrder(root))
