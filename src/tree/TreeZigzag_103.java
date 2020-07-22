package tree;

import java.util.*;

import static java.util.Arrays.asList;
import static tree.StringUtils.printDim;

public class TreeZigzag_103 {

    public static void main(String[] args) {
        System.out.println(printDim(new TreeZigzag_103().zigzagLevelOrder(TreeNode.tree(asList(3, 9, 20, null, null, 15, 7)))));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean direction = true;

        List<List<Integer>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (direction)
                    level.add(node.val);
                else
                    level.add(0, node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            result.add(level);
            direction = !direction;
        }

        return result;
    }
}
