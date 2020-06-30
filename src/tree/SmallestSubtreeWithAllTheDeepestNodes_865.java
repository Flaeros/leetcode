package tree;

import static java.util.Arrays.asList;

public class SmallestSubtreeWithAllTheDeepestNodes_865 {

    public static void main(String[] args) {
        System.out.println(new SmallestSubtreeWithAllTheDeepestNodes_865().subtreeWithAllDeepest(
                TreeNode.tree(asList(3, 5, 1, 6, 2, 0, 8, 9, 3, 7, 4, 5, 6, 8, 7))
        ));
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).value;
    }

    private Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null)
            return new Pair<>(0, null);

        Pair<Integer, TreeNode> left = deep(root.left);
        Pair<Integer, TreeNode> right = deep(root.right);

        int ld = left.key;
        int rd = right.key;

        int maxd = Math.max(ld, rd) + 1;
        TreeNode maxNode = ld == rd ? root : ld > rd ? left.value : right.value;
        return new Pair<>(maxd, maxNode);
    }


    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
