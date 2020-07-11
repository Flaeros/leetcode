package tree;

import static java.util.Arrays.asList;

public class FlattenMultilevelDoublyLinkedList {

    public static void main(String[] args) {

        Node root = Node.childNodes(asList(
                asList(1, 2, 3, 4, 5, 6),
                asList(null, null, 7, 8, 9, 10),
                asList(null, 11, 12)));

        System.out.println(new FlattenMultilevelDoublyLinkedList().flatten(root));
    }

    public Node flatten(Node head) {


        return head;
    }
}
