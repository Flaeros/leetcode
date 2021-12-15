# Definition for a binary tree node.
from typing import Optional


# recursively, from bottom to top, count maximum depth from both sides
# left depth, right depth, diameter at node
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def helper(node):
            nonlocal max_height
            if not node:
                return 0
            left = helper(node.left)
            right = helper(node.right)
            max_height = max(max_height, left + right)
            return 1 + max(left, right)

        max_height = 0
        helper(root)

        return max_height


def tree_from_array(arr):
    return tree_from_parent(arr, 0, None)


def tree_from_parent(arr, index, parent):
    if index >= len(arr) or arr[index] is None:
        return None

    node = TreeNode(arr[index])
    node.parent = parent
    node.left = tree_from_parent(arr, index * 2 + 1, node)
    node.right = tree_from_parent(arr, index * 2 + 2, node)
    return node


root: TreeNode = tree_from_array([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4])
print(Solution().diameterOfBinaryTree(root))

root: TreeNode = tree_from_array([1, 2, 3, 4, 5, None, None])
print(Solution().diameterOfBinaryTree(root))
