package tree;

import java.util.List;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static TreeNode tree(List<Integer> tree, int i) {
        if (tree.isEmpty())
            return null;

        TreeNode node = null;

        if (i < tree.size()) {
            Integer val = tree.get(i);
            if (val == null)
                return null;

            node = new TreeNode(val);

            node.left = tree(tree, 2 * i + 1);
            node.right = tree(tree, 2 * i + 2);
        }

        return node;
    }
}
