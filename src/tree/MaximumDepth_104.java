package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static java.util.Arrays.asList;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MaximumDepth_104 {

    public static void main(String[] args) {
        System.out.println(new MaximumDepth_104().maxDepth(TreeNode.tree(asList(3, 9, 20, null, null, 15, 7), 0)));
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> values = new LinkedList<>();
        int count = 0;

        values.offer(root);

        while (!values.isEmpty()) {
            int size = values.size();
            while (size-- > 0) {
                TreeNode node = values.poll();
                if(node.left != null)
                    values.offer(node.left);

                if(node.right != null)
                    values.offer(node.right);
            }
            count++;
        }

        return count;
    }

    public int maxDepthDfs(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();

        int max = 0;
        stack.push(root);
        values.push(1);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer temp = values.pop();
            max = Math.max(temp, max);

            if (node.left != null) {
                stack.push(node.left);
                values.push(temp + 1);
            }

            if (node.right != null) {
                stack.push(node.right);
                values.push(temp + 1);
            }
        }

        return max;
    }

    public int maxDepthRec(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = root.left == null ? 0 : maxDepthRec(root.left);
        int rightDepth = root.right == null ? 0 : maxDepthRec(root.right);

        if (leftDepth > rightDepth)
            return leftDepth + 1;
        return rightDepth + 1;
    }

    static TreeNode tree2(List<Integer> tree) {
        if (tree.isEmpty())
            return null;

        TreeNode[] nodes = new TreeNode[tree.size()];
        TreeNode root = new TreeNode(tree.get(0));
        nodes[0] = root;

        for (int i = 1; i < tree.size(); i += 2) {
            TreeNode parent = nodes[(i - 1) / 2];
            if (parent == null) {
                continue;
            }

            Integer left = tree.get(i);
            if (left != null) {
                TreeNode leftNode = new TreeNode(left);
                parent.left = leftNode;
                nodes[i] = leftNode;
            }

            Integer right = tree.get(i + 1);
            if (right != null) {
                TreeNode rightNode = new TreeNode(right);
                parent.right = rightNode;
                nodes[i + 1] = rightNode;
            }
        }

        return root;
    }
}
