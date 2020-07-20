package linked;

import static java.util.Arrays.asList;

public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {

        System.out.println(ListNode.printNodes(new RemoveLinkedListElements_203().removeElements(ListNode.nodes(asList(1, 2, 2, 1)), 2)));
        System.out.println(ListNode.printNodes(new RemoveLinkedListElements_203().removeElements(ListNode.nodes(asList(1, 1)), 1)));
        System.out.println(ListNode.printNodes(new RemoveLinkedListElements_203().removeElements(ListNode.nodes(asList(1, 2, 6, 3, 4, 5, 6)), 1)));
        System.out.println(ListNode.printNodes(new RemoveLinkedListElements_203().removeElements(ListNode.nodes(asList(1, 2, 6, 3, 4, 5, 6)), 2)));
        System.out.println(ListNode.printNodes(new RemoveLinkedListElements_203().removeElements(ListNode.nodes(asList(1, 2, 6, 3, 4, 5, 6)), 6)));
        System.out.println(ListNode.printNodes(new RemoveLinkedListElements_203().removeElements(ListNode.nodes(asList(1)), 1)));
        System.out.println(ListNode.printNodes(new RemoveLinkedListElements_203().removeElements(ListNode.nodes(asList(1, 2)), 2)));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = null;

        while (head != null && head.val == val) {
            head = head.next;
        }

        while (node != null) {
            if (node.val == val) {
                if (prev != null) {
                    prev.next = node.next;
                    node = node.next;
                    continue;
                }
            }
            prev = node;
            node = node.next;
        }
        return head;
    }
}
