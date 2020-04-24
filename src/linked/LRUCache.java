package linked;


import java.util.HashMap;
import java.util.Map;

/**
 * #146
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("cache = " + cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println("cache = " + cache.get(2));      // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println("cache = " + cache.get(1));      // returns -1 (not found)
        System.out.println("cache = " + cache.get(3));       // returns 3
        System.out.println("cache = " + cache.get(4));       // returns 4
    }

    Map<Integer, DoubleNode> map = new HashMap<>();
    DoubleNode head = new DoubleNode(0, 0);
    DoubleNode tail = new DoubleNode(0, 0);
    int capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));

        if (map.size() == capacity)
            remove(tail.prev);

        insert(new DoubleNode(key, value));
    }

    private void remove(DoubleNode node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(DoubleNode node) {
        map.put(node.key, node);
        DoubleNode nextNode = head.next;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
        nextNode.prev = node;
    }


    static class DoubleNode {
        DoubleNode prev;
        DoubleNode next;
        int key;
        int val;

        public DoubleNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
