package linked;

import java.util.Arrays;
import java.util.List;

public class ReorderList_143 {

    public static void main(String[] args) {
        ListNode nodes = ListNode.nodes(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        new ReorderList_143().reorderList(nodes);
        System.out.println(nodes);

        nodes = ListNode.nodes(Arrays.asList(1, 2, 3, 4));
        new ReorderList_143().reorderList(nodes);
        System.out.println(nodes);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow;
        ListNode preCurrent = slow.next;

        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = middle.next;
            middle.next = current;
        }

        ListNode first = head;
        ListNode second = middle.next;
        while (first != middle) {
            middle.next = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = middle.next;
        }
    }
}
