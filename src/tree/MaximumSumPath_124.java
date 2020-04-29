package tree;


import static java.util.Arrays.asList;

public class MaximumSumPath_124 {

    public static void main(String[] args) {
        System.out.println(new MaximumSumPath_124().maxPathSum(TreeNode.tree(asList(1, 2, 3))));
        System.out.println(new MaximumSumPath_124().maxPathSum(TreeNode.tree(asList(-10, 9, 20, null, null, 15, 7))));
    }

    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        calculateMax(root);
        return max;
    }

    private int calculateMax(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(0, calculateMax(node.left));
        int right = Math.max(0, calculateMax(node.right));

        max = Math.max(max, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
