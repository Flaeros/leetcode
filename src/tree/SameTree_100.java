package tree;

import static java.util.Arrays.asList;

public class SameTree_100 {

    public static void main(String[] args) {

        TreeNode first = TreeNode.tree(asList(1, 2, 3));
        TreeNode second = TreeNode.tree(asList(1, 2, 3));
        System.out.println(new SameTree_100().isSameTree(first, second));

        first = TreeNode.tree(asList(1, 2, null));
        second = TreeNode.tree(asList(1, null, 2));
        System.out.println(new SameTree_100().isSameTree(first, second));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
