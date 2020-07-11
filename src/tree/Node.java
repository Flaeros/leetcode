package tree;

import java.util.List;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public static Node childNodes(List<List<Integer>> levels) {
        Node root = null;
        Node node = null;
        Node levelRoot = null;
        boolean childSet = true;
        for (List<Integer> vals : levels) {

            for (Integer val : vals) {
                Node next;

                if (val == null) {
                    node = null;
                    levelRoot = levelRoot.next;
                    continue;
                }

                next = new Node(val);

                if (!childSet) {
                    levelRoot.child = next;
                    childSet = true;
                    levelRoot = null;
                }

                if (levelRoot == null) {
                    levelRoot = next;
                }

                if (root == null) {
                    root = next;
                    node = root;
                } else {
                    if (node != null)
                        node.next = next;
                    next.prev = node;
                    node = next;
                }
            }
            childSet = false;
        }

        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = this;

        while (node != null) {
            sb.append(node.val);
            sb.append(", ");
            node = node.next;
        }

        return sb.toString();
    }
}
