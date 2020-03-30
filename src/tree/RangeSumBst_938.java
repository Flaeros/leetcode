package tree;

import static java.util.Arrays.asList;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * The binary search tree is guaranteed to have unique values.
 */
public class RangeSumBst_938 {
    /**
     * he number of nodes in the tree is at most 10000.
     * The final answer is guaranteed to be less than 2^31.
     */
    public static void main(String[] args) {
        System.out.println(new RangeSumBst_938().rangeSumBST(TreeNode.tree(asList(10, 5, 15, 3, 7, null, 18), 0), 7, 15));
        System.out.println(new RangeSumBst_938().rangeSumBST(TreeNode.tree(asList(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 0), 6, 10));
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;

        if (root.val < L)
            return rangeSumBST(root.right, L, R);

        if (root.val > R)
            return rangeSumBST(root.left, L, R);

        return rangeSumBST(root.left, L, R) +
                root.val +
                rangeSumBST(root.right, L, R);
    }
}
