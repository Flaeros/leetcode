# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# init first, last
# in-order traversal
# link nodes by travelling right, everytime with last

class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        def in_order(node):
            nonlocal first, last
            if node:
                in_order(node.left)
                if last:
                    last.right = node
                    node.left = last
                else:
                    first = node
                last = node

                in_order(node.right)

        if not root:
            return None
        first, last = None, None
        in_order(root)
        first.left = last
        last.right = first

        return first

def tree_from_array(arr):
    return tree_from_parent(arr, 0, None)


def tree_from_parent(arr, index, parent):
    if index >= len(arr) or arr[index] is None:
        return None

    node = Node(arr[index])
    node.parent = parent
    node.left = tree_from_parent(arr, index * 2 + 1, node)
    node.right = tree_from_parent(arr, index * 2 + 2, node)
    return node


root: Node = tree_from_array([2, 1, 3])
res = Solution().treeToDoublyList(root)
print(res)

root: Node = tree_from_array([8, 3, 10, 1, 6, None, 14, None, None, 4, 7, None, None, 13, None])
res = Solution().treeToDoublyList(root)
print(res.val)
