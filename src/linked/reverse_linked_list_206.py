class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# save next
# change next to prev
# update prev
# update head to next


class Solution(object):
    def reverseList(self, head):
        prev = None

        while head:
            temp = head.next
            head.next = prev
            prev = head
            head = temp

        return prev
