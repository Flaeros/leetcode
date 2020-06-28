package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;
import static tree.StringUtils.printDim;

public class BinaryTreeLevelOrderTraversal_102 {

    public static void main(String[] args) {
        System.out.println(printDim(new BinaryTreeLevelOrderTraversal_102().levelOrder(TreeNode.tree(asList(3, 9, 20, null, null, 15, 7)))));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.offer(root);
        levels.offer(0);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            int level = levels.poll();
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }

            List<Integer> nodes = result.get(level);
            nodes.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                levels.offer(level + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                levels.offer(level + 1);
            }
        }

        return result;
    }
}
