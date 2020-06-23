package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class BinaryTreePaths_257 {

    public static void main(String[] args) {
        System.out.println(new BinaryTreePaths_257().binaryTreePaths(TreeNode.tree(asList(-1, -2, -3, null, -5, null, null))));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result, sb, root);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, TreeNode root) {
        if (root == null)
            return;
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            sb.append("->");
            helper(result, sb, root.left);
            helper(result, sb, root.right);
        }
        sb.setLength(len);
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<StringBuilder> helper = helper(root);
        List<String> result = new ArrayList<>();

        for (StringBuilder sb : helper) {
            result.add(sb.toString());
        }
        return result;
    }

    public List<StringBuilder> helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            return new ArrayList<>(Collections.singletonList(sb));
        }

        List<StringBuilder> current = new ArrayList<>();
        if (root.left != null) {
            List<StringBuilder> left = helper(root.left);
            current.addAll(left);
        }
        if (root.right != null) {
            List<StringBuilder> right = helper(root.right);
            current.addAll(right);
        }

        for (StringBuilder s : current) {
            s.insert(0, "->");
            s.insert(0, root.val);
        }
        return current;
    }
}
