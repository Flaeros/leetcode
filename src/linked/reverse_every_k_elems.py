from __future__ import print_function


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


# until the end (while)
# keep reference to the each first element
# reverse equal or less than k elements

# keep head after first reversal
# keep new end after each reversal

def reverse_every_k_elements(head, k):
    current = head
    head = None
    prev = None
    prev_end, new_end = None, None

    while current is not None:
        new_end = None
        for i in range(k):
            if current is not None:
                if new_end is None:
                    new_end = current #7

                next = current.next # None
                current.next = prev #  8>7
                prev = current # 8
                current = next # None
#01
        if prev_end is not None:
            prev_end.next = prev #  4->8

        prev_end = new_end # 4

        if head is None:
            head = prev # 3

    new_end.next = None

    return head


def main():
    head = Node(1)
    head.next = Node(2)
    head.next.next = Node(3)
    head.next.next.next = Node(4)
    head.next.next.next.next = Node(5)
    head.next.next.next.next.next = Node(6)
    head.next.next.next.next.next.next = Node(7)
    head.next.next.next.next.next.next.next = Node(8)

    print("Nodes of original LinkedList are: ", end='')
    head.print_list()
    result = reverse_every_k_elements(head, 3)
    print("Nodes of reversed LinkedList are: ", end='')
    result.print_list()


main()
