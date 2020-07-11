package tree;

import static java.util.Arrays.asList;

public class FlattenMultilevelDoublyLinkedList_430 {

    public static void main(String[] args) {

        Node root = Node.childNodes(asList(
                asList(1, 2, 3, 4, 5, 6),
                asList(null, null, 7, 8, 9, 10),
                asList(null, 11, 12)));

        System.out.println(new FlattenMultilevelDoublyLinkedList_430().flatten(root));
    }

    public Node flatten(Node head) {

        Node node = head;

        while (node != null) {

            if (node.child != null) {
                Node next = node.next;

                node.next = flatten(node.child);
                node.next.prev = node;
                node.child = null;

                while (node.next != null)
                    node = node.next;

                if (next != null) {
                    node.next = next;
                    next.prev=node;
                }
            }

            node = node.next;
        }
        return head;
    }
}
