class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# by index, from 0 - sequence
# dfs, take node - compare value
# if equals - check children
# if not - return


def find_path(root, sequence):
    return find_path_rec(root, sequence, 0)


def find_path_rec(node, sequence, index):
    if not node:
        return False

    if index >= len(sequence):
        return False

    if node.val == sequence[index]:
        if not node.left and not node.right and index == len(sequence) - 1:
            return True
        return find_path_rec(node.left, sequence, index + 1) or find_path_rec(node.right, sequence, index + 1)
    else:
        return False


def main():
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    root.left.left = TreeNode(1)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(5)

    print("Tree has path sequence: " + str(find_path(root, [1, 0, 7])))
    print("Tree has path sequence: " + str(find_path(root, [1, 1, 6])))


main()
