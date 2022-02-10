class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def find_paths(root, sum):
    allPaths = []
    find_paths_rec(root, sum, [], allPaths)
    return allPaths


def find_paths_rec(node, sum, path, allPaths):
    if not node:
        return

    path.append(node.val)

    if node.val == sum and not node.left and not node.right:
        allPaths.append(path.copy())
        path.pop()
        return

    find_paths_rec(node.left, sum - node.val, path, allPaths)
    find_paths_rec(node.right, sum - node.val, path, allPaths)
    path.pop()
    return


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(4)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    sum = 23
    print("Tree paths with sum " + str(sum) +
          ": " + str(find_paths(root, sum)))


main()
