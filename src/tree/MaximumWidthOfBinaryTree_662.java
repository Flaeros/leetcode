package tree;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MaximumWidthOfBinaryTree_662 {

    public static void main(String[] args) {
        System.out.println(new MaximumWidthOfBinaryTree_662().widthOfBinaryTree(TreeNode.tree(
                asList(1, 2, 3, 4, null, null, 7, 8, null, null, null, null, null, null, 15))));
    }

    int width = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        List<Integer> start = new ArrayList<>();
        helper(root, 0, 1, start);
        return width;
    }

    private void helper(TreeNode root, int level, int index, List<Integer> start) {
        if (root == null)
            return;

        if (level == start.size())
            start.add(index);

        width = Math.max(width, index + 1 - start.get(level));

        helper(root.left, level + 1, index * 2, start);
        helper(root.right, level + 1, index * 2 + 1, start);
    }
}
