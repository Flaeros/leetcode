from __future__ import print_function

from typing import Optional


class Node:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    def print_list(self):
        temp = self
        while temp is not None:
            print(temp.value, end=" ")
            temp = temp.next
        print()


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def print_list(self):
        temp = self
        while temp is not None:
            print(temp.val, end=" ")
            temp = temp.next
        print()


class Solution:
    def reverseBetween(self, head: Optional[ListNode], p: int, q: int) -> Optional[ListNode]:

        prev = None
        current = head
        i = 1
        while i != p:
            prev = current
            current = current.next
            i += 1

        left = prev
        end = current

        prev = None
        while i != q:
            next = current.next
            current.next = prev
            prev = current
            current = next
            i += 1

        right = current.next
        current.next = prev
        start = current

        if left is not None:
            left.next = start
        end.next = right

        if p > 1:
            return head
        else:
            return start



def main():
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    print("Nodes of original LinkedList are: ", end='')
    head.print_list()
    result = Solution().reverseBetween(head, 2, 4)
    print("Nodes of reversed LinkedList are: ", end='')
    result.print_list()


    head = ListNode(5)

    print("Nodes of original LinkedList are: ", end='')
    head.print_list()
    result = Solution().reverseBetween(head, 1, 1)
    print("Nodes of reversed LinkedList are: ", end='')
    result.print_list()


    head = ListNode(3)
    head.next = ListNode(5)

    print("Nodes of original LinkedList are: ", end='')
    head.print_list()
    result = Solution().reverseBetween(head, 1, 2)
    print("Nodes of reversed LinkedList are: ", end='')
    result.print_list()


main()
