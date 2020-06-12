package math;

import java.util.*;

public class InsertDeleteGetRandom_ {

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1));
        // Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2));
        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(2));
        // getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());
        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomSet.remove(1));
        // 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2));
        // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());
    }

    static class RandomizedSet {
        Map<Integer, Integer> indexes;
        List<Integer> nums;

        Random rand = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            indexes = new HashMap<>();
            nums = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (indexes.containsKey(val))
                return false;

            indexes.put(val, nums.size());
            nums.add(val);

            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!indexes.containsKey(val))
                return false;

            int index = indexes.get(val);
            int size = nums.size();
            if (index < size - 1) {
                int last = nums.get(size - 1);
                nums.set(index, last);
                indexes.put(last, index);
            }

            indexes.remove(val);
            nums.remove(size - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

}
