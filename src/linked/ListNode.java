package linked;

import java.util.List;

public class ListNode {
    int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode nodes(List<Integer> values) {
        ListNode root = null;
        for (Integer value : values) {
            ListNode listNode = new ListNode(value);
            if (root == null)
                root = listNode;
            else
                root.appendToTail(value);

        }
        return root;
    }

    public static String printNodes(ListNode root) {
        ListNode node = root;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val);
            builder.append(" ");
            node = node.next;
        }
        return builder.toString();
    }

    void appendToTail(int d) {
        ListNode end = new ListNode(d);
        ListNode n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }
}
