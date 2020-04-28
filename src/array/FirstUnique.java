package array;

import java.util.HashMap;
import java.util.Map;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <p>
 * Implement the FirstUnique class:
 * <p>
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 */
public class FirstUnique {

    public static void main(String[] args) {

        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        System.out.println("firstUnique = " + firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println("firstUnique = " + firstUnique.showFirstUnique());// return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println("firstUnique = " + firstUnique.showFirstUnique());// return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println("firstUnique = " + firstUnique.showFirstUnique());// return -1
    }

    Map<Integer, Integer> map = new HashMap<>();

    ListNode head;
    ListNode tail;
    ListNode unique;

    public FirstUnique(int[] nums) {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        unique = tail;

        head.next = tail;
        tail.prev = head;

        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return unique.val;
    }

    public void add(int value) {
        Integer valueCount = map.getOrDefault(value, 0);
        map.put(value, valueCount + 1);

        ListNode node = new ListNode(value);
        ListNode prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;

        findNextUnique(node);
    }

    private void findNextUnique(ListNode node) {
        if (map.containsKey(unique.val) && map.get(unique.val) == 1)
            return;

        if (unique.val == -1 && map.get(node.val) == 1) {
            unique = node;
        }

        while (unique.val != -1 && map.get(unique.val) != 1) {
            unique = unique.next;
        }
    }

    static class ListNode {
        int val;
        public ListNode prev;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
