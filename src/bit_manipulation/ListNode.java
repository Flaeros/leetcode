package bit_manipulation;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode nodes(int[] nodes) {
        ListNode next = null;
        for (int i = nodes.length - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(nodes[i]);
            listNode.next = next;
            next = listNode;
        }
        return next;
    }
}