package tree;

import static java.util.Arrays.asList;

public class CountCompleteTreeNodes_222 {

    public static void main(String[] args) {
        System.out.println(new CountCompleteTreeNodes_222().countNodes(TreeNode.tree(asList(1, 2, 3, 4, 5, 6, null, null))));
    }

    public int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        int h = height(root);

        if (h < 0)
            return 0;

        if (height(root.right) == h - 1) {
            return (1 << h) + countNodes(root.right);
        }
        return (1 << h - 1) + countNodes(root.left);
    }

    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
