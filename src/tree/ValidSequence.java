package tree;

import static java.util.Arrays.asList;
import static tree.TreeNode.tree;

public class ValidSequence {

    public static void main(String[] args) {
        TreeNode tree = tree(asList(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0, null, null, null, null));
        System.out.println(new ValidSequence().isValidSequence(tree, new int[]{0,1,0,1}));
        System.out.println(new ValidSequence().isValidSequence(tree, new int[]{0,0,1}));
        System.out.println(new ValidSequence().isValidSequence(tree, new int[]{0,1,1}));
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    public boolean isValidSequence(TreeNode node, int[] arr, int i) {
        if (node == null) {
            return i == arr.length;
        }

        if (i == arr.length - 1 && (node.left != null || node.right != null))
            return false;

        if (node.val != arr[i])
            return false;

        return isValidSequence(node.left, arr, i + 1) || isValidSequence(node.right, arr, i + 1);
    }
}
