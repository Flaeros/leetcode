package tree;

import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree_543 {


    public static void main(String[] args) {
        System.out.println(new DiameterOfBinaryTree_543().diameterOfBinaryTree(TreeNode.tree(asList(1, 2, 3, 4, 5, null, null), 0)));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger maxLength = new AtomicInteger(0);
        diameterOfBinaryTree(root, maxLength);
        return maxLength.get();
    }


    public int diameterOfBinaryTree(TreeNode root, AtomicInteger maxLength) {
        if (root == null) {
            return 0;
        }

        int leftDepth = diameterOfBinaryTree(root.left, maxLength);
        int rightDepth = diameterOfBinaryTree(root.right, maxLength);

        int subTreeDiameter = leftDepth + rightDepth;
        int localMax = Math.max(maxLength.get(), subTreeDiameter);
        maxLength.set(localMax);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
