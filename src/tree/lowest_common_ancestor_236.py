# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# use dfs, find a path to both nodes, store it in two arrays
# i.e.:
# 3 5 - 3 1
# 3 5 - 3 5 2 4
# from left to right, find the last equal node

from tree_tools import *


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        p_path = self.pathToNode(root, p, [])
        q_path = self.pathToNode(root, q, [])

        pq_min_len = min(len(p_path), len(q_path))
        result = root
        for i in range(pq_min_len):
            if p_path[i].val != q_path[i].val:
                return result
            result = p_path[i]

        return result

    def pathToNode(self, node, target, path):
        if not node:
            return None

        path.append(node)
        if node.val == target.val:
            return list(path)

        left_res = self.pathToNode(node.left, target, path)
        right_res = self.pathToNode(node.right, target, path)

        if left_res:
            return left_res

        if right_res:
            return right_res

        del path[-1]

        return None
