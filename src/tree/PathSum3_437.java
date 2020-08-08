package tree;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class PathSum3_437 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.tree(asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1, null, null, null, null ));
        System.out.println(new PathSum3_437().pathSum(tree, 8));
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
        if (root == null)
            return 0;

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);

        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);

        return res;
    }
}
