from __future__ import print_function
from collections import deque


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right, self.next = None, None, None

    # level order traversal using 'next' pointer
    def print_level_order(self):
        nextLevelRoot = self
        while nextLevelRoot:
            current = nextLevelRoot
            nextLevelRoot = None
            while current:
                print(str(current.val) + " ", end='')
                if not nextLevelRoot:
                    if current.left:
                        nextLevelRoot = current.left
                    elif current.right:
                        nextLevelRoot = current.right
                current = current.next
            print()


# bfs by level with queue size iteration
# we track end of the level and refer to None
# we track previous node to make a next
# reference to current one on the same level

def connect_level_order_siblings(root):
    if not root:
        return

    q = deque()

    q.append(root)

    while q:
        size = len(q)
        prev = None
        for i in range(size):
            node = q.pop()

            if prev:
                prev.next = node
            prev = node

            if node.left:
                q.appendleft(node.left)

            if node.right:
                q.appendleft(node.right)
    return


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(9)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    connect_level_order_siblings(root)

    print("Level order traversal using 'next' pointer: ")
    root.print_level_order()


main()
