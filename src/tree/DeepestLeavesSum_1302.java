package tree;

import java.util.LinkedList;
import java.util.Stack;

import static java.util.Arrays.asList;


/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum_1302 {

    /**
     * The number of nodes in the tree is between 1 and 10^4.
     * The value of nodes is between 1 and 100.
     */
    public static void main(String[] args) {
        System.out.println(new DeepestLeavesSum_1302().deepestLeavesSum(TreeNode.tree(asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8), 0)));
    }

    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();

        nodes.offer(root);

        int sum = 0;
        while (!nodes.isEmpty()) {
            sum = 0;
            int size = nodes.size();
            for (int i = 0; i < size ; i++) {

                TreeNode node = nodes.poll();
                sum += node.val;

                if (node.right != null)
                    nodes.offer(node.right);
                if (node.left != null)
                    nodes.offer(node.left);
            }
        }
        return sum;
    }

    public int deepestLeavesSumDfs(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        int sum = 0;
        int maxDepth = 0;

        nodes.push(root);
        depths.push(0);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            Integer depth = depths.pop();

            if (node.right != null) {
                nodes.push(node.right);
                depths.push(depth + 1);
            }

            if (node.left != null) {
                nodes.push(node.left);
                depths.push(depth + 1);
            }

            if (depth == maxDepth) {
                sum += node.val;
            } else if (depth > maxDepth) {
                sum = node.val;
            }

            maxDepth = Math.max(maxDepth, depth);
        }

        return sum;
    }
}
