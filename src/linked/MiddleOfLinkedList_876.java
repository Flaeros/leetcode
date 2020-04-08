package linked;

import static java.util.Arrays.asList;
import static linked.ListNode.printNodes;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node
 */
public class MiddleOfLinkedList_876 {

    /**
     * The number of nodes in the given list will be between 1 and 100.
     */
    public static void main(String[] args) {
        System.out.println(printNodes(new MiddleOfLinkedList_876().middleNode(ListNode.nodes(asList(1)))));
        System.out.println(printNodes(new MiddleOfLinkedList_876().middleNode(ListNode.nodes(asList(1, 2)))));
        System.out.println(printNodes(new MiddleOfLinkedList_876().middleNode(ListNode.nodes(asList(1, 2, 3)))));
        System.out.println(printNodes(new MiddleOfLinkedList_876().middleNode(ListNode.nodes(asList(1, 2, 3, 4)))));
        System.out.println(printNodes(new MiddleOfLinkedList_876().middleNode(ListNode.nodes(asList(1, 2, 3, 4, 5)))));
        System.out.println(printNodes(new MiddleOfLinkedList_876().middleNode(ListNode.nodes(asList(1, 2, 3, 4, 5, 6)))));
        System.out.println(printNodes(new MiddleOfLinkedList_876().middleNode(ListNode.nodes(asList(1, 2, 3, 4, 5, 6, 7)))));
    }

    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
