class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def find_sum_of_path_numbers(root):
    return find_sum_rec(root, 0)

def find_sum_rec(node, pathSum):
    if not node:
        return 0

    sum = 10 * pathSum + node.val

    if not node.left and not node.right:
        return sum

    return find_sum_rec(node.left, sum) + find_sum_rec(node.right, sum)

def main():
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    root.left.left = TreeNode(1)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(5)
    print("Total Sum of Path Numbers: " + str(find_sum_of_path_numbers(root)))


main()
