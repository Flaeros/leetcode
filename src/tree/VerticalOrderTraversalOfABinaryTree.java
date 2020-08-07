package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static tree.StringUtils.printDim;

public class VerticalOrderTraversalOfABinaryTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.tree(asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(printDim(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(tree)));
        tree = TreeNode.tree(asList(3, 9, 20, null, null, 15, 7));
        System.out.println(printDim(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(tree)));
    }

    List<int[]> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        list.sort(new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                } else if (a[2] != b[2]) {
                    return -a[2] + b[2];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int j = i;

            while (j < list.size() && list.get(j)[1] == list.get(i)[1]) {
                j++;
            }

            List<Integer> temp = new ArrayList<>();

            for (int z = i; z < j; z++) {
                temp.add(list.get(z)[0]);
            }

            result.add(temp);
            i = j - 1;
        }

        return result;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null)
            return;
        list.add(new int[]{root.val, x, y});
        dfs(root.left, x - 1, y - 1);
        dfs(root.right, x + 1, y - 1);
    }
}
