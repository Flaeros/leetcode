package tree;

import java.util.*;

/**
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * The cloned tree is a copy of the original tree.
 * Return a reference to the same node in the cloned tree.
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 */
public class NodeInClonedTree_1397 {

    /**
     * The number of nodes in the tree is in the range [1, 10^4].
     * The values of the nodes of the tree are unique.
     * target node is a node from the original tree and is not null.
     */
    public static void main(String[] args) {
        TreeNode original = TreeNode.tree(Arrays.asList(3, 9, 20, null, null, 15, 7), 0);
        TreeNode cloned = TreeNode.tree(Arrays.asList(3, 9, 20, null, null, 15, 7), 0);
        TreeNode target = original.right.right;

        System.out.println(new NodeInClonedTree_1397().getTargetCopy(original, cloned, target).val);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<List<Integer>> routes = new LinkedList<>();
        nodes.offer(original);
        routes.offer(new ArrayList<>());
        List<Integer> finalRoute = new ArrayList<>();

        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
            List<Integer> route = routes.poll();

            if (currentNode.val == target.val) {
                finalRoute = route;
                break;
            }

            if (currentNode.left != null) {
                nodes.offer(currentNode.left);
                ArrayList<Integer> newRoute = new ArrayList<>(route);
                newRoute.add(0);
                routes.offer(newRoute);
            }
            if (currentNode.right != null) {
                nodes.offer(currentNode.right);
                ArrayList<Integer> newRoute = new ArrayList<>(route);
                newRoute.add(1);
                routes.offer(newRoute);
            }
        }

        TreeNode current = cloned;
        for (Integer route : finalRoute) {
            if (route == 0)
                current = current.left;
            else
                current = current.right;
        }
        return current;
    }

    public final TreeNode getTargetCopyRecursive(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<Integer> path;

        path = findNode(original, target.val);

        TreeNode current = cloned;
        for (Integer route : path) {
            if (route == 0)
                current = current.left;
            else
                current = current.right;
        }
        return current;
    }

    private List<Integer> findNode(TreeNode node, int val) {
        if (node.val == val)
            return new ArrayList<>();
        if (node.left != null) {
            ArrayList<Integer> route = new ArrayList<>(Arrays.asList(0));
            List<Integer> childrenRoute = findNode(node.left, val);
            if (childrenRoute != null) {
                route.addAll(childrenRoute);
                return route;
            }
        }
        if (node.right != null) {
            ArrayList<Integer> route = new ArrayList<>(Arrays.asList(1));
            List<Integer> childrenRoute = findNode(node.right, val);
            if (childrenRoute != null) {
                route.addAll(childrenRoute);
                return route;
            }
        }
        return null;
    }

}
