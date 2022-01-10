# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow, fast = head, head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                return self.findCycleStart(head, slow)
        return None

    def findCycleStart(self, head, node):
        cycle_length = self.findCycleLength(node)
        slow, fast = head, head

        for i in range(cycle_length):
            fast = fast.next

        while slow is not fast:
            slow = slow.next
            fast = fast.next

        return slow

    def findCycleLength(self, node):
        cycle_length = 1
        slow = node.next
        while slow is not node:
            slow = slow.next
            cycle_length += 1

        return cycle_length


def main():
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(6)

    head.next.next.next.next.next.next = head.next.next
    print("LinkedList has cycle: " + str(Solution().detectCycle(head).val))

    head.next.next.next.next.next.next = head.next.next.next
    print("LinkedList has cycle: " + str(Solution().detectCycle(head).val))

    head.next.next.next.next.next.next = head
    print("LinkedList has cycle: " + str(Solution().detectCycle(head).val))


main()
