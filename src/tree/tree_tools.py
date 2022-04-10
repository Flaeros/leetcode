# Definition for a Node.
class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


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
