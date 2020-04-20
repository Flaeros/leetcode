package tree;

import static java.util.Arrays.asList;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 */
public class TreeFromPreOrder_1008 {


    /**
     * 1 <= preorder.length <= 100
     * The values of preorder are distinct.
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node = new TreeFromPreOrder_1008().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(node);
    }

    int i = 0;

    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound)
            return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}
