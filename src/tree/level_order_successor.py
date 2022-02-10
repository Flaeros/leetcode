from collections import deque


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


def find_successor(root, key):
    if root is None:
        return None
    q = deque()

    q.appendleft(root)
    found = False
    while q:
        node = q.pop()
        if found:
            return node
        if node.val == key:
            found = True

        if node.left:
            q.appendleft(node.left)
        if node.right:
            q.appendleft(node.right)

    return None


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(9)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    result = find_successor(root, 12)
    if result:
        print(result.val)
    result = find_successor(root, 9)
    if result:
        print(result.val)


main()
