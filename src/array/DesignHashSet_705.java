package array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DesignHashSet_705 {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }

    public static class MyHashSet {

        int capacity = 1000;
        double loadFactor = 0.75;
        List<Integer>[] data;
        int count = 0;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            data = new LinkedList[capacity];
        }

        public void add(int key) {
            if (contains(key))
                return;

            if (loadFactor * capacity == count) {
                count = 0;
                capacity *= 2;
                List<Integer>[] oldData = data;
                data = new LinkedList[capacity];

                for (List<Integer> oldBucket : oldData) {
                    if (oldBucket != null) {
                        for (Integer oldKey : oldBucket) {
                            add(oldKey);
                        }
                    }
                }
            }

            int hash = keyToHash(key);
            if (data[hash] == null)
                data[hash] = new LinkedList<>();
            data[hash].add(key);
            count++;
        }

        public void remove(int key) {
            int hash = keyToHash(key);
            List<Integer> bucket = data[hash];

            if (bucket != null) {
                Iterator<Integer> it = bucket.iterator();
                while (it.hasNext()) {
                    if (it.next() == key) {
                        it.remove();
                        count--;
                    }
                }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int hash = keyToHash(key);
            List<Integer> bucket = data[hash];

            if (bucket != null) {
                for (Integer integer : bucket) {
                    if (integer == key)
                        return true;
                }
            }

            return false;
        }

        private int keyToHash(int key) {
            return key % capacity;
        }
    }

    public static class MyHashSet2 {

        boolean[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet2() {
            data = new boolean[1000001];
        }

        public void add(int key) {
            data[key] = true;
        }

        public void remove(int key) {
            data[key] = false;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return data[key];
        }
    }
}
