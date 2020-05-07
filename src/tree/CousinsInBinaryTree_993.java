package tree;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Arrays.asList;

public class CousinsInBinaryTree_993 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree(asList(1, 2, 3, 4, null, null, null));
        System.out.println(new CousinsInBinaryTree_993().isCousins(root, 4, 3));

        root = TreeNode.tree(asList(1, 2, 3, null, 4, null, 5));
        System.out.println(new CousinsInBinaryTree_993().isCousins(root, 5, 4));

        root = TreeNode.tree(asList(1, 2, 3, null, 4, null, null));
        System.out.println(new CousinsInBinaryTree_993().isCousins(root, 2, 3));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        nodes.offer(root);
        levels.offer(1);

        TreeNode xParent = null;
        Integer xLevel = -1;
        TreeNode yParent = null;
        Integer yLevel = -1;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            Integer level = levels.poll();

            TreeNode left = node.left;
            if (left != null) {
                if (left.val == x) {
                    xParent = node;
                    xLevel = level;
                }
                if (left.val == y) {
                    yParent = node;
                    yLevel = level;
                }
                levels.offer(level + 1);
                nodes.offer(left);
            }

            TreeNode right = node.right;
            if (right != null) {
                if (right.val == x) {
                    xParent = node;
                    xLevel = level;
                }
                if (right.val == y) {
                    yParent = node;
                    yLevel = level;
                }
                levels.offer(level + 1);
                nodes.offer(right);
            }
        }

        if (xLevel == -1 || yLevel == -1)
            return false;

        if (!xLevel.equals(yLevel))
            return false;

        if (xParent == yParent)
            return false;

        return true;
    }
}
