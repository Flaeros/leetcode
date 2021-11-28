# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next




class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = None
        prev = None

        while head:
            temp = current
            current = ListNode(head.val)

            current.next = temp
            prev = current
            head = head.next

        return current


def print_list(head: Optional[ListNode]):
    while head:
        print(head.val)
        head = head.next


def list(numbers):
    temp = ListNode()
    head = temp
    for num in numbers:
        head.next = ListNode(num)
        head = head.next

    return temp.next


print_list(Solution().reverseList(list([1, 2, 3, 4])))
