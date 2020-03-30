package bit_manipulation;

/**
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 */
public class ConvertBinaryNumber_1290 {

    /**
     * The Linked List is not empty.
     * Number of nodes will not exceed 30.
     * Each node's value is either 0 or 1.
     */
    public static void main(String[] args) {
        System.out.println(new ConvertBinaryNumber_1290().getDecimalValue(ListNode.nodes(new int[]{1, 0, 1})));
        System.out.println(new ConvertBinaryNumber_1290().getDecimalValue(ListNode.nodes(new int[]{0})));
        System.out.println(new ConvertBinaryNumber_1290().getDecimalValue(ListNode.nodes(new int[]{1})));
        System.out.println(new ConvertBinaryNumber_1290().getDecimalValue(ListNode.nodes(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0})));
        System.out.println(new ConvertBinaryNumber_1290().getDecimalValue(ListNode.nodes(new int[]{0, 0})));
        System.out.println(new ConvertBinaryNumber_1290().getDecimalValue(ListNode.nodes(new int[]{1, 0, 0})));
    }

    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = ( result << 1) | head.val;
            head = head.next;
        }
        return result;
    }
}
