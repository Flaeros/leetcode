from collections import deque


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


def find_minimum_depth(root):
    q = deque()

    q.append(root)

    level = 0
    while q:
        level_size = len(q)
        for _ in range(level_size):

            node = q.popleft()

            if node.left:
                q.append(node.left)

            if node.right:
                q.append(node.right)

            if node.left is None and node.right is None:
                return level
        level += 1

    return -1


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    print("Tree Minimum Depth: " + str(find_minimum_depth(root)))
    root.left.left = TreeNode(9)
    root.right.left.left = TreeNode(11)
    print("Tree Minimum Depth: " + str(find_minimum_depth(root)))


main()
