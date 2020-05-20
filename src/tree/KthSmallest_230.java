package tree;

import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;
import static tree.TreeNode.tree;

public class KthSmallest_230 {

    public static void main(String[] args) {
        System.out.println(new KthSmallest_230().kthSmallest(tree(asList(3, 1, 4, null, 2, null, null)), 1));
        System.out.println();
        System.out.println(new KthSmallest_230().kthSmallest(tree(asList(5, 3, 6, 2, 4, null, null, 1, null, null, null, null, null, null, null)), 3));
    }


    int i = 1;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k);
    }

    public int helper(TreeNode node, int k) {
        if (node == null)
            return -1;

        int r = helper(node.left, k);
        if (r != -1)
            return r;

        if (i == k)
            return node.val;
        i++;

        r = helper(node.right, k);
        return r;
    }
}
