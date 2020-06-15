package tree;

import static java.util.Arrays.asList;
import static tree.TreeNode.tree;

public class SearchBinarySearchTree_700 {

    public static void main(String[] args) {
        System.out.println(new SearchBinarySearchTree_700().searchBST(tree(asList(5, 3, 6, 2, 4, null, null, 1, null, null, null, null, null, null, null)), 3));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
