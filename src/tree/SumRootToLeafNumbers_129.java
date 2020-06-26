package tree;

import java.util.LinkedList;

import static java.util.Arrays.asList;

public class SumRootToLeafNumbers_129 {

    public static void main(String[] args) {
        System.out.println(new SumRootToLeafNumbers_129().sumNumbers(TreeNode.tree(asList(1, 2, 3))));
        System.out.println(new SumRootToLeafNumbers_129().sumNumbers(TreeNode.tree(asList(4, 9, 0, 5, 1, null, null))));
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int current = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return current;
        }

        return sumNumbers(root.left, current) + sumNumbers(root.right, current);
    }

    public int sumNumbers2(TreeNode root) {
        sum = 0;
        helper(root, new LinkedList<>());
        return sum;
    }

    private void helper(TreeNode root, LinkedList<Integer> number) {
        if (root == null)
            return;

        number.addLast(root.val);

        if (root.left == null && root.right == null) {
            sum += listToNumber(number);
            number.removeLast();
            return;
        }

        helper(root.left, number);
        helper(root.right, number);

        number.removeLast();
    }

    int listToNumber(LinkedList<Integer> number) {
        int num = 0;
        int register = 0;
        for (int i = number.size() - 1; i >= 0; i--) {
            num += number.get(i) * Math.pow(10, register++);
        }
        return num;
    }
}
