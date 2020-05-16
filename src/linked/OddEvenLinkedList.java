package linked;

import static java.util.Arrays.asList;
import static java.util.Arrays.deepToString;
import static linked.ListNode.printNodes;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        System.out.println(printNodes(new OddEvenLinkedList().oddEvenList(ListNode.nodes(asList()))));
        System.out.println(printNodes(new OddEvenLinkedList().oddEvenList(ListNode.nodes(asList(1)))));
        System.out.println(printNodes(new OddEvenLinkedList().oddEvenList(ListNode.nodes(asList(1, 2)))));
        System.out.println(printNodes(new OddEvenLinkedList().oddEvenList(ListNode.nodes(asList(1, 2, 3)))));
        System.out.println(printNodes(new OddEvenLinkedList().oddEvenList(ListNode.nodes(asList(1, 2, 3, 4)))));
        System.out.println(printNodes(new OddEvenLinkedList().oddEvenList(ListNode.nodes(asList(1, 2, 3, 4, 5)))));
        System.out.println(printNodes(new OddEvenLinkedList().oddEvenList(ListNode.nodes(asList(1, 2, 3, 4, 5, 6, 7, 8, 9)))));

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
