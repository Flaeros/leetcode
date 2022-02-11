class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# dfs
# from each node? (logn)^2
# track path
# count sum from the end of path

def count_paths(root, target):
    return count_paths_rec(root, target, [])


def count_paths_rec(node, target, path):
    if not node:
        return 0

    path.append(node.val)

    current_sum, path_sum = 0, 0
    path_count = 0

    for i in range(len(path) - 1, -1, -1):
        path_sum += path[i]
        if path_sum == target:
            path_count += 1

    current_sum += path_count
    current_sum += count_paths_rec(node.left, target, path)
    current_sum += count_paths_rec(node.right, target, path)

    path.pop()

    return current_sum


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(4)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    print("Tree has paths: " + str(count_paths(root, 11)))


main()
