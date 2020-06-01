package tree;

import static java.util.Arrays.asList;

public class InvertBinaryTree_226 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.tree(asList(1, 2, 3, 4, 5, 6, 7));
        TreeNode invertTree = new InvertBinaryTree_226().invertTree(tree);
        System.out.println();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = right;

        invertTree(left);
        invertTree(right);

        return root;
    }
}
