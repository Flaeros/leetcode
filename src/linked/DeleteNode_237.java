package linked;

import static java.util.Arrays.asList;
import static linked.ListNode.printNodes;

public class DeleteNode_237 {

    public static void main(String[] args) {
        ListNode nodes = ListNode.nodes(asList(4, 5, 1, 9));
        new DeleteNode_237().deleteNode(nodes.next);
        System.out.println(printNodes(nodes));

        nodes = ListNode.nodes(asList(4, 5, 1, 9));
        new DeleteNode_237().deleteNode(nodes.next.next);
        System.out.println(printNodes(nodes));
    }

    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next != null) {
                node = node.next;
            } else {
                node.next = null;
            }
        }
    }
}
