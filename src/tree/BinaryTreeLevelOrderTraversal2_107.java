package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static java.util.Arrays.asList;
import static tree.StringUtils.printDim;

public class BinaryTreeLevelOrderTraversal2_107 {


    public static void main(String[] args) {
        System.out.println(printDim(new BinaryTreeLevelOrderTraversal2_107().levelOrderBottom(TreeNode.tree(asList(3, 9, 20, null, null, 15, 7)))));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(level);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
