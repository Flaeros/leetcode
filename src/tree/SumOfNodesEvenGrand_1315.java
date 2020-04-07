package tree;

import java.util.Stack;

import static java.util.Arrays.asList;

/**
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 * <p>
 * If there are no nodes with an even-valued grandparent, return 0.
 */
public class SumOfNodesEvenGrand_1315 {

    public static void main(String[] args) {
        System.out.println(new SumOfNodesEvenGrand_1315().sumEvenGrandparent(TreeNode.tree(asList(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5), 0)));
    }

    public int sumEvenGrandparent(TreeNode root) {
        return sumRec(root, false, false);
    }

    public int sumRec(TreeNode node, boolean p, boolean gp) {

        int sum = 0;

        if (gp)
            sum += node.val;

        if (node.left != null) {
            sum += sumRec(node.left, node.val % 2 == 0, p);
        }

        if (node.right != null) {
            sum += sumRec(node.right, node.val % 2 == 0, p);
        }

        return sum;
    }


    public int sumEvenGrandparentStack(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Boolean> parents = new Stack<>();
        Stack<Boolean> gparents = new Stack<>();
        int sum = 0;

        nodes.push(root);
        parents.push(false);
        gparents.push(false);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();

            Boolean parent = parents.pop();
            Boolean gparent = gparents.pop();

            if (gparent)
                sum += node.val;

            if (node.left != null) {
                nodes.push(node.left);
                gparents.push(parent);
                parents.push(node.val % 2 == 0);
            }

            if (node.right != null) {
                nodes.push(node.right);
                gparents.push(parent);
                parents.push(node.val % 2 == 0);
            }
        }
        return sum;
    }
}
