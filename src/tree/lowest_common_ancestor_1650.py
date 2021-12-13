# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None


class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        ph = self.get_height(p)
        qh = self.get_height(q)

        if qh > ph:
            p, q = q, p
            ph, qh = qh, ph

        while ph != qh:
            ph -= 1
            p = p.parent

        while p != q:
            p = p.parent
            q = q.parent
        return p

    def get_height(self, p: Node) -> int:
        height = 0
        while p:
            height += 1
            p = p.parent
        return height

    def lowestCommonAncestor2(self, p: 'Node', q: 'Node') -> 'Node':
        visited = set()
        node = p
        while node:
            visited.add(node)
            node = node.parent

        node = q
        while node:
            if node in visited:
                return node
            node = node.parent

    def lowestCommonAncestor3(self, p: 'Node', q: 'Node') -> 'Node':
        p_anc, q_anc = [], []
        node = p
        while node is not None:
            p_anc.append(node)
            node = node.parent

        node = q
        while node is not None:
            q_anc.append(node)
            node = node.parent

        i = 0
        j = 0
        while i < len(p_anc) and j < len(q_anc):
            if len(p_anc) - i == len(q_anc) - j:
                if p_anc[i].val == q_anc[j].val:
                    return p_anc[i]
                else:
                    i += 1
                    j += 1
            elif len(p_anc) - i > len(q_anc) - j:
                i += 1
            else:
                j += 1

        return None


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


def get_depth(node):
    if node is None:
        return 0
    result = 0

    nodes = [(node, 1)]

    while nodes:
        node, depth = nodes.pop()
        result = max(depth, result)
        if node.right is not None:
            nodes.append((node.right, depth + 1))
        if node.left is not None:
            nodes.append((node.left, depth + 1))

    return result


root: Node = tree_from_array([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4])
print(Solution().lowestCommonAncestor(root.left, root.right).val)

root: Node = tree_from_array([3, 5, 1, 6, 2, 0, 8, None, None, 7, 4])
print(Solution().lowestCommonAncestor(root.left, root.left.right.right).val)
